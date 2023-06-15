public class A4Stack<T> implements Stack<T> {
	private A4Node<T> head;

	public A4Stack() {
		head = null;
	}

	public void push(T value){
		A4Node<T> yup = new A4Node<T>(value);
			if(head == null){
			head = yup; 
		}else{
			A4Node<T> cur = head;
			head = yup;
			head.next = cur;
			}
		}


	public T pop(){
			if(head == null){
				return null;
			}else if(head.next == null) {
				A4Node<T> cur1 = head;
				head = null;
				return cur1.getData();
			}else{
			A4Node<T> cur = head.next;
			A4Node<T> cur2 = head;
				head.next = null;
				head = cur;
				return cur2.getData();
			}
	}

	public boolean isEmpty(){
		return (head == null);
	}

	public T top(){
		if(head == null){
			return null;
		}else{
			return head.getData();
		}
	}
	
	public void popAll(){
		head = null;
	}
}