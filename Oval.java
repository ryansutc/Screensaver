import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;


public class Oval extends Shape {
	private int squish; //will be this.getWidth()/2 when squishing and this.getWidth() when expanding. See move method and wall collision 
	private int[] normalshape = {this.getWidth(), this.getHeight()};
	public Oval(int x, int y, int width, int height, int dx, int dy) {
		super(x, y, width, height, dx, dy);
		// TODO Auto-generated constructor stub
		this.setColor(Color.GREEN);
		squish = (normalshape[0]/2);
	}
	
	public Oval(int x, int y, int width, int height, int dx, int dy, Color clr) {
		super(x, y, width, height, dx, dy);
		// TODO Auto-generated constructor stub
		this.setColor(clr);
		//normalshape[0] = 30;
		//normalshape[1] = 30;
		squish = (normalshape[0]/2);
	}
	
	@Override
	public void draw(Graphics g, JPanel c){
		g.setColor(this.getColor());
		g.fillOval(this.getX(), this.getY(), this.getWidth(), this.getHeight());

	}
	
	@Override
	//shape changing move
	public void move(Graphics g, JPanel jp){
		//if the new coords are outside window switch direction
		this.x += dx; //move x
		this.y += dy; //move y
		
		int faredge = this.x + this.getWidth(); //prevent from going beyond far wall bounds
		
		
		//FAR WALL HIT
		if (faredge >= jp.getWidth()){ //if hit wall
			if (this.getWidth() >= squish){ //if still fat enough to shrink
				shrink();
			}
			
			if (this.getWidth() <= squish){ //else if shrunk enough, expand
				if (squish == (normalshape[0]/2)){ //toggle squish to expand
					dx = dx - (dx * 2); //switch direction
					squish = normalshape[0];
					System.out.println("One off. switch direction, expand. squish is " + squish);
				}
			}
		}
		
		//NEAR WALL HIT
		else if (this.x < 0){//if hit near wall			
			if (this.getWidth() >= (squish)){
				shrink();
				this.x = 0; //but prevent from moving
			}
			if (this.getWidth() <= squish){
				if (squish == (normalshape[0]/2)){
					dx = dx - (dx * 2);//change direction
					squish = normalshape[0];					
				}
			}
		}
		
		//If too small expand, even if off the wall
		if (this.getWidth() < squish){
			expand();
			if (this.getWidth() >= this.normalshape[0]){ //finally if expanded. toggle squish again
				this.setWidth(this.normalshape[0]);
				this.setHeight(this.normalshape[1]);
				squish = normalshape[0]/2;
			}		
		}
		
		//TOP / BOTTOM WALLS
		if ((this.y + this.getHeight()) > jp.getHeight() ){
			this.y = jp.getHeight() - this.getHeight();
			dy = dy - (dy * 2);
		}
		else if ((this.y + dy) < 0){
			y = 0;
			dy= dy - (dy * 2);
		}
	}
	
	private void shrink(){
		this.setWidth(this.getWidth()- Math.abs(dx)); //shrink width
		this.setHeight(this.getHeight()+ Math.abs(dx)); //expand height
	}
	
	private void expand(){
		this.setWidth(this.getWidth()+ Math.abs(dx)); //expand x
		this.setHeight(this.getHeight()- Math.abs(dx)); //shrink y
	}
	
}
