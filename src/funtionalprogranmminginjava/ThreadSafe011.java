package funtionalprogranmminginjava;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ThreadSafe011 {

	
	public static void main(String args[]) {
		Runnable r1 = new Runnable() {
			
			@Override
			public void run() {
				for(int i = 0; i < 10000; i++) {
					System.out.println(Thread.currentThread().getId() 
							+ " : "
							+ i
					);
				}
			}
		};
		
		Runnable r2 = () -> {
				IntStream.range(1, 10000)
					.forEach(i ->
					System.out.println(Thread.currentThread().getId() 
							+ " : "
							+ i
					));
//				for(int i = 0; i < 10000; i++) {
//					System.out.println(Thread.currentThread().getId() 
//							+ " : "
//							+ i
//					);
//				}
		};
		Thread t1 = new Thread(r2);
		t1.start();
		Thread t2 = new Thread(r2);
		t2.start();
		Thread t3 = new Thread(r2);
		t3.start();
	}
}
