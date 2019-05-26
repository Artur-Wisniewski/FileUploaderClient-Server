package dateBase;
import  Conteners.UserTable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class mySQLserverConnection {
    public void setup(){
        EntityManagerFactory EntityManagerFactoryClientServer = Persistence.createEntityManagerFactory("clientserver");
        EntityManager entityManager = EntityManagerFactoryClientServer.createEntityManager();

        UserTable userTable = new UserTable();
        entityManager.getTransaction().begin();

        entityManager.persist(userTable);

        entityManager.getTransaction().commit();
        entityManager.close();
        EntityManagerFactoryClientServer.close();
    }
}
