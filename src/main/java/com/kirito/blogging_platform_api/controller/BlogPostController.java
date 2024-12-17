package com.kirito.blogging_platform_api.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.kirito.blogging_platform_api.common.dtos.BlogDto;
import com.kirito.blogging_platform_api.common.dtos.ResponseResult;
import com.kirito.blogging_platform_api.common.pojo.BlogPost;
import com.kirito.blogging_platform_api.mapper.BlogPostMapper;
import com.kirito.blogging_platform_api.service.BlogPostService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

import static com.kirito.blogging_platform_api.common.enums.AppHttpCodeEnum.*;

@RestController
public class BlogPostController {

    @Autowired
    private BlogPostService blogPostService;

    @Autowired
    private BlogPostMapper blogPostMapper;

    @PostMapping("/posts")
    public ResponseResult<?> create(@RequestBody BlogDto dto){
        if (dto.checkParam()) {
            return ResponseResult.errorResult(BAD_REQUEST);
        }

        BlogPost entity = new BlogPost(dto);
        blogPostService.save(entity);
        return ResponseResult.okResult(CREATED, entity);
    }

    @PutMapping("/posts/{id}")
    public ResponseResult<?> update(@PathVariable String id, @RequestBody BlogDto dto){
        if (StringUtils.isBlank(id) || dto.checkParam()){
            return ResponseResult.errorResult(BAD_REQUEST);
        }
        BlogPost post = blogPostService.getOne(Wrappers.<BlogPost>lambdaQuery().eq(BlogPost::getId, id));
        if (post == null){
            return ResponseResult.errorResult(NOT_FOUND);
        }
        post.setTitle(dto.getTitle());
        post.setContent(dto.getContent());
        post.setCategory(dto.getCategory());
        post.setTags(String.join(",",dto.getTags()));
        post.setUpdateTime(LocalDateTime.now());
        blogPostService.updateById(post);
        return ResponseResult.okResult(post);
    }

    @DeleteMapping("/posts/{id}")
    public ResponseResult<?> delete(@PathVariable String id){
        if (StringUtils.isBlank(id)){
            return ResponseResult.errorResult(BAD_REQUEST);
        }

        if (blogPostService.removeById(id)) {
            return ResponseResult.okResult(NO_CONTENT);
        }
        return ResponseResult.errorResult(NOT_FOUND);
    }

    @GetMapping("/posts/{id}")
    public ResponseResult<?> getBlog(@PathVariable String id){
        if (StringUtils.isBlank(id)){
            return ResponseResult.errorResult(BAD_REQUEST);
        }

        BlogPost post = blogPostService.getOne(Wrappers.<BlogPost>lambdaQuery().eq(BlogPost::getId, id));
        if (post == null){
            return ResponseResult.errorResult(NOT_FOUND);
        }

        return ResponseResult.okResult(post);
    }

    @GetMapping("/posts")
    public ResponseResult<?> getBlogAll(@RequestParam(name = "term", required = false) String term){
        // 如果 term 不为空，执行模糊搜索
        if (term != null && !term.isEmpty()) {
            LambdaQueryWrapper<BlogPost> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.like(BlogPost::getTitle, term)
                    .or()
                    .like(BlogPost::getContent, term)
                    .or()
                    .like(BlogPost::getTags, term);

            List<BlogPost> result = blogPostMapper.selectList(queryWrapper);
            return ResponseResult.okResult(result);
        }

        // 如果 term 为空，返回所有博客
        return ResponseResult.okResult(blogPostService.list());
    }
}
