package org.example.weddingeventmanagment;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.*;


public class RefundRequestsController {

    @FXML private TableView<RefundRequest> refundTable;
    @FXML private TableColumn<RefundRequest, Number> colId;
    @FXML private TableColumn<RefundRequest, String> colClient;
    @FXML private TableColumn<RefundRequest, Number> colAmount;
    @FXML private TableColumn<RefundRequest, String> colStatus;

    @FXML private Button btnVerify;
    @FXML private Button btnApprove;
    @FXML private Button btnReject;

    @FXML private Label summaryLabel;

    private ObservableList<RefundRequest> requests;

    @FXML
    public void initialize() {

        // Bind table columns
        colId.setCellValueFactory(data -> data.getValue().requestIdProperty());
        colClient.setCellValueFactory(data -> data.getValue().clientNameProperty());
        colAmount.setCellValueFactory(data -> data.getValue().amountProperty());
        colStatus.setCellValueFactory(data -> data.getValue().statusProperty());

        // event-2: Retrieve pending refund requests (mock database)
        requests = FXCollections.observableArrayList(
                new RefundRequest(2001, "Client A", 1200.00, "Pending"),
                new RefundRequest(2002, "Client B", 850.50, "Pending"),
                new RefundRequest(2003, "Client C", 2300.00, "Pending")
        );

        refundTable.setItems(requests);

        // Button actions
        btnVerify.setOnAction(e -> verifyRequest());
        btnApprove.setOnAction(e -> approveRequest());
        btnReject.setOnAction(e -> rejectRequest());
    }

    // event-3: Verify request validity + payment history
    private void verifyRequest() {
        RefundRequest selected = refundTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            summaryLabel.setText("Please select a refund request.");
            return;
        }

        // Mock verification
        summaryLabel.setText("Request " + selected.getRequestId()
                + " verified with payment history. Valid.");
    }

    // event-4: Approve refund
    private void approveRequest() {
        RefundRequest selected = refundTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            summaryLabel.setText("Select a request to approve.");
            return;
        }

        selected.setStatus("Approved");
        refundTable.refresh();

        // event-5: Notify client (mock)
        summaryLabel.setText("Refund approved. Client has been notified.");
    }

    // event-4: Reject refund
    private void rejectRequest() {
        RefundRequest selected = refundTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            summaryLabel.setText("Select a request to reject.");
            return;
        }

        selected.setStatus("Rejected");
        refundTable.refresh();

        // event-5: Notify client (mock)
        summaryLabel.setText("Refund rejected. Client has been notified.");
    }
}
