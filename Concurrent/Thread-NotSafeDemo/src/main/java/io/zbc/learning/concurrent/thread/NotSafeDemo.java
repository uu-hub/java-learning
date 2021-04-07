package io.zbc.learning.concurrent.thread;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author zmsoft
 * @version 1.0
 * @date 2021-03-27 17:33
 *
 * 请举例说明集合类是不安全的
 *
 * 1 故障现象
 *      java.util.ConcurrentModifycationException
 * 2 导致原因
 *
 * 3 解决方案
 *      3.1 Vector
 *      3.2 Collections.synchronizedList(new ArrayList<>())
 *      3.3 CopyOnWriteArrayList
 *
 * 4 优化建议（同样的错误，不出现第二次）
 *
 */
public class NotSafeDemo {

    public static void main(String[] args) {
//        List<String> list = Arrays.asList("a","b","c");
//        List<String> list = new ArrayList<String>();
//        List<String> list = new Vector<>();
//        List<String> list = Collections.synchronizedList(new ArrayList<>());
        List<String> list = new CopyOnWriteArrayList();

        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }

    }
}
