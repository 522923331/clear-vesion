package com.eachday.enums;

import lombok.Getter;

@Getter
public enum ResultCodeEnum {
    SUCCESS(1000,"操作成功"),
    FAILED(1001,"操作失败"),
    VALIDATE_FAILED(1002,"参数校验失败"),
    ERROR(5000,"未知错误");

    private int code;
    private String message;

    ResultCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
