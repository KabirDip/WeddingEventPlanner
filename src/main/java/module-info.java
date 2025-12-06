module org.example.weddingeventmanagment {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.weddingeventmanagment to javafx.fxml;
    exports org.example.weddingeventmanagment;
}