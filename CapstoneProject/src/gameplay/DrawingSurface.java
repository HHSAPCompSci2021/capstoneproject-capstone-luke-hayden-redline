package gameplay;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import processing.core.PApplet;

/**
 * 
 * @author Luke Ma, Hayden Kaplanov
 * @version 5
 * Draws current track and all cars
 *
 */
public class DrawingSurface extends PApplet {
	public PApplet drawer;
	private Track track;
	private Car playerCar;
	private List<Car> robotCars;
	private Random rand;
	private int maxLaps = 3;
	private Statistics stats;

	public DrawingSurface() throws IOException {
		stats = new Statistics("projectinfo.txt");
		int level = Statistics.updateStatistics(false, -1);
		if (level == 1)
			track = new StraightTrack(500, 500, 800, 300);
		else if (level == 2)
			track = new ArcTrack(500, 500, 150, 300, 300);

		int carWidth = 40;
		int carHeight = 24;
		playerCar = new Car("Player", track.getStart().getX()-carWidth,
				track.getStart().getY()+carHeight,
				carWidth, carHeight, 0, 4, 0, Color.RED);

		rand = new Random(System.currentTimeMillis());

		String[] robotNames = new String[] {"Blue Falcon", "Black Bull", "White Cat", "Wild Goose"};
		Color[] robotColors = new Color[] {Color.BLUE, Color.BLACK, Color.WHITE, Color.GREEN};
		robotCars = new ArrayList<>();
		for(int i=0; i<robotNames.length; i++) {
			robotCars.add(new Car(robotNames[i], track.getStart().getX()-carWidth/2-75-50*i,
					track.getStart().getY()+ 24 + (i+1)*24,
					carWidth, carHeight, rand.nextInt(5)+1, rand.nextInt(20)+1,0 /*rand.nextInt(11)-5*/, robotColors[i]));
		}
	}

	public void setup() {

	}

	public void draw() {
		background(255);
		stroke(0);
		track.draw(this);

		stroke(0);
		double oldPlayerX = playerCar.getX();
		double oldPlayerY = playerCar.getY();
		if(playerCar.canMove(track))
			playerCar.move();
		
		if(hasCrossedFinishLine(playerCar, oldPlayerX, oldPlayerY)) {
			playerCar.finishLap();
		}
		
		playerCar.draw(this);
		if(playerCar.getLaps() >= maxLaps+1) {
			declareWin(playerCar);
		}

		for(Car robotCar : robotCars) {
			double oldRobotX = robotCar.getX();
			double oldRobotY = robotCar.getY();
			if(robotCar.canMove(track))
				robotCar.move();
			else
				 robotCar.turn(rand.nextInt(22)-20);
			
			if(hasCrossedFinishLine(robotCar, oldRobotX, oldRobotY)) {
				robotCar.finishLap();
			}

			robotCar.draw(this);
			if(robotCar.getLaps() >= maxLaps+1) {
				declareWin(robotCar);
			}
		}
		
		dispLap();
	}
	
	/**
	 * Runs once a car has won a race
	 * @param car The winning car
	 */
	public void declareWin(Car car) {
		fill(255);
		textSize(50);
	    text(car.getName() + " wins", 500, 100);
	    playerCar.stop();
	    for(Car robotCar : robotCars) {
	    	robotCar.stop();
	    }
	}
	
	/**
	 * Displays what lap each car is on
	 */
	public void dispLap() {
		fill(255);
		textSize(40);
		int laps = playerCar.getLaps() > maxLaps ? maxLaps : playerCar.getLaps();
		text("Lap " + laps +"/"+maxLaps, 40, 100);
		
		int yPos = 100 + 40;
		for(Car robotCar : robotCars) {
			laps = robotCar.getLaps() > maxLaps ? maxLaps : robotCar.getLaps();
			textSize(20);
			text(robotCar.getName() + " Lap " + laps +"/"+maxLaps, 40, yPos);
			yPos += 40;
		}
	}
	
	/**
	 * Dictates keyboard controls
	 */
	public void keyPressed() {
		if (keyCode == LEFT) {
			playerCar.turn(-20);
		} else if (keyCode == RIGHT) {
			playerCar.turn(20);
		} else if (keyCode == UP) {
			playerCar.changeSpeed(1);
		} else if (keyCode == DOWN) {
			playerCar.changeSpeed(-1);
		}
	}
	
	/**
	 * Checks if the car has crossed the finish line
	 * @param car The car being checked
	 * @param oldX The car's x-coordinate before moving
	 * @param oldY The car's y-coordinate before moving
	 * @return
	 */
	private boolean hasCrossedFinishLine(Car car, double oldX, double oldY) {		
		Line lastMove = new Line(oldX, oldY, car.getX(), car.getY());
		//check for intersection w/fin line
		if(lastMove.getX()!=track.getEnd().getX() &&
				lastMove.intersects(track.getEnd()) &&
				(car.getAngle()%360<90&&car.getAngle()%360>-90)) {
			return true;
		}

		return false;
	}
}
