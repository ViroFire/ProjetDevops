package ProjetDevops.ProjetDevops;

import java.io.FileNotFoundException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataframeTest {

	 @Before
	 public void init() {
	 }
	
	 @After
	 public void cleanUp() {
		// TODO Auto-generated method stub

	}
	 
	 @Test
	 public void TestDataframeBon() throws FileNotFoundException {
		 Dataframe data = new Dataframe("data_sources/bonCSV.csv");
		 data.toString();
	 }
	 
	 @Test
	 public void TestDataframeRempli() throws FileNotFoundException {
		 Dataframe data = new Dataframe("data_sources/rempli.csv"); 
		 data.toString();
	 }

	@Test
	public void TestDataframeVide() throws FileNotFoundException {
		Dataframe data = new Dataframe("data_sources/bonCSV.csv");
		data.toString();
	}

}