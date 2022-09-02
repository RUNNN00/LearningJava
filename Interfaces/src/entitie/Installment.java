package entitie;

import java.util.Date;

public class Installment {
	private Date date;
	private double price;

	public Installment(Date date, double price) {
		this.date = date;
		this.price = price;
	}

	public Date getDate() {
		return date;
	}

	public double getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return date.toString() + " - U$" + String.format("%.2f", price);
	}
}
