
public class MinimumDepthofBinaryTree {
	 private int minDepth = Integer.MAX_VALUE;
	 public int minDepth(TreeNode root) {
		 if(root == null) return 0;
	     findminDepth(root, 1);
	     return minDepth;
	 }
	 private void findminDepth(TreeNode root, int depth) {
		if(root.left == null && root.right == null){
			if(depth <= minDepth) minDepth = depth;
			return;
		}
		depth++;
		if(root.left !=null)
		    findminDepth(root.left, depth);
		if(root.right !=null)
			findminDepth(root.right, depth);
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
