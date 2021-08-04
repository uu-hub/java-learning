package io.zbc.learning.thread;

/**
 * @author zmsoft
 * @version 1.0
 * @date 2021-03-26 22:08
 */

class Ticket {
    private int number = 30;

    public synchronized void saleTicket() {
        if (number > 0) {
            System.out.println(Thread.currentThread().getName() + "\t卖出第："+(number--)+"\t还剩下：" +number);
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

public class SaleTicketSync {

    public static void main(String[] args) throws Exception{
        final Ticket ticket = new Ticket();

        new Thread(new Runnable() {
            public void run() {
                for (int i = 1; i <= 40; i++) {
                    ticket.saleTicket();
                }
            }
        },"A").start();

        new Thread(new Runnable() {
            public void run() {
                for (int i = 1; i <= 40; i++) {
                    ticket.saleTicket();
                }
            }
        },"B").start();

        new Thread(new Runnable() {
            public void run() {
                for (int i = 1; i <= 40; i++) {
                    ticket.saleTicket();
                }
            }
        },"C").start();
    }
}

