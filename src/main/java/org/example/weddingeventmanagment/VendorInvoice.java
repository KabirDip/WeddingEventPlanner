package org.example.weddingeventmanagment;

import javafx.beans.property.*;

public class VendorInvoice {

    private final IntegerProperty invoiceId;
    private final StringProperty vendorName;
    private final DoubleProperty amount;
    private final StringProperty status;
    private String bankAccount;

    public VendorInvoice(int invoiceId, String vendorName, double amount, String status) {
        this.invoiceId = new SimpleIntegerProperty(invoiceId);
        this.vendorName = new SimpleStringProperty(vendorName);
        this.amount = new SimpleDoubleProperty(amount);
        this.status = new SimpleStringProperty(status);
    }


    public String getBankAccount() {
        return bankAccount;
    }

    public int getInvoiceId() { return invoiceId.get(); }
    public IntegerProperty invoiceIdProperty() { return invoiceId; }

    public String getVendorName() { return vendorName.get(); }
    public StringProperty vendorNameProperty() { return vendorName; }

    public double getAmount() { return amount.get(); }
    public DoubleProperty amountProperty() { return amount; }

    public String getStatus() { return status.get(); }
    public StringProperty statusProperty() { return status; }

    public void setStatus(String status) { this.status.set(status); }
}
