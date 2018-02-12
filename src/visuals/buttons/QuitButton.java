package visuals.buttons;

import resources.SingletonResources;
import visuals.frames.AbstractFrame;

public class QuitButton extends AbstractButton {

	public QuitButton(AbstractFrame frame) {
		super(frame);
		setBounds(x, y4, w, h);
		setIcon(SingletonResources.getInstance().getQuitButton());
		setRolloverIcon(SingletonResources.getInstance().getQuitRollButton());
	}

	@Override
	public void doAction(AbstractFrame frame) {
		frame.dispose();
	}

}
