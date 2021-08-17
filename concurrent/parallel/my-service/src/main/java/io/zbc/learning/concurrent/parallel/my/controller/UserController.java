package io.zbc.learning.concurrent.parallel.my.controller;

import io.zbc.learning.concurrent.parallel.my.service.UserService;
import io.zbc.learning.concurrent.parallel.my.service.UserServiceThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

/**
 * @author zbc
 * @description
 * @date 2021/8/4 15:04
 */
@RestController
@RequestMapping("/main")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserServiceThread userServiceThread;

    @RequestMapping("/user")
    public String getUser() {
        return userService.getUserInfo("zbc").toString();
    }

    @RequestMapping("/userThread")
    public String getUserThread() throws ExecutionException, InterruptedException {
        return userServiceThread.getUserInfo("zbc").toString();
    }
}
