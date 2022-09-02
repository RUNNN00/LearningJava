package service;

import java.util.Calendar;
import java.util.Date;

import entities.Contract;
import entities.Installment;

public class ContractService {

	private IPaymentService paymentService;

	public ContractService(IPaymentService paymentService) {
		this.paymentService = paymentService;
	}

	public void processContract(Contract contract, int months) {

		double basicQuota = contract.getValue() / months;
		for (int i = 1; i <= months; i++) {
			double updateQuota = basicQuota + paymentService.interest(basicQuota, i);
			double fullQuota = updateQuota + paymentService.paymentFee(updateQuota);
			Date dueDate = addMonth(contract.getDate(), i);
			Installment aux = new Installment(dueDate, fullQuota);
			contract.addInstallment(aux);
		}
	}
	
	private Date addMonth(Date date, int n) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, n);
		return calendar.getTime();
	}
}
