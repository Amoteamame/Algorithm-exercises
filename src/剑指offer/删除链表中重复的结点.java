package 剑指offer;

/**
 * Created by htFly on 2020/5/29.
 */
public class 删除链表中重复的结点 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode deleteDuplication(ListNode pHead)
    {
        if (pHead==null || pHead.next==null){return pHead;}
        ListNode Head = new ListNode(0); // 创建了头节点，理解下用例{1,1,1,1,1,1,2}->输出{2}
        Head.next = pHead;
        ListNode pre  = Head;
        ListNode last = Head.next;
        while (last!=null){
            if(last.next!=null && last.val == last.next.val){
                // 找到最后的一个相同节点
                while (last.next!=null && last.val == last.next.val){
                    last = last.next;
                }
                pre.next = last.next;
                last = last.next;
            }else{
                pre = pre.next;
                last = last.next;
            }
        }
        return Head.next;
    }
}
