package com.lihd.class04;

/**
 *
 * https://leetcode.com/problems/merge-two-sorted-lists
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/5/12 9:55
 */
public class Code06SortedListMerge {
//    public static class Node {
//        public int value;
//        public Node next;
//        public Node(int value) {
//            this.value = value;
//        }
//    }
//
//    public static Node mergeSortedList(Node head1, Node head2) {
//
//        if (head1 == null || head2 == null) {
//            //链表有一个null 尽可能返回一个不null的节点
//            return head1 == null ? head2 : head1;
//        }
//        //找到较小的节点 作为头部
//        Node head = head1.value <= head2.value ? head1 : head2;
//
//        Node curA = head.next;//代表一个head节点的下一个
//        Node curB = head == head1 ? head : head2;//代表另一个节点
//
//        Node next = head;//用于串起来所有的节点
//
//        while (curA != null && curB != null) {
//            if (curA.value <= curB.value) {//curA 向后面移动
//                next.next = curA;
//                curA = curA.next;
//            } else {
//                next.next = curB;
//                curB = curB.next;
//            }
//            next = next.next;
//        }
//        next.next = curA != null ? curA : curB;
//        return head;
//    }

    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }
        ListNode head;

        if (list1.val <= list2.val) {
            head = list1;
            list1 = list1.next;
        } else {
            head = list2;
            list2 = list2.next;
        }
        ListNode cur = head;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }

        cur.next = list1 == null ? list2 : list1;
        return head;
    }

    //对上面代码的小优化
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        cur.next = list1 == null ? list2 : list1;
        return dummy.next;
    }



}
