//import java.awt.List;
//import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class BaseDonnee {
	
	ConcurrentHashMap<Integer, Object> base;
	int last_object;
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
			base.remove(last_object);
		}	
		else
			taille_courante ++;

		int key = o.hashCode();
		base.putIfAbsent(key, o);
		last_object = key;
		return key;
		
	}
	
	public void suppObject(int key){
		base.remove(key);
		taille_courante -- ;
	}
	
	/*public void addObjectList(Object o,int key){
		if(taille_courante == taille_max)
			base.remove(last_object);
		else
			taille_courante ++;
		
		ArrayList l = (ArrayList)base.get(key);
		if(l==null)
			l = new ArrayList();
		
		l.add(o);
		base.putIfAbsent(key, l);
		last_object = key;

		
	}
	
	public void suppObjectList(int key){
		ArrayList l = (ArrayList)base.get(key);
		l.remove(l.size()-1);
		taille_courante -- ;
		
	}*/
	
	public ConcurrentHashMap<Integer, Object> getBase(){
		return base;
	}
	
	
	
	
	
}
