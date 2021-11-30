package utils;

public class Convert {

	public static String codeToString(String code) {

		// Nombres
		if (code.contains("NUMPAD") || code.contains("DIGIT")) {
			return Character.toString(code.charAt(code.length() - 1));
		}
		// Fonctions (F1, F2 ...)
		else if (code.startsWith("F") && code.length() == 2) {
			return code;
		}
		// Lettres
		else if (code.length() == 1) {
			return code;
		} else {
			switch (code) {
			case "ESCAPE":
				return code;
			case "BACK_SPACE":
				return "Retour arri�re";
			case "ENTER":
				return "Entr�e";
			case "TAB":
				return "Tabulation";
			case "CAPS":
				return "Verr. Maj.";
			case "SHIFT":
				return "Maj.";
			case "CONTROL":
				return "Ctrl.";
			case "ALT":
				return "Alt.";
			case "WINDOWS":
				return "Windows";
			case "SPACE":
				return "Espace";
			case "CONTEXT_MENU":
				return "Menu contexte";
			case "UP":
				return "Fl�che haut";
			case "DOWN":
				return "Fl�che bas";
			case "LEFT":
				return "Fl�che gauche";
			case "RIGHT":
				return "Fl�che droite";
			case "INSERT":
				return "Insertion";
			case "DELETE":
				return "Suppr.";
			case "HOME":
				return "Maison";
			case "END":
				return "Fin";
			case "PAGE_UP":
				return "Page haut";
			case "PAGE_DOWN":
				return "Page bas";
			case "NUM_LOCK":
				return "Verr. Num.";
			case "DIVIDE":
				return "/";
			case "MULTIPLY":
				return "*";
			case "SUBSTRACT":
				return "-";
			case "ADD":
				return "+";
			case "PRINTSCREEN":
				return "Impr. �cran";
			case "SCROLL_LOCK":
				return "Arr�t d�fil.";
			case "PAUSE":
				return "Pause";
			default:
				return null;
			}
		}
	}

	public static String buttonToString(String code) {

		switch (code) {
		case "PRIMARY":
			return "Clic gauche";
		case "SECONDARY":
			return "Clic droit";
		case "MIDDLE":
			return "Clic molette";
		case "SCROLL_UP":
			return "Molette vers le haut";
		case "SCROLL_DOWN":
			return "Molette vers le bas";
		default:
			return null;
		}
	}
}
