package com.lihd.class04;

import java.util.ArrayList;
import java.util.List;

/**
 * 已经验证
 * 单双链表的反转
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/5/12 13:13
 */
public class Code01ListReverse {

    //单链表的反转
    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    //双链表的反转
    public static DoubleNode reverseList(DoubleNode head) {
        if (head == null) {
            return null;
        }
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }


    //=============================================
    //测试代码 在下面 只要结果正确就可以
    //=============================================

    public static ListNode testReverseLinkedList(ListNode head) {
        if (head == null) {
            return null;
        }
        ArrayList<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        list.get(0).next = null;
        int N = list.size();
        for (int i = 1; i < N; i++) {
            list.get(i).next = list.get(i - 1);
        }
        return list.get(N - 1);
    }

    public static DoubleNode generateRandomDoubleList(int len, int value) {
        int size = (int) (Math.random() * (len + 1));
        if (size == 0) {
            return null;
        }
        size--;
        DoubleNode head = new DoubleNode((int) (Math.random() * (value + 1)));
        DoubleNode pre = head;
        while (size != 0) {
            DoubleNode cur = new DoubleNode((int) (Math.random() * (value + 1)));
            pre.next = cur;
            cur.last = pre;
            pre = cur;
            size--;
        }
        return head;
    }

    // for test
    public static List<Integer> getDoubleListOriginOrder(DoubleNode head) {
        List<Integer> ans = new ArrayList<>();
        while (head != null) {
            ans.add(head.val);
            head = head.next;
        }
        return ans;
    }

    // for test
    public static boolean checkDoubleListReverse(List<Integer> origin, DoubleNode head) {
        DoubleNode end = null;
        for (int i = origin.size() - 1; i >= 0; i--) {
            if (!origin.get(i).equals(head.val)) {
                return false;
            }
            end = head;
            head = head.next;
        }
        for (int i = 0; i < origin.size(); i++) {
            if (!origin.get(i).equals(end.val)) {
                return false;
            }
            end = end.last;
        }
        return true;
    }





    // for test
    public static ListNode generateRandomLinkedList(int len, int val) {
        int size = (int) (Math.random() * (len + 1));
        if (size == 0) {
            return null;
        }
        size--;
        ListNode head = new ListNode((int) (Math.random() * (val + 1)));
        ListNode pre = head;
        while (size != 0) {
            ListNode cur = new ListNode((int) (Math.random() * (val + 1)));
            pre.next = cur;
            pre = cur;
            size--;
        }
        return head;
    }



    // for test
    public static List<Integer> getLinkedListOriginOrder(ListNode head) {
        List<Integer> ans = new ArrayList<>();
        while (head != null) {
            ans.add(head.val);
            head = head.next;
        }
        return ans;
    }

    // for test
    public static boolean checkLinkedListReverse(List<Integer> origin, ListNode head) {
        for (int i = origin.size() - 1; i >= 0; i--) {
            if (!origin.get(i).equals(head.val)) {
                return false;
            }
            head = head.next;
        }
        return true;
    }


    public static DoubleNode testReverseDoubleList(DoubleNode head) {
        if (head == null) {
            return null;
        }
        ArrayList<DoubleNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        list.get(0).next = null;
        DoubleNode pre = list.get(0);
        int N = list.size();
        for (int i = 1; i < N; i++) {
            DoubleNode cur = list.get(i);
            cur.last = null;
            cur.next = pre;
            pre.last = cur;
            pre = cur;
        }
        return list.get(N - 1);
    }


    public static void f(ListNode head) {
        head = head.next;
    }

    // for test
    public static void main(String[] args) {
        int len = 50;
        int val = 100;
        int testTime = 100000;
        System.out.println("test begin!");
        for (int i = 0; i < testTime; i++) {
            ListNode ListNode1 = generateRandomLinkedList(len, val);
            List<Integer> list1 = getLinkedListOriginOrder(ListNode1);
            ListNode1 = reverseList(ListNode1);
            if (!checkLinkedListReverse(list1, ListNode1)) {
                System.out.println("Oops1!");
            }

            ListNode ListNode2 = generateRandomLinkedList(len, val);
            List<Integer> list2 = getLinkedListOriginOrder(ListNode2);
            ListNode2 = testReverseLinkedList(ListNode2);
            if (!checkLinkedListReverse(list2, ListNode2)) {
                System.out.println("Oops2!");
            }

            DoubleNode node3 = generateRandomDoubleList(len, val);
            List<Integer> list3 = getDoubleListOriginOrder(node3);
            node3 = reverseList(node3);
            if (!checkDoubleListReverse(list3, node3)) {
                System.out.println("Oops3!");
            }

            DoubleNode node4 = generateRandomDoubleList(len, val);
            List<Integer> list4 = getDoubleListOriginOrder(node4);
            node4 = reverseList(node4);
            if (!checkDoubleListReverse(list4, node4)) {
                System.out.println("Oops4!");
            }

        }
        System.out.println("test finish!");
    }

}
