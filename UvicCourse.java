public class UvicCourse {
	private String name;
	private Student[] classList;
	
	public UvicCourse(String name, Student[] classList) {
		// TODO: fix this
	this.name = name;
	this.classList = classList;
	}
	
	/*
	 * Purpose: get this course's name
	 * Parameters: none
	 * Returns: String - this course's name
	 */
	public String getName() {
		return name;
	}
	
	/*
	 * Purpose: get this course's classlist
	 * Parameters: none
	 * Returns: Student[] - the array of students in this class
	 */
	public Student[] getClassList() {
		return classList;
	}
	
	
	/* 
	 * Purpose: calculate the average grade of all students in this course
	 * Parameters: none
	 * Returns: double - the average grade of all students,
	 *                   or 0.0 if there are no enrolled students
	 */
	public double averageGrade() {
		// TODO: implement this
		int i = 0;
		double sum = 0;
		double average = 0;
		while(i < classList.length){
			sum += classList[i].getGrade();
			i++;
		}
		if(classList.length > 0){	
		average = sum/classList.length;
}
		return average; // so it compiles	
	}


	/*
	 * Purpose: gets the grade of the student with given sid
	 * Parameters: String sid - the sid of the student to search for
	 * Returns: int - the grade of the students with given sid, 
	 *                or -1 if no student with given sid is in 
	 *                enrolled in this class
 	 */
	public int getGrade(String sid) {
		int i = 0;
		int grade = 0;
		while(i < classList.length){
			if(classList[i].getSid().equals(sid)){
				grade = classList[i].getGrade();
			}
			i++;
		}
		// TODO: implement this	
		return grade; // so it compiles
	}

	
	/*
	 * Purpose: determines if s is in this course's class list
	 * Parameters: Student s - the student
	 * Returns: boolean - true if this course's class list contains s
	 */
	public boolean hasStudent(Student s) {
		boolean isFound = false;
		int i = 0;
		while(i < classList.length){
			if(classList[i].getSid().equals(s.getSid())) {
				isFound = true;
			}
			i++;
		}
		// TODO: implement this	
		return isFound; // so it compiles
	}
	
	
	/*
	 * Purpose: updates the grade of the student with given studentSid to
	 *          newGrade if the student is found in this course's class list
	 * Parameters: String studentSid - the sid of the student to update
	 *             int newGrade - the new grade for the student
	 * Returns: void - nothing
	 */
	public void updateGrade(String studentSid, int newGrade) {
		// TODO: implement this	
		boolean isFound = false;
		int i = 0;
		while(i < classList.length){
			if(classList[i].getSid().equals(studentSid)) {
				isFound = true;
				break;
			}
			i++;
		}
		if(isFound){
		classList[i].setGrade(newGrade);

		}
	}
	

	
	/*
	 * Purpose: add the given student to this course's classlist
	 * Parameters: Strudent newStudent - student to add to class list
	 * Returns: void - nothing
	 * Precondition: newStudent is not already a student in classList
	 */
	public void addStudent(Student newStudent) {
		Student[] updatedList = new Student[classList.length+1];
		// TODO: implement this	
		Student[] oldList = classList;
		classList = updatedList;
		int i = 0;
		while(i < oldList.length){
			classList[i] = oldList[i];
			i++;
		}
		classList[i] = newStudent;
	}

}