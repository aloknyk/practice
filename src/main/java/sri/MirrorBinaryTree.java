package sri;

public class MirrorBinaryTree {
	private class Node {
		int data;
		Node left,right;
		
		Node(int item){
			data = item;
			left=null;
			right=null;
		}
	}
	
	Node tree;
	
	private Node insertLeft(Node t,int item){
		if(null != t.left){
			t.left = insertLeft(t.left, item);
		}
		else {
			t.left = new Node(item);
		}
		return t;
	}
	
	private Node insertRight(Node t,int item){
		if(null != t.right){
			t.right = insertRight(t.right, item);
		}
		else {
			t.right = new Node(item);
		}
		return t;
	}

	public static void main(String[] args) {
		new MirrorBinaryTree().start();
	}

	private  void start() {
		//TODO: read mirrored tree instead of hardcoding
		tree = new Node(10);
		insertLeft(tree, 20);
		insertLeft(tree, 40);
		insertRight(tree, 30);
		
		tree = mirrorTree(tree);
		//TODO: Print mirrored tree
		System.out.println("Test");
	}

	private Node mirrorTree(Node t) {
		if(null != t){
			Node tmp = t.left;
			t.left = mirrorTree(t.right);
			t.right = mirrorTree(tmp);
		}
		return t;
	}

}
