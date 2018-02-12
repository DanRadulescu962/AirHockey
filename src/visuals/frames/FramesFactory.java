package visuals.frames;

public class FramesFactory {

	public static AbstractFrame getFrame(String name, 
			AbstractFrame previousFrame) {
		switch (name) {

		case "Start":
			return new StartFrame(name);
		case "Main":
			return new MainFrame(name);
		case "Player1":
			return new VictoryFrame("Player1");
		case "Player2":
			return new VictoryFrame("Player2");
		case "Options":
			return new OptionsFrame(name, previousFrame);
		case "Credits":
			return new CreditsFrame(name, previousFrame);
		default:
			throw new IllegalArgumentException();

		}
	}

}
