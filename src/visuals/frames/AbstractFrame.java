package visuals.frames;

import java.awt.Container;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;

import visuals.buttons.AbstractButton;

public abstract class AbstractFrame extends JFrame implements ActionListener {

	private final int width = 960;

	private final int height = 600;

	protected Container c;

	protected JLabel frameLabel;

	protected ArrayList<AbstractButton> buttons;
	
	protected AbstractFrame previousFrame;

	public AbstractFrame(String name) {
		super(name);
		setResizable(false);
		setUndecorated(true);
		setSize(width, height);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public AbstractFrame(String name, AbstractFrame frame){
		this(name);
		previousFrame = frame;
	}

	public AbstractFrame getPreviousFrame(){
		return previousFrame;
	}
}
