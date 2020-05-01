package ProjetDevops.ProjetDevops;

import static org.junit.Assert.*;

import org.junit.Test;

public class ColonneTest {

	Colonne col = new Colonne("prénom");
	Colonne col2 = new Colonne("a2e4", TypeData.UNDEF);
	
	@Test
	public void testGetString() {
		col.getName();
		col.getType();
		col.toString();
	}
	
	@Test
	public void testGetUndef() {
		col2.getName();
		col2.getType();
		col2.toString();
	}
}
