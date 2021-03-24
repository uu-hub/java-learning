package io.zbc.learning.java.algorithm.sort;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class SortUtil {
    /**
     * 生成随机int数组
     *
     * @param length 生成数组的长度，随机数范围为0~(length-1)
     * @param seed 保证多次调用生成同样的数组
     * @return
     */
    public static int[] randomIntArray(int length, long seed) {
        int[] array = new int[length];
        Set<Integer> randomSet = new LinkedHashSet<Integer>();
        Random r = new Random(seed);
        while (randomSet.size() < length) {
            randomSet.add(r.nextInt(length));
        }
        for (int i = 0; i < randomSet.size(); i++) {
            array[i] = (int) randomSet.toArray()[i];
        }
        return array;
    }
}
