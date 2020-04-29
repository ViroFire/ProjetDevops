package ProjetDevops.ProjetDevops;

import java.util.ArrayList;

public class Line {

		private ArrayList<String> data;

		/**
		 * Permet d'ajouter une ligne avec l'ArrayList data.
		 * @param data (Création de la liste).
		 */
		public Line(ArrayList<String> data) {
			this.data=data;
		}
		
		/**
		 * Permet de récupèrer la ligne complete
		 * @return data (L'ArrayList de données de la ligne).
		 */
		public ArrayList<String> getData() {
			return data;
		}

		@Override
		public String toString() {
			return "Line [data=" + data + "]";
		}
		
		
}
