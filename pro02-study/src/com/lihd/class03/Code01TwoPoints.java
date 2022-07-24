package com.lihd.class03;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/5/10 17:03
 */
public class Code01TwoPoints {

    public static boolean binarySearch(int[] arr, int value) {
        if(arr == null || arr.length == 0){
            return false;
        }

        int L = 0;
        int R = arr.length - 1;
        while(L <= R){
            int mid = L + (R - L)>>1;

            if (arr[mid] == value) {
                return true;
            } else if (value > arr[mid]) {
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return false;
    }

    public static int getFirstGE(int[] arr, int value) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int L = 0;
        int R = arr.length - 1;
        int ans = - 1;

        while (L <= R) {
            int mid = L + (R - L) >> 1;
            if (value >= arr[mid]) {
                ans = R;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return ans;
    }

    public static int getLastGE(int[] arr, int value) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int L = 0;
        int R = arr.length - 1;
        int ans = -1;
        while (L <= R) {
            int mid = L + (R - L) >> 1;
            if (value > arr[mid]) {
                L = mid + 1;
            }else{
                ans = R;
                R = mid - 1;
            }
        }
        return ans;
    }


}
