package sri.search;

/**
 * Created by sravind0 on 07-Aug-18.
 */
public class MyBST {
    private class Node {
        Node left;
        Node right;
        int key;

        private Node(int key) {
            this.key = key;
        }

        private Node(Node left,Node right,int key) {
            this.key = key;
            this.left = left;
            this.right = right;
        }
    }

    Node root = null;

    public Node insert(int key) {
        this.root = insertrec(root,key);
        this.traverseinorder();
        return root;
    }

    private Node insertrec(Node root, int key) {
        if(root == null) {
            root = new Node(key);
            return  root;
        }
        if(root.key == key) {
            return root;
        }
        if(key < root.key) {
            root.left = insertrec(root.left,key);
        }
        else {
            root.right = insertrec(root.right,key);
        }
        return root;
    }

    public boolean search(int key) {
        return searchrec(this.root,key);
    }

    private boolean searchrec(Node node,int key) {
        if(node == null) {
            return false;
        }
        if(node.key == key) {
            return true;
        }
        if(key < node.key) {
            return searchrec(node.left,key);
        }else {
            return searchrec(node.right,key);
        }
    }

    public void traverseinorder() {
        traverseinorderrec(this.root);
    }

    private void traverseinorderrec(Node node) {
        if(node != null) {
            traverseinorderrec(node.left);
            System.out.println(node.key);
            traverseinorderrec(node.right);
        }
    }
}
