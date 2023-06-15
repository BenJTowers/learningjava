public class ArrayBasedBinarySearchTree extends ArrayBasedBinaryTree{
    private int root;
    private int size;
    private Integer[] treeIndexes;

        public ArrayBasedBinarySearchTree(){
            this.data = new Integer[100];
            this.root = 0;
            this.size = 0;
        }

        public void insert(Integer value){
            insert(root, value);
            size++;
        }

        private void insert(int index, Integer value){
            if(data[index] == null){
                data[index] = value;
                return;
            }else if(data[index] > value){
                insert(this.getLeft(index), value);
            }else if(data[index] <= value){
                insert(this.getRight(index), value);
            }


        }


    
    public static void main(String[] args) {
        ArrayBasedBinarySearchTree emptyTree = new ArrayBasedBinarySearchTree();
        
        ArrayBasedBinarySearchTree myTree = new ArrayBasedBinarySearchTree();
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
    }

}
