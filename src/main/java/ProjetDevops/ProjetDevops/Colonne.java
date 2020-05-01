package ProjetDevops.ProjetDevops;

public class Colonne {
	
	private String nom;
	private TypeData type;

	
	/**
	 * Constructeur de colonne
	 * Le nom est passé en paramètre et le type est UNDEF
	 * @param nom (nom de la nouvelle colonne)
	 */
	public Colonne(String nom) {
		this.nom = nom;
		this.type = TypeData.UNDEF;
	}
	
	/**
	 * Constructeur de colonne 
	 * Le nom et le type sont passés en paramètre
	 * @param nom (nom de la nouvelle colonne)
	 * @param type (type de la nouvelle colonne)
	 */
	public Colonne(String nom, TypeData type) {
		this.nom = nom;
		this.type = type;
	}
	
	/**
	 * Type la colonne
	 * @param type
	 */
	public void setType(TypeData type) {
		this.type = type;
	}
	
	/**
	 * Renvoie le nom de la colonne
	 * @return nom (nom de la colonne)
	 */
	public String getName() {
		return nom;
	}

	/**
	 * Renvoie le type de la colonne
	 * @return type (type de la colonne)
	 */
	public TypeData getType() {
		return type;
	}

	@Override
	public String toString() {
		return "Colonne [nom=" + nom + "type=" + type +"]" ;
	}
	
}
