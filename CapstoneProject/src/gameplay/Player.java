package gameplay;
import java.awt.Color;

/**
 * 
 * @author Luke Ma, Hayden Kaplanov
 * @version 1
 * Represents a car controlled by a player (maybe have faster default speeds?)
 */
public class Player extends Car{ //maybe use a slider to determine max speed vs accel, like what F-Zero has
	public Player(int ms, int a, Color c) {
		super(ms, a, c);
	}
	public String getStats() {
		return "";
	}
}
