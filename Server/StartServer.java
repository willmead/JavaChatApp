package Server;

public class StartServer {

    public static void main(String[] args) {
        Server server = new Server();

        try {
            server.run();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
