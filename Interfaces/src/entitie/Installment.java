package entitie;

import java.sql.Date;

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
	
	// TODO toString installment
}
