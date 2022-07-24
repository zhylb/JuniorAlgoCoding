package com.lihd.class03;

import java.util.Arrays;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/5/10 17:20
 */
public class Code02LocalMin {


    public static int getLocalMin(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        //至少有一个元素
        if (arr.length == 1) {
            return arr[0];
        }
        //至少有两个元素 判断两个边界是否满足条件
/*        这里代码都没有用了
        if (arr[0] < arr[1]) {
            return arr[0];
        }
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr[arr.length - 1];
        }
        //此时至少有三个元素 并且边界都不是局部最小*/
        int L = 0;
        int R = arr.length - 1;
        while (R - L >= 2) {//至少有三个元素 进去循环
            int mid = L + ((R - L) >> 1);
            if (arr[mid] < arr[mid + 1] && arr[mid] < arr[mid - 1]) {
                return mid;
            } else if (arr[mid] > arr[mid - 1]) {
                //在左边找
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return arr[L] < arr[R] ? L : R ;
    }

    public static boolean isLocalMin(int[] arr,int index) {
        if(arr.length == 1 || index < 0){
            return true;
        }
        boolean leftLessThan = index - 1 < 0 || arr[index] < arr[index - 1];
        boolean rightLessThan = index + 1 >= arr.length || arr[index] < arr[index + 1];
        return leftLessThan && rightLessThan;
    }

    public static int[] createLocalMinArr(int maxLen, int maxValue) {
        int len = getRandom(maxLen);
        int[] arr = new int[len];
        if (len > 0) {
            //至少有一个元素
            arr[0] = getRandom(maxValue);

            for (int i = 1; i < arr.length; i++) {
                do {
                    arr[i] = getRandom(maxValue);
                } while (arr[i] == arr[i - 1]);
            }
        }
        return arr;
    }

    public static int getRandom(int maxValue) {
        return (int) (Math.random()*maxValue);
    }

    public static void main(String[] args) {
        int maxValue = 10;
        int maxLen = 10;
        int testTimes = 100;
        for (int i = 0; i < testTimes; i++) {
            int[] localMinArr = createLocalMinArr(maxLen, maxValue);
            int localMin = getLocalMin(localMinArr);

            if (!isLocalMin(localMinArr, localMin)) {
                System.out.println(Arrays.toString(localMinArr));
                System.out.println(localMin);
                System.out.println("测试失败");
            }
        }
    }

}
