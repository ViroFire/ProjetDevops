package ProjetDevops.ProjetDevops;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.Test;

public class AffichageDataframeTest {

	ByteArrayOutputStream streamOut;
	PrintStream ps;
	//Sauvegarde pour la sortie standar
	PrintStream oldOut;
	
	/**
	 * Change la sortie standard pour récupérer ce qui est envoyé
	 */
	private void changeSortie() {
		streamOut = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(streamOut);
		oldOut = new PrintStream(System.out);
		System.setOut(ps);	
	}
	
	/**
	 * Permet de remettre la sortie standard par defaut
	 */
	private void defaultSortie() {
		System.out.flush();
		System.setOut(oldOut);		
	}
	
	@Test
	public void testAffichageColonne() {
		changeSortie();
		String BadRef = "";
		String stringRef = "prenom: age: taille: \n" + "STRING INTEGER DOUBLE \n";
		
		try {
			Dataframe data = new Dataframe("data_sources/rempli.csv");
			data.affichageColonne();
			defaultSortie();
			assertEquals(stringRef, streamOut.toString());
			assertNotEquals(BadRef, streamOut.toString());
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Test
	public void testAffichageDataframe() {
		changeSortie();
		String BadRef = "";
		String stringref = "prenom: age: taille: \n" + 
							"STRING INTEGER DOUBLE \n" + 
							"Martin 15 1.75 \n" + 
							"Pierre 20 1.82 \n" + "\n" + "";
		
		try {
			Dataframe data = new Dataframe("data_sources/bonCSV.csv");
			data.affichageDataframe();
			defaultSortie();
			assertEquals(stringref, streamOut.toString());
			assertNotEquals(BadRef, streamOut.toString());
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testAffichagePremieresLignes() throws IOException {
		changeSortie();
		String BadRef = "";
		String stringref = "prenom: age: taille: \n" + 
				"STRING INTEGER DOUBLE \n" + 
				"Martin; 15; 1.75; \n" + 
				"Pierre; 20; 1.82; \n" + "\n" + "";
		
		try {
			Dataframe data = new Dataframe("data_sources/rempli.csv");
			data.affichagePremieresLignes();
			defaultSortie();
			assertEquals(stringref, streamOut.toString());
			assertNotEquals(BadRef, streamOut.toString());
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testAffichageDernieresLignes() {
		changeSortie();
		String BadRef="";
		String stringref = "prenom: age: taille: \n" + 
				"STRING INTEGER DOUBLE \n" + 
				"Antoine; 26; 1.83; \n" + 
				"Mimi; 54; 1.21; \n" + "\n" + "";
		
		try {
			Dataframe data = new Dataframe("data_sources/rempli.csv");
			data.affichageDernieresLignes();
			defaultSortie();
			assertEquals(stringref, streamOut.toString());
			assertNotEquals(BadRef, streamOut.toString());
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testAffichageDataframeVide() {
		changeSortie();
		String BadRef="";
		String stringref = ": \n" + "UNDEF \n" + "\n" + "";
		
		try {
			Dataframe data = new Dataframe("data_sources/vide.csv");
			data.affichagePremieresLignes();
			defaultSortie();
			assertEquals(stringref, streamOut.toString());
			assertNotEquals(BadRef, streamOut.toString());
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
