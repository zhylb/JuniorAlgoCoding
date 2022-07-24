package com.lihd.class07;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/5/13 22:34
 */
public class TreeNodeUtils {
    //根据层序序遍历的结果构建一棵树
    public static TreeNode createTree(Integer[] arr) {
        if (arr == null || arr.length == 0 || arr[0] == null) {
            return null;
        }
        int index = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode head = new TreeNode(arr[0]);
        queue.add(head);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            node.left = createTree(arr, index++, arr.length);
            node.right = createTree(arr, index++, arr.length);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return head;
    }

    public static TreeNode createTree(Integer[] arr, int index, int maxIndex) {
        if (index >= maxIndex ||arr[index] == null) {
            return null;
        } else {
            return new TreeNode(arr[index]);
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {4,8,null,6,1,9,null,-5,4,null,null,null,-3,null,10};
        TreeNode root = createTree(arr);

        Code07MaximumSumBST sumBST = new Code07MaximumSumBST();
        int maxSumBST = sumBST.maxSumBST(root);
        System.out.println(maxSumBST);

    }


}
