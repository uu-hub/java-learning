package io.zbc.learning.spring.data.redis.service.impl;

import io.zbc.learning.spring.data.redis.dao.IUserDao;
import io.zbc.learning.spring.data.redis.service.IRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class RedisService implements IRedisService {

    @Autowired
    private IUserDao userDao;

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @Override
    public String setValue(String key) {
        String value = "value of " + key;
        try {
            redisTemplate.opsForValue().set(key, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }

    @Override
    @Cacheable(cacheNames = "1", key = "#key")
    public String getValue(String key) {
        String strDateFormat = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
        String value = userDao.selectUserByName(key).getValue();
        System.out.println(sdf.format(new Date()) + " " + key + " = " + value);
        return value;
    }
}
