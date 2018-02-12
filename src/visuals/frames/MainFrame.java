package visuals.frames;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.sound.sampled.Clip;
import javax.swing.JLabel;

import music.AudioManager;
import resources.SingletonResources;
import visuals.buttons.AbstractButton;
import visuals.buttons.ButtonsFactory;

public class MainFrame extends AbstractFrame {

	private Clip audioPlayer;
	
	private void prepareButtons() {
		buttons = new ArrayList<>();
		buttons.add(ButtonsFactory.getButton("Start", this));
		buttons.add(ButtonsFactory.getButton("Options", this));
		buttons.add(ButtonsFactory.getButton("Credits", this));
		buttons.add(ButtonsFactory.getButton("Quit", this));
	}
	
	public MainFrame(String name) {
		super(name);
		prepareButtons();
		frameLabel = new JLabel(SingletonResources.getInstance().getMainFrame());
		setContentPane(frameLabel);

		c = getContentPane();
		c.setLayout(null);
		for (AbstractButton button : buttons)
			c.add(button);
		setVisible(true);
		
		audioPlayer = AudioManager.playBackgroundSong(SingletonResources
				.getInstance().getMainSong());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttons.get(0)) {
			AudioManager.stopBackgroundSong(audioPlayer);
			buttons.get(0).doAction(this);
		}

		if (e.getSource() == buttons.get(1)) {
			buttons.get(1).doAction(this);
		}

		if (e.getSource() == buttons.get(2)) {
			buttons.get(2).doAction(this);
		}

		if (e.getSource() == buttons.get(3)) {
			buttons.get(3).doAction(this);
		}
	}

}
