package services;

public class PaypalService implements OnlinePaymentService{
    private Double tax;
    private Double juros;
    public PaypalService() {
        tax = 2.0;
        juros = 1.0;
    }
    @Override
    public double getTax() {
        return tax;
    }
    @Override
    public double getJuros(){
        return juros;
    }
}
