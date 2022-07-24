package com.lihd.class01;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/5/9 20:35
 */
public class Code01GetBinary {
    public static void printBinary(int num){
        for (int i = 31; i >= 0; i--) {
            String value = (num & (1 << i)) != 0 ? "1" : "0";
            System.out.print(value);
        }
        System.out.println();
    }
    public static void main(String[] args) {
        //深刻理解 为什么负数 要取反 + 1 这是为了其他的+ - * / 都可以使用一套逻辑
        int num = Integer.MIN_VALUE;
        printBinary(num);
        //一个数 取反 + 1 就等于其相反数
        printBinary(~num + 1);
        printBinary(-num);
    }
}
