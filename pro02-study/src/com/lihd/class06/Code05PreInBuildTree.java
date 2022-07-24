package com.lihd.class06;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * 中等 : 105
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/5/12 23:10
 */
public class Code05PreInBuildTree {
    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int pL, int pR, int[] inorder, int iL, int iR) {
        if (pL > pR) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[pL]);
        if (pL == pR) {
            return node;
        }
        int mid = iL;
        while (inorder[mid] != preorder[pL]) {
            mid ++;
        }
        node.left = buildTree(preorder, pL + 1, mid - iL + pL, inorder, iL, mid - 1);
        node.right = buildTree(preorder, mid - iL + pL + 1, pR, inorder, mid + 1, iR);
        return node;

    }


    //使用一个map 对上面的代码进行小优化
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }

    public TreeNode buildTree(int[] preorder, int pL, int pR, int[] inorder, int iL, int iR,HashMap<Integer, Integer> map) {
        if (pL > pR) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[pL]);
        if (pL == pR) {
            return node;
        }
        int mid = map.get(preorder[pL]);
        node.left = buildTree(preorder, pL + 1, mid - iL + pL, inorder, iL, mid - 1, map);
        node.right = buildTree(preorder, mid - iL + pL + 1, pR, inorder, mid + 1, iR, map);
        return node;
    }
}
