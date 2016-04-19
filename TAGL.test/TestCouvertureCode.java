import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class TestCouvertureCode {

	@Test
	public void testAjoutUnObject() {
		BaseDonnee b = new BaseDonnee(5);
		
		int key=b.addObject(5);
		
		assertEquals( "Test de l'ajout d'un objet",(int)b.getObject(key), 5);
		assertEquals( "Test de l'ajout d'un objets",b.getTaille_courante(),1);
	}
	
	@Test
	public void testEnleverUnObject() {
		BaseDonnee b = new BaseDonnee(5);
		
		int key=b.addObject(5);
		b.suppObject(key);
		
		assertEquals( "Test retrait d'un objet",b.getObject(key), null);
		assertEquals( "Test retrait d'un objet",b.getTaille_courante(),0);
	}
	
	@Test
	public void testEnleveAjoutplusieursObjects() {
		BaseDonnee b = new BaseDonnee(10);
		
		int key1=b.addObject(5);
		int key2=b.addObject("leroi");
		int key3=b.addObject("lareine");		
		int key4=b.addObject(-5);
		
		
		assertEquals( "Test retrait et ajout de plusieurs objets",b.getObject(key1),5);
		assertEquals( "Test retrait et ajout de plusieurs objets",b.getObject(key2),"leroi");
		assertEquals( "Test retrait et ajout de plusieurs objets",b.getObject(key3),"lareine");
		assertEquals( "Test retrait et ajout de plusieurs objets",b.getObject(key4),-5);
		assertEquals( "Test retrait et ajout de plusieurs objets",b.getTaille_courante(),4);
		
		b.suppObject(key3);
		assertEquals( "Test retrait et ajout de plusieurs objets",b.getObject(key3),null);
		
		int key5 = b.addObject(5.0);
		int key6 = b.addObject(8.0);		
		
		assertEquals( "Test retrait et ajout de plusieurs objets",b.getObject(key5),5.0);
		assertEquals( "Test retrait et ajout de plusieurs objets",b.getObject(key6),8.0);
		assertEquals( "Test retrait et ajout de plusieurs objets",b.getTaille_courante(),5);
		
		b.suppObject(key5);
		b.suppObject(key2);
		b.suppObject(key4);
		
		assertEquals( "Test retrait et ajout de plusieurs objets",b.getObject(key5),null);
		assertEquals( "Test retrait et ajout de plusieurs objets",b.getObject(key2),null);
		assertEquals( "Test retrait et ajout de plusieurs objets",b.getObject(key4),null);
		
		b.suppObject(key5);
		assertEquals( "Test retrait et ajout de plusieurs objets",b.getObject(key5),null);
		assertEquals( "Test retrait et ajout de plusieurs objets",b.getTaille_courante(),2);
	}
	
	@Test
	public void testSurTailleMax() {
		BaseDonnee b = new BaseDonnee(4);
		
		int key1=b.addObject(5);
		int key2=b.addObject("leroi");
		int key3=b.addObject("lareine");		
		int key4=b.addObject(-5);
		
		assertEquals( "Test sur la taille max",b.getObject(key4),-5);
		
		int key5=b.addObject(6);
		
		assertEquals( "Test sur la taille max",b.getObject(key1),null);
		assertEquals( "Test sur la taille max",b.getObject(key2),"leroi");
		assertEquals( "Test sur la taille max",b.getObject(key3),"lareine");
		assertEquals( "Test sur la taille max",b.getObject(key4),-5);
		
		assertEquals( "Test sur la taille max",b.getObject(key5),6);		
		
		assertEquals( "Test sur la taille max",b.getTaille_courante(),4);
		
	}
	
	@Test
	public void TestRandom(){
		int taille = (int) (Math.random() * 300 );
		BaseDonnee b = new BaseDonnee(taille);
		int cpt = 0;
		while(b.getTaille_courante()!=taille){
			int x = (int)Math.random();
			int key = b.addObject(x);
			cpt++;
			assertEquals( "Test random",b.getObject(key),x);
			assertEquals( "Test random",b.getTaille_courante(),cpt);
	
		}
	}

}
