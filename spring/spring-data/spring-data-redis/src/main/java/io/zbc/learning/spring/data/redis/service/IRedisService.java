package io.zbc.learning.spring.data.redis.service;

public interface IRedisService {

    public String setValue(String key) throws InterruptedException;
    public String getValue(String key);
}
