package io.zbc.learning.java.algorithm.sort;

import java.util.Arrays;

public class BubbleSort implements Sort {
    public static void main(String[] args) {
//        int[] array = {5, 3, 2, 6, 1, 4};
//        int[] array = {1, 2, 3, 5, 4};
        int[] array = {2, 1, 3, 4, 5, 6, 7};
        array = SortUtil.randomIntArray(7, 10);
        new BubbleSort().sort(array);
    }

    @Override
    public int[] sort(int[] array) {
        int len = array.length - 1;
        int temp = 0;
        int exchangeCounts = 0;
        int position = len;
        for (int i = 0; i < array.length - 1; i++) {
            exchangeCounts = 0;
            System.out.println("----------------第" + (i + 1) + "次排序----------------");
            for (int j = 0; j < len; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    exchangeCounts++;
                    position = j;
                }
                System.out.println("第" + (i + 1) + "次排序的第" + (j + 1) + "次比较：" + Arrays.toString(array));
            }
            len = position;
            System.out.println("第" + (i + 1) + "次排序结果：" + Arrays.toString(array));
            if (exchangeCounts == 0) {
                return array;
            }
        }
        return array;
    }

}
