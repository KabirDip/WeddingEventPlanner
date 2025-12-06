package org.example.weddingeventmanagment;

public class BudgetAllocation {
    private String category;
    private double amount;

    public BudgetAllocation(String category, double amount) {
        this.category = category;
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public double getAmount() {
        return amount;
    }
}
