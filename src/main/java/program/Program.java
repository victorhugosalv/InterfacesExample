package program;

import entities.Contract;
import entities.Installments;
import services.BBService;
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

        Contract contract = new Contract(numero, date, valueTotal);

        System.out.print("Entre com o número de parcelas: ");
        int quantParcelas = input.nextInt();
        System.out.println("Qual a empresa de cobrança? ");
        input.nextLine();
        String empresa = input.nextLine().toUpperCase();

        while (true) {
            if (empresa.equals("PAYPAL")) {
                ContractService service = new ContractService(new PaypalService());
                service.processContract(contract, quantParcelas);
                break;
            } else if(empresa.equals("BB")){
                ContractService service = new ContractService(new BBService());
                service.processContract(contract, quantParcelas);
                break;
            } else {
                System.out.println("Digite uma empresa válida: ");
                System.out.println("Qual a empresa de cobrança? ");
                input.nextLine();
                empresa = input.nextLine().toUpperCase();
            }

        }
        System.out.println("PARCELAS: ");

        for (Installments c : contract.getInstallments()){
            System.out.println(fmt.format(c.getDueDate()) + " - " + String.format("%.2f",c.getAmount()));
        }




        input.close();
    }
}
