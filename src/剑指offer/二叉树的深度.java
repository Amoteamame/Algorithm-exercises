package 剑指offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.nowcoder.com/practice/435fb86331474282a3499955f0a41e8b?tpId=13&tqId=11191&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class 二叉树的深度 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth=0;
        int width = 0;
        int cur =0;
        TreeNode current;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            cur =0 ;
            width = queue.size();
            while (cur < width) {
                current = queue.poll();
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }

                cur++;
            }
            depth++;



        }
        return depth;
    }

    public int TreeDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = TreeDepth2(root.left);
        int right = TreeDepth2(root.right);
        return Math.max(left, right) + 1;
    }


    public static void main(String[] args) {
        TreeNode root = null;
    }

}
