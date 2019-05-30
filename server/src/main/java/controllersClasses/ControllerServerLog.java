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
        textflow.getChildren().add(new Text("Server is up\n"));
        textflow.getChildren().add(new Text("Something very long koteczku moj kochany jesli to czytasz pamietaj zawsze Cie kochalem nie wazne co by sie nie stalo zawsze i to zawsze bede Cie kochał\n Tutaj powinny byc jakies cenne informacje"));
    }
}
