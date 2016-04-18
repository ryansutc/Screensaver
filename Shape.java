import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.JPanel;


public abstract class Shape {

	protected int x;
	protected int y;
	private int width;
	private int height;
	private Color color;
	private Double scale = 1.0;
	
	protected int dx; //horizontal movement (run)
	protected int dy; //vertical movement (rise)
	
	//constructor
	public Shape(int x, int y, int width, int height, int dx, int dy){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.dx = dx;
		this.dy = dy;
	}
	
	public Shape(int x, int y, Double scale, int dx, int dy){
		//this is the constructor for Star
		this.x = x;
		this.y = y;
		this.setScale(scale);
		this.dx = dx;
		this.dy = dy;
	}
	
	//todo create overridden constructor here with direction
	public abstract void draw(Graphics g, JPanel c);
	

	//abstract class move
	
		public void move(Graphics g, JPanel jp){//if the new coords are outside window switch direction
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
		
		if ((this.y + this.getHeight()) > jp.getHeight() ){
			this.y = jp.getHeight() - this.getHeight();
			dy = dy - (dy * 2);
		}
		else if ((this.y + dy) < 0){
			y = 0;
			dy= dy - (dy * 2);
		}

	}
	
	public void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		
	}
	

//GETTERS AND SETTERS	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}

	public Double getScale() {
		return scale;
	}

	public void setScale(Double scale) {
		this.scale = scale;
	}

	
}//end class
