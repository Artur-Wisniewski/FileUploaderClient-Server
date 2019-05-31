package controllersClasses;

import Conteners.FileInformation;
import FileClasses.FileExplorerTableView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.ContextMenuEvent;
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

        fileExplorer = new FileExplorerTableView(tableViewMain,columnIcon,columnDateModified,columnName,columnSize,
                "C:\\SERVER");
        currentDirectory.setText("Current Directory: " + fileExplorer.getPath());
    }
    @FXML
    void OpenFile(ActionEvent event) {
        checkContent();
    }

    @FXML
    void ShareFile(ActionEvent event) {
        //TO DO
    }
    @FXML
    void onMouseDoubleClickedTableView(MouseEvent event) {
        if(event.getClickCount() == 2) {
            checkContent();
        }
    }
    @FXML
    void goUpOnAction(ActionEvent event) {

        if(!fileExplorer.getDirectoryFile().getName().equals("SERVER"))
        changeDirectory(fileExplorer.getDirectoryFile().getParentFile());
        else
            System.out.println("It's your mother directory !!!");
    }
    @FXML
    void dropRightClickMenu(ContextMenuEvent event) {}



    void checkContent(){
        File file = new File(fileExplorer.getPath() + "\\" + tableViewMain.getSelectionModel().getSelectedItem().getName());
        if(!enterIfDirectory(file)){
            openIfFile(file);
        }
    }
    private boolean enterIfDirectory(File file){
        if(file.isDirectory()){
            changeDirectory(file);
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
    private void changeDirectory(File file){
        fileExplorer.setDirectoryFile(file);
        fileExplorer.refreshTableView();
        currentDirectory.setText("Current Directory: " + fileExplorer.getPath());
    }

}
