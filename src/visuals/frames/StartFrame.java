package visuals.frames;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.sound.sampled.Clip;
import javax.swing.JLabel;
import javax.swing.JTextField;

import music.AudioManager;
import resources.SingletonResources;

public class StartFrame extends AbstractFrame implements KeyListener {

	private JTextField text = new JTextField(20);
	private Clip backgroundSong;

	public StartFrame(String name) {
		super(name);
		frameLabel = new JLabel(SingletonResources.getInstance()
				.getEntranceFrame());
		setContentPane(frameLabel);

		c = getContentPane();
		c.setLayout(null);
		text.addKeyListener(this);
		c.add(text);
		setVisible(true);
		
		backgroundSong = AudioManager.playBackgroundSong(SingletonResources
					.getInstance().getIntroSong());
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			AudioManager.stopBackgroundSong(backgroundSong);
			FramesFactory.getFrame("Main", null);
			dispose();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
