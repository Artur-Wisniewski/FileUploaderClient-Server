package controllersClasses;

import Conteners.User;
import dateBase.MySQLserverConnection;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerServerUsersExplorer implements Initializable {
    @FXML
    private TableColumn<User, String> columnName;

    @FXML
    private TableColumn<User, String> columnPassword;

    @FXML
    private TableColumn<User, String> columnLocalPath;

    @FXML
    private TableColumn<User, String> columnPath;

    MySQLserverConnection mySQLserverConnection;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mySQLserverConnection = new MySQLserverConnection("clientserver");
        mySQLserverConnection.selectUsers();
    }
}
