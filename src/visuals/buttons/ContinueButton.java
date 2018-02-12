package visuals.buttons;

import resources.SingletonResources;
import visuals.frames.AbstractFrame;
import visuals.frames.FramesFactory;

public class ContinueButton extends AbstractButton{

	public ContinueButton(AbstractFrame frame){
		super(frame);
		
		setBounds(xCont, yCont, w, h);
		setIcon(SingletonResources.getInstance().getContButton());
		setRolloverIcon(SingletonResources.getInstance().getCont2Button());
	}

	@Override
	public void doAction(AbstractFrame frame) {
		frame.dispose();
		FramesFactory.getFrame("Main", null);
	}
	
}
