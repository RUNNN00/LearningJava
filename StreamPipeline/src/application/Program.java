package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import entities.Product;

public class Program {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		List<Product> list = new ArrayList<>();
		
		System.out.print("Enter full file path: ");
		String path = sc.nextLine();
		
		try (BufferedReader buffer = new BufferedReader(new FileReader(path))) {
			
			String line = buffer.readLine();
			while (line != null) {
				
				String[] segment = line.split(", ");
				Product prod = new Product(segment[0], Double.parseDouble(segment[1]));
				list.add(prod);
				
				line = buffer.readLine();
			}
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		Comparator<String> comparator = (s1, s2) -> s1.toLowerCase().compareTo(s2.toLowerCase());
		
		double avaragePrice = list.stream().map(p -> p.getPrice()).reduce(0.0, (x, y) -> x + y) / list.size();
		System.out.println("Avarage price: " + String.format("%.2f", avaragePrice));
		List<String> names = list.stream()
				.filter(p -> p.getPrice() < avaragePrice)
				.map(p -> p.getName())
				.sorted(comparator.reversed())
				.toList();
		
		names.forEach(System.out::println);
		
		sc.close();
	}
}
