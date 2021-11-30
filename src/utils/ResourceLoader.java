package utils;

import application.main.Main;
import javafx.scene.image.Image;
import javafx.scene.text.Font;

public class ResourceLoader {

	private static Main main;

	public void setMain(Main main) {
		this.main = main;
	}

	public static Image loadImg(String nom, int w, int h) {

		Image im = new Image(main.getClass().getResourceAsStream("/ressources/images/" + nom), w, h, true, true);
		return im;
	}

	public static Image loadImg(String nom) {

		Image im = new Image(main.getClass().getResourceAsStream("/ressources/images/" + nom));
		return im;
	}

	public static String loadCss(String nom) {
		return main.getClass().getResource("/ressources/css/" + nom).toString();
	}

	public static Font loadFont(String police, int taille) {
		return Font.loadFont(main.getClass().getResourceAsStream("/ressources/polices/" + police), taille);

	}

}
