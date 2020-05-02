package ProjetDevops.ProjetDevops;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.Test;

public class DataframeTest {
	
	ByteArrayOutputStream streamOut;
	PrintStream ps;
	// Sauvegarde pour la sortie standard
	PrintStream oldOut;

	/** Teste l'emplacement des fichiers et s'ils existent bien
	 * @throws FileNotFoundException
	 */
    @Test
    public void testFile() throws FileNotFoundException {
    	Dataframe df = new Dataframe("./data_sources/vide.csv");
    	Dataframe df2 = new Dataframe("./data_sources/rempli.csv");
    }

    /** Teste si deux dataframes .csv sont identiques
     * @throws FileNotFoundException
     */
    @Test
    public void testDoublonFile() throws FileNotFoundException {
    	Dataframe df = new Dataframe("./data_sources/vide.csv");
    	Dataframe df2 = new Dataframe("./data_sources/rempli.csv");
    	assertFalse("fichiers identiques", df.equals(df2));
    	Dataframe df3 = new Dataframe("./data_sources/rempli.csv");
    	assertFalse("fichiers identiques", df3.equals(df2));
    }

    /** Teste deux dataframes String sont identiques
     */
	@Test
	public void testDoublon() {
		String[][] data = {{"c1", "c2", "c3"},
							{"STRING", "INTEGER", "DOUBLE"},
							{"1", "2", "3"},
							{"4", "5", "6"}
							};
		Dataframe df = new Dataframe(data);
		Dataframe df2 = new Dataframe(data);
		assertFalse("Deux dataframes identiques", df.equals(df2));
	}

	/** Affiche un dataframe String
	 */
	@Test
	public void testToString() {
		String[][] data = {{"c1", "c2", "c3", "c4"},
				{"STRING", "INTEGER", "DOUBLE", "UNDEF"},
				{"1", "2", "3", "a4"},
				{"4", "5", "6", "2b"}
				};
		Dataframe df = new Dataframe(data);
		System.out.println(df.toString());
	}
	
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
	 * Remet la sortie standard par defaut
	 */
	private void defaultSortie() {
		System.out.flush();
		System.setOut(oldOut);		
	}
	
	/** Teste l'affichage d'une colonne
	 */
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

	/** Teste si l'affichage d'un dataframe .csv est correct
	 */
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
	
	/** Teste si l'affichage des premières lignes d'un dataframe .csv est correct
	 * @throws IOException
	 */
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
	
	/** Teste si l'affichage des dernières lignes d'un dataframe .csv est correct
	 * @throws IOException
	 */
	@Test
	public void testAffichageDernieresLignes() throws IOException {
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
	
	/** Teste si l'affichage d'un dataframe .csv vide est bien vide
	 */
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
