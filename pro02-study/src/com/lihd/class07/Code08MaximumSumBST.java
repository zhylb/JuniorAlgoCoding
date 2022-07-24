package com.lihd.class07;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/5/13 21:58
 */
public class Code08MaximumSumBST {

    public static class Info{
        Integer max;
        Integer min;
        boolean isBST;
        int bstSum;
        int maxSum;

        public Info(Integer max, Integer min, boolean isBST, int bstSum, int maxSum) {
            this.max = max;
            this.min = min;
            this.isBST = isBST;
            this.bstSum = bstSum;
            this.maxSum = maxSum;
        }

        public Info(boolean isBST, int bstSum, int maxSum) {
            this.isBST = isBST;
            this.bstSum = bstSum;
            this.maxSum = maxSum;
        }
    }

    public int maxSumBST(TreeNode root) {
        int sum = getMaxSumBSTInfo(root).maxSum;
        return Math.max(sum, 0);
    }

    public Info getMaxSumBSTInfo(TreeNode root) {
        if (root == null) {
            return new Info(true, 0, 0);
        }
        Info leftInfo = getMaxSumBSTInfo(root.left);
        Info rightInfo = getMaxSumBSTInfo(root.right);
        //初始化好最小值和最大值
        int max = root.val;
        int min = root.val;
        if (leftInfo.max != null) {
            max = Math.max(leftInfo.max, max);
            min = Math.min(leftInfo.min, min);
        }
        if (rightInfo.max != null) {
            max = Math.max(rightInfo.max, max);
            min = Math.min(rightInfo.min, min);
        }
        //判断是否是搜索二叉树
        boolean isBST = false;
        int bstSum = 0;
        int maxSum = Math.max(leftInfo.maxSum , rightInfo.maxSum);
        boolean leftLessThan = leftInfo.max == null || leftInfo.max < root.val;
        boolean rightMoreThan = rightInfo.min == null || rightInfo.min > root.val;
        if (leftInfo.isBST && rightInfo.isBST && leftLessThan && rightMoreThan) {
            isBST = true;
            bstSum = leftInfo.bstSum + rightInfo.bstSum + root.val;
            maxSum = Math.max(maxSum, bstSum);
        }
        return new Info(max, min, isBST, bstSum,maxSum);
    }

}
