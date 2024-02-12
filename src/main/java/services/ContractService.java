package services;

import entities.Contract;
import entities.Installments;

import java.time.LocalDate;

public class ContractService {

    private OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Contract contract, Integer months){
        double basicQuota = contract.getTotalValue() / months;
        for (int k = 1; k <= months; k++){
            LocalDate dueDate = contract.getDate().plusMonths(k);
            double interest = onlinePaymentService.interest(basicQuota, k);
            double fee = onlinePaymentService.paymentFee(basicQuota + interest);
            double quota = basicQuota + interest + fee;
            contract.getInstallments().add(new Installments(dueDate, quota));
        }
    }
}
