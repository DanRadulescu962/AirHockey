package visuals.frames;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JLabel;

import resources.SingletonResources;
import visuals.buttons.AbstractButton;
import visuals.buttons.ButtonsFactory;

public class VictoryFrame extends AbstractFrame {

	private void prepareButtons(){
		buttons = new ArrayList<>();
		buttons.add(ButtonsFactory.getButton("Continue", this));
	}
	
	public VictoryFrame(String name) {
		super(name);
		if (name.equals("Player1"))
			frameLabel = new JLabel(SingletonResources.getInstance()
					.getP1Frame());
		else
			frameLabel = new JLabel(SingletonResources.getInstance()
					.getP2Frame());

		setContentPane(frameLabel);
		prepareButtons();

		c = getContentPane();
		c.setLayout(null);
		for (AbstractButton button : buttons)
			c.add(button);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttons.get(0)){
			buttons.get(0).doAction(this);
		}
	}

}
