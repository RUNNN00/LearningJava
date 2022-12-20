package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import entities.Employe;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		List<Employe> employes = new ArrayList<>();
		
		System.out.print("Enter full file path: ");
		String path = sc.nextLine();
		
		try (BufferedReader buffer = new BufferedReader(new FileReader(path))) {
			
			String line = buffer.readLine();
			while(line != null) {
				
				String[] segment = line.split(",");
				employes.add(new Employe(segment[0], segment[1], Double.parseDouble(segment[2])));
				
				line = buffer.readLine();
			}
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.print("Enter salary: ");
		double salary = sc.nextDouble();
		
		System.out.println("Email of people whose salary is more than " + String.format("%.2f", salary));
		List<String> emails = employes.stream().filter(p -> p.getSalary() > salary).map(p -> p.getEmail()).sorted().toList();
		emails.forEach(System.out::println);
		
		double sum = employes.stream()
				.filter(e -> e.getName().charAt(0) == 'M')
				.map(e -> e.getSalary())
				.reduce(0.0, (x, y) -> x + y);
		System.out.println("Sum of salary of people whose name starts with 'M': " + String.format("%.2f",  sum));
		
		sc.close();
	}
}
