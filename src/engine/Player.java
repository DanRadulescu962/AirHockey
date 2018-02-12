package engine;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;

import music.AudioManager;
import resources.SingletonResources;

public class Player extends MovingObject {

	//value of speed
	private double value = 2;
	
	public Player(ImageIcon icon, ImageObserver observer, double posX,
			double posY, double speedX, double speedY, int typeOfControls) {
		super(icon, observer, posX, posY, speedX, speedY, typeOfControls);
	}

	//methods used for handling game breaks
	public void freeze(){
		value = 0;
	}
	
	public void recover(){
		value = 2;
	}
	
	@Override
	public void checkBounds() {
		if (getPosX() < 5)
			setPosX(5);
		if (getPosX() > 860)
			setPosX(860);

		if (getPosY() < 10)
			setPosY(10);
		if (getPosY() > 510)
			setPosY(510);
	}

	public void collisionPlayer(Player p) {

		// current player
		double p1x = getPosX();
		double p1y = getPosY();

		// player p
		double pcx = p.getPosX();
		double pcy = p.getPosY();

		if (Math.abs(p1x - pcx) < 60 && Math.abs(p1y - pcy) < 60) {
			if (p1x < pcx) {
				p1x = p1x - 50;
				pcx = pcx + 50;
			} else {
				p1x = p1x + 50;
				pcx = pcx + 50;
			}
			if (p1y < pcy) {
				p1y = p1y - 50;
				pcy = pcy + 50;
			} else {
				p1y = p1y + 50;
				pcy = pcy - 50;
			}

			AudioManager.playShortSong(SingletonResources.getInstance()
					.getPunch());
		}

		setPosX(p1x);
		setPosY(p1y);
		p.setPosX(pcx);
		p.setPosY(pcy);
	}

	@Override
	public void collisionNet() {

	}

	public void checkGoal(Controls controls) {

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

	public void updateSpeed(Controls controls) {
		int type = getTypeOfControls();
		if (type == 1) {
			if (controls.isUpPlayer1()) {
				setSpeedY(-value);
			}

			if (controls.isDownPlayer1()) {
				setSpeedY(value);
			}

			if (controls.isLeftPlayer1()) {
				setSpeedX(-value);
			}

			if (controls.isRightPlayer1()) {
				setSpeedX(value);
			}

			if (!controls.isUpPlayer1() && !controls.isDownPlayer1()) {
				setSpeedY(0);
			}

			if (controls.isUpPlayer1() && controls.isDownPlayer1()) {
				setSpeedY(0);
			}

			if (!controls.isLeftPlayer1() && !controls.isRightPlayer1()) {
				setSpeedX(0);
			}

			if (controls.isLeftPlayer1() && controls.isRightPlayer1()) {
				setSpeedX(0);
			}
		}

		if (type == 2) {
			if (controls.isUpPlayer2()) {
				setSpeedY(-value);
			}
			if (controls.isDownPlayer2()) {
				setSpeedY(value);
			}
			if (controls.isLeftPlayer2()) {
				setSpeedX(-value);
			}
			if (controls.isRightPlayer2()) {
				setSpeedX(value);
			}

			if (!controls.isUpPlayer2() && !controls.isDownPlayer2()) {
				setSpeedY(0);
			}

			if (controls.isUpPlayer2() && controls.isDownPlayer2()) {
				setSpeedY(0);
			}

			if (!controls.isLeftPlayer2() && !controls.isRightPlayer2()) {
				setSpeedX(0);
			}

			if (controls.isLeftPlayer2() && controls.isRightPlayer2()) {
				setSpeedX(0);
			}
		}
	}

	public void accept(IDrawer d) {
		d.visit(this);
	}

	public void accept(IUpdater d) {
		d.visit(this);
	}
}
