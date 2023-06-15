import java.lang.Math;
/*
 * RefBasedBinarySearchTree.java
 *
 * A ref-based BinaryTree meant to store values of type Integer
 */
public class RefBasedBinarySearchTree extends RefBasedBinaryTree {
    private int size;

    public RefBasedBinarySearchTree(){
        root = null;
        size = 0;
    }

    public void insert(Integer value){
        if (root == null){
            root = new TreeNode(value);
        }else{
            insert(value, root);
        }
        size++;
    }

    private void insert(Integer value, TreeNode cur){
        if(value < cur.getValue()){
            if(cur.getLeft() != null){
                insert(value, cur.getLeft());
            }else {
                TreeNode t = new TreeNode(value);
                cur.setLeft(t); 
            }
        }else{
            if(cur.getRight() != null){
                insert(value, cur.getRight());
            }else{
                TreeNode t = new TreeNode(value);
                cur.setRight(t); 
            }
        }
    }

    public int sum(){
        int total = 0;
        total = sum(root);
        return total;
    }

    private int sum(TreeNode cur){
        if(cur == null){
            return 0;
        }
        return cur.getValue() + sum(cur.getLeft()) + sum(cur.getRight());
    }

    public boolean find(int val){
        return find(root, val);
    }

    private boolean find(TreeNode cur, int val){
        if(cur == null){
            return false;
        }
        if(cur.data == val){
            return true;
        }
        if(val < cur.data){
            return find(cur.getLeft(),val);
        }
        return find(cur.getRight(),val);
    }

    public int getMax() throws TreeEmptyException{
        if(root == null){
            throw new TreeEmptyException();
        }
        return getMax(root, 0);
    }

    private int getMax(TreeNode cur, int most) throws TreeEmptyException{
        if(cur == null){
            return most;
        }
        if(most < cur.getValue()){
            most = cur.getValue();
        }

        int max = Math.max(getMax(cur.getLeft(), most),getMax(cur.getRight(), most));
        return max;
    }


    public static void main(String[] args) {
        // use these trees to test the methods you will implement
        RefBasedBinarySearchTree emptyTree = new RefBasedBinarySearchTree();
        RefBasedBinarySearchTree myTree = new RefBasedBinarySearchTree();
        myTree.insert(2);
        myTree.insert(1);
        myTree.insert(5);
        myTree.insert(7);
        myTree.insert(0);
        myTree.insert(4);
        myTree.insert(6);
        
        System.out.println("in");
        myTree.inOrder();
        System.out.println("pre");
        myTree.preOrder();
        System.out.println("post");
        myTree.postOrder();
        
        System.out.println("toString\n" + myTree);

        System.out.println("find sum: " + myTree.sum());
        System.out.println("find 6: " + myTree.find(6));
        System.out.println("find 9: " + myTree.find(9));
        try{
            System.out.println("find max: " + myTree.getMax());
        }catch (TreeEmptyException e){
            System.out.println("tree empty");
        }
    }
}
