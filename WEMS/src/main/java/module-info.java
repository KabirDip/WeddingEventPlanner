module com.example.wems {
    requires javafx.controls;
    requires javafx.fxml;

    // Allow FXML loader to create controllers
    opens com.example.wems to javafx.fxml;
    opens com.example.wems.controllers to javafx.fxml;

    // Allow TableView to access Event getters using reflection
    opens com.example.wems.models to javafx.base, javafx.fxml;

    exports com.example.wems;
    exports com.example.wems.models;
    exports com.example.wems.controllers;
}
