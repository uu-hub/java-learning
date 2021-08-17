package io.zbc.learning.concurrent.parallel.my.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zbc
 * @description
 * @date 2021/8/4 15:08
 */
@Service
public class UserService {

    @Autowired
    RemoteService remoteService;

    public Object getUserInfo(String userId) {
        long t1 = System.currentTimeMillis();

        String r1 = remoteService.getUserInfo(userId);
        JSONObject userInfo = JSONObject.parseObject(r1);

        String r2 = remoteService.getUserMoney(userId);
        JSONObject moneyInfo = JSONObject.parseObject(r2);

        JSONObject result = new JSONObject();
        result.putAll(userInfo);
        result.putAll(moneyInfo);

        System.out.println("执行总时间为：" + (System.currentTimeMillis() - t1));

        return result;
    }
}
