package service;

public class PaypalPaymentService implements IPaymentService {

	private final double INTEREST_MONTHLY = 0.01;
	private final double FEE = 0.02;

	public double calculate(double value, int index) {
		double aux = value * INTEREST_MONTHLY * index;
		return aux + (aux * FEE);
	}
}
