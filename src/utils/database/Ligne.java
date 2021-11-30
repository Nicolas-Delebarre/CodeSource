package utils.database;

import java.util.ArrayList;
import java.util.List;

public class Ligne {

	private List<String> valeurs;

	public Ligne(List<String> valeurs) {
		this();
		this.valeurs = valeurs;
	}

	public Ligne() {
		valeurs = new ArrayList<String>();
	}

	/**
	 * Permet de récupérer l'enregistrement contenu à l'index indiqué. L'index
	 * correspond au numéro de la colonne à récupérer l'élément. Le premier
	 * index est 0.
	 *
	 * @param index
	 *            L'index de la colonnne correspondant à l'enregistrement à
	 *            récupérer.
	 * @return Retourne la valeur de l'enregistrement.
	 */
	public String getValeur(int index) {
		return valeurs.get(index);
	}

	/**
	 * Permet de récupérer toutes les valeurs contenues dans la ligne sous forme
	 * de liste.
	 *
	 * @return Retourne toutes les valeurs contenues dans la ligne.
	 */
	public List<String> getValeurs() {
		return valeurs;
	}

	/**
	 * Permet de connaître le nombre de valeurs dans la ligne.
	 *
	 * @return Retourne le nombre de valeurs contenus dans la ligne.
	 */
	public int getNombreValeurs() {
		return valeurs.size();
	}

	/**
	 * Permet d'ajouter une nouvelle valeur à la ligne, à la suite des autres.
	 *
	 * @param valeur
	 *            Nouvelle valeur à ajouter à la ligne.
	 */
	public void addValeur(String valeur) {
		valeurs.add(valeur);
	}

	/**
	 * Permet d'afficher la ligne dans la console, pour débuguer.
	 *
	 * @param tailleColonne
	 *            Taille de la colonne, en nombre de caractère.
	 */
	public void afficher(int tailleColonne) {

		System.out.print(" ");
		for (int i = 0; i < tailleColonne * getNombreValeurs() + 3; i++) {
			System.out.print("-");
		}
		System.out.println();

		for (String valeur : getValeurs()) {

			int longueur = valeur.length();

			System.out.print("| " + valeur);
			for (int i = 0; i < tailleColonne - longueur; i++) {
				System.out.print(" ");
			}
		}
		System.out.println("|");

	}

}
