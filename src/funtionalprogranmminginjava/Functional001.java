package funtionalprogranmminginjava;

import java.util.Arrays;
import java.util.List;

public class Functional001 {

	public static void main(String arg[]) {
		System.out.println("Print all numbers : ");
		printAllNumbers(List.of(9,35,8,1,6,98,2,4,56,23));
		System.out.println("Print only even numbers : ");
		printEvenNumbers(List.of(9,35,8,1,6,98,2,4,56,23));
		System.out.println("Print only odd numbers : ");
		printOddNumbers(List.of(9,35,8,1,6,98,2,4,56,23));
		List<String> courses = Arrays.asList("Spring Data", "AWS", "Spring Security", "GCP", "Python");
		System.out.println("Print All string from list : ");
		printStringFromList(courses);
		System.out.println("Print All Spring courses from list : ");
		printSpringCoursesFromList(courses);
		System.out.println("Print All courses with 4 or more character : ");
		printCoursesWith4OrMoreChar(courses);
		System.out.println("Print sqaure of even numbers : ");
		printSquareOfEvenNumbers(List.of(9,35,8,1,6,98,2,4,56,23));
		System.out.println("Print cube of odd numbers : ");
		printCubeOfOddNumbers(List.of(9,35,8,1,6,98,2,4,56,23));
		System.out.println("Print number of characters in the course : ");
		printNoOfCharactersInCourse(courses);
	}

	private static void printNoOfCharactersInCourse(List<String> courses) {
		courses.stream()
			.map(course -> course.length())
			.forEach(System.out::println);
	}

	private static void printSquareOfEvenNumbers(List<Integer> numList) {
		numList.stream()
			.filter(num -> num%2 == 0)
			.map(num -> num*num)
			.forEach(System.out::println);
	}
	private static void printCubeOfOddNumbers(List<Integer> numList) {
		numList.stream()
			.filter(num -> num%2 == 1)
			.map(num -> num*num*num)
			.forEach(System.out::println);
	}

	private static void printCoursesWith4OrMoreChar(List<String> courses) {
		courses.stream()
			.filter(course -> course.length()>3)
			.forEach(System.out::println);
	}

	private static void printSpringCoursesFromList(List<String> courses) {
		courses.stream()
			.filter(course -> course.toLowerCase()
			.contains("spring")).forEach(System.out::println);		
	}

	private static void printStringFromList(List<String> strList) {
		strList.stream()
			.forEach(System.out::println);
	}

	private static void printOddNumbers(List<Integer> numList) {
		numList.stream()
				.filter(num -> num%2 == 1)
				.forEach(System.out::println);
	}

	private static void printAllNumbers(List<Integer> numList) {
		//numList.stream().forEach(Functional001::print);
		numList.stream() // convert to stream
			.forEach(System.out::println);// method reference
	}
	private static void printEvenNumbers(List<Integer> numList) {
		//numList.stream().filter(Functional001::isEven).forEach(System.out::println);
		numList.stream() // convert to stream
				.filter((num) -> num%2 == 0)//lamda expression
				.forEach(System.out::println);// method reference
	}
	
//	private static boolean isEven(Integer num) {
//		return num%2 == 0;
//	}
	
//	private static void print(Integer integer1) {
//		System.out.println(integer1);
//	}
}
