package service;

public class PaypalPaymentService implements IPaymentService {

	private static final double INTEREST = 0.01;
	private static final double PAYMENT_FEE = 0.02;

	public double interest(double amount, int months) {
		return amount * INTEREST * months;
	}

	public double paymentFee(double amount) {
		return amount * PAYMENT_FEE;
	}
}
