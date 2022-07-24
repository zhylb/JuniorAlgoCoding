package com.lihd.class01;

import java.util.Arrays;

/**
 * 选择 冒泡 插入
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/5/9 20:50
 */
public class Code03BaseSort {


    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void selectSort(int[] arr){
        if(arr == null){
            return;
        }
        //0 - N - 1
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            // i + 1 - N  上面的N - 1保证了这里的i + 1不会越界
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[minIndex] > arr[j] ? j : minIndex;
            }
            swap(arr,minIndex,i);
        }
    }

    public static void bubbleSort(int[] arr) {
        if(arr == null){
            return;
        }
        // N - 1
        for (int i = arr.length - 1; i >= 1; i--) {
            //0 - i 按道理说应该可以到达 i 但是 我们想要 j 和 j + 1进行操作 于是就 这样了
            for (int j = 0; j < i; j++) {
                if(arr[j] > arr[j + 1]){
                    swap(arr,j, j+1);
                }
            }
        }
    }

    public static void insertSort(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1] ; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 9, 7, 4, 1, 5, 3, 4, 6};
        System.out.println(Arrays.toString(arr));
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }



}
