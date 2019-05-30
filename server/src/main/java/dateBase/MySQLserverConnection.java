package dateBase;
import Conteners.User;
import com.sun.xml.bind.v2.TODO;
import javafx.fxml.LoadException;

import javax.persistence.*;
import java.io.IOException;

public class MySQLserverConnection {
    EntityManagerFactory EntityManagerFactoryClientServer;
    EntityManager entityManager;
    public MySQLserverConnection(String persistanceUnitName){
        EntityManagerFactory EntityManagerFactoryClientServer = Persistence.createEntityManagerFactory(persistanceUnitName);
        EntityManager entityManager = EntityManagerFactoryClientServer.createEntityManager();
    }
    public void addUser(User user) { //very temporary

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(user);
            entityManager.getTransaction().commit();
        } catch (RollbackException e) { // returning false failure user adding
            System.out.println("Nazwa Lub dysk jest zajety/a");
        }
    }
    public void selectUsers(){
        //TO DO


    }
    public void CloseConnection(){
        entityManager.close();
        EntityManagerFactoryClientServer.close();
    }

}
