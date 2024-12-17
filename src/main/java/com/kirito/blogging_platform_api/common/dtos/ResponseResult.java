package com.kirito.blogging_platform_api.common.dtos;


import com.kirito.blogging_platform_api.common.enums.AppHttpCodeEnum;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ResponseResult<T> implements Serializable {
    private Integer code;
    private String info;
    private T data;

    public ResponseResult(){
        this.code = 200;
    }

    public ResponseResult(Integer code, T data) {
        this.code = code;
        this.data = data;
    }

    public ResponseResult(Integer code, String info) {
        this.code = code;
        this.info = info;
    }

    public ResponseResult(Integer code, String info, T data) {
        this.code = code;
        this.info = info;
        this.data = data;
    }

    public ResponseResult<?> error(Integer code, String msg){
        this.code = code;
        this.info = msg;
        return this;
    }

    public ResponseResult<?> ok(Integer code, T data){
        this.code = code;
        this.data = data;
        return this;
    }

    public ResponseResult<?> ok(Integer code, T data, String msg){
        this.code = code;
        this.data = data;
        this.info = msg;
        return this;
    }

    public ResponseResult<?> ok(T data){
        this.data = data;
        return this;
    }

    public static ResponseResult<?> errorResult(int code, String msg){
        ResponseResult<?> result = new ResponseResult<>();
        return result.error(code, msg);
    }

    public static ResponseResult<?> okResult(int code, String msg){
        ResponseResult<?> result = new ResponseResult<>();
        return result.ok(code, null, msg);
    }

    public static ResponseResult<?> okResult(Object data){
        ResponseResult result = setAppHttpCodeEnum(AppHttpCodeEnum.SUCCESS, AppHttpCodeEnum.SUCCESS.getInfo());
        if (data != null){
            result.setData(data);
        }
        return result;
    }

    public static ResponseResult<?> okResult(AppHttpCodeEnum enums, Object data){
        ResponseResult result = setAppHttpCodeEnum(enums, enums.getInfo());
        if (data != null){
            result.setData(data);
        }
        return result;
    }

    public static ResponseResult<?> okResult(AppHttpCodeEnum enums){
        return setAppHttpCodeEnum(enums, enums.getInfo());
    }

    public static ResponseResult<?> errorResult(AppHttpCodeEnum enums){
        return setAppHttpCodeEnum(enums, enums.getInfo());
    }

    public static ResponseResult<?> errorResult(AppHttpCodeEnum enums, String info){
        return setAppHttpCodeEnum(enums, info);
    }

    private static ResponseResult<?> setAppHttpCodeEnum(AppHttpCodeEnum enums){
        return okResult(enums.getCode(), enums.getInfo());
    }

    private static ResponseResult<?> setAppHttpCodeEnum(AppHttpCodeEnum enums, String info){
        return okResult(enums.getCode(), info);
    }
}
