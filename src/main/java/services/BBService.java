package services;

public class BBService implements OnlinePaymentService {

    private Double tax;
    private Double juros;

    public BBService() {
        tax = 1.5;
        juros = 0.7;
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
