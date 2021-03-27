package io.zbc.learning.concurrent.thread;

import java.util.concurrent.TimeUnit;

class Phone {


    //1，2，3
//    public synchronized void sendEmail() throws Exception {
//        try {TimeUnit.SECONDS.sleep(4); } catch (Exception e) {e.printStackTrace();}
//        System.out.println("-------sendEmail");
//    }
//
//    public synchronized void sendSMS() throws Exception {
//        System.out.println("-------sendSMS");
//    }

    //5，6，
//    public static synchronized void sendEmail() throws Exception {
//        try {TimeUnit.SECONDS.sleep(4); } catch (Exception e) {e.printStackTrace();}
//        System.out.println("-------sendEmail");
//    }
//
//    public static synchronized void sendSMS() throws Exception {
//        System.out.println("-------sendSMS");
//    }



    //7，8
    public static synchronized void sendEmail() throws Exception {
        try {TimeUnit.SECONDS.sleep(4); } catch (Exception e) {e.printStackTrace();}
        System.out.println("-------sendEmail");
    }

    public synchronized void sendSMS() throws Exception {
        System.out.println("-------sendSMS");
    }

    public void hello() {
        System.out.println("-------hello");
    }
}

/**
 * @author zmsoft
 * @version 1.0
 * @date 2021-03-27 16:51
 * 多线程8锁
 * 1 标准访问，请先打印邮件还是短信？
 * 2 邮件方法暂停4秒钟，请问先打印邮件还是短信？
 * 3 新增一个普通方法hello(),请问先打印邮件还是hello？
 * 4 两部手机，请问先打印邮件还是短信？
 * 5 两个静态同步方法，同一部手机，请问先打印邮件还是短信？
 * 6 两个静态同步方法，2部手机，请问先打印邮件还是短信？
 * 7 1个普通同步方法，1个静态同步方法，1部手机，请问先打印邮件还是短信？
 * 8 1个普通同步方法，1个静态同步方法，2部手机，请问先打印邮件还是短信？
 *
 *
 */
public class Lock8 {

    public static void main(String[] args) throws InterruptedException{
        Phone phone = new Phone();
        Phone phone2 = new Phone();

        new Thread(() -> {
            try {
                phone.sendEmail();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {

            }
        },"A").start();

        Thread.sleep(100);

        new Thread(() -> {
            try {
//                phone.sendSMS(); //1,2
//                phone.hello();   //3
//                phone2.sendSMS(); //4
//                phone.sendSMS();   //5
//                phone2.sendSMS();   //6
//                phone.sendSMS();   //7
                phone2.sendSMS();   //7
            } catch (Exception e) {
                e.printStackTrace();
            } finally {

            }
        },"B").start();


    }
}
