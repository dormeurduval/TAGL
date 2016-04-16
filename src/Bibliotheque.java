import java.util.*;

public class Bibliotheque extends Thread {
	int taille_courante;
	int taille_max;
	int last_object;
	int last_modif;

	
	ThreadRemove[] tab_remove;
	ThreadSearch[] tab_search;
	int nb_thread;
	List table;
	

	
	public void Bibliothèque(int taille_max,int nb_thread){
		taille_courante = 0;
		this.taille_max = taille_max;
		this.nb_thread = nb_thread;
		table = new <HashMap<Integer ,Object>>ArrayList();
		tab_remove = new ThreadRemove[nb_thread];
		tab_search = new ThreadSearch[nb_thread];		
		for(int i=0;i<nb_thread;i++){
			table.add(new HashMap());
			tab_remove[i]=new ThreadRemove((HashMap<Integer ,Object>)table.get(i));
			tab_search[i]=new ThreadSearch((HashMap<Integer ,Object>)table.get(i));			
		}
			
		
	}
	
	public void ajouterObject(Object s){
		if(taille_courante == taille_max){
			HashMap<Integer ,Object> h =(HashMap)(table.get(last_modif));
			h.remove(last_object);
		}	
		else
			taille_courante++;
		
		HashMap<Integer ,Object> h = (HashMap)(table.get(last_modif));
		h.put(s.hashCode(),s);
		last_object = s.hashCode();
		last_modif = (last_modif + 1 ) % nb_thread;
		
	}
	
	public Object trouverObject(Integer k){
		Object valeur_retour = null;
		for(int i=0;i<nb_thread;i++){
			tab_search[i].add(k,valeur_retour);			
			tab_search[i].start();

		}
		return valeur_retour;
	}
	
	public void removeObject(Integer k){
		for(int i=0;i<nb_thread;i++){
			tab_remove[i].add_key(k);
			tab_remove[i].start();			
		}
	}
	
	
	
}
