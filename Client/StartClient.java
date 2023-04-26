package Client;
public class StartClient {

    public static void main(String[] args) {
        Client client = new Client();

        try {
            client.run();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
