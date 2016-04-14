import java.awt.*;
import java.util.Random;

import javax.swing.JPanel;
public class Rectangle extends Shape{
	
	public Rectangle(int x, int y, int width, int height, int dx, int dy) {
		super(x, y, width, height, dx, dy);
		// TODO Auto-generated constructor stub
	}
	public Rectangle(int x, int y, int width, int height, int dx, int dy, Color color) {
		super(x, y, width, height, dx, dy);
		this.setColor(color);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void draw(Graphics g, JPanel c){

		g.setColor(this.getColor());
		g.fillRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());

	}
	
}
