/**
 * package 指定类文件所在的包
 */
package io.zbc.learning.java;

/**
 * 关键字 public 访问修饰符，表这个类是公开的
 * 关键字 class 用来定义一个类
 * HelloWorld 类的名字，首字母需要大写，同时要与文件名相同
 * 花括号{}中间是类的定义
 */
public class HelloWorld {
    /**
     * public static 用来修饰方法，这里表示它是一个公开的静态方法
     * void 方法的返回类型
     * main 方法名
     * String[] 参数类型
     * args 参数名
     * 用()括起来的是方法参数
     * 花括号{}中间的是方法的代码
     */
    public static void main(String[] args) {
        // 方法的代码每一行用;结束
        System.out.println("Hello, world!");
        int num = '中';
        System.out.println("\\u" + num);

        int[] ns = new int[]{1, 2, 3, 4, 5};
        System.out.println(ns.length);
    }
}
