package visuals.buttons;

import engine.GameEngine;
import music.AudioManager;
import resources.SingletonResources;
import visuals.frames.AbstractFrame;

public class StartButton extends AbstractButton {

	public StartButton(AbstractFrame frame) {
		super(frame);
		setBounds(x, y1, w, h);
		setIcon(SingletonResources.getInstance().getStartButton());
		setRolloverIcon(SingletonResources.getInstance().getStartRollButton());
	}

	@Override
	public void doAction(AbstractFrame frame) {
		frame.dispose();
		new GameEngine();
	}

}
