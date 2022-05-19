package gameplay;

import processing.core.PApplet;

public class StraightTrack extends Track {
	private double width;
	private double height;

	public StraightTrack(double x, double y, double width, double height) {
		super(x, y);
		this.width = width;
		this.height = height;
	}

	@Override
	public void draw(PApplet drawer) {
		drawer.background(0,97,63);
		drawer.fill(75);
		drawer.rect((float)(x-width/2), (float)(y-height/2), (float)width, (float)height);

	}

	@Override
	public boolean isPointOn(double x, double y) {
		// TODO Auto-generated method stub
		return false;
	}

}
