package engine;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.ImageObserver;

public class Drawer implements IDrawer{

	Graphics g;
	ImageObserver observer;
	Font f;
	
	public Drawer(Graphics g, ImageObserver observer){
		this.g = g;
		this.observer = observer;
		f = new Font("Times New Roman", Font.BOLD, 30);
	}

	@Override
	public void visit(MovingObject obj) {
		g.drawImage(obj.getImage(), (int)obj.getPosX(), (int)obj.getPosY(), 
				observer);
	}

	public void setG(Graphics g) {
		this.g = g;
	}

	public void visit(Scoreboard score){
        g.setFont(f);
        
        g.drawString(score.getLeftScore(), 400, 100);
        g.drawString(score.getRightScore(), 600, 100);
        
        if (score.isLeftMessage()){
        	g.drawString("POINT!",370,200);
            g.setColor(Color.RED);
            g.fillOval(900,235,20,20);
            g.fillOval(900,350,20,20);
            g.setColor(Color.BLACK);
        }
        
        if (score.isRightMessage()){
        	g.drawString("POINT!",530,200);
            g.setColor(Color.RED);
            g.fillOval(50,230,20,20);
            g.fillOval(50,345,20,20);
            g.setColor(Color.BLACK);
        }
        
        if (score.isYesOrNo()){
        	g.drawString("Y",390,200);
            g.drawString("N",550,200);
        }
	}
	
	
}
