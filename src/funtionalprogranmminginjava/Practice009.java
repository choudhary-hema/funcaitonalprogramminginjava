package funtionalprogranmminginjava;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Practice009 {

	public static void main(String args[]) {
		//1. Find the First Element in the Stream
		//Given a list of integers, find the first element that is greater than 99.
		System.out.println("getFirst Number which is more than 99" +
			Stream.of(1,32,13,94,5,9,81,7,66,0)
				.filter(a -> a > 99)
				.findFirst()
				.orElse(null)
		); // null

		System.out.println("==============================================================");
		
		//2. Group Strings by Length
		//Given a list of strings, group the strings by their length using Java Streams.
		List<String> courses = List.of("Java", "Spring Boot", "Python", "Postges DB", "Google Cloud Platform", "Microsoft Azure");
		Map<Integer, List<String>> groupByCourseLength = courses.stream()
			.collect(Collectors.groupingBy(String::length));
		System.out.println("groupByCourseLength : " + groupByCourseLength);
		// groupByCourseLength : {4=[Java], 21=[Google Cloud Platform], 6=[Python], 10=[Postges DB], 11=[Spring Boot], 15=[Microsoft Azure]}
		
		System.out.println("==============================================================");
		
		//3. Find the Longest String
		//Given a list of strings, find the string with the maximum length.
		Optional<String> max = courses.stream()
			.max(Comparator.comparingInt(String::length));
		System.out.println("max : " + max.get()); // max : Google Cloud Platform

		System.out.println("==============================================================");
		
		//4. Check if All Elements are Positive
		//Given a list of integers, check if all elements are positive.
		
		System.out.println("All number positive : " + 
			Stream.of(1,7,1,843,944,254,242,72,61,07,23)
				.allMatch(a -> a%2 == 0)
		); // false
		
		System.out.println("==============================================================");
		
		//5. Convert List of Strings to Upper-case
		//Convert all the strings in a list to upper-case using Java Streams.
		courses.stream().map(String::toUpperCase)
			.forEach(System.out::println);
	
		//JAVA
		//SPRING BOOT
		//PYTHON
		//POSTGES DB
		//GOOGLE CLOUD PLATFORM
		//MICROSOFT AZURE
		
		System.out.println("==============================================================");
		
		//6. Find the Average of a List of Numbers
		//Given a list of integers, find the average of all numbers using Streams.

		List<Integer> numbers = List.of(1,31,8,98,31,9,1,81,30,8);
		System.out.println(
				numbers.stream()
					.mapToInt(a -> a)
					.average()
					.getAsDouble()
		);
		//29.8
		System.out.println("==============================================================");
		
		//7. Remove Duplicates
		//Given a list of integers, remove all duplicates and return a new list.

		System.out.println(
			numbers.stream().distinct().collect(Collectors.toList())		
		);
		// [1, 31, 8, 98, 9, 81, 30]
		
		System.out.println("==============================================================");
		
		//8. Partition a List into Even and Odd Numbers
		//Partition a list of integers into two parts: one containing even numbers, and the other containing odd numbers using Java Streams.

		Map<Boolean, List<Integer>> partitionedNumbers = numbers.stream()
                .collect(Collectors.partitioningBy(a -> a % 2 == 0));

		List<Integer> evenNumbers = partitionedNumbers.get(true);  // List of even numbers
		List<Integer> oddNumbers = partitionedNumbers.get(false);  // List of odd numbers
		
		System.out.println("Even numbers: " + evenNumbers);
		System.out.println("Odd numbers: " + oddNumbers);
		
		System.out.println("==============================================================");
		
		//9. Concatenate Two Lists
		//Given two lists of integers, concatenate them into one list using Streams.
		
		List<Integer> list1 = List.of(1, 2, 3, 4);
        List<Integer> list2 = List.of(5, 6, 7, 8);

        // Concatenate the two lists into one
        List<Integer> concatenatedList = Stream.concat(list1.stream(), list2.stream())
                                               .collect(Collectors.toList());

        System.out.println("Concatenated list: " + concatenatedList);
        
		System.out.println("==============================================================");
		
		//10. Create a Map from List of Strings
		//Given a list of strings, create a Map where the key is the string and the value is its length.

		System.out.println("==============================================================");
		
		//11. Find Words That Start with a Specific Letter
		//Given a list of words, find all words that start with the letter 'A' (or any specified letter).

		System.out.println("==============================================================");
		
		//12. Calculate the Product of All Numbers
		//Given a list of integers, calculate the product of all numbers using Streams.

		System.out.println("==============================================================");
		
		//13. Skip the First n Elements in the Stream
		//Given a list of integers, skip the first n elements and collect the remaining ones.

		System.out.println("==============================================================");
		
		//14. Limit the Number of Elements in a Stream
		//Given a list of strings, return only the first 3 elements using limit() in Streams.

		System.out.println("==============================================================");
		
		//15. Check if Any Element Matches a Condition
		//Given a list of strings, check if any string contains more than 10 characters.
	}
}
