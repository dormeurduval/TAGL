import java.io.Serializable;

public class Data extends Object implements Serializable{

	Object o;
	int key;
	
	public Data(int key, Object o){

		this.o = o;
		this.key = key;
	}
	
	public Object getData(){
		return o;
	}
	
	
	public int getK(){
		return key;
	}
	
	public void setData(Object o){
		this.o = o;
	}
	

	
	public void getK(int key){
		this.key = key;
	}
	
	
}
