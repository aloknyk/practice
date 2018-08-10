package sri.test;

import sri.search.MyBST;

/**
 * Created by sravind0 on 07-Aug-18.
 */
public class TestMyBST {

    public static void main(String[] args) {
        MyBST tree = new MyBST();
        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80 */
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println("is 40 present ? "+tree.search(40));
        System.out.println("is 23 present ? "+tree.search(23));
    }
}
