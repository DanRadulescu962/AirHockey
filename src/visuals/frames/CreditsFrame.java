package visuals.frames;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JLabel;

import resources.SingletonResources;
import visuals.buttons.AbstractButton;
import visuals.buttons.ButtonsFactory;

public class CreditsFrame extends AbstractFrame {

	private void prepareButtons() {
		buttons = new ArrayList<>();
		buttons.add(ButtonsFactory.getButton("Back", this));
	}

	public CreditsFrame(String name) {
		super(name);
		prepareButtons();
		frameLabel = new JLabel(SingletonResources.getInstance()
				.getCreditsFrame());
		setContentPane(frameLabel);

		c = getContentPane();
		c.setLayout(null);
		for (AbstractButton button : buttons)
			c.add(button);
		setVisible(true);
	}
	
	public CreditsFrame(String name, AbstractFrame previousFrame){
		this(name);
		this.previousFrame = previousFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttons.get(0)) {
			buttons.get(0).doAction(this);
		}

	}

}
