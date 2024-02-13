package services;

public interface OnlinePaymentService {

    double getTax();
    double getJuros();

    default Double interest(Double amount, Integer months) {
        return amount * ((getJuros()/100) * months);
    }


    default Double paymentFee(Double amount) {
        return amount * (getTax()/100);
    }
}
