import java.util.*;

public class BSTMap<K extends Comparable<K>, V > implements  Map<K, V>  {
    
	BinarySearchTree<K,V> bst;

	public BSTMap () {
		bst = new BinarySearchTree<K,V>();
	}

	public boolean containsKey(K key) {
		// TODO: implement this
		BSTNode<K,V> cur = bst.root;
		return containsKeyRec(key, cur);
	}
	
	private boolean containsKeyRec(K key, BSTNode<K,V> cur)
	{
		if (cur.key.compareTo(key) == 0)
		{
			return true;
		}
		else if(cur.key.compareTo(key) < 0)
		{
			if(cur.left != null)
			{
				return containsKeyRec(key, cur.left);
			}
		}
		else
		{		
			if(cur.right != null)
			{
				return containsKeyRec(key, cur.right);
			}
		}
		return false;
	}

	public V get (K key) throws KeyNotFoundException {
		// TODO: implement this
		return bst.find(key);
	}

	public List<Entry<K,V> >	entryList() {
		// TODO: implement this
		return bst.entryList(); // so it compiles
	}

	public void put (K key, V value) {
		// TODO: implement this
		bst.insert(key,value);
	}

	public int size() {
		// TODO: implement this
		return bst.size(); // so it compiles
	}

	public void clear() {
		// TODO: implement this
		bst.clear();
	}

}