package ProjetDevops.ProjetDevops;

import java.io.FileNotFoundException;

import org.junit.Test;

public class AffichageDataframeTest {

	@Test
	public void testAffichagePremierLignes() {
		try {
			Dataframe data = new Dataframe("data_sources/rempli.csv");
			data.printDataframe();
			data.printColonne();
			data.printFirstLines();
			data.printLastLines();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
