package FileClasses;

import Conteners.FileInformation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;

import static javafx.embed.swing.SwingFXUtils.toFXImage;

public class FileExplorerTableView {

    static File         DirectoryFile;
    static Label        label;

    /**
     * Table of view vars
     * @param tableview
     * store columns
     * @param image
     * store file image
     * @param date
     * store file last modification date
     * @param name
     * store name of the file
     * @param size
     * store size of the file
     */

    TableView<FileInformation>              tableview;
    TableColumn<FileInformation, ImageView> image;
    TableColumn<FileInformation, String>    date;
    TableColumn<FileInformation, String>    name;
    TableColumn<FileInformation, String>    size;

    public FileExplorerTableView(TableView<FileInformation> tableview, TableColumn<FileInformation, ImageView> image,
                                 TableColumn<FileInformation, String> date, TableColumn<FileInformation, String> name, TableColumn<FileInformation, String> size,String DirectoryFileName){
        this.fileSetUp(tableview,image,date,name,size,DirectoryFileName);
        this.createTableView();

    }

    public void fileSetUp(TableView<FileInformation> tableview,TableColumn<FileInformation, ImageView> image,
                          TableColumn<FileInformation, String>    date,TableColumn<FileInformation, String>    name,TableColumn<FileInformation, String>    size,String DirectoryFileName){
        setDirectoryFileByName(DirectoryFileName);
        this.tableview = tableview;
        this.date = date;
        this.image = image;
        this.name = name;
        this.size = size;
    }
    public void refreshTableView(){
        tableview.getItems().clear();
        createTableView();
    }
    private void createTableView(){
        /**
         * Called to create a new TableView
         *
         * @param list
         * A list that allows listeners to track changes when they occurs
         * @param files
         * store every file in this Directory
         * @param fileInformationArray
         * store record informations
         *
         * */


        File [] files = DirectoryFile.listFiles();
        FileInformation [] fileInformationArray = new FileInformation[files.length];
        int i = 0;
        for (File file : files){
            fileInformationArray[i++] = createFileInformation(file);
        }
        ObservableList<FileInformation> list = FXCollections.observableArrayList(fileInformationArray);
        image.setCellValueFactory(new PropertyValueFactory<>("image"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        size.setCellValueFactory(new PropertyValueFactory<>("size"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        tableview.setItems(list);
    }
    private FileInformation createFileInformation(File file){
        /**
         * Called to get FileInformationArray member
         *
         * @return new FileInformation
         *
         * Called by {@link #createTableView()} method
         * */
        return new FileInformation(new ImageView(getFileIcon(file))
                ,file.getName()
                ,getFileSize(file)
                ,getLastModified(file));
    }
    private Image getFileIcon(File f){

        /**
         * @provides FileIcon
         *
         * @return
         * current file icon
         *
         * Called by {@link #createFileInformation(File file)} method
         * */

        return toFXImage((BufferedImage) ((ImageIcon) FileSystemView.getFileSystemView().getSystemIcon(f)).getImage(),null);
    }
    //    private void setLabel(){
//        /**
//         * Called to set label text label will contain current directory
//         * */
//        label.setText(DirectoryToString);
//    }
    private String getFileSize(File f){
        /**
         * Called to get file size
         *
         * @param sizeInByte
         * contain size of file in bytes.
         * @return
         * returning file size
         *
         * Called by {@link #createFileInformation(File file)} method
         * */
        long    sizeInByte=0;

        try {
            sizeInByte = Files.walk(Paths.get(f.toURI())).filter(path -> path.toFile().isFile()).mapToLong(p -> p.toFile().length()).sum();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(sizeInByte == 0){
            return "";
        }
        if( sizeInByte >= 1024 ){
            return Long.toString(sizeInByte/1024 )+" KB";
        }
        else {
            return Long.toString(sizeInByte)+" B";
        }
    }
    private String getLastModified(File f){
        /**
         * Called to get Last Modified with Date Format
         *
         * @return
         * LastModified with format
         *
         * Called by {@link #createFileInformation(File file)} method
         * */
        return new SimpleDateFormat("dd.MM.yy HH:mm").format(f.lastModified());
    }
    public void setDirectoryFile(File file){
        this.DirectoryFile = file;
    }
    public void setDirectoryFileByName(String name){
        this.DirectoryFile = new File(name);
    }
    public  String getPath() {
        return DirectoryFile.getAbsolutePath();
    }
    public  File getDirectoryFile() {
        return DirectoryFile;
    }
}
