package io.zbc.learning.spring.data.redis.controller;

import io.zbc.learning.spring.data.redis.service.impl.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/redis")
@RestController
public class RedisController {

    @Autowired
    RedisService redisService;

    @RequestMapping(value = "/setValue/{key}",method = RequestMethod.GET)
    public String setValue(@PathVariable("key") String key) throws InterruptedException {
        return redisService.setValue(key);
    }

    @RequestMapping(value = "/getValue/{key}",method = RequestMethod.GET)
    public String getValue(@PathVariable("key") String key){
        return redisService.getValue(key);
    }
}
