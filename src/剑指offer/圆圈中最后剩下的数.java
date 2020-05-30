package 剑指offer;

import java.util.LinkedList;

/**
 * Created by htFly on 2020/5/27.
 */
public class 圆圈中最后剩下的数 {
    public int LastRemaining_Solution(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        int[] array = new int[n]; // 用数组来模拟环
        int i = -1, step = 0, count = n;
        while (count > 0) {
            i++;
            if (i >= n) {
                i = 0; // 回到环的起点
            }
            if (array[i] == -1) {
                continue;
            }
            step++;
            if (step == m) {
                array[i] = -1;
                step = 0;
                count--;
            }
        }
        return i;
    }

    public int LastRemaining_Solution2(int n, int m) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int bt = 0;
        while (list.size() > 1) {
            bt = (bt + m - 1) % list.size(); // 第一次删掉的位置是从0开始数m-1个位置，以后每次从删掉的下一个节点开始取，所以每次要在bt的索引处加上m-1，因为是环，所以加了以后对链表长度取余
            list.remove(bt);
        }
        return list.size() == 1 ? list.get(0) : -1;
    }
}
