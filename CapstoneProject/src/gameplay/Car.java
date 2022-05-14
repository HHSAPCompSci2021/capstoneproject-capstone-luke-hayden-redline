package gameplay;
import java.awt.Color;

/**
 * 
 * @author Luke Ma, Hayden Kaplanov
 * @version 1
 * Represents a car in the game
 */
public class Car {
	private int maxSpeed;
	private int accel;
	private Color color;
	
	private int pos; //will change frequently
	
	public Car(int ms, int a, Color c) {
		maxSpeed = ms;
		accel = a;
		//pos = 
		color = c;
	}
	
	public int getPos() {
		return pos;
	}

}
