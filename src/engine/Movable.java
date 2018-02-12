package engine;

public interface Movable {

	public void checkBounds();
	public void collisionPlayer(Player p);
	public void collisionNet();
	public void checkGoal(Controls controls);
	public void updatePosition(double delta);
	public void updateSpeed(Controls controls);
	public void accept(IUpdater updater);
}
