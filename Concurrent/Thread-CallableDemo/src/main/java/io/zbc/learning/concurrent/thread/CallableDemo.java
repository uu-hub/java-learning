package io.zbc.learning.concurrent.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;


//class MyThread implements Runnable{
//
//    public void run() {
//
//    }
//}

class MyThread implements Callable<Integer>{

    public Integer call() throws Exception {
        System.out.println("******come in here******");
        return 1024;
    }
}


/**
 * @author zmsoft
 * @version 1.0
 * @date 2021-05-11 20:58
 *
 * java
 *  多线程中，第3种获得多线程的方式
 *
 *  callable接口与runnable接口的区别？
 *    1.是否有返回值
 *    2.是否抛异常
 *    3.落地方法不一样，一个是run，一个是call
 *
 *
 * 1. get方法一般请放在最后一行
 *
 *
 */
public class CallableDemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        FutureTask futureTask = new FutureTask(new MyThread());

        new Thread(futureTask,"A").start();
        new Thread(futureTask,"B").start();

        System.out.println(Thread.currentThread().getName() + "********计算完成");

        System.out.println(futureTask.get());

//        MyThread myThread = new MyThread();
//
//        Thread t1 = new Thread(myThread);
//        t1.start();

//        Thread(Runnable target, String name);
//        Thread(Callable target, String name);
//        Interface Runnable  Collection
    }
}
