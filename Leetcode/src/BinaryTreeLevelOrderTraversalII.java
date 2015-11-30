import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversalII {
	List<List<Integer>> res = new ArrayList<List<Integer>>();
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		if(root==null) return res; 
		List<TreeNode> list = new ArrayList<TreeNode>();
		list.add(root);
		traverseTree(list);
		List<List<Integer>> temp = new ArrayList<List<Integer>>();
		//逆序
		for(int i=res.size()-1;i>=0;i--){
			temp.add(res.get(i));
		}
		return temp;
	}
	//每一次递归都把一层的节点存入list当中
	private void traverseTree(List<TreeNode> list) {
		List<TreeNode> temp = new ArrayList<TreeNode>();
		if(list.size()==0)return;
		List<Integer> num = new ArrayList<Integer>();
		for(int i=0;i<list.size();i++){
			num.add(list.get(i).val);
			if(list.get(i).left!=null){
				temp.add(list.get(i).left);
			}
			if(list.get(i).right!=null){
				temp.add(list.get(i).right);
			}
		}
		res.add(num);
		traverseTree(temp);
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		TreeNode l2 = new TreeNode(9);
		TreeNode l3 = new TreeNode(20);
		TreeNode l4 = new TreeNode(15);
		TreeNode l5 = new TreeNode(7);
		root.left = l2;root.right = l3;
		l3.left = l4;l3.right = l5;
		new BinaryTreeLevelOrderTraversalII().levelOrderBottom(root);
	}
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
