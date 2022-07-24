package com.lihd.class06;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 测试链接：https://leetcode.com/problems/merge-k-sorted-lists/
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/5/12 22:23
 */
public class Code01MergeSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> heap = new PriorityQueue<>((o1,o2) -> o1.val - o2.val);
        for (ListNode list : lists) {
            if (list != null) {
                heap.add(list);
            }
        }
        if (heap.isEmpty()) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (!heap.isEmpty()) {
            ListNode node = heap.poll();
            if (node.next != null) {
                heap.add(node.next);
            }
            cur.next = node;
            cur = cur.next;
        }
        return dummy.next;
    }

}
