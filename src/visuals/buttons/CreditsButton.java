package visuals.buttons;

import resources.SingletonResources;
import visuals.frames.AbstractFrame;
import visuals.frames.FramesFactory;

public class CreditsButton extends AbstractButton {

	public CreditsButton(AbstractFrame frame) {
		super(frame);
		setBounds(x, y3, w, h);
		setIcon(SingletonResources.getInstance().getCreditsButton());
		setRolloverIcon(SingletonResources.getInstance().getCreditsRollButton());
	}

	@Override
	public void doAction(AbstractFrame frame) {
		frame.setVisible(false);
		FramesFactory.getFrame("Credits", frame);
	}

}
