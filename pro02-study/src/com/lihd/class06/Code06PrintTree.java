package com.lihd.class06;

import sun.reflect.generics.tree.Tree;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/5/12 23:27
 */
public class Code06PrintTree {

    public static void in(TreeNode node) {
        if (node == null) {
            return;
        }
        in(node.left);
        System.out.print(node.val + ", ");
        in(node.right);
    }

    public static void pre(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + ", ");
        pre(node.left);
        pre(node.right);
    }

    public static void post(TreeNode node) {
        if (node == null) {
            return;
        }
        post(node.left);
        post(node.right);
        System.out.print(node.val + ", ");
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println("\n=====先序=====");
        pre(root);
        System.out.println("\n======中序====");
        in(root);
        System.out.println("\n=====后序=====");
        post(root);

    }

}
