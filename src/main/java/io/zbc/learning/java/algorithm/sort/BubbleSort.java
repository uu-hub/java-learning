package io.zbc.learning.java.algorithm.sort;

import java.util.Arrays;

public class BubbleSort implements Sort {
    public static void main(String[] args) {
        int[] array = {5, 3, 2, 6, 1, 4};
        new BubbleSort().sort(array);
    }

    @Override
    public int[] sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
            System.out.println("----------------第" + (i + 1) + "次排序----------------");
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
                System.out.println("第" + (i + 1) + "次排序的第" + (j + 1) + "次比较：" + Arrays.toString(array));
            }
            System.out.println("第" + (i + 1) + "次排序结果：" + Arrays.toString(array));
        }
        return array;
    }
}
