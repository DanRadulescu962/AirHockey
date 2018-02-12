package engine;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;

import resources.SingletonResources;
import music.AudioManager;

public class Puck extends MovingObject {

	private double savedSpeedX, savedSpeedY;
	
	public Puck(ImageIcon icon, ImageObserver observer, double posX,
			double posY, double speedX, double speedY, int typeOfControls) {
		super(icon, observer, posX, posY, speedX, speedY, typeOfControls);
	}

	//methods used for handling game breaks
	public void freeze(){
		
		if (getSpeedX() != 0)
			savedSpeedX = getSpeedX();
		
		if (getSpeedY() != 0){
			savedSpeedY = getSpeedY();
		}
		
		setSpeedX(0);
		setSpeedY(0);
	}
	
	public void recover(){
		setSpeedX(savedSpeedX);
		setSpeedY(savedSpeedY);
	}
	
	//update methods
	@Override
	public void checkBounds() {
		if (getPosX() < 20) {
			setPosX(20);
			setSpeedX(-getSpeedX());
			AudioManager.playShortSong(SingletonResources.getInstance()
					.getPuckSlap1());
		}

		if (getPosX() > 910) {
			setPosX(910);
			setSpeedX(-getSpeedX());
			AudioManager.playShortSong(SingletonResources.getInstance()
					.getPuckSlap1());
		}

		if (getPosY() < 20) {
			setPosY(20);
			setSpeedY(-getSpeedY());
			AudioManager.playShortSong(SingletonResources.getInstance()
					.getPuckSlap1());
		}

		if (getPosY() > 560) {
			setPosY(560);
			setSpeedY(-getSpeedY());
			AudioManager.playShortSong(SingletonResources.getInstance()
					.getPuckSlap1());
		}
	}

	private boolean playerContact(Player p) {
		Ellipse2D r1 = new Ellipse2D.Double(p.getPosX() + 18, p.getPosY() + 20,
				60, 55);
		Rectangle r2 = new Rectangle((int) getPosX() + 2, (int) getPosY() + 2,
				getWidth() - 5, getHeight() - 5);

		if (r1.intersects(r2))
			return true;

		return false;
	}

	// determine speed of puck after collision with a player
	// I used constant dimensions
	@Override
	public void collisionPlayer(Player p) {

		double p1x = p.getPosX();
		double p1y = p.getPosY();
		double speedx = getSpeedX();
		double speedy = getSpeedY();
		double puckx = getPosX();
		double pucky = getPosY();

		if (playerContact(p)) {
			if (p1x + 50 == puckx + 12) {
				if (p1y + 50 < pucky + 12) {
					speedy = (float) (-Math.sqrt(2));
					speedx = 0;
				} else if (p1y + 50 > pucky + 12) {
					speedy = (float) (Math.sqrt(2));
					speedx = 0;
				}
			} else {

				if (p1x + 50 > puckx + 12 && p1y + 50 < pucky + 12) {
					speedx = -(float) (Math.sqrt(2) * Math.cos(Math
							.atan(((p1y + 50) - (pucky + 12))
									/ ((p1x + 50) - (puckx + 12)))));
					speedy = -(float) (Math.sqrt(2) * Math.sin(Math
							.atan(((p1y + 50) - (pucky + 12))
									/ ((p1x + 50) - (puckx + 12)))));
				}
				if (p1x + 50 < puckx + 12 && p1y + 50 < pucky + 12) {
					speedx = (float) (Math.sqrt(2) * Math.cos(Math
							.atan(((p1y + 50) - (pucky + 12))
									/ ((p1x + 50) - (puckx + 12)))));
					speedy = (float) (Math.sqrt(2) * Math.sin(Math
							.atan(((p1y + 50) - (pucky + 12))
									/ ((p1x + 50) - (puckx + 12)))));
				}
				if (p1x + 50 > puckx + 12 && p1y + 50 > pucky + 12) {
					speedx = -(float) (Math.sqrt(2) * Math.cos(Math
							.atan(((p1y + 50) - (pucky + 12))
									/ ((p1x + 50) - (puckx + 12)))));
					speedy = -(float) (Math.sqrt(2) * Math.sin(Math
							.atan(((p1y + 50) - (pucky + 12))
									/ ((p1x + 50) - (puckx + 12)))));
				}
				if (p1x + 50 < puckx + 12 && p1y + 50 > pucky + 12) {
					speedx = (float) (Math.sqrt(2) * Math.cos(Math
							.atan(((p1y + 50) - (pucky + 12))
									/ ((p1x + 50) - (puckx + 12)))));
					speedy = (float) (Math.sqrt(2) * Math.sin(Math
							.atan(((p1y + 50) - (pucky + 12))
									/ ((p1x + 50) - (puckx + 12)))));
				}
			}

			setSpeedX(speedx * 3);
			setSpeedY(speedy * 3);
			AudioManager.playShortSong(SingletonResources.getInstance()
					.getPuckSlap2());
		}
	}

	// check intersection with net
	private boolean netContact(double X, double Y1, double Y2, double width,
			double height) {
		Rectangle r1 = new Rectangle((int) X, (int) Y1, (int) width,
				(int) height);
		Rectangle r2 = new Rectangle((int) X, (int) Y2, (int) width,
				(int) height);

		Ellipse2D margin = new Ellipse2D.Double(getPosX() + 2, getPosY() + 2,
				12, 12);

		if (margin.intersects(r1))
			return true;

		if (margin.intersects(r2))
			return true;

		return false;
	}

	// update after hitting a net
	@Override
	public void collisionNet() {
		
		//TODO: Calibrate collision dimensions
		
		if (netContact(38, 248, 332, 35, 10)
				|| netContact(894, 257, 340, 35, 10)) {
			setSpeedY(-getSpeedY());
			AudioManager.playShortSong(SingletonResources.getInstance()
					.getCrowd());
		}
	}

	@Override
	public void checkGoal(Controls controls) {
		// check position for right net
		if (getPosX() > 897 && 260 < getPosY() && getPosY() < 325) {
			controls.setGoalRightNet(true);
			AudioManager.playShortSong(SingletonResources.getInstance()
					.getGoal());
			AudioManager.playShortSong(SingletonResources.getInstance()
					.getOvation());
		} else
			controls.setGoalRightNet(false);

		// check position for left net
		if (getPosX() < 47 && 252 < getPosY() && getPosY() < 315) {
			controls.setGoalLeftNet(true);
			AudioManager.playShortSong(SingletonResources.getInstance()
					.getGoal());
			AudioManager.playShortSong(SingletonResources.getInstance()
					.getOvation());
		} else
			controls.setGoalLeftNet(false);
	}

	@Override
	public void updatePosition(double delta) {
		double pos, speed;
		pos = getPosX();
		speed = getSpeedX();
		pos += speed * delta;
		setPosX(pos);

		pos = getPosY();
		speed = getSpeedY();
		pos += speed * delta;
		setPosY(pos);
	}

	@Override
	public void updateSpeed(Controls controls) {

	}

	public void accept(IDrawer d) {
		d.visit(this);
	}

	public void accept(IUpdater d) {
		d.visit(this);
	}
}
