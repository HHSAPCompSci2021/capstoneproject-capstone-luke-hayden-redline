package gameplay;

import processing.core.PApplet;

public class ArcTrack extends Track {
	private double innerRadius;
	private double outerRadius;
	private double straightLength;

	public ArcTrack(double x, double y, double innerRadius, double outerRadius, double straightLength) {
		super(x, y);
		this.innerRadius = innerRadius;
		this.outerRadius = outerRadius;
		this.straightLength = straightLength;
	}

	@Override
	public void draw(PApplet drawer) {
		drawer.arc((float) x, (float) y, (float) outerRadius * 2, (float) outerRadius * 2, PApplet.HALF_PI,
				PApplet.PI + PApplet.HALF_PI);
		drawer.arc((float) x, (float) y, (float) innerRadius * 2, (float) innerRadius * 2, PApplet.HALF_PI,
				PApplet.PI + PApplet.HALF_PI);

		drawer.arc((float) (x + straightLength), (float) y, (float) outerRadius * 2, (float) outerRadius * 2,
				-PApplet.PI + PApplet.HALF_PI, PApplet.HALF_PI);
		drawer.arc((float) (x + straightLength), (float) y, (float) innerRadius * 2, (float) innerRadius * 2,
				-PApplet.PI + PApplet.HALF_PI, PApplet.HALF_PI);

		drawer.line((float) x, (float) (y - innerRadius), (float) (x + straightLength), (float) (y - innerRadius));
		drawer.line((float) x, (float) (y - outerRadius), (float) (x + straightLength), (float) (y - outerRadius));
		drawer.line((float) x, (float) (y + innerRadius), (float) (x + straightLength), (float) (y + innerRadius));
		drawer.line((float) x, (float) (y + outerRadius), (float) (x + straightLength), (float) (y + outerRadius));


		drawer.background(0, 97, 62);
		
		drawer.fill(75);
		drawer.arc((float)(x+straightLength), (float)y, (float)outerRadius*2, (float)outerRadius*2, -PApplet.PI+PApplet.HALF_PI, PApplet.HALF_PI);
		drawer.fill(0,97,62);
		drawer.arc((float)(x+straightLength), (float)y, (float)innerRadius*2, (float)innerRadius*2, -PApplet.PI+PApplet.HALF_PI, PApplet.HALF_PI);
		
		drawer.fill(75);
		drawer.arc((float)x, (float)y, (float)outerRadius*2, (float)outerRadius*2, PApplet.HALF_PI, PApplet.PI+PApplet.HALF_PI);
		drawer.fill(0,97,62);
		drawer.arc((float)x, (float)y, (float)innerRadius*2, (float)innerRadius*2, PApplet.HALF_PI, PApplet.PI+PApplet.HALF_PI);
		
		drawer.line((float)x, (float)(y-innerRadius), (float)(x+straightLength), (float)(y-innerRadius));
		drawer.line((float)x, (float)(y-outerRadius), (float)(x+straightLength), (float)(y-outerRadius));
		drawer.line((float)x, (float)(y+innerRadius), (float)(x+straightLength), (float)(y+innerRadius));
		drawer.line((float)x, (float)(y+outerRadius), (float)(x+straightLength), (float)(y+outerRadius));

		drawer.fill(75);
		drawer.noStroke();
		drawer.rect((float)x, (float)(y-innerRadius-1), (float)(straightLength), (float)(innerRadius-outerRadius+2));
		drawer.rect((float)x, (float)(y+innerRadius+1), (float)(straightLength), (float)(outerRadius-innerRadius-1));
		
		drawer.stroke(255);
		drawer.line((float)(x+straightLength/2), (float)(y+innerRadius), (float)(x+straightLength/2), (float)(y+outerRadius)); //start line
		drawer.line((float)(x+straightLength/2-1), (float)(y+innerRadius), (float)(x+straightLength/2-1), (float)(y+outerRadius)); //finish line
	}

	@Override
	public boolean isPointOn(double x, double y) { // test for corners
		if (x < this.x - straightLength / 2 - outerRadius)
			return false;
		else if (x > this.x + straightLength / 2 + outerRadius)
			return false;
		else if (x > this.x - straightLength / 2 && x < this.x + straightLength / 2) {
			if (y < this.y - outerRadius)
				return false;
			else if (y > this.y + outerRadius)
				return false;
			else if (y > this.y - innerRadius && y < this.y + innerRadius)
				return false;
		} else if (x < this.x - straightLength / 2 && x > this.x - straightLength / 2 - outerRadius) {
			double distSquare = (x - (this.x - straightLength / 2)) * (x - (this.x - straightLength / 2))
					+ (y - this.y) * (y - this.y);
			if (distSquare > outerRadius * outerRadius || distSquare < innerRadius * innerRadius)
				return false;
		} else if (x > this.x + straightLength / 2 && x < this.x + straightLength / 2 + outerRadius) {
			double distSquare = (x - (this.x + straightLength / 2)) * (x - (this.x + straightLength / 2))
					+ (y - this.y) * (y - this.y);
			if (distSquare > outerRadius * outerRadius || distSquare < innerRadius * innerRadius)
				return false;
		}

		return true;
	}

}
