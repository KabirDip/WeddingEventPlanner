package org.example.weddingeventmanagment;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;


public class BudgetOverviewController {

    @FXML
    private ComboBox<String> eventIdCombo;

    @FXML
    private PieChart budgetPieChart;

    @FXML
    private TableView<BudgetAllocation> allocationTable;

    @FXML
    public void initialize() {
        // Dummy event IDs (replace with database call)
        eventIdCombo.setItems(FXCollections.observableArrayList("EVT-101", "EVT-102", "EVT-103"));

        eventIdCombo.setOnAction(e -> loadBudgetData(eventIdCombo.getValue()));
    }

    private void loadBudgetData(String eventId) {
        // Dummy data for demonstration
        ObservableList<BudgetAllocation> allocations = FXCollections.observableArrayList(
                new BudgetAllocation("Venue", 50000),
                new BudgetAllocation("Food & Catering", 35000),
                new BudgetAllocation("Decor & Setup", 20000),
                new BudgetAllocation("Performers", 15000),
                new BudgetAllocation("Marketing", 10000)
        );

        // Update Table
        allocationTable.setItems(allocations);

        // Update Pie Chart
        ObservableList<PieChart.Data> chartData = FXCollections.observableArrayList();
        for (BudgetAllocation a : allocations) {
            chartData.add(new PieChart.Data(a.getCategory(), a.getAmount()));
        }
        budgetPieChart.setData(chartData);
    }
}
