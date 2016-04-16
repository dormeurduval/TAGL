import java.util.HashMap;

public class ThreadRemove extends Thread{
	HashMap<Integer ,Object> h;
	int key;

	ThreadRemove(HashMap<Integer ,Object> h){
		this.h = h;
	}
	
	public void add_key(int key){
		this.key=key;

	}
	
	
	public void run(){	
		h.remove(key);
	}	


		
	
}
