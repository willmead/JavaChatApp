package Server;
import java.net.Socket;

class ServerAccepter extends Thread {

    Server server;

    public ServerAccepter(Server server) {
        this.server = server;
    }

    public void run() {
        while (true) {

            try {
                Socket socket = server.serverSocket.accept();
    
                server.users[server.userIndex] = new User(server, socket);
                server.users[server.userIndex].start();
                server.userIndex ++;

                System.out.println("Client Accepted.");
            } catch (Exception e) {
                System.out.println(e);
            }   
            
        }
    }
}