package com.lihd.class02;

import java.util.Arrays;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/5/10 8:39
 */
public class Code02Random {
    private static final long BIG_TIMES = 100_0000L;

    public static void testFrequency(double mul,double range, long times){
        long count = 0;
        for (long i = 0; i < times; i++) {
            if(mul * Math.random() < range){
                count ++;
            }
        }
        System.out.println((double) count/times);
    }

    public static void testFrequency(long times,Randomise randomise){
        long count = 0;
        for (long i = 0; i < times; i++) {
            if(randomise.random() == 1){
                count ++;
            }
        }
        System.out.println((double) count/times);
    }

    public static void main(String[] args) {
        //testFrequency(1,0.5,BIG_TIMES);
        testFrequency(BIG_TIMES,() -> getGreatXFunc(0.7));
        //两个随机数都小于0.5的概率
        testFrequency(BIG_TIMES,() -> randomMaxX2Func(0.5) < 0.5 ? 1 : 0);
        //两个数任意一个小于0.5的概率
        testFrequency(BIG_TIMES,() -> randomMinX2Func(0.5) < 0.5 ? 1 : 0);

        testFrequency(BIG_TIMES,() -> randomValueAtoB(1,5) > 3 ? 1 : 0);
        testFrequency(BIG_TIMES,() -> generate0or1(1,5));

        int c = 2;
        int d = 10;
        int[] arr = new int[d + 1];
        for (long i = 0; i < BIG_TIMES; i++) {
            arr[randomValueCtoD(c,d,1,5)] ++;
        }

        for (int i = 0; i < d + 1; i++) {
            System.out.println(i +"出现的概率是"+(double) arr[i]/BIG_TIMES);
        }

    }


    public static int getLessXFunc(double X){
        return Math.random() < X ? 1 : 0;
    }

    public static int getGreatXFunc(double X){
        return Math.random() > X ? 1 : 0;
    }

    // 函数 X2
    public static double randomMaxX2Func(double X){
        return Math.max(Math.random(), Math.random());
    }
    // 函数 1 - (1 - X)2
    public static double randomMinX2Func(double X){
        return Math.min(Math.random(), Math.random());
    }

    //等概率返回 [a,b]上的数字
    public static int randomValueAtoB(int a, int b){
        return (int) ((b - a + 1)*(Math.random())) + a;
    }

    //利用黑盒方法 生成0|1生成器方法
    public static int generate0or1(int a, int b){
        int mid = (b + a + 1)/2;
        boolean isEven = (b + a + 1) % 2 == 0;
        if(isEven){
            //等概率返回 0|1 mid的位置是中点靠右的
            //因此< mid 和 >= mid的值各占一半
            //于是 小于 mid 的概率是50%,小于返回1 ,大于返回0
            return randomValueAtoB(a,b) < mid ? 1 : 0;
        }else{
            //是奇数 有一个值不能用!!!
            //这个值就是 mid
            int ans;
            do{
                ans = randomValueAtoB(a, b);
            }while (ans == mid);//如果 ans一直等于这个 无效值 就重新生成随机数 直到不相等
            //因此< mid 和 > mid的值各占一半 =mid的值会一直循环(被抛弃)
            //于是 小于 mid 的概率是50%,小于返回1 ,大于返回0
            return ans < mid ? 1 : 0;
        }

    }

    //利用0|1随机生成器 生成一个区间的数
    //给我一个可以 在a - b 上等概率返回的数
    //我返回一个可以在 c - d上等概率返回的数
    public static int randomValueCtoD(int c,int d,int a,int b){
        int randomMaxValue = d - c;//[0,d-c]
        int binaryValue = 1;
        int binaryBit = 1;
        while(binaryValue < randomMaxValue){// 数组的范围是 [0,d-c] 数组大小是 randomMaxValue + 1
            binaryValue = binaryValue<<1 | 1;
            binaryBit ++;
        }
        int generateRandom;
        do{
            generateRandom = 0;
            //这里的范围就是 [0,binaryBit) 比如二进制位是5, 1 左移4位刚好是第5位, 1 左移0位刚好是1 (第一位)
            for (int i = 0; i < binaryBit; i++) {
                generateRandom += generate0or1(a,b) << i;
            }
            //这里 generateRandom 的值为[0,2的binaryBit方 - 1] 上等概率的随机数
        }while(generateRandom > randomMaxValue);
        //这里generateRandom 的值为 [0,randomMaxValue] -> [0,d - c]
        //同时 + c [c,d]等概率返回
        return generateRandom + c;
    }

}

interface Randomise{
    //0 为假 1 为真
    int random();
}


