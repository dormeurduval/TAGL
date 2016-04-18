import java.io.Serializable;

public class Valeur implements Serializable {
	private String valeur;

    public Valeur(String val) {
        this.valeur = val;
    }

    public String getValeur(){
    	return valeur;
    }
    
	public void setValeur(String s){
		valeur = s;
	}
}

