package ProjetDevops.ProjetDevops;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;

public class LigneTest {
	
	@Test
	public void testInitDataArrayList() {
		ArrayList<String> listeString = new ArrayList<String>();
		listeString.add("oui");
		listeString.add("bonjour");
		listeString.add("non");
		Ligne ligne = new Ligne(listeString);
	}

	@Test
	public void testInitDataTab() {
		String[] tabString = {"1", "2", "3"};
		Ligne ligne = new Ligne(tabString);
	}
	
	@Test
	public void testGetData() {
		ArrayList<String> listeString = new ArrayList<String>();
		listeString.add("oui");
		listeString.add("bonjour");
		listeString.add("non");
		Ligne ligne2 = new Ligne(listeString);
		// 1er affichage
		System.out.println(ligne2.getData());
	}
	
	@Test
	public void testToStringArrayList() {
		ArrayList<String> listeString = new ArrayList<String>();
		listeString.add("oui");
		listeString.add("bonjour");
		listeString.add("non");
		// 2ème affichage
		System.out.println(listeString.isEmpty());
		// 3ème affichage
		System.out.println(listeString.toString());
		Ligne ligne2 = new Ligne(listeString);
		// 4ème affichage
		System.out.println(ligne2.toString());
	}
	
	@Test
	public void testToStringTab() {
		String[] tabString = {"1", "2", "3"};
		Ligne ligne = new Ligne(tabString);
		// 5ème affichage
		System.out.println(ligne.toString());
	}
}
