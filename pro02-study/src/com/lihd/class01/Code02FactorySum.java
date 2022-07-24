package com.lihd.class01;

/**
 * 阶乘前 n 项求和
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/5/9 20:43
 */
public class Code02FactorySum {

    public static long factory(int num){
        long result = 1L;
        for (int i = 2; i <= num; i++) {
            result *= i;
        }
        return result;
    }

    public static long getFactorySum(int num){
        long result = 0;
        for (int i = 1; i <= num; i++) {
            result += factory(i);
        }
        return result;
    }

    public static long getFactorySum2(int num){
        long result = 0;
        long cur = 1;
        for (int i = 1; i <= num; i++) {
            cur *= i;
            result += cur;
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(getFactorySum(10));
        System.out.println(getFactorySum2(10));
    }

}
