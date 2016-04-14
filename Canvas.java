import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;


public class Canvas extends JPanel {
	private final int ANIMATION_DELAY = 20;
	Timer animationTimer = new Timer(ANIMATION_DELAY, new TimerHandler());
	ArrayList<Shape> shapes = new ArrayList<>(); //list of shapes being drawn
	int itemCount = 1;
	Random myrdm = new Random();
	Color colorArray[] = {Color.RED,Color.BLUE,Color.GREEN,
			Color.YELLOW,Color.BLACK,Color.MAGENTA};
	/**
	 * Create the panel.
	 */
	public Canvas() {

		animationTimer.start();
		
	}
	
	public void addShape(int x, int y){
		
		int dx = 1 + myrdm.nextInt(4);
		int dy = 1 + myrdm.nextInt(4);
		Color clr = colorArray[1 + myrdm.nextInt(colorArray.length -1)];
		if (itemCount == 1){
			shapes.add(new Rectangle(x, y, 25, 25, dx, dy, clr));
		}
		if (itemCount == 2){
			shapes.add(new Oval(x, y, 20, 20, dx, dy, clr));
		}
		if (itemCount == 3){
			shapes.add(new Triangle(x,y,30, 30, dx, dy, clr));
		}
		if (itemCount == 4){
			shapes.add(new Star(x,y,0.5,dx,dy));
		
		}
		
		itemCount += 1;
		if (itemCount > 4){
			itemCount = 1;	
		}
	}

	private class TimerHandler implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {

			repaint();
		}
		
	}//end named inner class
	

	public void paintComponent(Graphics g)
	{

		super.paintComponent(g);
		
		for (Shape s : shapes){
			s.move(g, this);
			
			s.draw(g,this);
		}
	}
}
