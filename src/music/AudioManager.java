package music;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * 
 * Audio files handler
 *
 */

public class AudioManager {

	public static void playShortSong(File song) {
		
		Clip audioPlayer = null;
		
		try {
			audioPlayer = AudioSystem.getClip();
		} catch (LineUnavailableException e) {
			System.out.println("Fatal Error!");
			e.printStackTrace();
			System.exit(0);
		}

		try {
			audioPlayer.open(AudioSystem.getAudioInputStream(song));
		} catch (LineUnavailableException e) {
			System.out.println("Fatal error!");
			e.printStackTrace();
			System.exit(0);
		} catch (IOException e) {
			System.out.println("Fatal error!");
			e.printStackTrace();
			System.exit(0);
		} catch (UnsupportedAudioFileException e) {
			System.out.println("Fatal error!");
			e.printStackTrace();
			System.exit(0);
		}

		FloatControl volume = (FloatControl) audioPlayer
				.getControl(FloatControl.Type.MASTER_GAIN);
		volume.setValue(2.0f);
		audioPlayer.start();

	}
	
	public static Clip playBackgroundSong(File song){
		
		Clip audioPlayer = null;
		
		try {
			audioPlayer = AudioSystem.getClip();
		} catch (LineUnavailableException e) {
			System.out.println("Fatal Error!");
			e.printStackTrace();
			System.exit(0);
		}

		try {
			audioPlayer.open(AudioSystem.getAudioInputStream(song));
		} catch (LineUnavailableException e) {
			System.out.println("Fatal error!");
			e.printStackTrace();
			System.exit(0);
		} catch (IOException e) {
			System.out.println("Fatal error!");
			e.printStackTrace();
			System.exit(0);
		} catch (UnsupportedAudioFileException e) {
			System.out.println("Fatal error!");
			e.printStackTrace();
			System.exit(0);
		}

		FloatControl volume = (FloatControl) audioPlayer
				.getControl(FloatControl.Type.MASTER_GAIN);
		volume.setValue(1.0f);
		audioPlayer.start();
		audioPlayer.loop(Clip.LOOP_CONTINUOUSLY);
		
		return audioPlayer;
	}
	
	public static void stopBackgroundSong(Clip audioPlayer){
		audioPlayer.loop(-1);
		audioPlayer.stop();
	}

}
