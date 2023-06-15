public class StudentLinkedList implements StudentList {

	StudentNode head;
	int count;

	public StudentLinkedList() {
		head = null;
		count = 0;
	}

	public void add(Student s) {
		StudentNode ye = new StudentNode(s);
		StudentNode cur = head;
		if(head == null){
			head = ye;
			count++;
		}else{
			while(cur.next != null){
				cur = cur.next;
			}
			cur.next = ye;
			ye.next = null;
			count++;
		}
	}

	public int size() {
		return count;
	}

	public void removeFront() {
		StudentNode cur = head;
		if(head != null){
			cur = cur.next;
			head.next = null;
			head = cur;
			count--;
		}
	}

	public boolean contains(Student s) {
		StudentNode cur = head;
		while(cur != null){
			if(cur.getData().equals(s)){
				return true;
			}

			cur = cur.next;
		}
		return false;
	}
	
	/*
	 * Purpose: returns a String reprensentation of elements
	 *      in this list separated by newlines
	 * Parameters: none
	 * Returns: String - the representation
	 */
	public String toString() {
		// DO NOT CHANGE THIS METHOD - it is correct
		// Changing it will result in your code getting
		// a score of 0 from the autograder for this lab
		
		String s = "";
		StudentNode tmp = head;

		while(tmp != null) {
			s  += tmp.getData() + "\n";
			tmp = tmp.next;
		}

		return s;
	}
}
