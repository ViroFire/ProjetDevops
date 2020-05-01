package ProjetDevops.ProjetDevops;

import java.util.ArrayList;

public class Ligne {

		private ArrayList<String> data;

		/**
		 * Ajoute une ligne avec l'ArrayList data
		 * @param data (création de la liste)
		 */
		public Ligne(ArrayList<String> data) {
			this.data = data;
		}
		
		/**
		 * Ajoute une ligne avec un tableau de String
		 * @param data (tableau de String)
		 */
		public Ligne(String[] data) {
			this.data = new ArrayList<String>();
			
			for(int i = 0; i < data.length; i++) {
				this.data.add(String.copyValueOf(data[i].toCharArray()));
			}
		}
		
		/**
		 * Récupère la ligne complète
		 * @return data (ArrayList de données de la ligne)
		 */
		public ArrayList<String> getData() {
			return data;
		}

		@Override
		public String toString() {
			return "Ligne [data = " + data + "]";
		}
		
		
}
