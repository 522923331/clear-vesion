package com.eachday.model;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;


/**
 * @description: 用户实体类
 * @program: basedStructure
 * @author: dove
 * @date: 2020-10-29 15:48
 **/
@Data
public class User {
    @NotNull(message="用户id不能为空")
    private Long id;
    @NotNull(message="用户账号不能为空")
    @Size(min = 6,max = 11,message = "账号长度必须是6-11个字符")
    private String account;
    @NotNull(message = "用户密码不能为空")
    @Size(min = 6,max = 16,message = "密码长度是6到16个字符")
    private String password;
    @NotNull(message = "用户邮箱不能为空")
    @Email(message = "邮箱格式不正常")
    private String email;

    private LocalDateTime createTime;
}
