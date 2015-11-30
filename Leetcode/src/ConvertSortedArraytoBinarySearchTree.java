
public class ConvertSortedArraytoBinarySearchTree {
	//要考虑清楚边界条件，解法类似于中序后序构造二叉树
	public TreeNode sortedArrayToBST(int[] nums) {
		if(nums.length==0)return null;
        if(nums.length==1){
        	TreeNode node = new TreeNode(nums[0]);
        	return node;
        }
        TreeNode root = new TreeNode(nums[nums.length/2]);
        if(nums.length/2>0){
        	 int[] leftnums = new int[nums.length/2]; 
        	 System.arraycopy(nums, 0, leftnums, 0, nums.length/2);
             root.left = sortedArrayToBST(leftnums);
        }
        if(nums.length%2!=0&&nums.length/2>0){
        	int[] rightnums = new int[nums.length/2];
        	System.arraycopy(nums, nums.length/2+1, rightnums, 0, nums.length/2);
        	root.right = sortedArrayToBST(rightnums);
        }else if(nums.length%2==0&&nums.length/2-1>0){
        	int[] rightnums = new int[nums.length/2-1];
        	System.arraycopy(nums, nums.length/2+1, rightnums, 0, nums.length/2-1);
        	root.right = sortedArrayToBST(rightnums);
        }
        return root;
    }
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		int[] nums = {1,2,3,4};
		TreeNode root = new ConvertSortedArraytoBinarySearchTree().sortedArrayToBST(nums);
	}
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
