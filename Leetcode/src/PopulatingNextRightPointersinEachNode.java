import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersinEachNode {
	//此题感觉正确答案有点问题，没有左子树就一定直接返回吗，还有不判断右子树为空就直接root.right.next = root.next.left;
	public void connect(TreeLinkNode root) {

        if(root==null||root.left==null)return;
        root.left.next = root.right;
        if(root.next!=null) root.right.next = root.next.left;
        connect(root.left);
        connect(root.right);
        
    }
	public static void main(String[] args) {
		TreeLinkNode root = new TreeLinkNode(1);
		TreeLinkNode l2 = new TreeLinkNode(2);
		TreeLinkNode l3 = new TreeLinkNode(3);
		TreeLinkNode l4 = new TreeLinkNode(4);
		TreeLinkNode l6 = new TreeLinkNode(6);
		TreeLinkNode l7 = new TreeLinkNode(7);
		root.left = l2;root.right = l3;
		l2.left = l4;l3.left = l6;l3.right = l7;
		new PopulatingNextRightPointersinEachNode().connect(root);
	}
	public static class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;
	    TreeLinkNode(int x) { val = x; }
	}
}
