package com.eachday.advice;

import com.eachday.enums.ResultCodeEnum;
import com.eachday.exception.ApiException;
import com.eachday.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: 全局异常处理类
 * @program: basedStructure
 * @author: dove
 * @date: 2020-10-29 17:53
 **/
@Slf4j
@RestControllerAdvice
public class ExceptionControllerAdvice {


    /**
     * 第二步：封装成为一个自定义的异常类，以便以后有新的异常类型，只需要创建新的异常类即可，达到解耦效果。
     * @param e
     * @return
     */
    @ExceptionHandler(ApiException.class)
    public ResultVo ApiExceptionHandler(ApiException e){
        log.error("step into apiException,the error is {}",e.getMessage());
        return new ResultVo(ResultCodeEnum.FAILED,e.getMessage());
    }

    /**第一步：
     * 等于是把控制层BingdingResult的代码逻辑放到这里处理
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultVo MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e){
        List<String> errors = e.getBindingResult().getAllErrors().stream().map(objectError -> objectError.getDefaultMessage()).collect(Collectors.toList());
        log.error("校验不通过，异常为{}",errors.toString());
        return new ResultVo(ResultCodeEnum.VALIDATE_FAILED,errors.toString());
    }
}
