package io.zbc.learning.concurrent.parallel.my.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author zbc
 * @description
 * @date 2021/8/4 15:12
 */
@Service
public class RemoteService {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 获取用户基本信息
     *
     * @param userId
     * @return
     */
    public String getUserInfo(String userId) {
        long currentTimeMillis = System.currentTimeMillis();
        String result = restTemplate.getForEntity("http://127.0.0.1:8090/user/getUserInfo?userId=" + userId, String.class)
                .getBody();
        System.out.println("获取用户基本信息的时间为：" + (System.currentTimeMillis() - currentTimeMillis));
        return result;
    }

    /**
     * 获取用户余额
     *
     * @param userId
     * @return
     */
    public String getUserMoney(String userId) {
        long currentTimeMillis = System.currentTimeMillis();
        String result = restTemplate.getForEntity("http://127.0.0.1:8090/money/getMoneyInfo?userId=" + userId, String.class)
                .getBody();
        System.out.println("获取用户余额的时间为：" + (System.currentTimeMillis() - currentTimeMillis));
        return result;
    }
}
