import java.io.Serializable;

public class Valeur implements Serializable {
	private String valeur;
	private int k;

    public Valeur(int key, String val) {
        this.valeur = val;
        this.k = key;
    }

    public String getValeur(){
    	return valeur;
    }
    
	public void setValeur(String s){
		valeur = s;
	}
	
	public int getK(){
		return k;
	}
	
	public void setk(int key){
		k = key;
	}
}

