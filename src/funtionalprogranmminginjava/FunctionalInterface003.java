package funtionalprogranmminginjava;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionalInterface003 {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(9,35,8,1,6,98,2,4,56,23);
		Predicate<Integer> predicate = a -> a%2 == 0;
		Function<Integer, Integer> mapper = b -> b*b;
		Consumer<Integer> action = System.out::println;
		
		numbers.stream()
			.filter(predicate)
			.map(mapper)
			.forEach(action);
		
		
		Predicate<Integer> predicate2 = new Predicate<Integer>() {
			
			@Override
			public boolean test(Integer t) {
				return t%2 == 0;
			}
		};
		
		Function<Integer, Integer> mapper2 = new Function<Integer, Integer>() {
			
			@Override
			public Integer apply(Integer t) {
				return t*t;
			}
		};
		Consumer<Integer> action2 = new Consumer<Integer>() {
			
			@Override
			public void accept(Integer t) {
				System.out.println(t);				
			}
		};
		numbers.stream()
			.filter(predicate2)
			.map(mapper2)
			.forEach(action2);
		
	}

}
