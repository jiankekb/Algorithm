
public class PathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
		return lookSum(root, 0, sum);
    }
	private boolean lookSum(TreeNode root, int temp, int sum) {
		if(root != null) temp += root.val;
		if(root.left==null&&root.right==null){
		    if(temp==sum)
			    return true;
            else return false;	    
		}
		if(root.left!=null&&lookSum(root.left , temp , sum)) return true;
		if(root.right!=null&&lookSum(root.right, temp, sum)) return true;
		return false;
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
