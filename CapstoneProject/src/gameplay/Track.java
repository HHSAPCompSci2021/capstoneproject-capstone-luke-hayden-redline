package gameplay;

/**
 * 
 * @author Luke Ma, Hayden Kaplanov
 * @version 1 Represents a racetrack
 */
public abstract class Track extends Shape {
	private int level;
	protected Line start;
	protected Line end;
	
	public Track(double x, double y) {
		super(x, y);
	}

	public int getLevel() {
		return level;
	}

	public Line getStart() {
		return start;
	}

	public Line getEnd() {
		return end;
	}
}
