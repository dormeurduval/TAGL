
public class ServeurExecution extends Thread{
	

	public void run(){
		
		
	}
	
	
	public static void main() throws InterruptedException{
		Thread[] tab = new Thread[100];
		for(int i=0;i<100;i++){
			tab[i]= new Thread();
			tab[i].start();
		}

		for(int i=0;i<100;i++){
			tab[i].join();

		}
		
		
	}

		
	
}
