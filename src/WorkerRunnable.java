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
    protected ConcurrentHashMap<String, Integer> cache = null;
    protected ConcurrentHashMap<Integer, List<String>> complexeCache = null;
    
    protected ObjectInputStream input = null;
   // protected ObjectOutputStream output = null;

    public WorkerRunnable(Socket clientSocket, ConcurrentHashMap<String, Integer> cache, 
    		ConcurrentHashMap<Integer,List<String>> complexeCache) {
        this.clientSocket = clientSocket;
        this.cache = cache;
        this.complexeCache = complexeCache;
    }

    public void run() {
        try {
            //InputStream input  = clientSocket.getInputStream();
            //OutputStream output = clientSocket.getOutputStream();
           /* long time = System.currentTimeMillis();
            output.write(("HTTP/1.1 200 OK\n\nWorkerRunnable: " +
this.serverText + " - " +
time +
"").getBytes());*/
	
			input = new ObjectInputStream(clientSocket.getInputStream());
			//output = new ObjectOutputStream(clientSocket.getOutputStream());
			/*Valeur student = (Valeur) input.readObject();
            System.out.println("Object received = " + student.getValeur());
			
			cache.putIfAbsent(student.getValeur(), 1);*/
			
			ComplexeData d = (ComplexeData) input.readObject();
			
			complexeCache.putIfAbsent(1, d.getValeur());
			
			System.out.println("Object cached !");
			
			for(Map.Entry<Integer, List<String>> entry : complexeCache.entrySet()){
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
