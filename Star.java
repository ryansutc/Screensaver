import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;

import javax.swing.JPanel;


public class Star extends Shape {
	Graphics2D g2;
	//static generic coords
	
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
		this.setWidth( (int) (108 * this.getScale()));
		this.setHeight( (int) (96 * this.getScale()));
		// draw GeneralPath (polygon)
		
		g2 = (Graphics2D) g;
		AffineTransform at = g2.getTransform();
		GeneralPath star = new GeneralPath();
		star.moveTo(xPoints[0], yPoints[0]);
		
		for (int i=1; i<xPoints.length; i++) {
			star.lineTo(xPoints[i], yPoints[i]);
		};

		star.closePath();
//		float dash1[] = {10f};
//		BasicStroke dashed = new BasicStroke(2.4f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 10.0f, dash1, 0.0f);
//		                        
//		g2.setStroke(dashed);
		g2.setColor(this.getColor());
		
		g2.translate(this.getX(), this.getY());
		g2.scale(this.getScale(), this.getScale());
		
		
		
		g2.fill(star);
		//g2.draw(star);
		//g2.scale(2, 2);
		//g2.translate(this.getX() - (this.getX()*2), this.getY() - (this.getY()*2)); //set canvas back to normal (untranslate)
		//g2.scale(2, 2);
		//g2.scale(swidth/this.getWidth(), swidth/this.getWidth()); //set canvas back to normal (unscale)
		//g2.translate(this.x, this.y);
		g2.setTransform(at);
		
	}

	//abstract class move
	
}
