package ProjetDevops.ProjetDevops;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Dataframe {
	
	FileInputStream file;
	ArrayList<Colonne> colonnes;
	ArrayList<Ligne> lignes;
	Scanner scanner;

	/**
	 * Créer un dataframe à partir du nom d'un fichier .csv
	 * @param file
	 * @throws FileNotFoundException 
	 */
	public Dataframe(String file) throws FileNotFoundException {
		colonnes = new ArrayList<Colonne>();
		lignes = new ArrayList<Ligne>();
		this.file = new FileInputStream(file);
		scanner = new Scanner(this.file);
		readCSV();
	}
	
	/**
	 * Construit d'un dataframe à partir d'un tableau 2D de String
	 * Noms de colonnes / Type des colonnes / Données
	 * @param tab (contient les données sous forme de String)
	 */
	public Dataframe(String[][] tab) {
		colonnes = new ArrayList<Colonne>();
		lignes = new ArrayList<Ligne>();
		// Création des colonnes
		TypeData currentType;
		String currentName;
		for(int i = 0; i < tab[0].length; i++) {
			currentName = tab[0][i];
			if(tab[1][i].equalsIgnoreCase("INTEGER")) {
				currentType = TypeData.INTEGER;
			}
			else if(tab[1][i].equalsIgnoreCase("DOUBLE")) {
				currentType = TypeData.DOUBLE;
			}
			else if(tab[1][i].equalsIgnoreCase("STRING")) {
				currentType = TypeData.STRING;
			}
			else {
				currentType = TypeData.UNDEF;
			}
			colonnes.add(new Colonne(currentName, currentType));
		}
		// Ajout lignes
		ArrayList<String> currentData = new ArrayList<String>();
		for(int i = 2; i < tab.length; i++) {
			if(tab[i].length == this.colonnes.size()) {
				for(int j = 0; j < tab[i].length; j++) {
					currentData.add(tab[i][j]);
				}
				lignes.add(new Ligne(extracted(currentData)));
				currentData.clear();
			}
		}
	}

	@SuppressWarnings("unchecked")
	private ArrayList<String> extracted(ArrayList<String> currentData) {
		return (ArrayList<String>) currentData.clone();
	}
	
	/**
	 * Lit le fichier CSV et remplit les listes colonnes et lignes
	 */
	private void readCSV() {
		// Création d'une liste de tableau de String pour stocker les données du fichier .csv
		ArrayList<String[]> dataCSV = new ArrayList<String[]>();
		
		// Récupération du contenu du fichier .csv
		while(scanner.hasNextLine()) {
			dataCSV.add(scanner.nextLine().replaceAll("\"", "").split(";"));
		}
		
		// Création des colonnes et ajout des noms
		String[] currentLine;
		int sizeData = dataCSV.get(0).length;
		currentLine = dataCSV.get(0);
		
		for(int i = 0; i<sizeData; i++) {
			colonnes.add(new Colonne(currentLine[i], TypeData.UNDEF));
		}
		
		// Création des lignes
		for(int i = 1; i < dataCSV.size(); i++) {
			currentLine = dataCSV.get(i);
			lignes.add(new Ligne(currentLine.clone()));
		}
		
		// Ajout de typedata aux colonnes
		if(lignes.size() > 0) {
			Ligne firstLine = lignes.get(0);
			Colonne currentColonne;
			String currentString;
			TypeData typeColonne;
			
			for(int i = 0; i < colonnes.size(); i++) {
				currentString = firstLine.getData().get(i);
				currentColonne = colonnes.get(i);
				try {
					Integer.parseInt(currentString);
					typeColonne = TypeData.INTEGER;
				} catch (Exception e) {
					// TODO: handle exception
					try {
						Float.parseFloat(currentString);
						typeColonne = TypeData.DOUBLE;
					} catch (Exception e2) {
						// TODO: handle exception
						typeColonne = TypeData.STRING;
					}
				}
				currentColonne.setType(typeColonne);
			}
		}
	}

	/**
	 * Affiche:
	 * -Premier ligne : le nom de la colonne
	 * -Deuxieme ligne : le type de la colonn
	 */
	public void printColonne() {
		for(int i = 0;i<colonnes.size();i++) {
			System.out.print(colonnes.get(i).getName()+": ");
		}
		System.out.println();
		for(int i = 0;i<colonnes.size();i++) {
			System.out.print(colonnes.get(i).getType().toString()+" ");
		}
		System.out.println();
	}
	
	/**
	 * Affiche sur la sortie standar, tous le contenu de la dataframe.
	 */
	public void printDataframe() {
		printColonne();
		for(int i = 0;i<lignes.size();i++) {
			for(int j = 0;j<colonnes.size();j++) {
				System.out.print(lignes.get(i).getData().get(j)+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	/**
	 * Affiche sur la sortie standar, les 2 premiere ligne de la dataframe.
	 */
	public void printFirstLines() {
		printColonne();
		for(int i = 0;i<2;i++) {
			for(int j = 0; j<colonnes.size();j++) {
				System.out.print(lignes.get(i).getData().get(j)+"; ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	/**
	 * Affiche sur la sortie standar, les 2 derniere ligne de la dataframe.
	 */
	public void printLastLines() {
		printColonne();
		for(int i = 0;i<lignes.size();i++) {
			if(i>lignes.size()-3) {
				for(int j = 0;j<colonnes.size();j++) {
					System.out.print(lignes.get(i).getData().get(j)+"; ");
				}
				System.out.println();
			}
		}
		System.out.println();
	}
	
	@Override
	public String toString() {
		return "Dataframe [colonnes = " + colonnes.toString() + ", lignes = " + lignes.toString() + "]";
	}
}
