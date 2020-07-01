package juc;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.bilibili.com/video/BV1vE411D7KE?p=4
 * 1 故障现象
 * 2 导致原因
 * 3 结局方法
 * 4 优化建议
 *
 *
 **/

public class ListNotSafe01 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("a");
        list.add("a");
        list.forEach(System.out::println);
    }
}
