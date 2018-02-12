package engine;

public class Updater implements IUpdater{

	private Controls controls;
	private double delta;
	
	@Override
	public void visit(Player p) {
		p.updateSpeed(controls);
		p.updatePosition(delta);
		p.checkBounds();
	}

	public void setControls(Controls controls) {
		this.controls = controls;
	}

	public void setDelta(double delta) {
		this.delta = delta;
	}

	@Override
	public void visit(Puck p) {
		p.updatePosition(delta);
		p.collisionNet();
		p.checkBounds();
		p.checkGoal(controls);
	}

}
