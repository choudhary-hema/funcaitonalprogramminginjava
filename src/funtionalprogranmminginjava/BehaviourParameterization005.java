package funtionalprogranmminginjava;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BehaviourParameterization005 {

	public static void main(String[] args) {

		List<Integer> numbers = List.of(9,35,8,1,6,98,2,4,56,23);
		Predicate<Integer> evenPredicates = a -> a%2==0;
		System.out.println("Even Number :");
		filterAndPrint(numbers, evenPredicates);
		System.out.println("========================================================================");
		Predicate<Integer> oddPredicate = a -> a%2==1;
		System.out.println("Odd Number :");
		filterAndPrint(numbers, oddPredicate);
		System.out.println("========================================================================");
		Function<Integer, Integer> sqaureMapper = a -> a*a;
		System.out.println("Square of Number : " + getRoot(numbers, sqaureMapper));
		System.out.println("========================================================================");
		Function<Integer, Integer> cubeMapper = a -> a*a*a;
		System.out.println("Cube of Number : " + getRoot(numbers, cubeMapper));
		
		
	}

	private static List<Integer> getRoot(List<Integer> numbers, Function<Integer, Integer> cubeMapper) {
		return numbers.stream()
			.map(cubeMapper)
			.collect(Collectors.toList());
	}

	private static void filterAndPrint(List<Integer> numbers, Predicate<Integer> oddPredicate) {
		numbers.stream()
			.filter(oddPredicate)
			.forEach(System.out::println);
	}

}
