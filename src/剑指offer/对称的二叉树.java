package 剑指offer;

import java.util.Stack;

/**
 * Created by htFly on 2020/5/30.
 */

public class 对称的二叉树 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    boolean isSymmetrical(TreeNode pRoot)
    {
        if (pRoot == null) {
            return true;
        }
        return comRoot(pRoot.left, pRoot.right);
    }

    private boolean comRoot(TreeNode left, TreeNode right) {
        if(left==null) return right == null;
        if(right==null) return false;
        if(left.val != right.val) return false;
        return comRoot(left.right, right.left) && comRoot(left.left, right.right);
    }

    boolean isSymmetrical2(TreeNode pRoot)
    {
        if (pRoot==null) return true;
        Stack<TreeNode> s = new Stack<>();
        s.push(pRoot.left);
        s.push(pRoot.right);
        while (!s.empty()) {
            TreeNode right = s.pop();
            TreeNode left = s.pop();
            if(left == null && right ==null) continue;
            if(left == null || right ==null) return false;
            if(left.val != right.val) return false;
            s.push(left.left);
            s.push(right.right);
            s.push(left.right);
            s.push(right.left);
        }
        return true;
    }
}
