package com.example.wems.controllers;

import com.example.wems.models.Guest;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.StringJoiner;

public class GuestCoordinatorController {

    @FXML private TableView<Guest> guestTable;

    // 🔹 These were MISSING — required for TableColumn to work
    @FXML private TableColumn<Guest, String> nameColumn;
    @FXML private TableColumn<Guest, String> emailColumn;
    @FXML private TableColumn<Guest, String> phoneColumn;
    @FXML private TableColumn<Guest, String> statusColumn;

    @FXML private TextField nameField;
    @FXML private TextField emailField;
    @FXML private TextField phoneField;
    @FXML private TextArea messageArea;
    @FXML private Label sendResultLabel;

    private final ObservableList<Guest> guests = FXCollections.observableArrayList();

    @FXML
    private void initialize() {

        // 🔹 REQUIRED: Link columns to Guest fields
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        guestTable.setItems(guests);
    }

    @FXML
    private void handleAddGuest() {
        String name = nameField.getText().trim();
        String email = emailField.getText().trim();
        String phone = phoneField.getText().trim();

        if (name.isEmpty() || email.isEmpty()) {
            showAlert("Validation", "Name and Email are required.");
            return;
        }

        guests.add(new Guest(name, email, phone));
        clearInputFields();
    }

    @FXML
    private void handleSendInvitation() {
        String message = messageArea.getText();

        if (guests.isEmpty()) {
            showAlert("No Guests", "Guest list is empty. Add guests first.");
            return;
        }

        for (Guest g : guests) {
            g.setStatus("Sent");
            System.out.println("Sent to: " + g.getEmail() + " - message: " + message);
        }

        guestTable.refresh();  // 🔹 Important (refresh table after updating status)
        sendResultLabel.setText("Sent!");
    }

    @FXML
    private void handleViewStatus() {
        if (guests.isEmpty()) {
            showAlert("No Guests", "Guest list is empty.");
            return;
        }

        StringJoiner joiner = new StringJoiner("\n");
        for (Guest g : guests) {
            joiner.add(g.getName() + " - " + g.getStatus());
        }

        showAlert("Guest Status", joiner.toString());
    }

    private void clearInputFields() {
        nameField.clear();
        emailField.clear();
        phoneField.clear();
    }

    private void showAlert(String title, String content) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle(title);
        a.setHeaderText(null);
        a.setContentText(content);
        a.showAndWait();
    }
}
