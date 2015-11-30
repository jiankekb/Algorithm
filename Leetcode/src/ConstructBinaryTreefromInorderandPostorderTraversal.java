
public class ConstructBinaryTreefromInorderandPostorderTraversal {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		//递归到叶子的后面，则返回
		if(postorder.length==0){
			return null;
		}
		TreeNode root = new TreeNode(postorder[postorder.length-1]);
		int i = 0;
		for(i=0;i<inorder.length-1;i++){
			if(inorder[i] == root.val)
				break;
		}
		//递归左子树
		if(i>0){
			int[] subInorder = new int [i];
			int[] subPostorder = new int [i];
			System.arraycopy(inorder, 0, subInorder, 0, i);
			System.arraycopy(postorder, 0, subPostorder, 0, i);
			root.left = buildTree(subInorder, subPostorder);
		}
		//递归右子树
		if(postorder.length-i-1>0){
			int[] subInorder = new int [postorder.length-i-1];
			int[] subPostorder = new int [postorder.length-i-1];
			System.arraycopy(inorder, i+1, subInorder, 0, postorder.length-i-1);
			System.arraycopy(postorder, i, subPostorder, 0, postorder.length-i-1);
			root.right = buildTree(subInorder, subPostorder);
		}
		return root;
			
    }
	public static void main(String[] args) {
		int[] inorder = {1,2};
		int[] postorder = {2,1};
		new ConstructBinaryTreefromInorderandPostorderTraversal().buildTree(inorder, postorder);
	}
	//Definition for a binary tree node.
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
