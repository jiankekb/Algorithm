

//此题与排序数组构造二分平衡搜索树有点类似，都用到了递归和深度优先的原则
public class ConvertSortedListtoBinarySearchTree {
	private ListNode temp = null;
	public TreeNode sortedListToBST(ListNode head) {
		if(head==null)return null;
		temp = head;
		ListNode runner = head;
		int len = 0;
		while(runner!=null){
			len++;
			runner = runner.next;
		}
		return helper(0,len-1);
    }
	private TreeNode helper(int first, int end) {
		if(first > end) return null;
		int mid = first + (end - first)/2;
		TreeNode left = helper(first , mid-1);
		TreeNode root = new TreeNode(temp.val);
		root.left = left;
		temp = temp.next;
		TreeNode right = helper(mid+1 , end);
		root.right = right;
		return root;
	}
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		l1.next = l2;l2.next = l3;
		new ConvertSortedListtoBinarySearchTree().sortedListToBST(l1);

	}
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	//Definition for singly-linked list.
	public static class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
	}
}
