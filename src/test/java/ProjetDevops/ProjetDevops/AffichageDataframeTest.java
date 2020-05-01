package ProjetDevops.ProjetDevops;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.Test;

public class AffichageDataframeTest {

	ByteArrayOutputStream streamSorti;
	PrintStream ps;
	//Sauvegarde pour la sortie standar
	PrintStream oldout;
	
	/**
	 * Change la sortie standar pour récupérer ce quie est envoyé
	 * sur celle-ci
	 */
	private void CapSorti() {
		streamSorti = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(streamSorti);
		oldout = new PrintStream(System.out);
		System.setOut(ps);	
	}
	
	/**
	 * Permet de remettre la sortie standar par defaut
	 */
	private void RetourSortiNormal() {
		System.out.flush();
		System.setOut(oldout);		
	}
	
	@Test
	public void TestAffichageColonne() {
		CapSorti();
		String BadRef="";
		String stringRef = "prenom: age: taille: \n" + 
				"STRING INTEGER DOUBLE \n";
		try {
			Dataframe data = new Dataframe("data_sources/rempli.csv");
			data.printColonne();
			RetourSortiNormal();
			assertEquals(stringRef, streamSorti.toString() );
			assertNotEquals(BadRef, streamSorti.toString());
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Test
	public void testAfficherDataframe() {
		CapSorti();
		String stringref = "prenom: age: taille: \n" + 
				"STRING INTEGER DOUBLE \n" + 
				"Martin 15 1.75 \n" + 
				"Pierre 20 1.82 \n" + 
				"\n" + 
				"";
		String BadRef="";
		try {
			Dataframe data = new Dataframe("data_sources/bonCSV.csv");
			data.printDataframe();
			RetourSortiNormal();
			System.out.println(streamSorti.toString());
			assertEquals(stringref, streamSorti.toString());
			assertNotEquals(BadRef, streamSorti.toString());
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testAffichagePremierLignes() throws IOException {
		CapSorti();
		String stringref = "prenom: age: taille: \n" + 
				"STRING INTEGER DOUBLE \n" + 
				"Martin; 15; 1.75; \n" + 
				"Pierre; 20; 1.82; \n" + 
				"\n" + 
				"";

		String BadRef="";
		try {
			Dataframe data = new Dataframe("data_sources/rempli.csv");
			data.printFirstLines();
			RetourSortiNormal();
			assertEquals(stringref, streamSorti.toString());
			assertNotEquals(BadRef, streamSorti.toString());
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testAffichageDernierLignes() {
		CapSorti();
		String stringref = "prenom: age: taille: \n" + 
				"STRING INTEGER DOUBLE \n" + 
				"Antoine; 26; 1.83; \n" + 
				"Mimi; 54; 1.21; \n" + 
				"\n" + 
				"";
		String BadRef="";
		try {
			Dataframe data = new Dataframe("data_sources/rempli.csv");
			data.printLastLines();
			RetourSortiNormal();
			assertEquals(stringref, streamSorti.toString());
			assertNotEquals(BadRef, streamSorti.toString());
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testAffichageDataframeVide() {
		CapSorti();
		String stringref = ": \n" + 
				"UNDEF \n" + 
				"\n" + 
				"";
		String BadRef="";
		try {
			Dataframe data = new Dataframe("data_sources/vide.csv");
			data.printFirstLines();
			RetourSortiNormal();
			assertEquals(stringref, streamSorti.toString());
			assertNotEquals(BadRef, streamSorti.toString());
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void Notfile() {
		try {
			Dataframe data = new Dataframe("data_sources/null.csv");
			data.printDataframe();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
