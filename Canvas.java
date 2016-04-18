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
	private static final Color purple1 = new Color(147,137,170);
	private static final Color purple2 = new Color(110,96,141);
	private static final Color purple3 = new Color(82,66,117);
	private static final Color purple4 = new Color(60,44,94);
	private static final Color purple5 = new Color(41,25,75);
	
	private static final Color green1 = new Color(241,245,192);
	private static final Color green2 = new Color(198,203,131);
	private static final Color green3 = new Color(163,169,87);
	private static final Color green4 = new Color(130,136,55);
	private static final Color green5 = new Color(102,108,27);
	
	private static final Color orange1 = new Color(249,233,194);
	private static final Color orange2 = new Color(206,184,133);
	private static final Color orange3 = new Color(172,147,88);
	private static final Color orange4 = new Color(138,113,55);
	private static final Color orange5 = new Color(110,85,28);
	
	
	Color colorArray[] = {purple1,purple2, purple3, purple4, purple5, 
			green1, green2, green3, green4, 
			orange1, orange2, orange3, orange4, orange5};
	/**
	 * Create the panel.
	 */
	public Canvas() {

		animationTimer.start();
		
	}
	
	public void addShape(int x, int y){
		
		int dx = 1 + myrdm.nextInt(4);
		int dy = 1 + myrdm.nextInt(4);
		Color clr = colorArray[0 + myrdm.nextInt(colorArray.length)];
		if (itemCount == 1){
			shapes.add(new Rectangle(x, y, 25, 25, dx, dy, clr));
		}
		if (itemCount == 2){
			shapes.add(new Oval(x, y, 30, 30, dx, dy, clr));
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
