package entities;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class Contract {
	private int number;
	private double value;
	private Date date;

	private List<Installment> installments;
	
	public Contract(int number, double value, Date date) {
		this.number = number;
		this.value = value;
		this.date = date;
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
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public void addInstallment(Installment installment) {
		installments.add(installment);
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
