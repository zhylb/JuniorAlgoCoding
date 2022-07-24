package com.lihd.class05;

import java.util.HashSet;

/**
 * 已经验证
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/5/12 18:30
 */
public class Code01BitMap {

    public static class BitMap{
        long[] arr;
        public BitMap(int maxValue) {
            arr = new long[(maxValue + 64) >> 6];
        }

        public void add(int value) {
            arr[value >> 6] |= 1L << (value & 63);
        }

        public void remove(int value) {
            arr[value >> 6] &= ~(1L << (value & 63));
        }

        public boolean contains(int value) {
            return (arr[value >> 6] & 1L << (value & 63)) != 0;
        }

    }

    public static void main(String[] args) {
        System.out.println("测试开始！");
        int max = 10000;
        BitMap bitMap = new BitMap(max);
        HashSet<Integer> set = new HashSet<>();
        int testTime = 10000000;
        for (int i = 0; i < testTime; i++) {
            int num = (int) (Math.random() * (max + 1));
            double decide = Math.random();
            if (decide < 0.333) {
                bitMap.add(num);
                set.add(num);
            } else if (decide < 0.666) {
                bitMap.remove(num);
                set.remove(num);
            } else {
                if (bitMap.contains(num) != set.contains(num)) {
                    System.out.println("2 Oops!");
                    break;
                }
            }
        }
        for (int num = 0; num <= max; num++) {
            if (bitMap.contains(num) != set.contains(num)) {
                System.out.println("1 Oops!");
            }
        }
        System.out.println("测试结束！");
    }



}
