import java.io.Serializable;
import java.util.List;

public class ComplexeData implements Serializable {
	
	private List<String> list;
	private int k;

    public ComplexeData(int key, List<String> val) {
        this.list = val;
        this.k = key;
    }

    public List<String> getValeur(){
    	return list;
    }
    
	public void setValeur(List<String> s){
		list = s;
	}
	
	public int getK(){
		return k;
	}
	
	public void setk(int key){
		k = key;
	}
		
}
