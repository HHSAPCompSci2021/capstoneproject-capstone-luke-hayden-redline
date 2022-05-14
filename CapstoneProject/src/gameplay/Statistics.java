package gameplay;
import java.io.*;

import processing.core.PApplet;

public class Statistics extends PApplet {
	private static int score = 0;
	private static int highScore;
	private static File infoFile;
	public Statistics() {
		
	}
	public static void changeHighScore() throws FileNotFoundException {
		infoFile = new File("Users/");
	}
}