package entitie;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import service.IPaymentService;

public class Contract {
	private int number;
	private double value;
	private int numberInstallment;
	private Date dateIn;
	
	private IPaymentService paymentService;
	private List<Installment> installments;
	
	public Contract(int number, double value, int numberInstallment, Date dateIn, IPaymentService paymentService) {
		this.number = number;
		this.value = value;
		this.numberInstallment = numberInstallment;
		this.dateIn = dateIn;
		this.paymentService = paymentService;
		installments = new ArrayList<Installment>();
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public int getNumberInstallment() {
		return numberInstallment;
	}
	
	public void generateInstallments() {
		double quota = value / numberInstallment;
		Date dateInstallment = dateIn;
		for (int i = 1; i <= numberInstallment; i++) {
			Installment aux = new Installment(dateInstallment, paymentService.calculate(quota, i));
			installments.add(aux);
			// Add time skip
		}
	}
	
	@Override
	public String toString() {
		
		String aux = "";
		for (Installment e : installments) {
			aux += e.toString() + "\n";
		}
		return aux;
	}
}
