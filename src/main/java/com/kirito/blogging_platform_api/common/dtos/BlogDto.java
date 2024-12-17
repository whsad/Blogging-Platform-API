package com.kirito.blogging_platform_api.common.dtos;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
public class BlogDto {
    private String title;
    private String content;
    private String category;
    private String[] tags;

    public boolean checkParam(){
        for (String tag : tags) {
            if (StringUtils.isBlank(tag)){
                return false;
            }
        }
        return StringUtils.isBlank(title) || StringUtils.isBlank(content) || StringUtils.isBlank(category);
    }
}
