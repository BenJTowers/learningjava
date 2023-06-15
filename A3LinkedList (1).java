// Name: Ben Towers
// Student number: v00978554

public class A3LinkedList implements A3List {
	private A3Node head;
	private A3Node tail;
	private int length;
	
	public A3LinkedList() {
		head = null;
		tail = null;
		length = 0;
	}
	
	public void addFront(String s) {
		A3Node ye = new A3Node(s);
		if(head == null){
			head = ye;
			tail = ye;
		}else{
			head.prev = ye;
			ye.next = head;
			head = ye;
		}

	}

	public void addBack(String s) {
		A3Node ye = new A3Node(s);
		if(head == null){
			head = ye;
			tail = ye;
		}else{
			tail.next = ye;
			ye.prev = tail;
			tail = ye;
		}
		
	}
	
	public int size() {
		A3Node cur = head;
		int length = 0;
		while(cur != null){
			length++;
			cur = cur.next;
		}
		return length;
	}
	
	public boolean isEmpty() {
		A3Node cur = head;
		int length = 0;
		while(cur != null){
			length++;
			cur = cur.next;
		}
		if(length == 0){
			return true;
		}else{
			return false;
		}
	}
	
	public void removeFront() {
		if(head != null){
			A3Node cur = head.next;
			if(cur != null){
			cur.prev = null;
			head.next = null;
			head = cur;
		}else{
			head = null;
			tail = null;
		}
		}

	}
	
	public void removeBack() {
		if(tail != null){
			A3Node cur = tail.prev;
			if(cur != null){
			cur.next = null;
			tail.prev = null;
			tail = cur;
		}else{
			tail = null;
			head = null;
		}
		}
	}
	
	
	public void rotate(int n) {
		int i = 0;
		tail.next = head;
		head.prev = tail;
		A3Node end = tail;
		while(i<n){
			end = end.prev;
			i++;
		}
		A3Node start = end.next;
		start.prev = null;
		end.next = null;
		tail = end;
		head = start;
		}
	
	
	public void interleave(A3LinkedList other) {
		A3Node hed1 = head;
		A3Node hed2 = other.head;
		A3Node tal1 = tail;
		A3Node tal2 = other.tail;

		while(hed1.next != null && hed2.next != null){
			A3Node cur1 = hed1.next;
			A3Node cur2 = hed2.next;

			if(hed1.next != null){
				hed2.next = cur1;
				hed1.next = cur2;
				hed1 = cur1;
				hed2 = cur2;
			}

		}
		while(tal1.prev != null && tal2.prev != null){
			A3Node cur1 = tal1.prev;
			A3Node cur2 = tal2.prev;

			if(tal1.prev != null){
				tal2.prev = cur1;
				tal1.prev = cur2;
				tal1 = cur1;
				tal2 = cur2;
			}
		}



	}
	
	/*
	 * Purpose: return a string representation of the list 
	 *          when traversed from front to back
	 * Parameters: none
	 * Returns: nothing
	 */
	public String frontToBack() {
		String result = "{";
		A3Node cur = head;
		while (cur != null) {
			result += cur.getData();
			cur = cur.next;
		}
		result += "}";
		return result;
	}
	
	/*
	 * Purpose: return a string representation of the list 
	 *          when traversed from back to front
	 * Parameters: none
	 * Returns: nothing
	 */
	public String backToFront() {
		String result = "{";
		A3Node cur = tail;
		while (cur != null) {
			result += cur.getData();
			cur = cur.prev;
		}
		result += "}";
		return result;
	}
}
	