package Client;
import java.net.Socket;

public class Client {

    String hostName = "localhost";
    int port = 8989;
    ReaderThread readerThread;
    WriterThread writerThread;
    Socket socket;

    public void run() throws Exception {
        
        socket = new Socket(hostName, port);
        readerThread = new ReaderThread(this, socket);
        writerThread = new WriterThread(this, socket);

        readerThread.start();
        writerThread.start(); 

    }
    
}
