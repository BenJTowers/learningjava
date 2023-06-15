public class A2Exercises {

	/*
	 * Purpose: get the number of students in the given course  	
	 *          with a grade above the given grade threshold
	 * Parameters: UvicCourse course
	 *             int gradeThreshold 
	 * Returns: int - the number of enrolled students with 	
	 *                a grade above gradeThreshold
	 */
	public static int countAbove(UvicCourse course, int gradeThreshold) {
		int count = 0;
		int i = 0;
		Student[] classList = course.getClassList();
		while(i < classList.length){
			if(classList[i].getGrade() > gradeThreshold){
				count++;
			}
			i++;
		} 
		return count; // so it compiles
	}
	
	/*
	 * Purpose: get the name of the class with the highest average
	 * Parameters: UvicCourse[] courses - the array of courses
	 * Returns: String - the name of the course with the highest average
	 * Precondition: the array has at least one course in it
	 * NOTE: if there are two are more courses with the same class average 
	 *       which is the highest value of all courses in the array,
	 *       the name of course that comes first in the array is returned
	 */
	public static String highestAverage(UvicCourse[] courses) {
		int i = 0;
		double a = 0;
		double b = 0;
		String courseName = "";
		while(i < courses.length-1){
			if(courses[i].averageGrade() > courses[i+1].averageGrade()){
				a = courses[i].averageGrade();
			}else{
				a = courses[i+1].averageGrade();
			}
			if(a > b){
				b = a;
			}
			i++;
		}
		i = 0;
		while(i < courses.length){
			if(courses[i].averageGrade() == b){
				courseName = courses[i].getName();
				break;
			}
			i++;
		}
		// TODO: implement this	
		return courseName; // so it compiles
	}
	
	/*
	 * Purpose: get the average grade of the student with given sid
	 *          across all courses the student is enrolled in
	 * Parameters: UvicCourse[] courses - an array of courses
	 *             String sid - the sid of the student for which 
	 *                          to calculate the average grade for
	 * Returns: double - the average grade of the student with given sid
	 *                   -1 if the student is not in any of the courses	 
	 *
	 * Note: the student is not necessarily enrolled in the courses
	 *       found in the given array
	 */
	public static double studentAverage(UvicCourse[] courses, String sid) {
		// TODO: implement this	
		int i = 0;
		int j = 0;
		double sum = 0;
		double counter = 0;
		double average = 0;
		Student[] classList = courses[i].getClassList();
		while(i < courses.length){
			classList = courses[i].getClassList();
			while(j < classList.length){
				if(classList[j].getSid().equals(sid)){
					sum += classList[j].getGrade();
					counter++;
				}
				j++;
			}
			j = 0;
			i++;
		}
	average = sum/counter;
		return average; // so it compiles
	}
	
}