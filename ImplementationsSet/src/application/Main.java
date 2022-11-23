package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import enities.Access;
import enities.Site;

public class Main {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter with file path: ");
		String path = scanner.nextLine();
		File file = new File(path);
		
		Site site = new Site();
		
		try (BufferedReader bufferReader = new BufferedReader(new FileReader(file))) {
			
			String line = bufferReader.readLine();
			while (line != null) {
				String words[] = line.split(" ");
				String name = words[0];
				Date date = Date.from(Instant.parse(words[1]));
				
				site.entry(new Access(name, date));
				
				line = bufferReader.readLine();
			}
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Numero de acessos no site: " + site.accessCount());
		
		scanner.close();
	}
}
