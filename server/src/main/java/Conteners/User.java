package Conteners;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class User {
    @Id
    @GeneratedValue
    private long id;
    @Column(unique = true)
    private String name;
    private String password;
    private String localFilePath;
    @Column(unique = true)
    private String serverFilePath;

    public User(String name, String password, String localFilePath, String serverFilePath) {
        this.name = name;
        this.password = password;
        this.localFilePath = localFilePath;
        this.serverFilePath = serverFilePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLocalFilePath() {
        return localFilePath;
    }

    public void setLocalFilePath(String localFilePath) {
        this.localFilePath = localFilePath;
    }

    public String getServerFilePath() {
        return serverFilePath;
    }

    public void setServerFilePath(String serverFilePath) {
        this.serverFilePath = serverFilePath;
    }
}
