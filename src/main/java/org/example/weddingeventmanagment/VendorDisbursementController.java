package org.example.weddingeventmanagment;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class VendorDisbursementController {

    @FXML
    private TableView<VendorInvoice> invoiceTable;

    @FXML
    private Button disburseButton;

    @FXML
    private Label statusLabel;

    @FXML
    public void initialize() {

        // Load approved invoices (mock data)
        ObservableList<VendorInvoice> approvedInvoices =
                FXCollections.observableArrayList(
                        new VendorInvoice(001, "ABC Catering", 55000, "AC-987654321"),
                        new VendorInvoice(002, "Event Lights Ltd", 32000, "AC-123456789"),
                        new VendorInvoice(003, "Royal Venue Services", 75000, "AC-564738291")
                );

        invoiceTable.setItems(approvedInvoices);

        disburseButton.setOnAction(e -> processPayment());
    }

    private void processPayment() {
        VendorInvoice selected = invoiceTable.getSelectionModel().getSelectedItem();

        if (selected == null) {
            statusLabel.setText("Please select an invoice to disburse payment.");
            statusLabel.setStyle("-fx-text-fill: red;");
            return;
        }



        // Step 1: Verify bank details (mock check)
        if (selected.getBankAccount().isEmpty()) {
            statusLabel.setText("Invalid bank details!");
            statusLabel.setStyle("-fx-text-fill: red;");
            return;
        }

        // Step 2: Simulate payment gateway API call
        boolean paymentSuccess = simulatePaymentGateway(selected);

        if (paymentSuccess) {
            statusLabel.setText("Payment Successful for Invoice: " + selected.getInvoiceId());
            statusLabel.setStyle("-fx-text-fill: green;");

            // Remove from table to indicate it has been disbursed
            invoiceTable.getItems().remove(selected);
        } else {
            statusLabel.setText("Payment Failed! Try again.");
            statusLabel.setStyle("-fx-text-fill: red;");
        }
    }

    // Dummy payment gateway simulation
    private boolean simulatePaymentGateway(VendorInvoice invoice) {
        try {
            Thread.sleep(800); // simulate network delay
        } catch (InterruptedException ignored) {}
        return true; // always successful for demo
    }
}
