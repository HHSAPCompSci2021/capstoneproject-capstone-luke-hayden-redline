package gameplay;
import java.awt.Dimension;
import javax.swing.JFrame;

import processing.awt.PSurfaceAWT;
import processing.core.PApplet;
import java.util.Scanner;
public class Main {
	private static int w;
	private static int h;
	//private static Scanner scan;
	public static void main(String[] args) {
		/*scan = new Scanner(System.in);
		System.out.println("How wide should the window be?");
		w = scan.nextInt();
		System.out.println("How tall should the window be?");
		h = scan.nextInt();
		Statistics stats = new Statistics();
		PApplet.runSketch(new String[]{""}, stats);
		PSurfaceAWT surf = (PSurfaceAWT) stats.getSurface();
		PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
		JFrame window = (JFrame)canvas.getFrame();
		window.setSize(w, h);
		window.setMinimumSize(new Dimension(100,100));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);
		window.setVisible(true);
		canvas.requestFocus();*/
		DrawingSurface drawing = new DrawingSurface();
		PApplet.runSketch(new String[]{""}, drawing);
		PSurfaceAWT surf = (PSurfaceAWT) drawing.getSurface();
		PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
		JFrame window = (JFrame)canvas.getFrame();
/*
		Scanner scan = new Scanner(System.in);
		System.out.println("How wide should the window be?");
		w = scan.nextInt();
		System.out.println("How tall should the window be?");
		h = scan.nextInt();
		scan.close();
	*/	
		window.setSize(1500,900);
		window.setLocation(100, 100);
		window.setMinimumSize(new Dimension(100,100));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);

		window.setVisible(true);
	}
}