package 剑指offer;

/**
 * Created by htFly on 2020/4/25.
 * https://www.nowcoder.com/questionTerminal/d8b6b4358f774294a89de2a6ac4d9337?f=discussion
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class 合并两个排序链表 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    // 递归版
    public ListNode Merge1(ListNode list1,ListNode list2){
        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1;
        if(list1.val<list2.val){
            list1.next = Merge1(list1.next,list2);
            return list1;
        }else{
            list2.next = Merge1(list1,list2.next);
            return list2;
        }
    }

    // 非递归版
    public ListNode Merge2(ListNode list1,ListNode list2){
        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1;

        ListNode mergeHead = null;
        ListNode currentNode = null;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                if (mergeHead == null) {
                    mergeHead = currentNode = list1;
                } else {
                    currentNode.next = list1;
                    currentNode = currentNode.next;
                }
                list1 = list1.next;
            }else {
                if (mergeHead == null) {
                    mergeHead = currentNode = list2;
                } else {
                    currentNode.next = list2;
                    currentNode = currentNode.next;
                }
                list2 = list2.next;
            }
        }

        if (list1 == null) {
            currentNode.next = list2;
        } else {
            currentNode.next = list1;
        }

        return mergeHead;
    }
}
