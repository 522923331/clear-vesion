package com.eachday.service;

import com.eachday.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * @author 52292
 */
@RestController
@RequestMapping("/user")
public class UserService {

    public String addUser(User user) {
        // 参数校验完毕后这里就写上业务逻辑
        return "success";
    }
}
