package Client;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class WriterThread extends Thread {

    Client client;
    BufferedWriter writer;

    public WriterThread(Client client, Socket socket) throws Exception {
        this.client = client;
        
        OutputStream outputStream = socket.getOutputStream();
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        this.writer = new BufferedWriter(outputStreamWriter);
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {

            try {
                String message = scanner.nextLine();

                this.writer.write(message);
                this.writer.newLine();
                this.writer.flush();

                if (message.equals("exit")) {
                    scanner.close();
                    client.socket.close();
                }

                
            } catch (Exception e) {
                System.out.println(e);
            }
            
        }
    }
    
}
