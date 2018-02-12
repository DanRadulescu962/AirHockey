package visuals.buttons;

import resources.SingletonResources;
import visuals.frames.AbstractFrame;
import visuals.frames.FramesFactory;

public class OptionsButton extends AbstractButton {

	public OptionsButton(AbstractFrame frame) {
		super(frame);
		setBounds(x, y2, w, h);
		setIcon(SingletonResources.getInstance().getOptionsButton());
		setRolloverIcon(SingletonResources.getInstance().getOptionsRollButton());
	}

	@Override
	public void doAction(AbstractFrame frame) {
		frame.setVisible(false);
		FramesFactory.getFrame("Options", frame);
	}

}
