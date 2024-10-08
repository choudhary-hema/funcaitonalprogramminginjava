package funtionalprogranmminginjava;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class MethodReference006 {

	public static void main(String args[]) {

		List<String> courses = Arrays.asList("AWS", "Java", "Spring Boot", "Python", "Gen AI");
		courses.stream()
			.map(String::toUpperCase)
			.forEach(MethodReference006::print);
		Supplier<String> a = String::new;
		
	}

	private static void print(String str) {
		System.out.println(str);
	}
}
