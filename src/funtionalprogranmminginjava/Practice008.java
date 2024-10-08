package funtionalprogranmminginjava;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Practice008 {
	
	public static void main(String args[]) {
		
		List<Integer> numbers = List.of(23,19,91,96,8,6,2,3);
		List<String> courses = List.of("AWS","GCP","AZURE","Scala","Java","Python","Salesforce","Spring Boot");
		
		//1. Sum of Even Numbers
		Predicate<Integer> listOfEvenNumbers = a -> a%2 == 0; 
		BinaryOperator<Integer> accumulator = Integer::sum;//(a, b) -> (a+b);
		Integer sumOfNumbers = numbers.stream()
			.filter(listOfEvenNumbers) // Takes a input, evaluates it and sends boolean value back
			.reduce(0, accumulator); // Takes 2 input of same type, gives single output of same type
		System.out.println("Sum of Even Numbers : " + sumOfNumbers); // Sum of Even Numbers : 112
		
		System.out.println("=====================================================================================");
		
		//2. Count Strings Starting with a Specific Letter
		Predicate<String> listOfCoursesStartingWithS = a -> a.startsWith("S");
		long countOfCourseStartingWithS = courses.stream()
			.filter(listOfCoursesStartingWithS) // filter out listOfCoursesStartingWithS
			.count(); // count
		System.out.println("count Of Course Starting With S : " + countOfCourseStartingWithS); // count Of Course Starting With S : 3
		
		System.out.println("=====================================================================================");
		
		//3. Find the Maximum Number
		Optional<Integer> max = numbers.stream()
				/*
				 * .max(new Comparator<Integer>() {
				 * 
				 * @Override public int compare(Integer o1, Integer o2) { if(o1 > o2) return o1;
				 * return o2; } });
				 */

			.max(Integer::compare);
		System.out.println("Max of Number : " + max.get());
		
		System.out.println("=====================================================================================");
		
		//4. Given a list of strings, filter out the strings that are longer than 5 characters and collect them into a new list.
		List<String> listOfCourseHavingMoreThan5Char = courses.stream()
			.filter(a -> a.length() > 5)
			.collect(Collectors.toList());
		System.out.println("List Of Course having more than 5 char: " + listOfCourseHavingMoreThan5Char); //List Of Course having more than 5 char: [Python, Salesforce, Spring Boot]
		
		System.out.println("=====================================================================================");
		
		//5. Sum of Squares
		int sumOfSquare = numbers.stream()
				.mapToInt(a -> a*a)
				.reduce(0, Integer::sum);
		System.out.println("Sum of Sqaure : " + sumOfSquare); // Sum of Square : 18500
		
		System.out.println("=====================================================================================");
		
		//6. Find Distinct Elements
		List<Integer> listOfDistinctNos = numbers.stream()
				.distinct()
				.toList();
		System.out.println("List of distinct numbers : " + listOfDistinctNos); // List of distinct numbers : [23, 19, 91, 96, 8, 6, 2, 3]
		
		System.out.println("=====================================================================================");
		
		//7. Count the Number of Words in a List
		//Given a list of strings, count how many words have a length greater than 3 characters.
		long countOfCourseHavingLessThan3Char = courses.stream()
			.filter(a -> a.length()<3)
			.count();
		System.out.println("Count Of Course having less than 3 char: " + countOfCourseHavingLessThan3Char); //List Of Course having less than 3 char: []

		System.out.println("=====================================================================================");
		
		//8. Group Words by Length
		//Given a list of strings, group the words by their length using Java Streams.
		Map<Integer, List<String>> groupByLength = courses.stream().collect(Collectors.groupingBy(a -> a.length()));
		System.out.println("groupByLength : " + groupByLength);// groupByLength : {3=[AWS, GCP], 4=[Java], 5=[AZURE, Scala], 6=[Python], 10=[Salesforce], 11=[Spring Boot]}
		
		System.out.println("=====================================================================================");
		
		//9. Sort a List of Integers
		//Given a list of integers, sort the list in ascending order using Java Streams.
		numbers.stream().sorted().forEach(System.out::print);//236819239196 
		System.out.println();		
		System.out.println("=====================================================================================");
		
		//10. Join Strings with a Delimiter
		//Given a list of strings, join them together as a single string with a delimiter (like a comma or space) in between.
		
		String concatinated = courses.stream()
			.collect(Collectors.joining(", "));
		System.out.println("concatinated : " + concatinated);//AWS, GCP, AZURE, Scala, Java, Python, Salesforce, Spring Boot
	}
}
