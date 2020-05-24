package 剑指offer;

/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 *
 * 在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树
 */
public class 平衡二叉树 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public int cheat(TreeNode root) {
        if (root==null) return 0;
        int left = cheat(root.left);
        int right= cheat(root.right);
        return (left>=0 && right >=0 && Math.abs(left-right)<=1)? 1+Math.max(left, right) : -1;
    }

    public boolean IsBalanced_Solution(TreeNode root) {
        return cheat(root) >= 0;
    }


}
