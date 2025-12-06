package com.example.wems;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Load only GuestCoordinator.fxml
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/com/example/wems/fxml/GuestCoordinator.fxml")
        );
        Parent guestRoot = loader.load();

        // Create TabPane with only one tab
        javafx.scene.control.TabPane tabPane = new javafx.scene.control.TabPane();

        javafx.scene.control.Tab tab1 = new javafx.scene.control.Tab("Guest Coordinator", guestRoot);
        tab1.setClosable(false);

        tabPane.getTabs().add(tab1);

        // Set Scene
        Scene scene = new Scene(tabPane, 900, 600);
        primaryStage.setTitle("Wedding Event Management - UI Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
