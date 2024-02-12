package program;

import entities.Contract;
import entities.Installments;
import services.ContractService;
import services.PaypalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Entre com os dados do contrato:");
        System.out.print("Número: ");
        int numero = input.nextInt();
        System.out.print("Data(dd/MM/yyyy): ");
        input.nextLine();
        LocalDate date = LocalDate.parse(input.nextLine(), fmt);
        System.out.print("Valor do Contrato: ");
        double valueTotal = input.nextDouble();
        System.out.print("Entre com o número de parcelas: ");
        int quantParcelas = input.nextInt();

        Contract contract = new Contract(numero, date, valueTotal);
        ContractService service = new ContractService(new PaypalService());

        service.processContract(contract, quantParcelas);

        System.out.println("PARCELAS: ");

        for (Installments c : contract.getInstallments()){
            System.out.println(fmt.format(c.getDueDate()) + " - " + String.format("%.2f",c.getAmount()));
        }




        input.close();
    }
}
