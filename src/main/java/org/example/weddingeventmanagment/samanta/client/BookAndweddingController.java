package com.midterm_2320481_8.weeding_event_management.samanta.client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BookAndweddingController {

    @FXML
    private TableColumn<BookandWedding, String> avavilabilityColumn;

    @FXML
    private TextField avavilityTextField;

    @FXML
    private TableColumn<BookandWedding, Integer> capacityColumn;

    @FXML
    private TextField capacityTextfield;

    @FXML
    private TableColumn<BookandWedding, LocalDate> datecolumn;

    @FXML
    private DatePicker datepicker;

    @FXML
    private TableColumn<BookandWedding, String> paymentColumn;

    @FXML
    private ComboBox<String> paymentCombobox;

    @FXML
    private TableView<BookandWedding> tableView;

    @FXML
    private ComboBox<String> venuelistcombobox;

    @FXML
    private TableColumn<BookandWedding, String> viewlistcolumn;

    @FXML
    public void initialize(){
        venuelistcombobox.getItems().addAll("Royal Grand Convention Hall","Blue Orchid Banquet Hall","Dreamland Luxury Convention");
        paymentCombobox.getItems().addAll("Bkash","CAsh","Card");
        viewlistcolumn.setCellValueFactory(new PropertyValueFactory<>("listofVenue"));
        paymentColumn.setCellValueFactory(new PropertyValueFactory<>("payment"));
        capacityColumn.setCellValueFactory(new PropertyValueFactory<>("capacity"));
        datecolumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        avavilabilityColumn.setCellValueFactory(new PropertyValueFactory<>("nenueAva"));

    }

    @FXML
    void backButton(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/midterm_2320481_8/weeding_event_management/samanta/client/clientDAshbord.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("EmergencyHelicopterService");
        window.setScene(scene2);
        window.show();

    }

    @FXML
    void bookButton(ActionEvent event) {
        String venue=venuelistcombobox.getValue();
        String payment=paymentCombobox.getValue();
        int cap=Integer.parseInt(capacityTextfield.getText());
        LocalDate date=datepicker.getValue();
        String ava=avavilityTextField.getText();
        File f= null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            f=new File("BookAndWedding.bin");
            if(f.exists()){
                fos=new FileOutputStream(f,true);
                oos=new AppendableObjectOutPutStream(fos);
            }
            else{
                fos=new FileOutputStream(f);
                oos=new ObjectOutputStream(fos);
            }
            BookandWedding y=new BookandWedding(venue,payment,cap,ava,date);
            tableView.getItems().add(y);
            oos.writeObject(y);

        }catch(IOException ex){
            Logger.getLogger(BookAndweddingController.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(BookAndweddingController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }

}
