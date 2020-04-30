package ProjetDevops.ProjetDevops;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Dataframe {
	
	FileInputStream file;
	ArrayList<Column> colonnes;
	ArrayList<Line> lignes;
	Scanner scanner;

	/**
	 * Créer un dataframe à partir du nom d'un fichier csv
	 * @param file
	 * @throws FileNotFoundException 
	 */
	public Dataframe(String file) throws FileNotFoundException {
		colonnes = new ArrayList<Column>();
		lignes = new ArrayList<Line>();
		this.file = new FileInputStream(file);
		scanner = new Scanner(this.file);
		readCSV();
	}
	
	/**
	 * Construit d'un dataframe à partir d'un tableau 2D de String
	 * Premiere lignes : noms de colonnes / Deuxième ligne : type des colonnes / Données
	 * @param tab (contient les données sous forme de string)
	 */
	public Dataframe(String[][] tab) {
		colonnes = new ArrayList<Column>();
		lignes = new ArrayList<Line>();
		// Création des colonnes
		DataType currentType;
		String currentName;
		for(int i = 0; i < tab[0].length; i++) {
			currentName = tab[0][i];
			if(tab[1][i].equalsIgnoreCase("INTERGER")) {
				currentType = DataType.INTEGER;
			}
			else if(tab[1][i].equalsIgnoreCase("DOUBLE")) {
				currentType = DataType.DOUBLE;
			}
			else if(tab[1][i].equalsIgnoreCase("STRING")) {
				currentType = DataType.STRING;
			}
			else {
				currentType = DataType.UNDEF;
			}
			colonnes.add(new Column(currentName, currentType));
		}
		// Ajout lignes
		ArrayList<String> currentData = new ArrayList<String>();
		for(int i = 2; i < tab.length; i++) {
			if(tab[i].length == this.colonnes.size()) {
				for(int j = 0; j < tab[i].length; j++) {
					currentData.add(tab[i][j]);
				}
				lignes.add(new Line(extracted(currentData)));
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
			colonnes.add(new Column(currentLine[i]));
		}
		
		// Création des lignes
		for(int i = 1; i < dataCSV.size(); i++) {
			currentLine = dataCSV.get(i);
			lignes.add(new Line(currentLine.clone()));
		}
	}

	@Override
	public String toString() {
		return "Dataframe [colonnes=" + colonnes.toString() + ", lignes=" + lignes.toString() + "]";
	}
}
