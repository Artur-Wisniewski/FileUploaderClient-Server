package sample;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientSocket {
    String HOST_NAME = "localhost";
    int PORT_NUMBER = 8080;
    PrintWriter out;
    BufferedReader in;
    Boolean launched = false;
    //singleton instance  static factory method
    public static final ClientSocket INSTANCE = new ClientSocket();
    private ClientSocket() {
    }
    public  void launch(){
        if(!launched)
        startConnection();
        launched = true;
    }
    public static ClientSocket getInstance() {
        return INSTANCE;
    }
    private void startConnection(){
        try {
            Socket client = new Socket(HOST_NAME, PORT_NUMBER);
            out = new PrintWriter(client.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        }catch (Exception e){
            e.fillInStackTrace();
        }
    }
    public void sendMessage(String message){
        out.println(message);
    }
    public BufferedReader getBufferedReader(){
        return in;
    }
}
