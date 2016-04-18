import java.awt.*;
import java.util.Random;

import javax.swing.JPanel;
public class Rectangle extends Shape{
	private Color baseColor;
	public Rectangle(int x, int y, int width, int height, int dx, int dy) {
		super(x, y, width, height, dx, dy);
		// TODO Auto-generated constructor stub
	}
	public Rectangle(int x, int y, int width, int height, int dx, int dy, Color color) {
		super(x, y, width, height, dx, dy);
		this.setColor(color);
		this.baseColor = this.getColor();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void draw(Graphics g, JPanel c){

		g.setColor(this.getColor());
		g.fillRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());

	}
	@Override
	public void move(Graphics g, JPanel jp){
		super.move(g, jp);
		int centroid[] = {this.x + (this.getWidth()/2), this.y + (this.getHeight()/2)};
		if (centroid[0] < 20 || centroid[0] > (jp.getWidth()-20) ||
				centroid[1] < 20 || centroid[1] > (jp.getHeight() - 20)){
			this.setColor(Color.GRAY);
			
		}
		
		else {
			this.setColor(this.baseColor);
		}
	}
	
}
