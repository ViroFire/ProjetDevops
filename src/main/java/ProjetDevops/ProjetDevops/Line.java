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
		 * Permet d'ajouter une ligne avec un tableau de String
		 * @param data (Tableau de string).
		 */
		public Line(String[] data) {
			this.data = new ArrayList<String>();
			for(int i = 0;i<data.length;i++) {
				this.data.add(String.copyValueOf(data[i].toCharArray()));
			}
			for(int i=0;i<this.data.size();i++) {
				System.out.println(this.data.get(i));
			}
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
