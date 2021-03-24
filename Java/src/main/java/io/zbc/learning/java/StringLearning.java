package io.zbc.learning.java;

public class StringLearning {
    public static void main(String[] args) {
        String a = new String("xyz");
        String b = new String("xyz");
        String c = "xyz";
        String d = "xyz";

        System.out.println(a==b);
        System.out.println(c==d);
    }
}
