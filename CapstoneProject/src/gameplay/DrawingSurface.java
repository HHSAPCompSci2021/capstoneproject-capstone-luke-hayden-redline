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
	public Track t;
	public PApplet drawer;
	public DrawingSurface() {
		//int n;
		//Scanner scan = new Scanner(System.in);
		//System.out.println("Which track?");
		//n = scan.nextInt();
		//scan.close();
		t = new Track(1,drawer);
	}
}
