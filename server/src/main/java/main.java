/**
 * @author Artur Wiśniewski
 *
 * */
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.LoadException;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class main extends Application {
    @Override
    public void start(Stage primaryStage){

        System.out.println("Kotek" );
        try{
            Parent root = FXMLLoader.load(getClass().getResource("fxml/serverMainPanel.fxml"));


        System.out.println("Kotek" );
        primaryStage.setTitle("FileUpServer");

        primaryStage.setScene(new Scene(root));

        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("icon/icon.png")));

        primaryStage.show();//sample/resources/icon.png


        }catch (LoadException e){
            System.out.println(e.toString());
            System.out.println(e.getMessage());
            e.printStackTrace();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }
    public static void main(String [] args){launch(args); }
}
