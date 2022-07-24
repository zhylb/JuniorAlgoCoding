package com.lihd.class03;

import java.util.TreeMap;

/**
 * TreeMap四个方法
 * firstKey
 * lastKey
 * floorKey
 * ceilingKey
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/5/10 18:52
 */
public class Code03TestAPI {
    public static void main(String[] args) {
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(1, "吕布");
        map.put(5, "韩信");
        map.put(3, "张辽");
        map.put(8, "华佗");
        map.put(7, "高览");
        System.out.println(map);
        System.out.println(map.firstKey());
        System.out.println(map.lastKey());
        System.out.println(map.ceilingEntry(6));
        System.out.println(map.floorEntry(6));
    }
}
