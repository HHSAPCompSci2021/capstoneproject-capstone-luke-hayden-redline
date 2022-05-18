package gameplay;
import processing.core.PApplet;
import java.awt.Color;

/**
 * Shape superclass for all specific shapes objects
 * @author Luke Ma
 * @version Last modified 10/10/21
 */
public abstract class Shape {
	//fields
	public double x;
	public double y;
	public Color fillColor = new Color(255,255,255,255);
	public Color strokeColor = new Color(0, 0, 0);
	public float strokeWeight = 4;
	
	/** Creates a new Shape object around a point (x,y) which represents different things depending on the specific shape being created.
	 * 
	 * @param x The x-coordinate of point (x,y)
	 * @param y The x-coordinate of point (x,y)
	 */
	public Shape(double x, double y) {
		this.x=x;
		this.y=y;
	}
	
	//methods
	/** Abstract method to be implemented in subclasses, draws a new Shape object
	 * @param drawer An instance of the PApplet class
	 */
	public abstract void draw(PApplet drawer);
	
	/** Abstract method to be implemented in subclasses, finds the area of various shapes
	 * 
	 * @return The area of whatever shape the method is being called on
	 */
//	public abstract	double getArea();
	
	/** Abstract method to be implemented in subclasses, finds the perimeter of various shapes
	 *
	 * @return The perimeter of whatever shape the method is being called on
	 */
//	public abstract double getPerimeter();
	
	/** Abstract method to be implemented in subclasses, detects whether or not point (x,y) lies on a shape
	 * @param x The x-coordinate of the point being tested
	 * @param y The y-coordinate of the point being tested
	 * @return True if point is on shape, false otherwise
	 */
	public abstract boolean isPointOn(double x, double y);
	
	public String toString() {
		return "";
	}
	
	/** Abstract method to be implemented in subclasses, detects where shapes are intersecting one another
	 * @param other An instance of the Shape class
	 * @return True if shapes intersect, false otherwise
	 */
	
//	public abstract boolean intersects(Shape other);
	
	/** Moves the shape x units to the right and y units down
	 * 
	 * @param x Amount of units the shape is moved to the right 
	 * @param y Amount of units the shape is moved down
	 */
	public void move(double x, double y) {
		this.x += x;
		this.y += y;
	}
	
	/** Teleports the shape to (x,y)
	 * 
	 * @param x The new x-coordinate of the shape
	 * @param y The new y-coordinate of the shape
	 */
	public void teleport(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	/** Sets a new value for x
	 * 
	 * @param x The new value for x
	 */
	public void setX(double x) {
		this.x = x;
	}
	
	/** Sets a new value for y
	 * 
	 * @param y The new value for y
	 */
	public void setY(double y) {
		this.y = y;
	}
	
	/** Gets the value of x
	 * 
	 * @return The value of x
	 */
	public double getX() {
		return x;
	}
	
	/**Gets the value of y
	 * 
	 * @return The value of y
	 */
	public double getY() {
		return y;
	}
	
	/** Sets a new fill color for shapes
	 * 
	 * @param fillColor An instance of the Color class, use new Color(R,G,B)
	 */
	public void setFillColor(Color fillColor) {
		this.fillColor = fillColor;
	}
	
	/** Sets a new stroke color for shapes
	 * 
	 * @param strokeColor An instance of the Color class, use new Color(R,G,B)
	 */
	public void setStrokeColor(Color strokeColor) {
		this.strokeColor = strokeColor;
	}
	
	/** Sets the stroke weight
	 * 
	 * @param w The stroke weight, set to 4 by default
	 */
	public void setStrokeWeight(float w) {
		this.strokeWeight = w;
	}
	
	/** Gets a shape's stroke weight
	 * 
	 * @return The stroke weight
	 */
	public float getStrokeWeight() {
		return this.strokeWeight;
	}

	/** Gets a shape's current stroke color
	 * 
	 * @return The stroke color
	 */
	public Color getStrokeColor() {
		return strokeColor;
	}

	/** Gets a shape's current fill color
	 * 
	 * @return The fill color
	 */
	public Color getFillColor() {
		return fillColor;
	}
}
