package com.lihd.class02;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/5/10 8:38
 */
public class Code01PreSum {


    public static int[] getPreSumArr(int[] arr){
        if(arr == null || arr.length == 0){
            return null;
        }

        int[] preSumArr = new int[arr.length];
        preSumArr[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            preSumArr[i] = arr[i] + preSumArr[i - 1];
        }
        return preSumArr;
    }

    //再好好想一想
    public static int[][] getPreSumMatrix(int[] arr){
        if(arr == null || arr.length == 0){
            return null;
        }

        int[][] preSumMatrix = new int[arr.length][arr.length];

        preSumMatrix[0][0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            preSumMatrix[0][i] = preSumMatrix[0][i - 1] + arr[i];
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                preSumMatrix[i][j] = preSumMatrix[i - 1][j] - preSumMatrix[i - 1][i - 1];
            }
        }
        return preSumMatrix;
    }

    public static int getSum(int[] preSumArr,int L, int R){
        if(L > R) {
            throw new RuntimeException("范围错误");
        }
        if(L == 0){
            return preSumArr[R];
        }
        return preSumArr[R] - preSumArr[L - 1];
    }

    public static int getSum(int[][] preSumMatrix, int L, int R) {
        return preSumMatrix[L][R];
    }

    public static void main(String[] args) {
        int[] arr = {4, 8, 3, 6, 2, -9, 6, 3};

        int[] preSumArr = getPreSumArr(arr);
        int[][] preSumMatrix = getPreSumMatrix(arr);

        int sum1 = getSum(preSumArr, 2, 7);
        int sum2 = getSum(preSumMatrix, 2, 7);

        System.out.println("sum1 = " + sum1);
        System.out.println("sum2 = " + sum2);

    }


}
