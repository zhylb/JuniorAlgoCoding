package com.lihd.class05;

/**
 * 测试链接：https://leetcode.com/problems/divide-two-integers
 * 已经验证
 * 用位运算实现 + - * /
 * 不得出现 + - * / 请使用位运算 允许使用比较运算符
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/5/12 17:05
 */
public class Code02BitOperate {

    public int add(int a, int b) {
        int sum = a;//这个定义无法省略
        while (b != 0) {
            sum = a ^ b;//无进位相加
            b = (a & b) << 1;//进位
            a = sum;
        }
        return sum;
    }
    public int negNum(int a) {
        return add(~a, 1);
    }
    public int sub(int a, int b) {
        return add(a, negNum(b));
    }

    public int mul(int a, int b) {
        //乘
        int ans = 0;
        while (b != 0) {

            if ((b & 1) != 0) {
                ans = add(ans, a);
            }
            a = a << 1;
            b = b >>> 1;//如果使用 >> 并且b是负数将无法终止循环
        }
        return ans;
    }
    public boolean isNeg(int num) {
        return num < 0;
    }


    public int div(int a, int b) {
        int x = isNeg(a) ? negNum(a) : a;
        int y = isNeg(b) ? negNum(b) : b;
        int ans = 0;
        for (int i = 30; i >= 0; i--) {
            if (x >> i >= y) {
                ans |= 1 << i;
                x = sub(x, y << i);
            }
        }
        return isNeg(a) ^ isNeg(b) ? negNum(ans) : ans;
    }

    public int divide(int a, int b) {
        if (a == Integer.MIN_VALUE && b == Integer.MIN_VALUE) {
            return 1;
        } else if (b == Integer.MIN_VALUE) {
            return 0;
        } else if (a == Integer.MIN_VALUE) {

            if (b == -1) {
                return Integer.MAX_VALUE;
            }
            //比较麻烦
            int c = div(add(a, 1), b);
            return div(sub(a, mul(c, b)), b) + c;
        } else {
            return div(a, b);
        }
    }

    public int div1(int a, int b) {
        int x = a < 0 ? -a : a;
        int y = b < 0 ? -b : b;

        int ans = 0;
        for (int i = 30; i >= 0; i--) {

            if (x >> i >= y) {
                ans |= 1 << i;
                x -= y << i;
            }
        }
        return a > 0 && b > 0 || a < 0 && b < 0 ? ans : -ans;
    }

    public int divide2(int a, int b) {
        if (a == Integer.MIN_VALUE && b == Integer.MIN_VALUE) {
            return 1;
        } else if (b == Integer.MIN_VALUE) {
            return 0;
        } else if (a == Integer.MIN_VALUE) {
            if (b == -1) {
                return Integer.MAX_VALUE;
            }
            int c = (a + 1)/b;
            return  (a - c * b) / b + c;
        } else {
            return div1(a, b);
        }
    }

    public static void main(String[] args) {
        Code02BitOperate o = new Code02BitOperate();
        System.out.println(o.negNum(7));
        System.out.println(o.div(7,3));
        System.out.println(o.sub(7,3));
    }
}
