package io.zbc.learning.concurrent.parallel.my.controller;

import io.zbc.learning.concurrent.parallel.my.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zbc
 * @description
 * @date 2021/8/4 15:04
 */
@Controller
@RequestMapping("/main")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/user")
    public String getUser(String userId) {
        return userService.getUserInfo(userId);
    }
}
