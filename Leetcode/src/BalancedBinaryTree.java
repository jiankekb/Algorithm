
public class BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        if(Math.abs(helper(root.left)-helper(root.right))>1) return false;
        if(isBalanced(root.left)==false) return false;
        if(isBalanced(root.right)==false) return false;
        return true;
	}
	private int helper(TreeNode root) {
		if(root==null) return 0;
		int deep = 1;
		int dl = helper(root.left);
		int dr = helper(root.right);
		deep+= dl>dr? dl:dr;
        return deep;
	}
	public static void main(String[] args) {

	}
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
