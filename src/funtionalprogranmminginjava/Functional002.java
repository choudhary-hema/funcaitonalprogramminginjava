package funtionalprogranmminginjava;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Functional002 {

	public static void main(String arg[]) {
		int sum = addListNumber(List.of(9,35,8,1,6,98,2,4,56,23));
		System.out.println("sum of list : " + sum);
		System.out.println("========================================================================");
		System.out.println("Print doubletheList");
		doubletheList(List.of(9,35,8,1,6,98,2,4,56,23));
		System.out.println("========================================================================");
		System.out.println("Print createListFilterEvenNumbers");
		createListFilterEvenNumbers(List.of(9,35,8,1,6,98,2,4,56,23));
		System.out.println("========================================================================");
		List<String> courses = Arrays.asList("AWS", "Java", "Spring Boot", "Python", "Gen AI");
		System.out.println("Print createListWithLengthOfEachCourse");
		System.out.println("========================================================================");
		createListWithLengthOfEachCourse(courses);
	}
	
	private static void createListWithLengthOfEachCourse(List<String> courses) {
		courses.stream()
			.map(a -> a.length())
			.collect(Collectors.toList())
			.forEach(System.out::println);
	}

	private static void createListFilterEvenNumbers(List<Integer> numList) {
		numList.stream()
			.filter(a -> a%2 == 0)
			.collect(Collectors.toList())
			.forEach(System.out::println);
		
	}

//	private static int sum(int aggregate, int nextNumber) {
//		return aggregate + nextNumber;
//	}
	private static int addListNumber(List<Integer> numList) {
		return numList.stream() //convert to stream
		//		.reduce(0, Functional002::sum); //reduce : combine them into one result : one value
		//		.reduce(0, (a,b) -> a+b); - using lambda function
				.reduce(0, Integer::sum);
	}
	private static void doubletheList(List<Integer> numList) {
		
		numList.stream().map(a -> a*a).collect(Collectors.toList()).forEach(System.out::println);;
	}
}
