package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class ClientGui implements Initializable {

    ClientSocket clientSocket;

    @FXML
    private DatePicker calendar;

    @FXML
    private ComboBox<String> comboBoxGodziny;
    final ObservableList<String> WEEK_DAYS =FXCollections.observableArrayList("10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00" );

    @FXML
    private TextField name;

    @FXML
    void sprawdzButtonAction(ActionEvent event) {

    }

    @FXML
    void zapiszSieButtonAction(ActionEvent event) {
        //json parser needed
        clientSocket.sendMessage(name.getText().toString() + " "  + calendar.getValue().toString() + " " +comboBoxGodziny.getValue().toString());
        System.out.println(name.getText() + " "  + calendar.getValue() + " " +comboBoxGodziny.getValue());
    }
    public TextField getTextField(){
        return name;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboBoxGodziny.setItems(WEEK_DAYS);
        clientSocket = ClientSocket.getInstance();
        clientSocket.launch();
        //tutaj musimy utworzyc watek sluchajacego! ktory updatuje
    }
}
