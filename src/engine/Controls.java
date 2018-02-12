package engine;

/**
 * 
 * Maintains status of keys pressed or goals scored. Also maintians
 * the status of pause
 *
 */
public class Controls {

	//1 left Player
	//2 right Player
	
	private boolean upPlayer1, downPlayer1, leftPlayer1, rightPlayer1;
	
	private boolean upPlayer2, downPlayer2, leftPlayer2, rightPlayer2;
	
	private boolean pause, continuePause, stopPause;
	
	public boolean isPause() {
		return pause;
	}

	public void setPause(boolean pause) {
		this.pause = pause;
	}

	public boolean isContinuePause() {
		return continuePause;
	}

	public void setContinuePause(boolean continuePause) {
		this.continuePause = continuePause;
	}

	public boolean isStopPause() {
		return stopPause;
	}

	public void setStopPause(boolean stopPause) {
		this.stopPause = stopPause;
	}

	private boolean goalLeftNet, goalRightNet;

	public boolean isUpPlayer1() {
		return upPlayer1;
	}

	public void setUpPlayer1(boolean upPlayer1) {
		this.upPlayer1 = upPlayer1;
	}

	public boolean isDownPlayer1() {
		return downPlayer1;
	}

	public void setDownPlayer1(boolean downPlayer1) {
		this.downPlayer1 = downPlayer1;
	}

	public boolean isLeftPlayer1() {
		return leftPlayer1;
	}

	public void setLeftPlayer1(boolean leftPlayer1) {
		this.leftPlayer1 = leftPlayer1;
	}

	public boolean isRightPlayer1() {
		return rightPlayer1;
	}

	public void setRightPlayer1(boolean rightPlayer1) {
		this.rightPlayer1 = rightPlayer1;
	}

	public boolean isUpPlayer2() {
		return upPlayer2;
	}

	public void setUpPlayer2(boolean upPlayer2) {
		this.upPlayer2 = upPlayer2;
	}

	public boolean isDownPlayer2() {
		return downPlayer2;
	}

	public void setDownPlayer2(boolean downPlayer2) {
		this.downPlayer2 = downPlayer2;
	}

	public boolean isLeftPlayer2() {
		return leftPlayer2;
	}

	public void setLeftPlayer2(boolean leftPlayer2) {
		this.leftPlayer2 = leftPlayer2;
	}

	public boolean isRightPlayer2() {
		return rightPlayer2;
	}

	public void setRightPlayer2(boolean rightPlayer2) {
		this.rightPlayer2 = rightPlayer2;
	}

	public boolean isGoalLeftNet() {
		return goalLeftNet;
	}

	public void setGoalLeftNet(boolean goalLeftNet) {
		this.goalLeftNet = goalLeftNet;
	}

	public boolean isGoalRightNet() {
		return goalRightNet;
	}

	public void setGoalRightNet(boolean goalRightNet) {
		this.goalRightNet = goalRightNet;
	}

	
}
