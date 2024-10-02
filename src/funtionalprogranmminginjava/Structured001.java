package funtionalprogranmminginjava;

import java.util.List;

public class Structured001 {

	public static void main(String arg[]) {
		printAllNumbers(List.of(9,35,8,1,6,98,2,4,56,23));
	}

	private static void printAllNumbers(List<Integer> numList) {
		//how do we loop?
		for(int num : numList) {
			//print only even number
			if(num%2 == 0) {
				System.out.println(num);
			}
		}
	}
}
