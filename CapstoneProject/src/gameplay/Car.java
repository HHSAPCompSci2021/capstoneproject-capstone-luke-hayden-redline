package gameplay;
import java.awt.Color;

import processing.core.PApplet;

/**
 * 
 * @author Luke Ma, Hayden Kaplanov
 * @version 1
 * Represents a car in the game
 */
public class Car {
	private int speed;
	private Color color;
	
	private int pos; //will change frequently
	
	public Car(int s, Color c) {
		speed = s;
		//accel = a; too complex
		//pos = 
		color = c;
	}
	
	public void draw(PApplet drawer) {

	}
	
	public void accelerate() {
		//physicsshapedemo code maybe
	}
	
	
	public int getPos() {
		return pos;
	}

}
