package Conteners;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.ImageView;

public class FileInformation {
    /**
     * @param image
     * contain value of file image
     * @param name
     * contain SimpleStringProperty ( string with some extras ) name of file in this case
     * @param size
     * contain size of file
     * @param date
     * contain date of last modification
     * */
    private ImageView image;
    private SimpleStringProperty name;
    private SimpleStringProperty size;
    private SimpleStringProperty date;

    public FileInformation(ImageView image, String name, String size, String date){
        this.image = image;
        this.name = new SimpleStringProperty(name);
        this.size = new SimpleStringProperty(size);
        this.date = new SimpleStringProperty(date);
    }

    /**
     * Getters and setters below
     * */
    public ImageView getImage() {
        return image;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getSize() {
        return size.get();
    }

    public SimpleStringProperty sizeProperty() {
        return size;
    }

    public void setSize(String size) {
        this.size.set(size);
    }

    public String getDate() {
        return date.get();
    }

    public SimpleStringProperty dateProperty() {
        return date;
    }

    public void setDate(String date) {
        this.date.set(date);
    }
}
