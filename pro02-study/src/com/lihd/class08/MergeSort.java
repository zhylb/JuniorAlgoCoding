package com.lihd.class08;

import java.util.Arrays;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/5/15 10:10
 */
public class MergeSort {


    //非递归实现归并排序
    public static void mergeSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int gap = 1;
        while (gap < arr.length) {
            int L = 0;
            while (L < arr.length) {
                //一定有左组 哪怕只有一个
                int mid = getIndex(L, gap - 1, arr.length);
                int R = getIndex(mid + 1, gap - 1, arr.length);
                if (R == -1) {
                    //没有右组
                    break;
                }
                merge(arr, L, mid, R);
                if (R == arr.length - 1) {
                    //防止溢出
                    break;
                }
                L = R + 1;
            }
            gap = gap << 1;
            if (gap < 0) {
                break;
            }
        }
    }

    public static int getIndex(int begin, int len,int arrLen) {
        if (begin >= arrLen) {
            return -1;
        }
        if (begin + len < arrLen) {
            return begin + len;
        } else {
            return arrLen - 1;
        }
    }




    public static void merge(int[] arr, int L,int M, int R) {
        int[] help = new int[R - L + 1];

        int leftIndex = L;
        int rightIndex = M + 1;
        int helpIndex = 0;

        while (leftIndex <= M && rightIndex <= R) {

            if (arr[leftIndex] <= arr[rightIndex]) {
                help[helpIndex++] = arr[leftIndex++];
            } else {
                help[helpIndex++] = arr[rightIndex++];
            }
        }
        //此时 leftIndex 和 rightIndex有且仅有一个角标越界
        while (leftIndex <= M) {
            help[helpIndex++] = arr[leftIndex++];
        }
        while (rightIndex <= R) {
            help[helpIndex++] = arr[rightIndex++];
        }

        //复制数组
        for (int i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
    }


    public static void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    public static void mergeSort(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        //至少有两个元素
//        int mid = L + ((R - L) >> 1);
        int mid = (L + R)/2;
        mergeSort(arr, L, mid);
        mergeSort(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            mergeSort(arr1);
//            Arrays.sort(arr2);
            mergeSort2(arr2);
            if (!isEqual(arr1, arr2)) {
                System.out.println("出错了！");
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println("测试结束");
    }



}
