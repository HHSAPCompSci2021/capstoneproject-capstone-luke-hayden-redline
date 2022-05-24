// package declaration & imports
package gameplay;
import java.io.*;
import processing.core.PApplet;
import java.util.Scanner;

public class Statistics extends PApplet {
	// sets up the variable fields
	private static int score = 0;
	private static int highScore = 0;
	public static int level = 0;
	
	// sets up the file access for the file i/o
	private static File infoFile;		
	private static Scanner scan;
	private static String path;
	private static FileWriter write;
	
	// instantiates the file and its path
	public Statistics(String path) {
		Statistics.path = path;
		infoFile = new File(path);
	}
	
	// This is the access method for this class - it updates the high score if necessary
	// It returns either the high score or the level
	// If answer is true, it will return the high score, while a parameter of "false" returns the level
	public static int updateStatistics(boolean answer, int level) throws IOException {
		int result;
		int returnLevel = 0;
		// first, if there is a new high score, the high score is updated
		if (score > highScore) {
			highScore = score;
		}
		
		// then the high score and the level stored in the file is accessed through file i/o
		int returnedScore = 0;
		try {
		      scan = new Scanner(infoFile);
		      returnedScore = scan.nextInt();
		      returnLevel = scan.nextInt();
		      scan.close();
		} catch (FileNotFoundException e) { // exception handling
		    e.printStackTrace();
		}
		
		if (highScore > returnedScore) { // checks if there is a new high score not stored in the file
			try {
				// this updates the high score and writes to the file
				write = new FileWriter(path);
				write.write(highScore + "\n");
				// updates the level
				if (level >= 0) {
					write.write(level);
					returnLevel = level;
				}
			} catch (FileNotFoundException e) { // exception handling
			    e.printStackTrace();
			}
		}
		
		// if the high score stored in the file is larger than that in the program, the program's high score is updated
		else {
			highScore = returnedScore;
		}
		
		// takes the answer parameter to decide what variable to return
		result = returnLevel;
		if (answer == true) {
			result = highScore;
		}
		return result;
	}
	
	// this is a simple getter method for the normal score
	public static int getScore() {
		return score;
	}
	
	// this is both a setter and a getter, as it increments the score by one and then returns it
	public static int incrementScore() {
		score++;
		return score;
	}
}