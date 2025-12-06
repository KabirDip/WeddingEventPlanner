package org.example.weddingeventmanagment;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.*;


public class VendorInvoicesController {

    @FXML private TableView<VendorInvoice> invoiceTable;
    @FXML private TableColumn<VendorInvoice, Number> colId;
    @FXML private TableColumn<VendorInvoice, String> colVendor;
    @FXML private TableColumn<VendorInvoice, Number> colAmount;
    @FXML private TableColumn<VendorInvoice, String> colStatus;

    @FXML private Button btnVerify;
    @FXML private Button btnApprove;
    @FXML private Button btnReject;

    @FXML private Label summaryLabel;

    private ObservableList<VendorInvoice> invoices;

    @FXML
    public void initialize() {

        // bind table columns
        colId.setCellValueFactory(data -> data.getValue().invoiceIdProperty());
        colVendor.setCellValueFactory(data -> data.getValue().vendorNameProperty());
        colAmount.setCellValueFactory(data -> data.getValue().amountProperty());
        colStatus.setCellValueFactory(data -> data.getValue().statusProperty());

        // EVENT 2: Retrieve pending invoices (dummy data for now)
        invoices = FXCollections.observableArrayList(
                new VendorInvoice(101, "Vendor A", 3400.50, "Pending"),
                new VendorInvoice(102, "Vendor B", 2100.00, "Pending"),
                new VendorInvoice(103, "Vendor C", 5500.75, "Pending")
        );

        invoiceTable.setItems(invoices);

        // Set listeners
        btnVerify.setOnAction(e -> verifyInvoice());
        btnApprove.setOnAction(e -> approveInvoice());
        btnReject.setOnAction(e -> rejectInvoice());
    }

    // EVENT 3: Verify invoice details with vendor contract records (simple mock)
    private void verifyInvoice() {
        VendorInvoice selected = invoiceTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            summaryLabel.setText("Please select an invoice.");
            return;
        }

        summaryLabel.setText("Invoice " + selected.getInvoiceId()
                + " verified with vendor contract records.");
    }

    // EVENT 4: Approve invoice
    private void approveInvoice() {
        VendorInvoice selected = invoiceTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            summaryLabel.setText("Please select an invoice.");
            return;
        }

        selected.setStatus("Approved");
        invoiceTable.refresh();

        summaryLabel.setText("Invoice " + selected.getInvoiceId() + " approved.");
    }

    // EVENT 4: Reject invoice
    private void rejectInvoice() {
        VendorInvoice selected = invoiceTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            summaryLabel.setText("Please select an invoice.");
            return;
        }

        selected.setStatus("Rejected");
        invoiceTable.refresh();

        summaryLabel.setText("Invoice " + selected.getInvoiceId() + " rejected.");
    }
}
