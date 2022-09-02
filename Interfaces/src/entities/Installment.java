package entities;

import java.util.Date;

public class Installment {
	private Date dueDate;
	private double price;

	public Installment(Date date, double price) {
		this.dueDate = date;
		this.price = price;
	}

	public Date getDate() {
		return dueDate;
	}

	public double getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return dueDate.toString() + " - U$" + String.format("%.2f", price);
	}
}
