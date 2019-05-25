package controllersClasses;

import Conteners.FileInformation;
import FileClasses.FileExplorerTableView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerServerFileExplorer implements Initializable {

    @FXML
    private Pane paneMain;

    @FXML
    private TableView<FileInformation>                   tableViewMain;

    @FXML
    private TableColumn<FileInformation, ImageView>      columnIcon;

    @FXML
    private TableColumn<FileInformation, String>         columnName;

    @FXML
    private TableColumn<FileInformation, String>         columnSize;

    @FXML
    private TableColumn<FileInformation, String>         columnDateModified;

    private  FileExplorerTableView fileExplorer;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fileExplorer = new FileExplorerTableView(tableViewMain,columnIcon,columnDateModified,columnName,columnSize);

    }
}
