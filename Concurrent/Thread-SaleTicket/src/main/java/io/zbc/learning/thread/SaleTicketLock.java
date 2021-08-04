package io.zbc.learning.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zmsoft
 * @version 1.0
 * @date 2021-03-26 22:08
 */

class TicketLock { //资源类
    private int number = 30;
    private Lock lock = new ReentrantLock();

    public void saleTicket() {

        lock.lock();
        try {
            if (number > 0) {
                System.out.println(Thread.currentThread().getName() + "\t卖出第："+(number--)+"\t还剩下：" +number);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }



    }
}

/**
 *   三个售票员  卖出  30张票
 *
 *   多线程编程
 *
 *   1 在高内聚低耦合的前提下， 线程    操作     资源类
 *
 */

public class SaleTicketLock {

    public static void main(String[] args) throws Exception{
        final TicketLock ticketLock = new TicketLock();

        new Thread(() -> {for (int i = 1; i <= 40; i++) ticketLock.saleTicket();},"A").start();
        new Thread(() -> {for (int i = 1; i <= 40; i++) ticketLock.saleTicket();},"B").start();
        new Thread(() -> {for (int i = 1; i <= 40; i++) ticketLock.saleTicket();},"C").start();

       /* new Thread(new Runnable() {
            public void run() {
                for (int i = 1; i <= 40; i++) {
                    ticketLock.saleTicket();
                }
            }
        },"A").start();

        new Thread(new Runnable() {
            public void run() {
                for (int i = 1; i <= 40; i++) {
                    ticketLock.saleTicket();
                }
            }
        },"B").start();

        new Thread(new Runnable() {
            public void run() {
                for (int i = 1; i <= 40; i++) {
                    ticketLock.saleTicket();
                }
            }
        },"C").start();*/


    }
}

