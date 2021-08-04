package io.zbc.learning.concurrent.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author zmsoft
 * @version 1.0
 * @date 2021-05-13 20:18
 *
 * 阻塞队列
 *
 * 1. 两个数据结构：栈/队列
 *  1.1 栈      后进先出
 *  1.2 队列     先进先出
 *  1.3 总结
 *
 * 2. 阻塞队列
 *  2.1 阻塞  必须要阻塞/不得不阻塞
 *
 *
 */
public class BlockingQueueDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(3);

//        System.out.println(blockingQueue.add("a"));
//        System.out.println(blockingQueue.add("b"));
//        System.out.println(blockingQueue.add("c"));

//        System.out.println(blockingQueue.add("x"));

//        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove());

//        System.out.println(blockingQueue.add("a"));
//        System.out.println(blockingQueue.add("b"));
//        System.out.println(blockingQueue.element());

//        System.out.println(blockingQueue.offer("a"));
//        System.out.println(blockingQueue.offer("b"));
//        System.out.println(blockingQueue.offer("c"));
//        System.out.println(blockingQueue.offer("d"));

//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());

//        blockingQueue.put("a");
//        blockingQueue.put("b");
//        blockingQueue.put("c");
//        blockingQueue.put("d");

//        System.out.println(blockingQueue.take());
//        System.out.println(blockingQueue.take());
//        System.out.println(blockingQueue.take());
//        System.out.println(blockingQueue.take());

        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("a", 3L, TimeUnit.SECONDS));   //不见不散，过时不侯


    }
}
