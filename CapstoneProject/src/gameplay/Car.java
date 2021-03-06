package gameplay;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import processing.core.PApplet;

/**
 * 
 * @author Luke Ma, Hayden Kaplanov
 * @version 1 Represents a car in the game
 */

class Point {
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	double x;
	double y;
}

public class Car {
	// center of the rectangle
	private String name;
	private double x;
	private double y;

	private int w;
	private int h;
	private double angleDeg;
	private int maxSpeed; // finishLine is own class, tick lapCount by 1 each time car.intersects
	private int speed;
	private Color color;
	
	private int lapCount;

	public Car(String name, double x, double y, int w, int h, int initialSpeed, int maxSpeed, double angleDeg, Color color) {
		this.name = name;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.maxSpeed = maxSpeed;
		this.speed = initialSpeed;
		this.angleDeg = angleDeg;
		this.color = color;
		
		this.lapCount = 0;
	}
	
	/**
	 * Draws the car
	 * @param Drawer an instance of the PApplet class
	 */
	public void draw(PApplet drawer) {
		drawer.rectMode(PApplet.CENTER);
		drawer.pushMatrix();
		drawer.translate((float) x, (float) y);
		drawer.rotate(PApplet.radians((float) angleDeg));
		drawer.fill(color.getRGB());
		drawer.rect(0, 0, w, h);
		drawer.popMatrix();
		drawer.rectMode(PApplet.CORNER);
	}
	
	/**
	 * 
	 * @return the name of the car
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * @return the x-coordinate of the car
	 */
	public double getX() {
		return x;
	}
	
	/**
	 * 
	 * @return the y-coordinate of the car
	 */
	public double getY() {
		return y;
	}
	
	public double getAngle() {
		return angleDeg;
	}
	
	/**
	 * Moves the car
	 */
	public void move() {
		x += speed * Math.cos(PApplet.radians((float) angleDeg));
		y += speed * Math.sin(PApplet.radians((float) angleDeg));
	}
	
	/**
	 * Turns the car
	 */
	public void turn(double dAngle) {
		angleDeg += dAngle;
	}
	
	/**
	 * Changes the current speed of the car
	 */
	public void changeSpeed(int dSpeed) {
		int newSpeed = speed + dSpeed;
		if (newSpeed < 0 || newSpeed > maxSpeed)
			return;
		speed = newSpeed;
	}
	
	/**
	 * Stops the car
	 */
	public void stop() {
		speed = 0;
	}
	
	/**
	 * Indicates that the car has finished a lap and increases lapCount by 1
	 */
	public void finishLap() {
		lapCount++;
	}
	
	/**
	 * Gets lapCount
	 * @return What lap the car is currently on
	 */
	public int getLaps() {
		return lapCount;
	}
	
	/**
	 * Returns the coordinates of the car's corners 
	 * @return An ArrayList of Point objects containing the car's corners' coordinates
	 */
	public List<Point> getCorners() {
		List<Point> corners = new ArrayList<>();
		corners.add(new Point((int) (x - w / 2 * Math.cos(angleDeg) - h / 2 * Math.sin(angleDeg)),
				(int) (y + w / 2 * Math.sin(angleDeg) - h / 2 * Math.cos(angleDeg))));
		corners.add(new Point((int) (x + w / 2 * Math.cos(angleDeg) - h / 2 * Math.sin(angleDeg)),
				(int) (y - w / 2 * Math.sin(angleDeg) - h / 2 * Math.cos(angleDeg))));
		corners.add(new Point((int) (x - w / 2 * Math.cos(angleDeg) + h / 2 * Math.sin(angleDeg)),
				(int) (y + w / 2 * Math.sin(angleDeg) + h / 2 * Math.cos(angleDeg))));
		corners.add(new Point((int) (x + w / 2 * Math.cos(angleDeg) + h / 2 * Math.sin(angleDeg)),
				(int) (y - w / 2 * Math.sin(angleDeg) + h / 2 * Math.cos(angleDeg))));
		return corners;

	}
	
	/**
	 * Checks if the car is inside the current track
	 * @param t The current track being raced on
	 * @return True if car is inside track, false otherwise
	 */
	public boolean insideTrack(Track t) { // will be run 4 times, once for each corner
		/*
		 * List<Point> corners = getCorners(); for(Point p : corners) {
		 * if(t.isPointOn(p.x, p.y)) { return true; } } return false;
		 */

		return t.isPointOn(x, y);
	}
	
	/**
	 * Checks if the car can currently move
	 * @param t The current track being raced on
	 * @return True if the car can move, false otherwise
	 */
	public boolean canMove(Track t) {
		double nextX = x + speed * Math.cos(PApplet.radians((float) angleDeg));
		double nextY = y + speed * Math.sin(PApplet.radians((float) angleDeg));

		return t.isPointOn(nextX, nextY);
	}
}
