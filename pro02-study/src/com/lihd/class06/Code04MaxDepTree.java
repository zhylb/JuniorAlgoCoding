package com.lihd.class06;

/**
 * 简单 : 104
 * https://leetcode.com/problems/maximum-depth-of-binary-tree
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/5/12 23:07
 */
public class Code04MaxDepTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
