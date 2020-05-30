package 剑指offer;

import java.util.LinkedList;

/**
 * Created by htFly on 2020/5/29.
 */
public class 字符流中第一个不重复的字符 {
    int[] tmp = new int[128];
    LinkedList<Character> queue = new LinkedList<>();

    public void Insert(char ch) {
        if (tmp[ch - ' '] == 0) {
            queue.add(ch);
        }
        tmp[ch - ' ']++;
    }
    public char FirstApperingOnce() {
        while (!queue.isEmpty() && tmp[queue.getFirst() - ' '] >= 2) {
            queue.removeFirst();
        }
        if (!queue.isEmpty()) {
            return queue.getFirst();
        }
        return '#';
    }
}
