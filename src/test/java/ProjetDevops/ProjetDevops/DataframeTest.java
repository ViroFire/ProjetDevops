package ProjetDevops.ProjetDevops;

import static org.junit.Assert.*;

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
	public void testDataframeVide() throws FileNotFoundException {
		Dataframe data = new Dataframe("data_sources/vide.csv");
	}

}