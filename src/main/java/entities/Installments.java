package entities;

import java.time.LocalDate;

public class Installments {
    private LocalDate dueDate;
    private Double amount;

    public Installments(LocalDate dueDate, Double amount) {
        this.dueDate = dueDate;
        this.amount = amount;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }
    public Double getAmount() {
        return amount;
    }


}
