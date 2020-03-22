package 剑指offer;

import java.util.ArrayList;

/**
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 */
public class 从尾到头打印链表 {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        getArrayList(list, listNode);
        return list;
    }

    public static void getArrayList(ArrayList<Integer> list, ListNode listNode) {
        if (listNode == null)
            return;

        getArrayList(list, listNode.next);
        list.add(listNode.val);
    }


    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode.next = listNode2;
        listNode2.next = listNode3;
        ArrayList<Integer> list =  printListFromTailToHead(listNode);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
