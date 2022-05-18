package gameplay;
import java.awt.Color;

import processing.core.PApplet;


// 1. draw 2 tracks
// 2. make car
// 3. spawn car on track w/stopping rules

/**
 * 
 * @author Luke Ma, Hayden Kaplanov
 * @version 1
 * Represents a car controlled by a player (maybe have faster default speeds?)
 */
public class Player extends Car{ //maybe use a slider to determine max speed vs accel, like what F-Zero has
	public Player(int ms, Color c) {
		super(ms, c);
	}
	//up is forward at some speed, left/right changes angle, sin/cos
	//stop on collision with track
	
	public String getStats() {
		return "";
	}
}
