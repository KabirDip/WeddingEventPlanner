package org.example.weddingeventmanagment;

import javafx.beans.property.*;

public class RefundRequest {

    private final IntegerProperty requestId;
    private final StringProperty clientName;
    private final DoubleProperty amount;
    private final StringProperty status;

    public RefundRequest(int requestId, String clientName, double amount, String status) {
        this.requestId = new SimpleIntegerProperty(requestId);
        this.clientName = new SimpleStringProperty(clientName);
        this.amount = new SimpleDoubleProperty(amount);
        this.status = new SimpleStringProperty(status);
    }

    public int getRequestId() { return requestId.get(); }
    public IntegerProperty requestIdProperty() { return requestId; }

    public String getClientName() { return clientName.get(); }
    public StringProperty clientNameProperty() { return clientName; }

    public double getAmount() { return amount.get(); }
    public DoubleProperty amountProperty() { return amount; }

    public String getStatus() { return status.get(); }
    public StringProperty statusProperty() { return status; }

    public void setStatus(String newStatus) { this.status.set(newStatus); }
}
