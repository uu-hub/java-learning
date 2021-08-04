package io.zbc.learning.concurrent.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author zmsoft
 * @version 1.0
 * @date 2021-05-13 20:50
 */
public class MyThreadPoolDemo {

    public static void main(String[] args) {

//        ExecutorService threadPool = Executors.newFixedThreadPool(5); //一池5个受理线程，类似一个银行有5个受理窗口
//        ExecutorService threadPool = Executors.newSingleThreadExecutor(); //一池1个受理线程，类似一个银行有1个受理窗口
        ExecutorService threadPool = Executors.newCachedThreadPool(); //一池n个受理线程，类似一个银行有n个受理窗口

        try {
            //模拟有10个顾客过来银行办理业务，目前池子里面有5个工作人员提供服务
            for (int i = 1; i <= 10; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName()+"\t 办理业务");
                });

                //暂停毫秒
//                try { TimeUnit.MILLISECONDS.sleep(400); } catch (Exception e) {e.printStackTrace();}
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}
