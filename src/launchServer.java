public class launchServer{
public static void main(String[] args){

	ThreadPooledServer server = new ThreadPooledServer(9000);
	new Thread(server).start();
	
	System.out.println("Server started !");

	try {
		Thread.sleep(20 * 1000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	System.out.println("Stopping Server");
	server.stop();
	
}
}