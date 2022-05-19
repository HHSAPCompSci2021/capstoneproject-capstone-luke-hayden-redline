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
	private int speed; //finishLine is own class, tick lapCount by 1 each time car.intersects
	private Color color;
	
	private int pos; //will change frequently
	
	public Car(int s, Color c) {
		speed = s;
		//accel = a; too complex
		//pos = 
		color = c;
	}
	
	public void draw(PApplet drawer) {
		drawer.rect(100, 100, 25, 25);
	}
	
	public void accelerate() {
		//physicsshapedemo code maybe
	}
	
	
	public int getPos() {
		
		// if lapcount>some other car.lapcount x>some car OR y> some other car
		return pos;
	}

}
