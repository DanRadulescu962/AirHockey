package visuals.buttons;

import javax.swing.JButton;

import visuals.frames.AbstractFrame;

public abstract class AbstractButton extends JButton {

	protected final int x = 300;
	protected final int y1 = 100;
	protected final int y2 = 220;
	protected final int y3 = 340;
	protected final int y4 = 460;
	protected final int xBack = 630;
	protected final int yBack = 500;
	protected final int xCont = 650;
	protected final int yCont = 450;
	protected final int w = 300;
	protected final int h = 50;

	public AbstractButton(AbstractFrame frame) {
		setRolloverEnabled(true);
		setBorderPainted(false);
		setContentAreaFilled(false);
		addActionListener(frame);
		addMouseListener(new MyMouseAdapter());
	}

	public abstract void doAction(AbstractFrame frame);

}
