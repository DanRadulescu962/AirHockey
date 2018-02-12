package engine;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.sound.sampled.Clip;
import javax.swing.JFrame;

import music.AudioManager;
import resources.SingletonResources;
import visuals.frames.FramesFactory;

public class GameEngine extends JFrame implements ActionListener {

	// Loop elements
	private boolean running;

	// Game elements
	private Player player1, player2;
	private Puck puck;
	private Image rink;
	private MyKeyAdapter status;
	private final int height = 600;
	private final int width = 960;
	private Scoreboard score;
	private Clip audioPlayer;
	private ArrayList<Drawable> list;
	private ArrayList<Movable> physicsList;

	// Double Buffer
	private Image dbImage;
	private Graphics dbg;
	private Drawer drawer;
	private Updater updater;

	//lists of Visitable elements
	private void prepareList() {
		list = new ArrayList<>();
		physicsList = new ArrayList<>();

		list.add(player1);
		list.add(player2);
		list.add(puck);
		list.add(score);

		physicsList.add(player1);
		physicsList.add(player2);
		physicsList.add(puck);
	}

	public GameEngine() {
		rink = SingletonResources.getInstance().getRink().getImage();
		player1 = new Player(SingletonResources.getInstance().getPlayerBlue1(),
				this, 350, 260, 0, 0, 1);

		player2 = new Player(
				SingletonResources.getInstance().getPlayerGreen2(), this, 545,
				260, 0, 0, 2);

		puck = new Puck(SingletonResources.getInstance().getPuck(), this, 480,
				290, 0, 0, 0);

		status = new MyKeyAdapter();
		score = new Scoreboard();
		drawer = new Drawer(dbg, this);
		updater = new Updater();
		audioPlayer = AudioManager.playBackgroundSong(SingletonResources
				.getInstance().getGameSong());
		prepareList();

		addKeyListener(status);
		setTitle("AirHockey");
		setSize(width, height);
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		running = true;
		if (running) {
			runGameLoop();
		}
	}

	public void runGameLoop() {
		Thread loop = new Thread() {
			public void run() {
				gameLoop();
			}
		};
		loop.start();
	}

	public void gameLoop() {

		// Game loop and also delta for smooth movement

		long lastLoopTime = System.nanoTime();
		int TARGET_FPS = 90;
		long OPTIMAL_TIME = 1000000000 / TARGET_FPS;
		while (running) {
			long now = System.nanoTime();
			long updateLength = now - lastLoopTime;
			lastLoopTime = now;
			double delta = updateLength / ((double) OPTIMAL_TIME);
			updatePhysics(delta, status.getControls());
			updateGlobalEvents();
			repaint();
			try {
				Thread.sleep(

				(lastLoopTime - System.nanoTime() + OPTIMAL_TIME) / 1000000

				);
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
	}

	//restart players after a goal
	public void restart() {
		try {
			Thread.sleep(1500);
		} catch (Exception e) {
			System.out.println("FATAL Error!");
			e.printStackTrace();
		}

		player1.setPosX(350);
		player1.setPosY(260);
		player2.setPosX(545);
		player2.setPosY(260);
		puck.setPosX(480);
		puck.setPosY(290);
		puck.setSpeedX(0);
		puck.setSpeedY(0);
	}

	//update global events like winning a game or
	//pressing the space button
	public void updateGlobalEvents() {
		if (status.getControls().isGoalLeftNet()) {
			score.updateLeftGoal();
			restart();
		}

		if (status.getControls().isGoalRightNet()) {
			score.updateRightGoal();
			restart();
		}

		if (score.checkGameOver()) {
			running = false;
			AudioManager.stopBackgroundSong(audioPlayer);
			dispose();
		}

		if (puck.getSpeedX() != 0 || puck.getSpeedY() != 0) {
			score.setLeftMessage(false);
			score.setRightMessage(false);
		}
		
		if (status.getControls().isPause()){
			puck.freeze();
			player1.freeze();
			player2.freeze();
		}
		
		if (status.getControls().isPause() && status.getControls().isContinuePause()){
			puck.recover();
			player1.recover();
			player2.recover();
			status.getControls().setPause(false);
		}
		
		if (status.getControls().isPause() && status.getControls().isStopPause()){
			running = false;
			AudioManager.stopBackgroundSong(audioPlayer);
			dispose();
			FramesFactory.getFrame("Main", null);
		}
	}

	//update collisions then indiviual movements
	//individual movements are updated using Visitor Pattern
	public void updatePhysics(double delta, Controls controls) {
		player1.collisionPlayer(player2);
		puck.collisionPlayer(player1);
		puck.collisionPlayer(player2);

		updater.setControls(controls);
		updater.setDelta(delta);
		for (Movable d : physicsList) {
			d.accept(updater);
		}
	}

	public void update(Graphics g) {
		paint(g);
	}

	public void paint(Graphics g) {
		dbImage = createImage(getWidth(), getHeight());
		dbg = dbImage.getGraphics();
		score.setYesOrNo(status.getControls().isPause());
		paintComponent(dbg);
		g.drawImage(dbImage, 0, 0, this);
	}

	//draw elements
	public void paintComponent(Graphics g) {
		g.drawImage(rink, 0, 0, this);
		drawer.setG(g);

		for (Drawable d : list) {
			d.accept(drawer);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

}
