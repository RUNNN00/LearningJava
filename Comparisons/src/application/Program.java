package application;

import entities.Client;

public class Program {

	public static void main(String[] args) {
		
		Client client1 = new Client("Maria", "maria@gmail.com");
		Client client2 = new Client("João", "João@gmail.com");
		
		System.out.println((client1.hashCode() == client2.hashCode()));
		System.out.println(client1.equals(client2));
		System.out.println((client1 == client2)); // memory comparison
	}
}
