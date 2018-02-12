package visuals.buttons;

import visuals.frames.AbstractFrame;

public class ButtonsFactory {

	public static AbstractButton getButton(String name, AbstractFrame frame) {

		switch (name) {
		case "Start":
			return new StartButton(frame);
		case "Options":
			return new OptionsButton(frame);
		case "Credits":
			return new CreditsButton(frame);
		case "Quit":
			return new QuitButton(frame);
		case "Back":
			return new BackButton(frame);
		case "Continue":
			return new ContinueButton(frame);
		default:
			throw new IllegalArgumentException();
		}

	}

}
