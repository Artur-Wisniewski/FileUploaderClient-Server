package Conteners;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class UserTable {
    @Id
    @GeneratedValue
    private long id;
    private String Name;
    private String Password;
    private String LocalFilePath;
    private String ServerFilePath;

    public long getId(){
        return id;
    }
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getLocalFilePath() {
        return LocalFilePath;
    }

    public void setLocalFilePath(String localFilePath) {
        LocalFilePath = localFilePath;
    }

    public String getServerFilePath() {
        return ServerFilePath;
    }

    public void setServerFilePath(String serverFilePath) {
        ServerFilePath = serverFilePath;
    }



}
