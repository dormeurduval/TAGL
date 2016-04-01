import java.util.*;

public class Serveur {
	Map<Integer ,Object> table;
	
	public void ajouterString(Object s){
		table.put(s.hashCode(),s);
	}
	
	public Object trouverObject(Integer k){
		return table.get(k);
	}
	
	
	
}
