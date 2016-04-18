import java.io.Serializable;
import java.util.List;

public class ComplexeData implements Serializable {
	
	private List<String> list;

    public ComplexeData(List<String> val) {
        this.list = val;
    }

    public List<String> getValeur(){
    	return list;
    }
    
	public void setValeur(List<String> s){
		list = s;
	}
		
}