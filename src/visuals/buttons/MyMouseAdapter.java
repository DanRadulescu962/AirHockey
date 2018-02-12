package visuals.buttons;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import music.AudioManager;
import resources.SingletonResources;

public class MyMouseAdapter extends MouseAdapter {

	@Override
	public void mouseEntered(MouseEvent ev) {
		AudioManager.playShortSong(SingletonResources.getInstance()
				.getButtonRoll());

	}

	@Override
	public void mousePressed(MouseEvent e) {
		AudioManager.playShortSong(SingletonResources.getInstance()
				.getButtonPush());

	}

}
