package com.eachday.vo;

import com.eachday.enums.ResultCodeEnum;
import lombok.Getter;

/**
 * @description: 响应数据封装类
 * @program: basedStructure
 * @author: dove
 * @date: 2020-10-29 18:15
 **/
@Getter
public class ResultVo<T> {
    private int code;
    private String message;
    private T data;

    public ResultVo(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

//    public ResultVo(T data) {
//        this(200,"成功",data);
//    }

    public ResultVo(ResultCodeEnum resultCodeEnum,T data){
        this.code = resultCodeEnum.getCode();
        this.message = resultCodeEnum.getMessage();
        this.data = data;
    }

    public ResultVo(T data){
        this(ResultCodeEnum.SUCCESS,data);
    }
}
