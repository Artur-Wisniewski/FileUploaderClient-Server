package controllersClasses;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
    @Override
    public void initialize(URL location, ResourceBundle resources) {



        /**
         * to make toggle buttons more like menu
         * switching from radio-button graphic
         * to toggle button graphic with radio-button action;)
         * */
        /*homeRadioButton.getStyleClass().remove("radio-button");
        homeRadioButton.getStyleClass().add("toggle-button");
        usersRadioButton.getStyleClass().remove("radio-button");
        usersRadioButton.getStyleClass().add("toggle-button");
        settingsRadioButton.getStyleClass().remove("radio-button");
        settingsRadioButton.getStyleClass().add("toggle-button");*/
    }
}
