import java.util.HashMap;

public class ThreadSearch extends Thread{
	HashMap<Integer ,Object> h;
	int key;
	Object o;

	ThreadSearch(HashMap<Integer ,Object> h){
		this.h = h;
	}
	
	public void add(int key,Object o){
		this.key=key;
		this.o = o;
	}
	
	
	public void run(){	
		Object value=h.get(key);
		if(value != null)
			o = value;
		
	}
}
