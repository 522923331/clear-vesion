package com.eachday.exception;

import lombok.Getter;

/**
 * @description: 接口调用异常处理类
 * @program: basedStructure
 * @author: dove
 * @date: 2020-10-29 18:02
 **/
@Getter
public class ApiException extends RuntimeException {
    private int code;
    private String message;

    public ApiException(String message) {
        super(message);
    }

    public ApiException(int code) {
        super("接口错误");
        this.code = code;
    }

    public ApiException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }
}
