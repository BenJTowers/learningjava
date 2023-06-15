public class A5Exercises {

	// PART 1

	/*
	 * Purpose: get a count of the number of elements in the array
	 *          with a value that is a multiple of x
	 * Parameters: int[] arr
	 * Returns: int - the number multiples of x
	 * Pre-condition: x > 0
	 * Post-condition - the array contents are unchanged
	 */
	public static int countMultiples(int[] arr, int x) {
		return countMultiples(arr ,0 ,x ,0); // so it compiles
	}

	private static int countMultiples(int[] arr,int i, int x,int count) {
		if(i == arr.length){
			return count;
		}else{
		if((arr[i]%x) == 0){
			count++;
		}
		return countMultiples(arr,++i ,x ,count);
	}
	}
		
	/*
	 * Purpose: double all values in the given array
	 * Parameters: int[] array - the array to modify
	 * Returns: void - nothing
	 */
	public static void doubleAll(int[] array) {
		doubleAll(array,0);
	}

	private static void doubleAll(int[] array, int i){
		if(i == array.length){
			return;
		}else{
		array[i] = array[i]*2;
		doubleAll(array, ++i);
		}

	}
	
	/*
	 * Purpose: get the minimum value found in the array
	 * Parameters: int[] array - the array to search
	 * Returns: int - minimum value found in the array
	 *                or -1 if the array is empty
	 * Post-condition - the array contents are unchanged
	 */
	public static int getMinimum(int[] array) {
		if(array.length == 0){
			return -1;
		}else{
		return getMinimum(array, 0, array[0]); // so it compiles
	}
	}
	
	private static int getMinimum(int[] array, int i, int min){
		if(i == array.length){
			return min;
		}else{
		if(array[i] < min){
			min = array[i];
		}
		
		return getMinimum(array, ++i, min);
		}

	}



	// PART II

	/*
	 * Purpose: get the total number of books in s
	 * Parameters: Stack<Book> s - the stack of books
	 * Returns: int - the total number of books
	 * Post-condition: s is not modified
	 */
	public static int totalBooks(Stack<Book> s) {
		int count = 0;
		if(s.isEmpty()){
		return 0;
		}else{
		Book k = s.pop();
		count++;
		count += totalBooks(s);
		s.push(k); 
	}
	return count;
	}

	/*
	 * Purpose: get the total number of pages of all 
	 *          books in the stack
	 * Parameters: Stack<Book> s - the stack of books
	 * Returns: int - the total number of pages
	 * Post-condition: s is not modified
	 */
	public static int totalPages(Stack<Book> s) {
		int count = 0;
		if(s.isEmpty()){
		return 0;
		}else{
		Book k = s.pop();
		count += k.getPages();
		count += totalPages(s);
		s.push(k);
	}
	return count;
	}
	
	/*
	 * Purpose: get the average number of pages of books in s
	 * Parameters: Stack<Book> s - the stack of books
	 * Returns: double - the average number of pages
	 *                   0.0 if there are no books in s
	 * Post-condition: s is not modified
	 */
	public static double averagePages(Stack<Book> s) {
		// You don't need to change this, if you have
		// completed the previous two exercises
		// correctly, it should pass all the tests
		if (s.isEmpty()) {
			return 0.0;
		} else {
			double sum = totalPages(s);
			int count = totalBooks(s);
			return sum/count;
		}
	}

	/*
	 * Purpose: determine whether toFind is contained in s
	 * Parameters: Stack<Book> s - the stack of books
	 *             Book toFind - the book to search for
	 * Returns: boolean - true if s contains toFind, false otherwise
	 * Post-condition: s is not modified
	 */
	public static boolean containsBook(Stack<Book> s, Book toFind) {
		if(s.isEmpty()){
		return false;
		}else{
		boolean bool = false;
		Book k = s.pop();
		bool = containsBook(s, toFind);
		if(k.equals(toFind)){
			bool = true;
		}
		s.push(k);
		return bool;
	}

	}

	/*
	 * Purpose: determine the books in s are stacked correctly
	 *          (ie. there is never a book stacked on top of 
	 *               another book with fewer pages)
	 * Parameters: Stack<Book> s - the stack of books
	 * Returns: boolean - true if books in s are stacked correctly
	 * Post-condition: s is not modified
	 */
	public static boolean stackedCorrectly(Stack<Book> s) {
		if(s.isEmpty()){
		return true;
		}else{
		Book k = s.pop();
		boolean bool = stackedCorrectly(s);
		if(!s.isEmpty()){
		  if(k.getPages() > s.top().getPages()){
			bool = false;
		}
	}
		s.push(k);
		return bool;
	}
}
}