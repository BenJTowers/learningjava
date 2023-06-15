/*
 * Lab2Tester.java
 *
 * A tester for the methods in Lab2.java
 *
 */
import java.util.Arrays;

public class Lab2Tester {
    
	private static int testPassCount = 0;
	private static int testCount = 0;

	// for approximate comparison of floating point numbers
	private static final double THRESHOLD = 0.01;

	public static void main(String[] args) {
		
		testGetHigherGradeStudent();
		testIsGradeAbove();
		testGetClasslist();
		testCountAbove();
		testGetClassAverage();
		testRegisterStudent();

		System.out.println("Passed " + testPassCount + " / " + testCount + " tests");
	}
	
	public static void testGetHigherGradeStudent() {
		// TODO: once you have implemented getHigherGradeStudent in Lab2.java
		//  uncomment the following tests - make sure you understand what they are testing

		
		Student s0  = new Student("abc", 50);
		Student s1a = new Student("def", 56);
		Student s1b = new Student("xyz", 56);
		Student s2  = new Student("xyz", 99);

		Student result;

		result = Lab2.getHigherGradeStudent(s0,s1a);
		//System.out.println("should be  " + s1a + " is " + result);
		displayResults(result.equals(s1a), "testGetHigherGradeStudent");

		result = Lab2.getHigherGradeStudent(s1a,s0);
		//System.out.println("should be  " + s1a + " is " + result);
		displayResults(result.equals(s1a), "testGetHigherGradeStudent");

		result = Lab2.getHigherGradeStudent(s1b,s1a);
		//System.out.println("should be  " + s1b + " is " + result);
		displayResults(result.equals(s1b) && result == s1b, "testGetHigherGradeStudent");

		result = Lab2.getHigherGradeStudent(s1b,s2);
		//System.out.println("should be  " + s2 + " is " + result);
		displayResults(result.equals(s2), "testGetHigherGradeStudent");
		
	}

	public static void testIsGradeAbove() {
		// TODO: write tests for Lab2.isGradeAbove
		boolean result = true;
		boolean expected = true;

		Student s1 = new Student("v00123456", 84);
		Student s2 = new Student("v00555555", 71);
		Student s3 = new Student("v00998877", 67);
		Student s4 = new Student("v00224466", 92);

		result = Lab2.isGradeAbove(s1,80);
		expected = true;
		//System.out.println("should be  " + s2 + " is " + result);
		displayResults(result == expected, "testisGradeAbove");

		result = Lab2.isGradeAbove(s2,75);
		expected = false;
		//System.out.println("should be  " + s2 + " is " + result);
		displayResults(result == expected, "testisGradeAbove");

		result = Lab2.isGradeAbove(s3,0);
		expected = true;
		//System.out.println("should be  " + s2 + " is " + result);
		displayResults(result == expected, "testisGradeAbove");

		result = Lab2.isGradeAbove(s4,96);
		expected = false;
		//System.out.println("should be  " + s2 + " is " + result);
		displayResults(result == expected, "testisGradeAbove");



	}

	public static void testGetClasslist() {
		// TODO: write tests for Lab2.getClasslist

		// NOTE: the Arrays library has been imported for you.
		//       you can use the Arrays.equals method to compare
		//       2 arrays of String objects as String has a equals method
		// The API for Arrays.equals:
		//       equals(Object[] a, Object[] a2)
		//       Returns true if the two specified arrays are equal to one another.

		// TODO: once you have implemented getClasslist in Lab2.java
		// uncomment the following test. We have gotten you started with 
		// some initial test data and one test, but you should consider 
		// other cases (empty array, longer array)

		
		Student s0  = new Student("abc", 50);
		Student s1a = new Student("v00123456", 60);
		Student s1b = new Student("v00123456", 70);
		Student s1c = new Student("v00123456", 80);
		Student s2a = new Student("v00555555", 70);
		Student s2b = new Student("v00555555", 80);
		Student s3 = new Student("v00998877", 80);
		Student s4 = new Student("v00224466", 90);
		Student s5 = new Student("v00910019", 70);
		Student s6 = new Student("v00123321", 50);
		Student[] students1 = {s0};
		Student[] arr1 = {s1a, s2a, s3};
		Student[] arr2 = {s1b, s4, s5, s6};
		Student[] arr3 = {s1c};
		Student[] arr4 = {s5, s6};
		String[] expected2 = {"v00123456","v00555555","v00998877"};
		String[] expected3 = {"v00123456", "v00224466", "v00910019", "v00123321"};
		
		String[] expected1 = {"abc"};
		String[] result;

		result = Lab2.getClasslist(students1);
		displayResults(Arrays.equals(result, expected1), "testGetClasslist - 1 elements");

		result = Lab2.getClasslist(arr1);
		displayResults(Arrays.equals(result, expected2), "testGetClasslist - 3 elements");

		result = Lab2.getClasslist(arr2);
		displayResults(Arrays.equals(result, expected3), "testGetClasslist - 4 elements");
		
	}


	public static void testCountAbove() {
		// TODO: write tests for Lab2.countAbove
		Student s1 = new Student("v00123456", 84);
		Student s2 = new Student("v00555555", 71);
		Student s3a = new Student("v00998877", 67);
		Student s3b = new Student("v00998877", 74);
		Student s4 = new Student("v00224466", 92);

		Student[] arr0 = new Student[0];
		Student[] arr1 = {s1, s2, s3a};
		Student[] arr2 = {s3b, s4};

		int expected = 0;
		int result = 0;

		result = Lab2.countAbove(arr0,96);
		expected = 0;
		//System.out.println("should be  " + s2 + " is " + result);
		displayResults(result == expected, "testCountAbove");

		result = Lab2.countAbove(arr1,70);
		expected = 2;
		//System.out.println("should be  " + s2 + " is " + result);
		displayResults(result == expected, "testCountAbove");

		result = Lab2.countAbove(arr2,75);
		expected = 1;
		//System.out.println("should be  " + s2 + " is " + result);
		displayResults(result == expected, "testCountAbove");




	}


	public static void testGetClassAverage() {
		Student s0 = new Student("abc", 50);
		Student s1 = new Student("def", 60); 
		Student s2 = new Student("xyz", 99);
		Student s3 = new Student("def", 88);

		Student[] students0 = {};
		Student[] students1 = {s0};
		Student[] students2 = {s0, s1, s2};
		Student[] students3 = {s0, s2, s3};

		double result = 0.0;
		double expected = 0.0;
		
		// Some of you noticed in Lab1 that floating point arithmetic sometimes
		// produces results with many decimals places. We use the threshold
		// (defined as a global variable at the top) to specify the margin 
		// of error we are okay with, and just make sure the expected and 
		// returned results are within the threshold of acceptable error.

		
		result = Lab2.getClassAverage(students0);
		expected = 0;
		displayResults(Math.abs(result-expected)<THRESHOLD, "testClassAverage - empty");

		result = Lab2.getClassAverage(students1);
		expected = 50.0;
		displayResults(Math.abs(result-expected)<THRESHOLD, "getClassAverage - 1 student");

		result = Lab2.getClassAverage(students2);
		expected = (50 + 99 + 60) / 3.0; 
		displayResults(Math.abs(result-expected)<THRESHOLD, "getClassAverage - 3 students, count 3");

		result = Lab2.getClassAverage(students3);
		expected = (50 + 99 + 88) / 3.0;
		displayResults(Math.abs(result-expected)<THRESHOLD, "getClassAverage - 3 students, count 3");
        
	}

	public static void testRegisterStudent() {
		// TODO: write tests for Lab2.registerStudent
		// HINT: the Student class also has a equals method so you
		// can use Arrays.equals again to compare 2 Student arrays
		Student[] result = {};


		Student s1a = new Student("v00123456", 60);
		Student s1b = new Student("v00123456", 70);
		Student s1c = new Student("v00123456", 80);
		Student s2a = new Student("v00555555", 70);
		Student s2b = new Student("v00555555", 80);
		Student s3 = new Student("v00998877", 80);
		Student s4 = new Student("v00224466", 90);
		Student s5 = new Student("v00910019", 70);
		Student s6 = new Student("v00123321", 50);

		Student[] arr1 = {s1a, s2a, s3};
		Student[] arr2 = {s1b, s4}; 
		Student[] arr3 = {s1c};  
		Student[] arr4 = {s5, s6};

		Student[] expected1 = {s1a, s2a, s3, s6}; 
		Student[] expected2 = {s1b, s4, s5}; 
		Student[] expected3 = {s1c, s4}; 
		Student[] expected4 = {s5, s6, s3}; 

		result = Lab2.registerStudent(arr1, s6);
		displayResults(Arrays.equals(result, expected1), "registerStudent"); 

		result = Lab2.registerStudent(arr2, s5);
		displayResults(Arrays.equals(result, expected2), "registerStudent");

		result = Lab2.registerStudent(arr3, s4);
		displayResults(Arrays.equals(result, expected3), "registerStudent");

		result = Lab2.registerStudent(arr4, s3);
		displayResults(Arrays.equals(result, expected4), "registerStudent");

	}
	
	public static void displayResults (boolean passed, String testName) {
		/* There is some magic going on here getting the line number
		 * Borrowed from:
		 * http://blog.taragana.com/index.php/archive/core-java-how-to-get-java-source-code-line-number-file-name-in-code/
		 */
		
		testCount++;
		if (passed) {
			System.out.println ("Passed test: " + testName);
			testPassCount++;
		} else {
			System.out.println ("Failed test: " + testName + " at line "
								+ Thread.currentThread().getStackTrace()[2].getLineNumber());
		}

	}

}
