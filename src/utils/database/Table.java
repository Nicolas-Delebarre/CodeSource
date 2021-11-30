package utils.database;

import java.util.ArrayList;
import java.util.List;

public class Table {

	private List<Ligne> lignes;

	public Table(List<Ligne> lignes) {
		this();
		this.lignes = lignes;
	}

	public Table() {
		lignes = new ArrayList<Ligne>();
	}

	/**
	 * R�cup�re la ligne correspondant � l'index sous forme de liste. Le premier
	 * index est 0.
	 *
	 * @param index
	 *            Index de la ligne � r�cup�rer. Est compris entre 0 et le
	 *            nombre de lignes - 1.
	 * @return Retourne la ligne indiqu�e.
	 */
	public Ligne getLigne(int index) {
		return lignes.get(index);
	}

	/**
	 * R�cup�re la colonne correspondant � l'index sous forme de liste. Le
	 * premier index est 0.
	 *
	 * @param index
	 *            Index de la colonne � r�cup�rer. Est compris entre 0 et le
	 *            nombre de colonne - 1.
	 * @return Retourne la colonne indiqu�e.
	 */
	public List<String> getColonne(int index) {
		List<String> colonnes = new ArrayList<String>();

		for (Ligne ligne : lignes) {
			colonnes.add(ligne.getValeur(index));
		}

		return colonnes;

	}

	/**
	 * Recup�re toutes les lignes contenues dans la table sous forme de liste.
	 *
	 * @return Retourne une liste contenant toutes les lignes de la table.
	 */
	public List<Ligne> getLignes() {
		return lignes;
	}

	/**
	 * Ajoute une ligne � la table, � la suite des autres.
	 *
	 * @param ligne
	 *            Ligne � ajouter � la table.
	 */
	public void addLigne(Ligne ligne) {
		lignes.add(ligne);
	}

	/**
	 * Permet de conna�tre le nombre de lignes de la table.
	 *
	 * @return Retourne le nombre de lignes contenues dans la table.
	 */
	public int getNombreLigne() {
		return lignes.size();
	}

	/**
	 * Permet de savoir si la table est vide.
	 *
	 * @return Retourne <b>true</b> si la table contient au moins une ligne ou
	 *         <b>false</b> si elle n'en contient aucune.
	 */
	public boolean isVide() {
		return lignes.isEmpty();
	}

	/**
	 * Permet d'afficher la table en console pour d�buguer.
	 *
	 * @param tailleColonne
	 *            Taille de la colonne, en nombre de caract�re.
	 */
	public void afficher(int tailleColonne) {

		if (getLigne(0).getNombreValeurs() <= 0) {
			System.out.println("Aucune valeur dans la table.");
		} else {
			for (Ligne ligne : getLignes()) {
				ligne.afficher(tailleColonne);
			}
			System.out.print(" ");
			for (int i = 0; i < tailleColonne * getLigne(0).getNombreValeurs() + 3; i++) {
				System.out.print("-");
			}
			System.out.println();
		}

	}

}
