package com.eachday.controller;

import com.alibaba.fastjson.JSON;
import com.eachday.model.User;
import com.eachday.service.UserService;
import com.eachday.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author 52292
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public String addUser(@RequestBody @Valid User user){
        log.info("user="+ JSON.toJSONString(user));
        //去掉BingdingResult对象，如果校验不通过会抛出MethodArgumentNotValidException异常，这里可以通过设置一个全局异常来处理异常信息，简化控制层代码
//        if (bindingResult.hasErrors()){
//            List<String> errors = bindingResult.getAllErrors().stream().map(error -> error.getDefaultMessage()).collect(Collectors.toList());
//            log.error("error="+errors.toString());
//            return errors.toString();
//        }
        return userService.addUser(user);
    }

    @GetMapping("/getUser")
    public User getUser(){
        User user = new User();
        user.setId(1L);
        user.setAccount("12345678");
        user.setPassword("12345678");
        user.setEmail("123@qq.com");
        return user;
    }
}
