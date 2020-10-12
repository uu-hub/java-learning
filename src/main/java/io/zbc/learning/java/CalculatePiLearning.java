package io.zbc.learning.java;

public class CalculatePiLearning {
    public static void main(String[] args) {
        double pi = 0;
        long j = 0;
        // 圆周率π可以使用公式计算：π/4 = 1 - 1/3 + 1/5 - 1/7 + 1/9 ……
        // int <= 2147483647
        long start = System.currentTimeMillis();
        for (long i = 1; i < 9223372036854775807L; i = i + 2, j++) {
            pi += (1.0 / i) * Math.pow(-1, j);
        }
        System.out.println(pi * 4);
        System.out.println("计算次数：" + j);
        System.out.println("计算耗时：" + (System.currentTimeMillis()-start) + "ms");
    }
}
