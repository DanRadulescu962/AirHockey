package engine;

import resources.SingletonResources;
import music.AudioManager;
import visuals.frames.FramesFactory;

public class Scoreboard implements Drawable {

	private String leftScore = "0", rightScore = "0";
	private boolean leftMessage = false, rightMessage = false;
	
	//if it's true then print Y/N on screen to decide
	//whether continue or stop game
	private boolean yesOrNo;

	public boolean isYesOrNo() {
		return yesOrNo;
	}

	public void setYesOrNo(boolean yesOrNo) {
		this.yesOrNo = yesOrNo;
	}

	@Override
	public void accept(IDrawer d) {
		d.visit(this);
	}

	public void updateLeftGoal() {
		Integer i = Integer.parseInt(rightScore);
		i++;
		rightScore = i.toString();
		rightMessage = true;
	}

	public void updateRightGoal() {
		Integer i = Integer.parseInt(leftScore);
		i++;
		leftScore = i.toString();
		leftMessage = true;
	}

	public String getLeftScore() {
		return leftScore;
	}

	public void setLeftScore(String leftScore) {
		this.leftScore = leftScore;
	}

	public String getRightScore() {
		return rightScore;
	}

	public void setRightScore(String rightScore) {
		this.rightScore = rightScore;
	}

	public boolean isLeftMessage() {
		return leftMessage;
	}

	public void setLeftMessage(boolean leftMessage) {
		this.leftMessage = leftMessage;
	}

	public boolean isRightMessage() {
		return rightMessage;
	}

	public void setRightMessage(boolean rightMessage) {
		this.rightMessage = rightMessage;
	}

	public boolean checkGameOver() {
		Integer left = Integer.parseInt(leftScore);
		Integer right = Integer.parseInt(rightScore);

		if (left == 5) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException ev) {
				System.err.println("sleep exception");
			}

			FramesFactory.getFrame("Player1", null);
			return true;
		}

		if (right == 5) {
			AudioManager.playShortSong(SingletonResources.getInstance()
					.getGameOver());

			try {
				Thread.sleep(3000);
			} catch (InterruptedException ev) {
				System.err.println("sleep exception");
			}

			FramesFactory.getFrame("Player2", null);
			return true;
		}

		return false;
	}
}
