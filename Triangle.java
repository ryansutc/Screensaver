import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;


public class Triangle extends Shape {
	private int minmax = 10;
	public Triangle(int x, int y, int width, int height, int dx, int dy) {
		super(x, y, width, height, dx, dy);
		// TODO Auto-generated constructor stub
	}
	public Triangle(int x, int y, int width, int height, int dx, int dy, Color clr) {
		
		super(x, y, width, height, dx, dy);

		//this.setHeight(height -= (height * 2));
		this.setColor(clr);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(Graphics g, JPanel c) {
		int[] xPoints = {this.getX(), this.getX() + this.getWidth(),this.getX() +(this.getWidth()/2)};
		int[] yPoints = {this.getY(), this.getY(), this.getY() - this.getHeight()};
		g.setColor(this.getColor());
		g.fillPolygon(xPoints, yPoints, xPoints.length);
		
	}
	@Override
	public void move(Graphics g, JPanel jp){
		//if the new coords are outside window switch direction
		x += dx; //move x
		y += dy; //move y
		
		//prevent from going beyond bounds
		if ((this.x + this.getWidth()) > jp.getWidth() ){
			this.x = jp.getWidth() - this.getWidth();// this.getWidth();
			dx = dx - (dx * 2);
		}
		else if ((this.x + dx) < 0){
			this.x = 0;
			dx = dx - (dx * 2);
		}
		
		if (this.y > jp.getHeight()){
			this.y = jp.getHeight();
			dy = dy - (dy * 2);
		}
		else if ((this.y - this.getHeight() + dy) < 0){
			y = 0 + this.getHeight();
			dy= dy - (dy * 2);
		}
		resize();
	}
	private void resize(){
		
		if (this.getWidth() >= minmax){
			minmax = 10;
			this.setWidth(this.getWidth()-1);
			this.setHeight(this.getHeight()-1);
		}
		else if (this.getWidth() <= minmax){
			minmax = 60;
			this.setWidth(this.getWidth()+1);
			this.setHeight(this.getHeight()+1);
		}
	}
}
