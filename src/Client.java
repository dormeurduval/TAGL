import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

public class Client {
    private Socket socket = null;
    private ObjectInputStream inputStream = null;
    private ObjectOutputStream outputStream = null;
    private boolean isConnected = false;

    public Client() {

    }

    public void communicate() {

        while (!isConnected) {
            try {
                socket = new Socket("localhost", 9000);
                System.out.println("Connected");
                isConnected = true;
                outputStream = new ObjectOutputStream(socket.getOutputStream());
                
                //Valeur student = new Valeur("Bijoy");
                //System.out.println("Object to be written = " + student.getValeur());
                //outputStream.writeObject(student);
                List<String> list = new ArrayList<String>();
                list.add("Bonjour Joris !");
                list.add("J'envoie une liste !");
                
                ComplexeData d = new ComplexeData(1, list);
                outputStream.writeObject(d);

            } catch (SocketException se) {
                se.printStackTrace();
                // System.exit(0);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.communicate();
    }
}

