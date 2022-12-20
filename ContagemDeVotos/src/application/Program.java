package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter file full path: ");
		String path = scanner.nextLine();
		Map<String, Integer> candidate = new HashMap<>();
		
		try (BufferedReader buffer = new BufferedReader(new FileReader(path))) {
			
			String line = buffer.readLine();
			while (line != null) {
				// TODO behaviour
				String[] segments = line.split(",");
				Integer sum = candidate.get(segments[0]);
				if (sum == null)
					candidate.put(segments[0], Integer.parseInt(segments[1]));
				else
					candidate.put(segments[0], sum + Integer.parseInt(segments[1]));
				line = buffer.readLine();
			}
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println(candidate.toString());
		
		scanner.close();
	}
}
