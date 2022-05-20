package gameplay;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import processing.core.PApplet;

/**
 * 
 * @author Luke Ma, Hayden Kaplanov
 * @version 1
 * Represents a car in the game
 */

class Point {
	double x;
	double y;
}

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
		drawer.fill(color.getRGB());
		drawer.rect(100, 100, 40, 25);
	}
	
	public void accelerate() {
		//physicsshapedemo code maybe
	}
	
	
	public int getPos() {
		
		// if lapcount>some other car.lapcount x>some car OR y> some other car
		return pos;
	}
	
	// option 1
	// { {x1, y1}, {x2, y2}, {x3, y3}, {x4, y4} }
	/*public int[][] getCorners() {
		
	}*/
	
	// option 2
	public List<Point> getCorners() {
		return new ArrayList<>();
	}
	
	public boolean intersectsT(Track t) { //will be run 4 times, once for each corner
		List<Point> corners = getCorners();
		for(Point p : corners) {
			if(t.isPointOn(p.x, p.y))
				return true;
		}
		
		return false;
	}
	
	public boolean intersects(Car other) {
		return false;
	}

}
