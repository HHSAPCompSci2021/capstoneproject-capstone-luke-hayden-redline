package gameplay;
import processing.core.PApplet;

/** Creates and draws lines on a blank canvas
 * 
 * @author Luke Ma
 * @version Last edited 10/10/21
 */
public class Line extends Shape{
	private double x2;
	private double y2;
	
	/** Constructs a line from (x1, y1) to (x2, y2)
	 * 
	 * @param x1 The x-coordinate of the line's start point
	 * @param y1 The y-coordinate of the line's start point
	 * @param x2 The x-coordinate of the line's end point
	 * @param y2 The y-coordinate of the line's end point
	 */
	public Line(double x1, double y1, double x2, double y2) {
		super(x1,y1);
		this.x2=x2;
		this.y2=y2;	
	}
	
	/** Changes a line's end point so that the line has distance d and is angled at a degrees above the horizontal
	 * 
	 * @param x1 The x-coordinate of the line's start point
	 * @param y1 The y-coordinate of the line's start point
	 * @param l The length of the line
	 * @param a The angle of the line in degrees
	 * @param b Abstract parameter to differentiate constructors, does not serve any purpose
	 */
	public Line(double x1, double y1, double l, double a, double b) {
		super(x1,y1);
		this.x2 = x + l*Math.cos(a*Math.PI/180);
		this.y2 = y + l*Math.sin(a*Math.PI/180);
	}
	
	public Line(double x1, double y1, double length) {
		super(x1,y1);
		this.x2 = x + length;
		this.y2 = y;
	}
	
	/** Sets this line’s second point (x2, y2) to a new coordinate
	 * 
	 * @param x2 The x-coordinate of the line's new end point 
	 * @param y2 The y-coordinate of the line's new end point
	 */
	public void setPoint2(double x2, double y2) {
		this.x2=x2;
		this.y2=y2;
	}
	/** Draws a new line using the PApplet passed as an argument
	 * @pre PApplet library must be imported
	 * @param drawer An instance of the PApplet class
	 * 
	 */
	public void draw(PApplet drawer) {
		drawer.strokeWeight(getStrokeWeight());
		drawer.stroke(getStrokeColor().getRGB());
		drawer.line((float)getX(),(float)getY(),(float)x2,(float)y2);
	}
	/** Returns the x coordinate of the intersection point of this line and the other line (assuming they continue forever)
	 * 
	 * @param other Another line object
	 * @return The x-coordinate of the two lines' intersection point
	 */
	public double getIntersectionX(Line other) {
		double xiTop = (getX()*y2-getY()*x2)*(other.getX()-other.x2)-(getX()-x2)*(other.getX()*other.y2-other.getY()*other.x2);
		double xiBottom = (getX()-x2)*(other.getY()-other.y2)-(getY()-y2)*(other.getX()-other.x2);
		
		if (xiBottom == 0) {
			return Double.MAX_VALUE;
		}
		
		return xiTop/xiBottom;
	}
	/** Returns the y coordinate of the intersection point of this line and the other line (assuming they continue forever)
	 * 
	 * @param other Another line object
	 * @return The -coordinate of the two lines' intersection point
	 */
	public double getIntersectionY(Line other) {
		double yiTop = (getX()*y2-getY()*x2)*(other.getY()-other.y2)-(getY()-y2)*(other.getX()*other.y2-other.getY()*other.x2);
		double yiBottom = (getX()-x2)*(other.getY()-other.y2)-(getY()-y2)*(other.getX()-other.x2);
		
		if (yiBottom == 0) {
			return Double.MAX_VALUE;
		}
		return yiTop/yiBottom;
	}

	
	/** Returns true if this line segment and the segment other intersect each other. Returns false if they do not intersect.
	 * @param other Another line object
	 * @return True if this line segment and the segment other intersect each other. false if otherwise.
	 */
	public boolean intersects(Shape other) {
		Line l2 = (Line) other;
		double xiBottom = (getX()-x2)*(l2.getY()-l2.y2)-(getY()-y2)*(l2.getX()-l2.x2);
		double x1Temp = getX(), y1Temp = getY(), x2Temp = l2.getX(), y2Temp = l2.getY(), l2X1Temp = x2, l2Y1Temp = y2, l2X2Temp = l2.x2, l2Y2Temp = l2.y2;
		double xiBottomTemp = (x1Temp-x2Temp)*(l2Y1Temp-l2Y2Temp)-(y1Temp-y2Temp)*(l2X1Temp-l2X2Temp);
		
		x1Temp = getX(); y1Temp = getY(); x2Temp = l2.x2; y2Temp = l2.y2; l2X1Temp = l2.getX(); l2Y1Temp = l2.getY(); l2X2Temp = x2; l2Y2Temp = y2;
		double xiBottomTemp2 = (x1Temp-x2Temp)*(l2Y1Temp-l2Y2Temp)-(y1Temp-y2Temp)*(l2X1Temp-l2X2Temp);
		
		if (xiBottom == 0 && xiBottomTemp == 0 && xiBottomTemp2 == 0) {
			return true;
		}
		
		double xi = getIntersectionX(l2);
		double yi = getIntersectionY(l2);
		
		if(xi==Double.MAX_VALUE || yi==Double.MAX_VALUE) {
			return false;
		}
		
		if( (xi-getX())*(xi-x2) <= 0
				&& (xi-l2.getX())*(xi-l2.x2) <= 0
				&& (yi-getY())*(yi-y2) <= 0
				&& (yi-l2.getY())*(yi-l2.y2) <= 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/** Returns the value of x2
	 * 
	 * @return The value of x2
	 */
	public double getX2() {
		return x2;
	}
	
	/** Returns the value of y2
	 * 
	 * @return The value of y2
	 */
	public double getY2() {
		return y2;
	}
	
	/** Returns the area of the line (always 0)
	 * 
	 */
	public double getArea() {
		return 0;
	}

	/** Finds the length of the line
	 * 
	 */
	public double getPerimeter() {
		double length = Math.sqrt(Math.pow(x2-getX(), 2) + Math.pow(y2-getY(), 2));
		return length;
	}
	
	/** Detects whether or not a point (x,y) lies on the line the method is called on
	 * @param x The x-coordinate of the inputted point
	 * @param y The y-coordinate of the inputted point
	 * @return True if point (x,y) lies on the line, false if otherwise
	 */
	public boolean isPointOn(double x, double y) {
		double m = (y2-getY())/(x2-getX());
		double b = y2-m*getY();
		if (y == m*x+b) {
			return true;
		} else {
			return false;
		}
	}
}
