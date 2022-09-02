package service;

public interface IPaymentService {

	public double interest(double amount, int months);
	
	public double paymentFee(double amount);
}
