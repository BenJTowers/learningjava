public class A4Exercises {
	
	/*
	 * Purpose: determine if the stack of plates has been
	 *          stacked correctly (ie. there is never a plate
	 *          on top of a smaller plate)
	 * Parameters: Stack<Plate> s - a stack of plates
	 * Returns: boolean - true if the plates are stacked correctly
	 *                    false otherwise
	 * Post-condition: the contents of s are not modified
	 */
	public static boolean stackedCorrectly(Stack<Plate> s) {
		Stack<Plate> temp = new A4Stack<Plate>();
		int x = 0;
		int y = 0;
		boolean result = true;
		while(!s.isEmpty()){
			Plate p = s.top();
			temp.push(s.pop());
			x = p.getDiameter();
			if(y > x){
				result = false;
			}
			y = x;
		}
		while(!temp.isEmpty()){
			s.push(temp.pop());
		}
		
		return result; // so it compiles
	}
	
	/*
	 * Purpose: insert p into the correct location in the
	 *          stack such that there are no smaller plates 
	 *          below p and no larger plates above p
	 * Parameters: Stack<Plate> s - a stack of plates
	 *             Plate p - the plate to insert into s
	 * Returns: void - nothing
	 * Pre-condition: plates in s have been stacked correctly
	 */
	public static void insertPlate(Stack<Plate> s, Plate p) {
		Stack<Plate> temp = new A4Stack<Plate>();
		int x = 0;
		int y = p.getDiameter();
		boolean test = false;
		while(!s.isEmpty()){
			Plate p1 = s.top();
			p1 = s.pop();
			x = p1.getDiameter();
			if(y < x && !test){
				temp.push(p);
				test = true;
			}
			temp.push(p1);
		}
		while(!temp.isEmpty()){
			s.push(temp.pop());
		}	
		if(s.isEmpty()){
			s.push(p);
		}
	}
}