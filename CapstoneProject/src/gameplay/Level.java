package gameplay;

import java.util.ArrayList;

/**
 * 
 * @author Luke Ma, Hayden Kaplanov
 * @version 1
 * Represents a level of the game
 */
public class Level {
	private int lapCount;
	public ArrayList <Car> cars; //properties of all cars present
	public Level(int levelNum, int lapCount, int carNum) { //levelNum could be an index of a 2D array that has tracknum, carnums, etc, will need to get rid of lap and car nums if so
		
	}
	
	public int getLaps() {
		return lapCount;
	}
}
