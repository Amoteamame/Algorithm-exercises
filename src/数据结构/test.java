package 数据结构;

import org.junit.Test;

/**
 * Created by htFly on 2020/3/1.
 */
public class test {

    @Test
    public void testSingleLinkedList(){
        SingleLinkedList singleList = new SingleLinkedList();
        singleList.addNode("A");
        singleList.addNode("B");
        singleList.addNode("C");
        singleList.addNode("D");
        //打印当前链表信息
        singleList.display();
        //删除C
        singleList.deleteNode("C");
        singleList.display();
        //查找B
        System.out.println(singleList.find("B"));
    }
}
