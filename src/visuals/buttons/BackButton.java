package visuals.buttons;

import resources.SingletonResources;
import visuals.frames.AbstractFrame;
import visuals.frames.FramesFactory;

public class BackButton extends AbstractButton {

	public BackButton(AbstractFrame frame) {
		super(frame);
		setBounds(xBack, yBack, w, h);
		setIcon(SingletonResources.getInstance().getBackButton());
		setRolloverIcon(SingletonResources.getInstance().getBackrollButton());
	}

	@Override
	public void doAction(AbstractFrame frame) {
		frame.getPreviousFrame().setVisible(true);
		frame.dispose();
	}

}
