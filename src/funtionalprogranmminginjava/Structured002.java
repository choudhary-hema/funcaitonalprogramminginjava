package funtionalprogranmminginjava;

import java.util.List;

public class Structured002 {

	public static void main(String arg[]) {
		int sum = addListNumber(List.of(9,35,8,1,6,98,2,4,56,23));
		System.out.println(sum);
	}

	private static int addListNumber(List<Integer> numList) {
		int sum = 0;
		for(int num : numList) {
			sum+=num;
		}
		return sum;
	}

}
