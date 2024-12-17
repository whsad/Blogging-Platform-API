package com.kirito.blogging_platform_api.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kirito.blogging_platform_api.common.pojo.BlogPost;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BlogPostMapper extends BaseMapper<BlogPost> {
}
