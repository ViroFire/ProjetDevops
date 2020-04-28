package ProjetDevops.ProjetDevops;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Dataframe {
	
	FileInputStream file;
	String[] nomsColonnes;
	ArrayList<Column> colonnes;
	ArrayList<Line> lignes;
	
	Scanner scanner;
	
	/**
	 * Permet de créer un Datframe à partir du nom d'un fichier csv
	 * @param file
	 * @throws FileNotFoundException 
	 */
	public Dataframe(String file) throws FileNotFoundException {
		colonnes = new ArrayList<Column>();
		lignes = new ArrayList<Line>();
		this.file = new FileInputStream(file);
		scanner = new Scanner(this.file);
	}
	
	/**
	 * Permet la construction d'un Dataframe à partir d'un tableau 2D de String,
	 * 
	 * @param args
	 * 
	 */
	public Dataframe(String[][] data) {
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 System.out.println( "Hello World! to dataframe" );
	}

}
