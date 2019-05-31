package controllersClasses;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerServerLog implements Initializable {
    @FXML
    TextFlow textflow;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        textflow.getChildren().add(new Text("Server running\n"));
        textflow.getChildren().add(new Text("Loading JPA"));
    }
}
