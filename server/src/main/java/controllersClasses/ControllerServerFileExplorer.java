package controllersClasses;

import Conteners.FileInformation;
import FileClasses.FileExplorerTableView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.awt.*;
import java.io.File;
import java.io.IOException;
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

    @FXML
    private Label currentDirectory;

    private  FileExplorerTableView fileExplorer;

    private Desktop desktop;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fileExplorer = new FileExplorerTableView(tableViewMain,columnIcon,columnDateModified,columnName,columnSize);
        currentDirectory.setText("Current Directory: " + fileExplorer.getPath());
    }
    @FXML
    void onMouseDoubleClickedTableView(MouseEvent event) {
        if(event.getClickCount() == 2) {
            File file = new File(fileExplorer.getPath() + "\\" + tableViewMain.getSelectionModel().getSelectedItem().getName());
            if(!getIfDirectory(file)){
                openIfFile(file);
            }
        }
    }
    private boolean getIfDirectory(File file){
        if(file.isDirectory()){
            fileExplorer.setDirectoryFile(file);
            fileExplorer.refreshTableView();
            currentDirectory.setText("Current Directory: " + fileExplorer.getPath());
            return true;
        }
        return false;
    }
    private boolean openIfFile(File file){
        if(file.isFile()){
            desktop = Desktop.getDesktop();
            try{
                desktop.open(file);
            } catch(IOException x){
                System.out.println(x.getMessage());
            }

            return true;
        }
        return false;
    }
}
