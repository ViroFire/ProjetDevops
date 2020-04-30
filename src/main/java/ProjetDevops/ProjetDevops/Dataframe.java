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
	 * Permet de créer un Datframe à partir du nom d'un fichier csv
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
	 * Permet la construction d'un Dataframe à partir d'un tableau 2D de String,
	 * Premiere lignes : noms de colonnes
	 * Seconde ligne : Type des colonnes (INTEGER, DOUBLE et STRING)
	 * Suite : données
	 * @param data (Tableau qui contient les données sous forme de string).
	 */
	public Dataframe(String[][] data) {
		colonnes = new ArrayList<Column>();
		lignes = new ArrayList<Line>();
		// Création des colonnes
		DataType currentType;
		String currentName;
		for(int i = 0; i<data[0].length;i++) {
			currentName = data[0][i];
			if(data[1][i].equalsIgnoreCase("INTERGER")) {
				currentType=DataType.INTEGER;
			}
			else if(data[1][i].equalsIgnoreCase("DOUBLE")) {
				currentType=DataType.DOUBLE;
			}
			else if(data[1][i].equalsIgnoreCase("STRING")) {
				currentType=DataType.STRING;
			}
			else {
				currentType=DataType.UNDEFINED;
			}
			colonnes.add(new Column(currentName,currentType));
		}
		// Ajout des lignes
		ArrayList<String> currentData = new ArrayList<String>();
		for(int i = 2; i<data.length;i++) {
			if(data[i].length == this.colonnes.size()) {
				for(int j = 0;j<data[i].length;j++) {
					currentData.add(data[i][j]);
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
	 * Lit le fichier CSV et complete les listes colonnes et lignes
	 */
	private void readCSV() {
		//Création d'une liste de tableaud e string pour stocker les donné du fichier .csv
		ArrayList<String[]> dataCSV = new ArrayList<String[]>();
		//Récupération du contenue du fichier CSV
		while(scanner.hasNextLine()) {
			dataCSV.add(scanner.nextLine().replaceAll("\"", "").split(";"));
		}
		//Création des colonnes et ajout des noms
		String[] currentLine;
		int sizeData = dataCSV.get(0).length;
		currentLine=dataCSV.get(0);
		for(int i = 0; i<sizeData;i++) {
			colonnes.add(new Column(currentLine[i]));
		}
		//Création des lignes
		for(int i = 1; i<dataCSV.size();i++) {
			currentLine=dataCSV.get(i);
			lignes.add(new Line(currentLine.clone()));
		}
	}

	@Override
	public String toString() {
		return "Dataframe [colonnes=" + colonnes.toString() + ", lignes=" + lignes.toString() + "]";
	}
}
