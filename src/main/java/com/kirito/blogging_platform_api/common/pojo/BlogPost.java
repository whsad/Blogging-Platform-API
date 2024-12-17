package com.kirito.blogging_platform_api.common.pojo;

import com.kirito.blogging_platform_api.common.dtos.BlogDto;
import lombok.Data;
import org.apache.commons.lang3.RandomStringUtils;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class BlogPost {
    private String id;
    private String title;
    private String content;
    private String category;
    private String tags;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public BlogPost() {}

    public BlogPost(BlogDto dto){
        this.id = UUID.randomUUID().toString().replace("-", "");
        this.title = dto.getTitle();
        this.content = dto.getContent();
        this.category = dto.getCategory();
        this.tags = String.join(",", dto.getTags());
        this.createTime = LocalDateTime.now();
        this.updateTime = LocalDateTime.now();
    }
}
