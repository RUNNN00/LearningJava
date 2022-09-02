package appiclation;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.TimeZone;

import entities.Contract;
import service.ContractService;
import service.PaypalPaymentService;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner scanner = new Scanner(System.in);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GTC")); // UTC pattern
		
		System.out.println("Enter contract data: ");
		System.out.print("Number: ");
		int number = scanner.nextInt();
		System.out.print("date (dd/MM/yyyy): ");
		scanner.nextLine();
		String dateString = scanner.nextLine();
		Date date = simpleDateFormat.parse(dateString);
		System.out.print("Contract value: ");
		double value = scanner.nextDouble();
		System.out.print("Enter number of installments: ");
		int numInstall = scanner.nextInt();
		
		Contract contract = new Contract(number, value, date);
		ContractService contracService = new ContractService(new PaypalPaymentService());
		contracService.processContract(contract, numInstall);
		System.out.println(contract.toString());
		scanner.close();
	}
}
