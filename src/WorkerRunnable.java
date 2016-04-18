import java.io.InputStream;
import java.io.OutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;
import java.util.List;
import java.util.Map;

public class WorkerRunnable implements Runnable{
	
    protected Socket clientSocket = null;
    protected ConcurrentHashMap<Integer, Object> complexeCache = null;
    
    protected ObjectInputStream input = null;
   // protected ObjectOutputStream output = null;

    public WorkerRunnable(Socket clientSocket, 
    		ConcurrentHashMap<Integer, Object> complexeCache) {
        this.clientSocket = clientSocket;
        
        this.complexeCache = complexeCache;
    }

    public void run() {
        try {
            
	
			input = new ObjectInputStream(clientSocket.getInputStream());
			//output = new ObjectOutputStream(clientSocket.getOutputStream());
			/*
            System.out.println("Object received = " + student.getValeur());
			
			cache.putIfAbsent(student.getValeur(), 1);*/
			
			Data d = (Data) input.readObject();
			
			if(!d.getData().equals("**remove**")){
				complexeCache.putIfAbsent(d.getK(), d.getData());
				System.out.println("Object cached !");
			}
			else{
				complexeCache.remove(d.getK());
				System.out.println("Object removed !");
			}
			
			
			
			for(Map.Entry<Integer, Object> entry : complexeCache.entrySet()){
    			System.out.printf("Key : %s and Value: %s %n", entry.getKey(), entry.getValue());
			}
			
			//ThreadPooledServer.showCache();
           // output.close();
            input.close();
           // System.out.println("Request processed: " + time);
        } catch (IOException e) {
            //report exception somewhere.
            e.printStackTrace();
        }
         catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}