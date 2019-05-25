package controllersClasses;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.LoadException;
import javafx.scene.Node;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerServerMainPanel implements Initializable {
    @FXML
    private RadioButton homeRadioButton;
    @FXML
    private RadioButton usersRadioButton;
    @FXML
    private RadioButton settingsRadioButton;
    @FXML
    private Pane mainPane;
    @FXML
    void onActionHomeRadioButton(ActionEvent event) {
        try{
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("../fxml/serverFileExpoler.fxml"));
            mainPane.getChildren().add(newLoadedPane);
        }catch(NullPointerException x){
            x.printStackTrace();
        }catch(IOException x){
            x.printStackTrace();
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try{
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("../fxml/serverFileExpoler.fxml"));
            mainPane.getChildren().add(newLoadedPane);
        }catch(NullPointerException x){
            x.printStackTrace();
        }catch(IOException x){
            x.printStackTrace();
        }
    }
}
