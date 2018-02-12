package resources;

import java.io.File;
import java.io.FileNotFoundException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.ImageIcon;

/**
 * 
 * Singleton class which maintains all resources
 *
 */

public class SingletonResources {

	// Pictures
	private ImageIcon p1Frame, contButton, cont2Button, p2Frame;
	private ImageIcon backButton, backrollButton, opFrame;
	private ImageIcon mainFrame, startButton, optionsButton, creditsButton;
	private ImageIcon quitButton, creditsFrame, entranceFrame, quitRollButton;
	private ImageIcon startRollButton, optionsRollButton, creditsRollButton;
	
	//Game Components
	private ImageIcon playerGreen2, playerBlue1, puck, rink;
	

	// Songs
	private File buttonPush, buttonRoll;
	private File mainSong, introSong, gameSong;
	private File crowd, puckSlap1, puckSlap2, goal;
	private File ovation, punch, gameOver;

	private static SingletonResources instance = null;

	public static SingletonResources getInstance() {
		if (instance == null)
			instance = new SingletonResources();

		return instance;
	}

	private SingletonResources() {

		p1Frame = new ImageIcon("Resources/Images/Frames/p1.png");
		p2Frame = new ImageIcon("Resources/Images/Frames/p2.png");
		opFrame = new ImageIcon("Resources/Images/Frames/OptionsMenu.png");
		mainFrame = new ImageIcon("Resources/Images/Frames/mainmenupic.jpg");
		creditsFrame = new ImageIcon("Resources/Images/Frames/Credits.png");
		entranceFrame = new ImageIcon(
				"Resources/Images/Frames/Entrance copy.png");

		startButton = new ImageIcon("Resources/Images/Buttons/Start.png");
		startRollButton = new ImageIcon("Resources/Images/Buttons/StartRol.png");
		quitButton = new ImageIcon("Resources/Images/Buttons/Quit.png");
		quitRollButton = new ImageIcon("Resources/Images/Buttons/QuitRol.png");
		optionsButton = new ImageIcon("Resources/Images/Buttons/optionsbut.png");
		optionsRollButton = new ImageIcon(
				"Resources/Images/Buttons/OptionsRol.png");
		creditsButton = new ImageIcon("Resources/Images/Buttons/creditsbut.png");
		creditsRollButton = new ImageIcon(
				"Resources/Images/Buttons/CreditsRol.png");
		backButton = new ImageIcon("Resources/Images/Buttons/back.png");
		backrollButton = new ImageIcon("Resources/Images/Buttons/backroll.png");
		contButton = new ImageIcon("Resources/Images/Buttons/continue.png");
		cont2Button = new ImageIcon("Resources/Images/Buttons/continueRol.png");
		
		playerBlue1 = new ImageIcon("Resources/Images/Components/bluePlayer1.png");
		playerGreen2 = new ImageIcon("Resources/Images/Components/greenPlayer2.png");
		rink = new ImageIcon("Resources/Images/Components/ahback.png");
		puck = new ImageIcon("Resources/Images/Components/puck.png");

		try {
			buttonPush = new File("Resources/Audio/ButtonPush.wav");
			buttonRoll = new File("Resources/Audio/ButtonRoll.wav");

			if (buttonPush == null || buttonRoll == null) {
				throw new FileNotFoundException();
			}
		} catch (FileNotFoundException e) {
			System.out.println("Fatal error! Could not find a file!");
			e.printStackTrace();
			System.exit(0);
		}
		
		try {
			introSong = new File("Resources/Audio/IntroSong.wav");
			mainSong = new File("Resources/Audio/MainSong.wav");
			gameSong = new File("Resources/Audio/GameSong.wav");

			if (introSong == null || mainSong == null || gameSong == null) {
				throw new FileNotFoundException();
			}
		} catch (FileNotFoundException e) {
			System.out.println("Fatal error! Could not find a file!");
			e.printStackTrace();
			System.exit(0);
		}
		
		try{
			crowd = new File("Resources/Audio/crowd.wav");
			puckSlap1 = new File("Resources/Audio/puckSlap.wav");
			puckSlap2 = new File("Resources/Audio/puckSlap2.wav");
			goal = new File("Resources/Audio/GoalSound.wav");
			
			if (crowd == null || puckSlap1 == null || puckSlap2 == null || goal == null){
				throw new FileNotFoundException();
			}
		} catch (FileNotFoundException e){
			System.out.println("Fatal error! Could not find a file!");
			e.printStackTrace();
			System.exit(0);
		}
		
		try{
			ovation = new File("Resources/Audio/ovation.wav");
			punch = new File("Resources/Audio/punch.wav");
			gameOver = new File("Resources/Audio/GameOver.wav");
			
			if (ovation == null || punch == null || gameOver == null){
				throw new FileNotFoundException();
			}
		} catch (FileNotFoundException e){
			System.out.println("Fatal error! Could not find a file!");
			e.printStackTrace();
			System.exit(0);
		}
	}

	public File getCrowd() {
		return crowd;
	}

	public File getPuckSlap1() {
		return puckSlap1;
	}

	public File getPuckSlap2() {
		return puckSlap2;
	}

	public File getGoal() {
		return goal;
	}

	public File getOvation() {
		return ovation;
	}

	public File getPunch() {
		return punch;
	}

	public File getGameOver() {
		return gameOver;
	}

	public ImageIcon getPlayerGreen2() {
		return playerGreen2;
	}

	public ImageIcon getPlayerBlue1() {
		return playerBlue1;
	}

	public ImageIcon getPuck() {
		return puck;
	}

	public ImageIcon getRink() {
		return rink;
	}

	public File getMainSong() {
		return mainSong;
	}

	public File getIntroSong() {
		return introSong;
	}

	public File getGameSong() {
		return gameSong;
	}

	public File getButtonPush() {
		return buttonPush;
	}

	public File getButtonRoll() {
		return buttonRoll;
	}

	public ImageIcon getP1Frame() {
		return p1Frame;
	}

	public ImageIcon getContButton() {
		return contButton;
	}

	public ImageIcon getCont2Button() {
		return cont2Button;
	}

	public ImageIcon getP2Frame() {
		return p2Frame;
	}

	public ImageIcon getBackButton() {
		return backButton;
	}

	public ImageIcon getBackrollButton() {
		return backrollButton;
	}

	public ImageIcon getOpFrame() {
		return opFrame;
	}

	public ImageIcon getMainFrame() {
		return mainFrame;
	}

	public ImageIcon getStartButton() {
		return startButton;
	}

	public ImageIcon getOptionsButton() {
		return optionsButton;
	}

	public ImageIcon getCreditsButton() {
		return creditsButton;
	}

	public ImageIcon getQuitButton() {
		return quitButton;
	}

	public ImageIcon getCreditsFrame() {
		return creditsFrame;
	}

	public ImageIcon getEntranceFrame() {
		return entranceFrame;
	}

	public ImageIcon getQuitRollButton() {
		return quitRollButton;
	}

	public ImageIcon getStartRollButton() {
		return startRollButton;
	}

	public ImageIcon getOptionsRollButton() {
		return optionsRollButton;
	}

	public ImageIcon getCreditsRollButton() {
		return creditsRollButton;
	}

}
