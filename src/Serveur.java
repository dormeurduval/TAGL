import java.util.*;

public class Serveur {
	int taille_courante;
	int taille_max;
	Object last_object;
	
	Map<Integer ,Object> table;
	
	public void Serveur(int taille_max){
		taille_courante = 0;
		this.taille_max = taille_max;
		table = new HashMap<Integer ,Object>();
		
	}
	
	public void ajouterObject(Object s){
		if(taille_courante == taille_max)
			table.remove(last_object);
		else
			taille_courante++;
		
		table.put(s.hashCode(),s);
		last_object = s;
	}
	
	public Object trouverObject(Integer k){
		return table.get(k);
	}
	
	
	
}
