import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;


public class Oval extends Shape {

	public Oval(int x, int y, int width, int height, int dx, int dy) {
		super(x, y, width, height, dx, dy);
		// TODO Auto-generated constructor stub
		this.setColor(Color.GREEN);
	}
	
	public Oval(int x, int y, int width, int height, int dx, int dy, Color clr) {
		super(x, y, width, height, dx, dy);
		// TODO Auto-generated constructor stub
		this.setColor(clr);
	}
	
	@Override
	public void draw(Graphics g, JPanel c){
		g.setColor(this.getColor());
		g.drawOval(this.getX(), this.getY(), this.getWidth(), this.getHeight());
		g.setColor(Color.BLACK);
		g.fillOval(this.getX() -1, this.getY()-1, this.getWidth()-1, this.getHeight()-1);
	}
	
}
