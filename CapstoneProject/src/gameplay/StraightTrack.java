package gameplay;

import processing.core.PApplet;

/**
 * 
 * @author Luke Ma, Hayden Kaplanov
 * @version 3
 * Draws and simulates behavior of an straight track, like a drag strip
 */
public class StraightTrack extends Track {
	private double width;
	private double height;

	public StraightTrack(double x, double y, double width, double height) {
		super(x, y);
		this.width = width;
		this.height = height;
	}

	@Override
	/**
	 * Draws the track
	 * @param drawer An instance of the PApplet class
	 */
	public void draw(PApplet drawer) {
		drawer.background(0,97,63);
		drawer.fill(75);
		drawer.rect((float)(x-width/2), (float)(y-height/2), (float)width, (float)height);

	}

	@Override
	/**
	 * Checks if a point is on a track
	 * @param x x-coordinate of point
	 * @param y y-coordinate of point
	 */
	public boolean isPointOn(double x, double y) {
		// TODO Auto-generated method stub
		return false;
	}

}
