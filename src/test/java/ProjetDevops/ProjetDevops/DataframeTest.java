package ProjetDevops.ProjetDevops;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataframeTest {

    @Test
    public void testFile() throws FileNotFoundException {
    	Dataframe df = new Dataframe("./data_sources/vide.csv");
    	Dataframe df2 = new Dataframe("./data_sources/rempli.csv");
    }

    @Test
    public void testDoublonFile() throws FileNotFoundException {
    	Dataframe df = new Dataframe("./data_sources/vide.csv");
    	Dataframe df2 = new Dataframe("./data_sources/rempli.csv");
    	assertFalse("fichiers identiques", df.equals(df2));
    	Dataframe df3 = new Dataframe("./data_sources/rempli.csv");
    	assertFalse("fichiers identiques", df3.equals(df2));
    }

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

}
