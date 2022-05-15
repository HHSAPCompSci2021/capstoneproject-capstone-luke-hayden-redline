package gameplay;
import java.awt.Color;

import processing.core.PApplet;

/**
 * 
 * @author Luke Ma, Hayden Kaplanov
 * @version 1
 * Represents a car controlled by a player (maybe have faster default speeds?)
 */
public class Player extends Car{ //maybe use a slider to determine max speed vs accel, like what F-Zero has
	public Player(int ms, Color c, PApplet marker) {
		super(ms, c);
		//marker.rect();
	}
	//up is forward at some speed, left/right changes angle, sin/cos
	//reduce speed by 3/4 on collision with track
	
	public String getStats() {
		return "";
	}
}
