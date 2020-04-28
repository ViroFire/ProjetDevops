package ProjetDevops.ProjetDevops;

public class Column {
	
	private String name;
	private DataType type;
	
	/**
	 * Constructeur de colonne. Le nom est passé en paramètre et le
	 * type est UNDEFINED.
	 * @param name (nom de la nouvelle colonne)
	 */
	public Column(String name) {
		this.name = name;
		this.type = DataType.UNDEFINED;
	}
	
	/**
	 * Constructeur de colonne. Le nom et le type sont passé en
	 * paramètre.
	 * @param name (nom de la nouvelle colonne)
	 * @param type (type de la nouvelle colonne)
	 */
	public Column(String name, DataType type) {
		this.name = name;
		this.type = type;
	}
	
	/**
	 * Renvoie le nom de la colonne.
	 * @return name (Nom de la colonne).
	 */
	public String getName() {
		return name;
	}

	/**
	 * Renvoie le type de la colonne.
	 * @return type (Type de la colonne).
	 */
	public DataType getType() {
		return type;
	}

	@Override
	public String toString() {
		return "Column [name=" + name + "]";
	}
	
}
