package Server;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class User extends Thread {
    
    Server server;
    String username;
    BufferedReader reader;
    BufferedWriter writer;

    public User(Server server, Socket socket) throws Exception {
        this.server = server;

        InputStream inputStream = socket.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        this.reader = new BufferedReader(inputStreamReader);

        OutputStream outputStream = socket.getOutputStream();
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        this.writer = new BufferedWriter(outputStreamWriter);
    }

    public void run() {
        while (true) {

            try {
                String message = reader.readLine();

                if (message == null) {
                    continue;
                }
        
                System.out.println(message);

                for (int i = 0; i < server.users.length; i++) {

                    if ((server.users[i] == null) || (server.users[i] == this)) {
                        continue;
                    } 

                    BufferedWriter otherUserWriter = server.users[i].writer;
                    otherUserWriter.write("Other User: " + message);
                    otherUserWriter.newLine();
                    otherUserWriter.flush();
                }
            } catch (Exception e) {
                System.out.println(e);
            }

        }
    }
}
