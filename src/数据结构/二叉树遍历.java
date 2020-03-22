package 数据结构;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * https://blog.csdn.net/u011514810/article/details/75907170
 */
public class 二叉树遍历 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 前序遍历,根结点-左孩子-右孩子,递归实现
    public static void preOrder(TreeNode root) {
        if (root != null) {
            System.out.println(root.val + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    // 前序遍历，非递归实现
    /*根据前序遍历访问的顺序，优先访问根结点，然后再分别访问左孩子和右孩子。即对于任一结点，其可看做是根结点，因此可以直接访问，访问完之后，若其左孩子不为空，按相同规则访问它的左子树；当访问其左子树时，再访问它的右子树。因此其处理过程如下：

    对于任一结点P：

    1)访问结点P，并将结点P入栈;

    2)判断结点P的左孩子是否为空，若为空，则取栈顶结点并进行出栈操作，并将栈顶结点的右孩子置为当前的结点P，循环至1);若不为空，则将P的左孩子置为当前的结点P;

    3)直到P为NULL并且栈为空，则遍历结束。*/

    public static ArrayList preOrder1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        ArrayList arrayList = new ArrayList();
        TreeNode p = root;
        while (p != null || !stack.empty()) {
            while (p != null) {
                arrayList.add(p.val);
                stack.push(p);
                p = p.left;
            }
            // 此时是当前节点最左侧的节点
            if (!stack.empty()) {
                TreeNode temp = stack.pop();
                p = temp.right;
            }

        }

        return arrayList;
    }

    // 中序遍历按照“左孩子-根结点-右孩子”的顺序进行访问。
    public static void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            System.out.println(root.val + " ");
            inOrder(root.right);
        }
    }

    /*  根据中序遍历的顺序，对于任一结点，优先访问其左孩子，而左孩子结点又可以看做一根结点，然后继续访问其左孩子结点，直到遇到左孩子结点为空的结点才进行访问，然后按相同的规则访问其右子树。因此其处理过程如下：

      对于任一结点P，

      1)若其左孩子不为空，则将P入栈并将P的左孩子置为当前的P，然后对当前结点P再进行相同的处理；

      2)若其左孩子为空，则取栈顶元素并进行出栈操作，访问该栈顶结点，然后将当前的P置为栈顶结点的右孩子；

      3)直到P为NULL并且栈为空则遍历结束*/
    // 非递归
    public static ArrayList inOrder2(TreeNode root) {
        ArrayList arrayList = new ArrayList();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        while (p != null || !stack.empty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            //遍历到了最左端
            if (!stack.empty()) {
                TreeNode temp = stack.pop();
                arrayList.add(temp.val);
                p = temp.right;
            }
        }

        return arrayList;
    }

    // 后序遍历按照“左孩子-右孩子-根结点”的顺序进行访问。
    public static void postOrder(TreeNode root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.val + " ");
        }
    }

    /* 在后序遍历中，要保证左孩子和右孩子都已被访问并且左孩子在右孩子前访问才能访问根结点，
     要保证根结点在左孩子和右孩子访问之后才能访问，因此对于任一结点P，先将其入栈。如果P不存在左孩子和右孩子，
     则可以直接访问它；或者P存在左孩子或者右孩子，但是其左孩子和右孩子都已被访问过了，则同样可以直接访问该结点。若非上述两种情况，
     则将P的右孩子和左孩子依次入栈，这样就保证了每次取栈顶元素的时候，左孩子在右孩子前面被访问，左孩子和右孩子都在根结点前面被访问。*/
    public static ArrayList postOrder1(TreeNode root) {
        ArrayList arrayList = new ArrayList();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return arrayList;
        }
        TreeNode pre = null, cur = null;
        while (!stack.empty()) {
            cur = stack.peek(); // peek也是取栈顶节点，但是不会像pop一样删除栈顶，只是返回栈顶地址
            if ((cur.left == null && cur.right == null) || (pre != null && (cur.left == pre || cur.right == pre))) {
                TreeNode temp = stack.pop();
                arrayList.add(temp.val);
                pre = temp;
            } else {
                if (cur.right != null) {
                    stack.push(cur.right);
                }
                if (cur.left != null) {
                    stack.push(cur.left);
                }

            }
        }
        return arrayList;
    }

    // 层次遍历
    public static void levelOrder(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>(); //底层实现是个链表
        if (root == null) {
            return;
        }
        queue.offer(root); //当队列为空时候，使用add方法会报错，而offer方法会返回false。

        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll(); //获取并删除列表的第一个元素
            System.out.println(temp.val+" ");
            if (temp.left!=null) {
                queue.offer(temp.left);
            }
            if (temp.right != null) {
                queue.offer(temp.right);
            }
        }
    }
}
