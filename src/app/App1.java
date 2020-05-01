package ProjetDevops.ProjetDevops.app;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import ProjetDevops.ProjetDevops.dataframe.Dataframe;

public class App1 
{
	public static void main(String[] args) throws FileNotFoundException {
		Dataframe df = new Dataframe(args[0]);
		System.out.println("Ouverture du fichier .csv");
	}
}
