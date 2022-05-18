package gameplay;

import java.util.Scanner;

import processing.core.PApplet;

/**
 * 
 * @author Luke Ma, Hayden Kaplanov
 * @version 1
 * Displays a dynamic background behind tracks and cars during gameplay by cycling through images
 *
 */
public class DrawingSurface extends PApplet{
	public PApplet drawer;
	private Track track;
	private Player car;
		//int n;
		//Scanner scan = new Scanner(System.in);
		//System.out.println("Which track?");
		//n = scan.nextInt();
		//scan.close();
		public DrawingSurface() {
			int level = 2;
			if(level == 1)
				track = new Track(500, 500, 100, 200, 100);
			else if(level == 2)
				track = new Track(500, 500, 150, 300, 300);
		}
		
		
		public void setup() {
			
		}
		
		
		public void draw() {
			background(255);
			stroke(0);
			track.draw(this);
			car.draw(this);
		}
		
		public void keyPressed() {
			if (keyCode == LEFT) {
			}
	}
}
