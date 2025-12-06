package com.midterm_2320481_8.weeding_event_management.samanta.client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class WeddingThemeandDesignController {

    @FXML
    private TableColumn<WeddingThemeandDesign, String> C;

    @FXML
    private TableColumn<WeddingThemeandDesign, String> colorpreferenceColumn;

    @FXML
    private ComboBox<String> colorpreferenceComboBox;

    @FXML
    private TextField customnotesTextField;

    @FXML
    private TableColumn<WeddingThemeandDesign,String> preferredthemeColumn;

    @FXML
    private ComboBox<String> preferredthemeComboBox;

    @FXML
    private TableView<WeddingThemeandDesign> weddingThemeandDesignTableView;

    @FXML
    void initialize(){
        preferredthemeComboBox.getItems().addAll("Royal","Classic","Floral");
        colorpreferenceComboBox.getItems().addAll("Blue","Red","White");










    }















    @FXML
    void finalthemedesignButton(ActionEvent event) {

    }

}
