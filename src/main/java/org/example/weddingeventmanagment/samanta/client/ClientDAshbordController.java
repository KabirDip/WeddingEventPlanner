package com.midterm_2320481_8.weeding_event_management.samanta.client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ClientDAshbordController {

    @FXML
    void bookandwedddinfgbutton(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/midterm_2320481_8/weeding_event_management/samanta/client/bookAndwedding.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("EmergencyHelicopterService");
        window.setScene(scene2);
        window.show();

    }

    @FXML
    public void weddingthemebutton(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/midterm_2320481_8/weeding_event_management/samanta/client/weddingThemeandDesign.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("EmergencyHelicopterService");
        window.setScene(scene2);
        window.show();
    }
}
