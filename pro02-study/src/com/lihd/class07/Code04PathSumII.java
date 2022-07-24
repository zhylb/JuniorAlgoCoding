package com.lihd.class07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/5/13 23:47
 */
public class Code04PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        pathSum(root, 0, targetSum, new ArrayList<>(), ans);
        return ans;
    }



    //优化后的代码
    //优化前的代码看老师的
    public void pathSum(TreeNode root, int preSum, int targetSum, List<Integer> preList, List<List<Integer>> ans) {
        preSum += root.val;
        preList.add(root.val);
        if (root.left == null && root.right == null) {
            if (preSum == targetSum) {
                ans.add(new ArrayList<>(preList));
            }
        }else {
            if (root.left != null) {
                pathSum(root.left, preSum, targetSum, preList, ans);
            }
            if (root.right != null) {
                pathSum(root.right, preSum, targetSum, preList, ans);
            }
        }
        preList.remove(preList.size() - 1);
    }

}
