package Server;

import java.net.ServerSocket;

public class Server {

    int port = 8989;
    ServerSocket serverSocket;
    ServerAccepter serverAccepter;
    User[] users = new User[5];
    int userIndex = 0;

    public void run() throws Exception {
        serverSocket = new ServerSocket(port);
        serverAccepter = new ServerAccepter(this);
        serverAccepter.start();

        System.out.println("Server started.");
    }
    
}
