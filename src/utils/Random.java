package utils;

public class Random {
	public static int generer(int bornInf, int bornSup) {
		return (int) (Math.random() * (bornSup - bornInf + 1) + bornInf);
	}

}
