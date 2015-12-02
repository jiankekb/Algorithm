import java.util.ArrayList;
import java.util.List;

public class PathSumII {
	List<List<Integer>> res = new ArrayList<List<Integer>>();
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null) return res;
        List<Integer> sumlist = new ArrayList<Integer>();
        findSumList(root,sumlist,sum);
        return res;
    }
	private void findSumList(TreeNode root, List<Integer> sumlist, int sum) {
		sum -= root.val;
		sumlist.add(root.val);
		if(root.left==null&&root.right==null&&sum==0){
			List<Integer> temp = new ArrayList<Integer>(sumlist);
			res.add(temp);
			return;
		}
		if(root.left!=null){
			findSumList(root.left , sumlist , sum);
			sumlist.remove(sumlist.size()-1);
		}
		if(root.right!=null){
			findSumList(root.right, sumlist, sum);
			sumlist.remove(sumlist.size()-1);
		}
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode l1 = new TreeNode(2);
		TreeNode l2 = new TreeNode(3);
		root.right = l1;
		l1.right = l2;
		System.out.println(new PathSumII().pathSum(root, 6));
	}
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
