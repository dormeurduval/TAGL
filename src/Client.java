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

    public boolean connect(){
    	//while(!isConnected){
    		try {
                socket = new Socket("localhost", 9000);
                
                System.out.println("Connected");
                isConnected = true;
                
    		} catch (SocketException se) {
                se.printStackTrace();
                // System.exit(0);
            } catch (IOException e) {
                e.printStackTrace();
            }
    		return isConnected;
    	//}
    	
    }
    
    public void sendData(Data d){
    	if(isConnected){
    		try {
				outputStream = new ObjectOutputStream(socket.getOutputStream());
				outputStream.writeObject(d);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    	}else
    		System.out.println("not connected send");
    }
    
    public  void removeData(int key){
    	if(isConnected){
    		Data d = new Data(key, "**remove**");
    		try {
				outputStream = new ObjectOutputStream(socket.getOutputStream());
				outputStream.writeObject(d);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
    	}else
    		System.out.println("not connected remove");
    }
    
    public void showBase(){
    	if(isConnected){
    		Data d = new Data(0, "**showBase**");
    		try {
				outputStream = new ObjectOutputStream(socket.getOutputStream());
				outputStream.writeObject(d);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
    	}else
    		System.out.println("not connected showBase");
    }
  

    public static void main(String[] args) {
        Client client = new Client();
        Client client2 = new Client();
        Client client3 = new Client();
        
        if(client.connect() && client2.connect() && client3.connect()){
        	Data d = new Data(1, "Bonjour!");
        	client.sendData(d);

        	List<String> list = new ArrayList<String>();
        	list.add("c'est une liste !"); list.add("yeah!");
        	Data s = new Data(2, list);
        	client2.sendData(s);
        	client2.showBase();

        	client3.showBase();
        }
        	
        
       
    }
}
