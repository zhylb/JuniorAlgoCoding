package com.lihd.class06;

/**
 * 简单 : 100
 * https://leetcode.com/problems/same-tree/
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/5/12 22:53
 */
public class Code02SameTree {


    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null ^ q == null) {
            return false;
        }

        if (p == null) { //此时q一定为空 idea他妈的就是不让我写上去 && q == null;
            return true;
        }

        //现在两个都不是null
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

    }
}
