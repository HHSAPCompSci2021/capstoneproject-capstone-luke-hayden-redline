package gameplay;

import processing.core.PApplet;

/**
 * 
 * @author Luke Ma, Hayden Kaplanov
 * @version 1
 * Represents a racetrack
 */
public class Track {

	//draw tracks
	
	/*
	 * if (preset = levelNum){
	 * different instructions for different levels
	 * } ???
	 */
	
	public Track(int levelNum, PApplet marker) {
		switch(levelNum) {
		case(1):marker.circle(10, 20, 30);
		case(2):marker.circle(20, 40, 60);
		}
	}
	
	public void draw(PApplet marker) {
		marker.stroke(0);
		marker.curve(101, 11, 233, 133, 43, 134, 154, 143);
		draw(marker);
	}
}
