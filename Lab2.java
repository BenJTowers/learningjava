/*
 * Lab2.java
 *
 * A class of static methods that operate on Students
 *
 */
public class Lab2 {
    
	/*
	 * Purpose: determines which student has the higher grade
	 * Parameters: Student - s1, Student - s2
	 * Returns: Student - the Student with the higher grade,
	 *                    s1 if they have the same grade
	 * Precondition: s1 and s2 are not null
	 */
	public static Student getHigherGradeStudent(Student s1, Student s2) {
		// TODO: implement getHigherGradeStudent
		if(s1.getGrade() >= s2.getGrade()){
			return s1;
		}else{
			return s2;
		} 
	}


	/*
	 * Purpose: determines whether the grade of Student s
	 *          is above the threshold
	 * Parameters: Student - s, int - threshold
	 * Returns: boolean - true if grade is above threshold, false otherwise
	 * Preconditions: s is not null
	 */
	// TODO: implement isGradeAbove
	public static boolean isGradeAbove(Student s, int threshold){
		if(s.getGrade() > threshold){
			return true;
		}else{
			return false;
		}
	}



	/*
	 * Purpose: creates an array sIDs of all Students in students
	 * Parameters: Student[] - students
	 * Returns: String[] - array of sIDs
	 * Preconditions: students is not null and contains no null elements
	 */
	// TODO: implement getClasslist
	public static String[] getClasslist(Student[] students){
		int i = 0;
		String[] classList = new String[students.length];
		while(i < students.length){
			classList[i] = students[i].getSid();
			i++;
		}
		return classList;
	}


	/*
	 * Purpose: counts the number of Students in students
	 *          with grade above threshold
	 * Parameters: Student[] - students, int - threshold
	 * Returns: int - the number of students with a grade above threshold
	 * Preconditions: students is not null and contains no null elements
	 */
	// TODO: implement countAbove
	// HINT: you should be using the isGradeAbove method!
	public static int countAbove(Student[] students, int threshold){
		int i = 0;
		int count = 0;
		while(i < students.length){
			if(Lab2.isGradeAbove(students[i], threshold)){
				count++;
			}
			i++;
		}
		return count;
	}


	/*
	 * Purpose: calculates the average grade of Students in students,
	 *          does NOT include students with -1 grade in calculation
	 *          average is 0.0 if students is empty or all students have -1 grade
	 * Parameters: Student[] - students
	 * Returns: double - the average grade
	 * Preconditions: students is not null and contains no null elements
	 */
	// TODO: implement getClassAverage
	// HINT: you can use the isGradeAbove method again
	public static double getClassAverage(Student[] students){
		int i = 0;
		double sum = 0;
		int count = 0;
		double average = 0;
		if(students.length != 0){
		while(i < students.length){
			if(students[i].getGrade() >= 0){
				sum += students[i].getGrade();
				count++;
			}
			i++;
		}
		average = sum/count;
	}
		return average;
	}


	/*
	 * Purpose: creates a new array 1 longer than students
	 *          and adds all students and s to the new array
	 * Parameters: Student[] - students, Student s
	 * Returns: Student[] - the new array
	 * Preconditions: students is not null and contains no null elements
	 *                Student s is not already contained within students
	 */
	// TODO: implement registerStudent
	public static Student[] registerStudent(Student[] students, Student s){
		Student[] updatedList = new Student[students.length+1];
		int i = 0;
		while(i < students.length){
			updatedList[i] = students[i];
			i++;
		}
		updatedList[i] = s;
		return updatedList;

	}

}
