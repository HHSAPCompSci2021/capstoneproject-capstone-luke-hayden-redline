// package declarations & imports
package gameplay;
import java.awt.Dimension;
import java.io.IOException;
import javax.swing.JFrame;
import processing.awt.PSurfaceAWT;
import processing.core.PApplet;
import java.util.Scanner;

public class Main {
	// creates the width and height fields
	private static int w;
	private static int h;
	
	// sets up the scanner
	private static Scanner scan;
	
	// main method
	public static void main(String[] args) throws IOException {
		// asks for window dimensions and gets them
		scan = new Scanner(System.in);
		System.out.println("How wide should the window be?");
		w = scan.nextInt();
		System.out.println("How tall should the window be?");
		h = scan.nextInt();
		
		// sets up the window
		DrawingSurface drawing = new DrawingSurface();
		PApplet.runSketch(new String[]{""}, drawing);
		PSurfaceAWT surf = (PSurfaceAWT) drawing.getSurface();
		PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
		JFrame window = (JFrame)canvas.getFrame();
		
		// sizes the window and finishes setting it up
		window.setSize(w, h);
		window.setLocation(100, 100);
		window.setMinimumSize(new Dimension(100,100));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);
		window.setVisible(true);
	}
}