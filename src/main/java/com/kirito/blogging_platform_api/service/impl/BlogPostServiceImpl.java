package com.kirito.blogging_platform_api.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kirito.blogging_platform_api.common.pojo.BlogPost;
import com.kirito.blogging_platform_api.mapper.BlogPostMapper;
import com.kirito.blogging_platform_api.service.BlogPostService;
import org.springframework.stereotype.Service;

@Service
public class BlogPostServiceImpl extends ServiceImpl<BlogPostMapper, BlogPost> implements BlogPostService {

}
