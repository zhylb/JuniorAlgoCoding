package com.lihd.class07;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/5/13 23:38
 */
public class Code03PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return hasPathSum(root, 0, targetSum);
    }

    public boolean hasPathSum(TreeNode root, int preSum ,int targetSum) {
        preSum += root.val;
        if (root.left == null && root.right == null) {
            //叶子节点
            return preSum == targetSum;
        }

        boolean left = root.left != null && hasPathSum(root.left, preSum, targetSum);
        boolean right = root.right != null && hasPathSum(root.right, preSum, targetSum);

        return left || right;
    }
}
