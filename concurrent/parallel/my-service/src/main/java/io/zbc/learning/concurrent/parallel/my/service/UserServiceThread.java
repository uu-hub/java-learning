package io.zbc.learning.concurrent.parallel.my.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.*;

/**
 * @author zbc
 * @description
 * @date 2021/8/4 15:08
 */
@Service
public class UserServiceThread {

    @Autowired
    RemoteService remoteService;

    // 线程池
    static ExecutorService taskExe = Executors.newFixedThreadPool(10);

    public Object getUserInfo(String userId) throws ExecutionException, InterruptedException {
        long t1 = System.currentTimeMillis();

        Callable<JSONObject> queryUserInfo = new Callable<JSONObject>() {
            @Override
            public JSONObject call() throws Exception {
                String r1 = remoteService.getUserInfo(userId);
                JSONObject userInfo = JSONObject.parseObject(r1);
                return userInfo;
            }
        };
        Callable<JSONObject> queryMoneyInfo = new Callable<JSONObject>() {
            @Override
            public JSONObject call() throws Exception {
                String r2 = remoteService.getUserMoney(userId);
                JSONObject moneyInfo = JSONObject.parseObject(r2);
                return moneyInfo;
            }
        };

        FutureTask<JSONObject> userInfoTask = new FutureTask<JSONObject>(queryUserInfo);
        FutureTask<JSONObject> moneyInfoTask = new FutureTask<JSONObject>(queryMoneyInfo);

        taskExe.submit(userInfoTask);
        taskExe.submit(moneyInfoTask);

        JSONObject result = new JSONObject();
        result.putAll(userInfoTask.get());
        result.putAll(moneyInfoTask.get());

        System.out.println("执行总时间为：" + (System.currentTimeMillis() - t1));

        return result;
    }
}
