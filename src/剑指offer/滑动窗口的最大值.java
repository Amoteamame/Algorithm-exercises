package 剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by htFly on 2020/5/31.
 */
public class 滑动窗口的最大值 {
    public static ArrayList<Integer> maxInWindows(int [] num, int size) {

        if (num == null || num.length == 0 || size <= 0 || num.length < size) {
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> result = new ArrayList<>();
        //双端队列，用来记录每个窗口的最大值下标
        LinkedList<Integer> qmax = new LinkedList<>();
        int index = 0;
        for (int i = 0; i < num.length; i++) {
            while (!qmax.isEmpty() && num[qmax.peekLast()] < num[i]) {
                qmax.pollLast();
            }
            qmax.addLast(i);
            //判断队首元素是否过期
//            if (qmax.peekFirst() == i - size) {
            if (i-qmax.peekFirst() >  size-1) {
                qmax.pollFirst();
            }
            //向result列表中加入元素
            if (i >= size - 1) {
                result.add(num[qmax.peekFirst()]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] num = {2, 3, 4, 2, 6, 2, 5, 1};
        maxInWindows(num, 3);
    }

}

