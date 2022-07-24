package com.lihd.class08;

import java.util.Arrays;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/5/15 11:39
 */
public class QuickSort {

    public static void quickSort(int[] arr) {
        quickSort(arr,0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        //至少有两个
        int[] partition = partition(arr, L, R);
        quickSort(arr,L,partition[0] - 1);
        quickSort(arr, partition[1] + 1, R);
    }


    public static int[] partition(int[] arr, int L, int R) {
        int less = L - 1;
        int index = L;
        int more = R;

        while (index < more) {
            if (arr[index] < arr[R]) {
                //小于区
                swap(arr,++less,index++);
            } else if (arr[index] > arr[R]) {
                //大于区
                swap(arr, --more, index);
            } else {
                index ++;
            }
        }
        swap(arr,more,R);
        return new int[]{less + 1, more};
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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
        boolean succeed = true;
        System.out.println("test begin");
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
//            int[] arr3 = copyArray(arr1);
            quickSort(arr1);
            Arrays.sort(arr2);
//            quickSort3(arr3);
            if (!isEqual(arr1, arr2) ) {//|| !isEqual(arr1, arr3)
                System.out.println("Oops!");
                succeed = false;
                break;
            }
        }
        System.out.println("test end");
        System.out.println(succeed ? "Nice!" : "Oops!");

    }
}
