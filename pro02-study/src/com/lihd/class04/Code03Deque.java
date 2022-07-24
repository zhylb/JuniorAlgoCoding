package com.lihd.class04;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 已验证
 * 模拟一个双端队列 操作都是 O(1)
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/5/12 12:49
 */
public class Code03Deque<T> {

    public static class Node<T> {
        T val;
        Node<T> next;
        Node<T> last;
        public Node(T val) {
            this.val = val;
        }
    }
    Node<T> head;
    Node<T> tail;
    int size;

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void addFormHead(T t) {
        Node<T> node = new Node<>(t);
        size ++;
        if (head == null) {
            head = node;
            tail = node;
        }else{
            node.next = head;
            head.last = node;
            head = node;
        }
    }

    public void addFormTail(T t) {
        Node<T> node = new Node<>(t);
        size ++;
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.last = tail;
            tail = node;
        }
    }

    public T pollFromHead() {
        if (isEmpty()) {
            return null;
        }
        T ans = head.val;
        size --;

        head = head.next;
        if (head == null) {
            tail = null;
        } else {
            head.last = null;
        }
        return ans;
    }

    public T pollFromTail() {
        if (isEmpty()) {
            return null;
        }
        T ans = tail.val;
        size --;

        tail = tail.last;
        if (tail == null) {
            head = null;
        } else {
            tail.next = null;
        }
        return ans;
    }

    public T peekFromHead(){
        if (isEmpty()) {
            return null;
        }
        return head.val;
    }

    public T peekFromTail(){
        if (isEmpty()) {
            return null;
        }
        return tail.val;
    }


    public static void testDeque() {
        Code03Deque<Integer> myDeque = new Code03Deque<>();
        Deque<Integer> test = new LinkedList<>();
        int testTime = 5000000;
        int maxValue = 200000000;
        System.out.println("测试开始！");
        for (int i = 0; i < testTime; i++) {
            if (myDeque.isEmpty() != test.isEmpty()) {
                System.out.println("1 Oops!");
            }
            if (myDeque.size() != test.size()) {
                System.out.println("2 Oops!");
            }
            double decide = Math.random();
            if (decide < 0.33) {
                int num = (int) (Math.random() * maxValue);
                if (Math.random() < 0.5) {
                    myDeque.addFormHead(num);
                    test.addFirst(num);
                } else {
                    myDeque.addFormTail(num);
                    test.addLast(num);
                }
            } else if (decide < 0.66) {
                if (!myDeque.isEmpty()) {
                    int num1 = 0;
                    int num2 = 0;
                    if (Math.random() < 0.5) {
                        num1 = myDeque.pollFromHead();
                        num2 = test.pollFirst();
                    } else {
                        num1 = myDeque.pollFromTail();
                        num2 = test.pollLast();
                    }
                    if (num1 != num2) {
                        System.out.println("3 Oops!");
                    }
                }
            } else {
                if (!myDeque.isEmpty()) {
                    int num1 = 0;
                    int num2 = 0;
                    if (Math.random() < 0.5) {
                        num1 = myDeque.peekFromHead();
                        num2 = test.peekFirst();
                    } else {
                        num1 = myDeque.peekFromTail();
                        num2 = test.peekLast();
                    }
                    if (num1 != num2) {
                        System.out.println("4 Oops!");
                    }
                }
            }
        }
        if (myDeque.size() != test.size()) {
            System.out.println("Oops!");
        }
        while (!myDeque.isEmpty()) {
            int num1 = myDeque.pollFromHead();
            int num2 = test.pollFirst();
            if (num1 != num2) {
                System.out.println("5 Oops!");
            }
        }
        System.out.println("测试结束！");
    }

    public static void main(String[] args) {
        testDeque();
    }





}
