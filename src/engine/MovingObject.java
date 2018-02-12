package engine;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;

public abstract class MovingObject implements Drawable, Movable{

	private Image image;
	private int height, width, typeOfControls;
	private double posX, posY, speedX, speedY;
	
	public MovingObject(ImageIcon icon, ImageObserver observer, double posX,
			double posY, double speedX, double speedY, int typeOfControls){
		image = icon.getImage();
		height = image.getHeight(observer);
		width = image.getWidth(observer);
		this.posX = posX;
		this.posY = posY;
		this.speedX = speedX;
		this.speedY = speedY;
		this.typeOfControls = typeOfControls;
	}

	public int getTypeOfControls() {
		return typeOfControls;
	}

	public double getSpeedX() {
		return speedX;
	}

	public void setSpeedX(double speedX) {
		this.speedX = speedX;
	}

	public double getSpeedY() {
		return speedY;
	}

	public void setSpeedY(double speedY) {
		this.speedY = speedY;
	}

	public Image getImage() {
		return image;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public double getPosX() {
		return posX;
	}

	public double getPosY() {
		return posY;
	}
	
	public void setPosX(double posX) {
		this.posX = posX;
	}

	public void setPosY(double posY) {
		this.posY = posY;
	}
	
}
