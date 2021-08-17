package io.zbc.learning.concurrent.parallel.other.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zbc
 * @description
 * @date 2021/8/17 15:51
 */
@Controller
@RequestMapping("/money")
public class MoneyController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 余额接口
     *
     * @param userId
     * @return
     */
    @RequestMapping("/getMoneyInfo")
    @ResponseBody
    public Object getMoneyInfo(@RequestParam String userId) {
        logger.info("余额接口，用户ID为：" + userId);

        try {
            Thread.currentThread().sleep(2000); // 模拟业务处理
        } catch (InterruptedException e) {
            e.printStackTrace();
            return "-1";
        }

        Map<String, String> map = new HashMap<String, String>();
        map.put("money", "100");
        map.put("card", "6868");
        return map;
    }
}
