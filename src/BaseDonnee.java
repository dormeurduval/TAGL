//import java.awt.List;
//import java.util.ArrayList;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class BaseDonnee {
	
	ConcurrentHashMap<Integer, Object> base;
	int first_object;
	int taille_courante;
	int taille_max;
	
	public int getTaille_courante(){
		return taille_courante;
	}
	
	BaseDonnee(int taille_max){
		base = new ConcurrentHashMap<Integer, Object>();
		taille_courante =0;
		this.taille_max = taille_max;
	
	}
	
	public int addObject(Object o){
		if(taille_courante == taille_max){
			base.remove(first_object);
		}	
		else
			taille_courante ++;

		int key = o.hashCode();
		base.putIfAbsent(key, o);
		if(taille_courante == 1)
			first_object = key;
		return key;
		
	}
	
	public void suppObject(int key){
		boolean isInthebase = base.containsKey(key);
		base.remove(key);
		if(isInthebase)
			taille_courante -- ;
	}
	
	public Object getObject(int key){
		return base.get(key);

	}
	
	public void addObjectList(Object o,int key){
		if(taille_courante == taille_max)
			base.remove(first_object);
		else
			taille_courante ++;
		
		ArrayList l = (ArrayList)base.get(key);
		if(l==null)
			l = new ArrayList();
		
		l.add(o);
		base.putIfAbsent(key, l);
		first_object = key;

		
	}
	
	public void suppObjectList(int key){
		boolean isInthebase = base.containsKey(key);
		ArrayList l = (ArrayList)base.get(key);
		l.remove(l.size()-1);
		if(isInthebase)
			taille_courante -- ;
		
	}
	
	
	public ConcurrentHashMap<Integer, Object> getBase(){
		return base;
	}
	
	
	
	
	
}
