package sample;
import org.json.*;
import java.io.BufferedReader;
import java.io.IOException;

public class ReaderThread implements Runnable {
    @Override
    public void run() {
        ClientSocket clientSocket = ClientSocket.getInstance();
        clientSocket.launch();//launch if not launched
        BufferedReader reader = clientSocket.getBufferedReader();
        while (true){
            try {
                String value = reader.readLine();
                //json parse
                //zapis do observable list i to wszystko tutaj

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
