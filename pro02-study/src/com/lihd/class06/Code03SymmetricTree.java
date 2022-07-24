package com.lihd.class06;

/**
 * 简单 : 101
 * 测试链接：https://leetcode.com/problems/symmetric-tree
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/5/12 23:01
 */
public class Code03SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root,root);
    }

    public boolean isSymmetric(TreeNode rootA, TreeNode rootB) {
        if (rootA == null ^ rootB == null) {
            return false;
        }

        if (rootA == null) {
            return true;
        }

        return rootA.val == rootB.val && isSymmetric(rootA.left, rootB.right) && isSymmetric(rootA.right, rootB.left);
    }
}
