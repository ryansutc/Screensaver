import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;

import javax.swing.JPanel;


public class Star extends Shape {
	Graphics2D g2;
	
	//static generic coords
	private int rotate = 1;
	private static final int xPoints[] = {55,67,109,73,83,55,27,37,1,43}; 
	private static final int yPoints[] = {0,36,36,54,96,72,96,54,36,36};

	
	//this constructor is never used
	public Star(int x, int y, int width, int height, int dx, int dy) {
		super(x, y, width, height, dx, dy);
		this.setColor(Color.RED);
		
	}//end constructor
	
	public Star(int x, int y, Double scale, int dx, int dy){
		super(x, y, scale, dx, dy);
				
	}
	
	@Override
	public void draw(Graphics g, JPanel c){
		this.setWidth( (int) (108 * this.getScale())); //scale star width
		this.setHeight( (int) (96 * this.getScale())); //scale star height
		
		g2 = (Graphics2D) g;
		AffineTransform at = g2.getTransform();
		GeneralPath star = new GeneralPath();
		star.moveTo(xPoints[0], yPoints[0]);
		
		for (int i=1; i<xPoints.length; i++) {
			star.lineTo(xPoints[i], yPoints[i]);
		};
		
		
		star.closePath();

		g2.setColor(this.getColor());
		
		g2.translate(this.getX(), this.getY());
		g2.scale(this.getScale(), this.getScale());
		updateRotate();
		//g2.rotate(Math.toRadians(45));
		g2.rotate(Math.toRadians(rotate), this.getWidth()/2, this.getHeight()/2);
		
		g2.fill(star);
		
		g2.setColor(Color.BLUE);
        g2.draw(star.getBounds());
		
		g2.setTransform(at);
	

	}


	
	//abstract class move
	private void updateRotate(){
		if (rotate < 360){
			rotate += 1;
		}
		else {rotate = 1;}
	}
}
