package Client;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReaderThread extends Thread {

    Client client;
    BufferedReader reader;

    public ReaderThread(Client client, Socket socket) throws Exception {
        this.client = client;
        
        InputStream inputStream = socket.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        this.reader = new BufferedReader(inputStreamReader);
    }

    public void run() {
        while (true) {

            try {
                String message = reader.readLine();

                if (message != null) {
                    System.out.println(message);
                }
                
            } catch (Exception e) {
                System.out.println(e);
            }

        }
    }
    
}
