package 数据结构;

/**
 * https://www.cnblogs.com/ysocean/p/7928988.html
 * 单向链表的具体实现
 * 单链表是链表中结构最简单的。一个单链表的节点(Node)分为两个部分，第一个部分(data)保存或者显示关于节点的信息，
 * 另一个部分存储下一个节点的地址。最后一个节点存储地址的部分指向空值。
 *
 * 单向链表只可向一个方向遍历，一般查找一个节点的时候需要从第一个节点开始每次访问下一个节点，一直访问到需要的位置。
 * 而插入一个节点，对于单向链表，我们只提供在链表头插入，只需要将当前插入的节点设置为头节点，next指向原头节点即可。
 * 删除一个节点，我们将该节点的上一个节点的next指向该节点的下一个节点。
 */
public class SingleLinkedList {
    private int size;// 链表节点的个数
    private Node head;//头节点

    public SingleLinkedList() {
        size =0;
        head = null;
    }

    // 节点类
    private class Node {
        private Object data;//每个节点的数据
        private Node next;//每个节点指向下一个节点的连接

        public Node(Object data) {
            this.data = data;
        }
    }

    // 在表头添加元素

    public Object addNode(Object data) {
        Node newNode = new Node(data);
        if (size == 0) {
            head = newNode;
        }else{
            newNode.next = head;
            head = newNode;
        }
        size++;
        return data;
    }

    // 在表头删除元素
    public Object deleteNode() {
        Object data = head.data;
        head =  head.next;
        size--;
        return data;
    }

    // 查找指定元素
    public Node find(Object object) {
        Node current = head;
        for (int i = 0; i < size; i++) {
            if (current.data == object) {
                return current;
            } else {
                current = current.next;
            }
        }
        return null;
    }
    // 删除指定节点
    public boolean deleteNode(Object obj) {
        if (size == 0) {
            return false;
        }
        Node preNode = head; //记录current前一个节点
        Node current = head;

        while (current.data != obj) {
            if (current.next == null) {
                return false;
            } else {
                preNode = current;
                current = current.next;
            }
        }
        preNode.next = current.next;
        size--;
        return true;
    }

    //判断链表是否为空
    public boolean isEmpty(){
        return (size == 0);
    }

    //显示节点信息
    public void display(){
        if(size >0){
            Node node = head;
            int tempSize = size;
            if(tempSize == 1){//当前链表只有一个节点
                System.out.println("["+node.data+"]");
                return;
            }
            while(tempSize>0){
                if(node.equals(head)){
                    System.out.print("["+node.data+"->");
                }else if(node.next == null){
                    System.out.print(node.data+"]");
                }else{
                    System.out.print(node.data+"->");
                }
                node = node.next;
                tempSize--;
            }
            System.out.println();
        }else{//如果链表一个节点都没有，直接打印[]
            System.out.println("[]");
        }

    }
}
