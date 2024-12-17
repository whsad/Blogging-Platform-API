package com.kirito.blogging_platform_api.common.enums;

import lombok.Getter;

@Getter
public enum AppHttpCodeEnum {

    SUCCESS(200, "OK"),
    CREATED(201, "Created"),
    NO_CONTENT(204, "No Content"),
    BAD_REQUEST(400, "Bad Request"),
    NOT_FOUND(404, "Not Found");

    final int code;
    final String info;

    AppHttpCodeEnum(int code, String info) {
        this.code = code;
        this.info = info;
    }
}
