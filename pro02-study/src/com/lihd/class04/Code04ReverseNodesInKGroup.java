package com.lihd.class04;

/**
 * 测试链接：https://leetcode.com/problems/reverse-nodes-in-k-group/
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/5/12 10:56
 */
public class Code04ReverseNodesInKGroup {

    //--------------请编写代码 不要改方法签名----------
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 0) {
            return head;
        }

        ListNode kNode = getKNode(head, k);
        if (kNode == null) {
            return head;
        }
        reverseKGroup(head, kNode);
        ListNode lastHead = head;
        ListNode start = lastHead.next;

        while (start != null) {
            ListNode node = getKNode(start, k);
            if (node == null) {
                return kNode;
            }
            reverseKGroup(start, node);
            lastHead.next = node;
            lastHead = start;
            start = lastHead.next;
        }
        return kNode;
    }


    //保证 start 和 end不是null
    //记录 : 这个方法错的很严重 调试了很久才好 目前是正确的
    public void reverseKGroup(ListNode start, ListNode end) {
        end = end.next;
        ListNode pre = end;
        ListNode cur = start;
        ListNode next = null;
        while (cur != end) {
            next = cur.next;

            cur.next = pre;
            pre = cur;

            cur = next;
        }
    }

    //可能返回null 如果不返回空 [start,return] 一共包含k个节点
    public ListNode getKNode(ListNode start, int k) {

        while (--k > 0 && start != null) {
            start = start.next;
        }
        return start;
    }
}
