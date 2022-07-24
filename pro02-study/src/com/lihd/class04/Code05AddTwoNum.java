package com.lihd.class04;

import java.util.List;

/**
 * 测试链接：https://leetcode.com/problems/add-two-numbers/
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/5/12 10:38
 */
public class Code05AddTwoNum {

    //-----------编写你的代码  不要写成静态的 ----------------
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null || l2 == null) {
            //尽可能返回一个非空的节点
            return l1 == null ? l2 : l1;
        }

        ListNode longNode = getListNodeLength(l1) >= getListNodeLength(l2) ? l1 : l2;
        ListNode shortNode = longNode != l1 ? l1 : l2;
        ListNode lastNode = longNode;//记录上一个有效的节点
        ListNode head = longNode;
        //Now longNode.len >= shortNode.len
        int carry = 0;
        int num = 0;
        while (shortNode != null) {
            lastNode = longNode;
            int sum = longNode.val + shortNode.val + carry;

            num = sum % 10;
            carry = sum / 10;

            longNode.val = num;

            shortNode = shortNode.next;
            longNode = longNode.next;
        }

        while (longNode != null) {
            lastNode = longNode;
            int sum = longNode.val + carry;
            num = sum % 10;
            carry = sum / 10;
            longNode.val = num;
            longNode = longNode.next;
        }

        if (carry != 0) {
            lastNode.next = new ListNode(carry);
        }
        return head;
    }
    //上面的方法名框架不要改 只改内容

    //获取链表的长度
    public int getListNodeLength(ListNode l) {
        int len = 0;
        while (l != null) {
            l = l.next;
            len++;
        }
        return len;
    }
}
