package com.lihd.class07;

/**
 * 简单 : 110
 * https://leetcode.com/problems/balanced-binary-tree
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/5/13 21:43
 */
public class Code02BalanceBinaryTree {

    public static class Info{
        int height;
        boolean isBalancedTree;
        public Info(int height, boolean isBalancedTree) {
            this.height = height;
            this.isBalancedTree = isBalancedTree;
        }
    }

    public boolean isBalanced(TreeNode root) {
        return getBalancedInfo(root).isBalancedTree;
    }

    public Info getBalancedInfo(TreeNode root) {
        if (root == null) {
            return new Info(0, true);
        }
        Info leftInfo = getBalancedInfo(root.left);
        Info rightInfo = getBalancedInfo(root.right);
        int height = Math.max(leftInfo.height,rightInfo.height) + 1;
        boolean isBalancedTree = leftInfo.isBalancedTree && rightInfo.isBalancedTree &&
                Math.abs(leftInfo.height - rightInfo.height) < 2;
        return new Info(height, isBalancedTree);
    }

}
