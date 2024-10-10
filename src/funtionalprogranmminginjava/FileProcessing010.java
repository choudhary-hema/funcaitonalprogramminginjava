package funtionalprogranmminginjava;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class FileProcessing010 {

	public static void main(String arg[]) throws IOException {
		Files.lines(Paths.get("data.txt"))
			.map(a -> a.split(" "))
			.flatMap(Arrays::stream)
			.distinct()
			.sorted()
			.forEach(System.out::println);
	}
}
