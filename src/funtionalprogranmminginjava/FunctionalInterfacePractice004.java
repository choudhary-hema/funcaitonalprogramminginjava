package funtionalprogranmminginjava;

import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FunctionalInterfacePractice004 {

	public static void main(String args[]) {

		List<Integer> numbers = List.of(9,35,8,1,6,98,2,4,56,23);
		BinaryOperator<Integer> accumulator = Integer::sum;
		BinaryOperator<Integer> accumulator2 = new BinaryOperator<Integer>() {
			
			@Override
			public Integer apply(Integer t, Integer u) {
				return t+u;
			}
		};
		int sum = numbers.stream() 
					.reduce(0, accumulator2);
		System.out.println("sum : " + sum);

		System.out.println("================================");
		Supplier<Integer> randomIntSupplier = () -> 2;

		System.out.println("randomIntSupplier : " + randomIntSupplier.get());

		System.out.println("================================");
		Supplier<Integer> randomIntSupplier1 = () -> {
			Random random = new Random();
			return random.nextInt();
		};

		System.out.println("randomIntSupplier : " + randomIntSupplier1.get());

		System.out.println("================================");
		UnaryOperator<Integer> unaryOperator = a -> a*2;
		System.out.println("unaryOperator : " + unaryOperator.apply(10));

		System.out.println("================================");
		BiPredicate<Integer, String> validUser = new BiPredicate<Integer, String>() {
			
			@Override
			public boolean test(Integer age, String location) {
				if (age > 17 && location.equals("India")) 
					return true;
				return false;
			}
		};

		System.out.println("validUser : " + validUser.test(9, "India"));
		System.out.println("validUser : " + validUser.test(19, "India"));
		System.out.println("validUser : " + validUser.test(43, "USA"));

		System.out.println("================================");
		BiFunction<Integer, String, String> welcomeUser = new BiFunction<Integer, String, String>() {
			
			@Override
			public String apply(Integer t, String u) {
				if( t < 18) {
					return "Restricted";
				}
				return "Welcome " + u + "!";
			}
		};

		System.out.println("welcomeUser : " + welcomeUser.apply(9, "Sujoy"));
		System.out.println("welcomeUser : " + welcomeUser.apply(29, "Peter"));

		System.out.println("================================");
		BiConsumer<String, Integer> printNumAndString = (a,b) -> {
			System.out.println(a + b);
		};
		printNumAndString.accept("Hey : ", 1);
		
	}
}
