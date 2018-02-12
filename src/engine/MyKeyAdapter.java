package engine;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MyKeyAdapter extends KeyAdapter{

	Controls controls;
	
	public MyKeyAdapter(){
		controls = new Controls();
	}
	
	public void keyPressed(KeyEvent e){
		int keyCode = e.getKeyCode();
		
		switch(keyCode){
			case KeyEvent.VK_LEFT:
				controls.setLeftPlayer2(true);
				break;
			case KeyEvent.VK_RIGHT:
				controls.setRightPlayer2(true);
				break;
			case KeyEvent.VK_UP:
				controls.setUpPlayer2(true);
				break;
			case KeyEvent.VK_DOWN:
				controls.setDownPlayer2(true);
				break;
				
			case KeyEvent.VK_A:
				controls.setLeftPlayer1(true);
				break;
			case KeyEvent.VK_D:
				controls.setRightPlayer1(true);
				break;
			case KeyEvent.VK_W:
				controls.setUpPlayer1(true);
				break;
			case KeyEvent.VK_S:
				controls.setDownPlayer1(true);
				break;
				
			case KeyEvent.VK_SPACE:
				controls.setPause(true);
				break;
				
			case KeyEvent.VK_Y:
				controls.setContinuePause(true);
				break;
			
			case KeyEvent.VK_N:
				controls.setStopPause(true);
				break;
		}
		
	}
	
	public void keyReleased(KeyEvent e){
		int keyCode = e.getKeyCode();
		
		switch(keyCode){
			case KeyEvent.VK_LEFT:
				controls.setLeftPlayer2(false);
				break;
			case KeyEvent.VK_RIGHT:
				controls.setRightPlayer2(false);
				break;
			case KeyEvent.VK_UP:
				controls.setUpPlayer2(false);
				break;
			case KeyEvent.VK_DOWN:
				controls.setDownPlayer2(false);
				break;
				
			case KeyEvent.VK_A:
				controls.setLeftPlayer1(false);
				break;
			case KeyEvent.VK_D:
				controls.setRightPlayer1(false);
				break;
			case KeyEvent.VK_W:
				controls.setUpPlayer1(false);
				break;
			case KeyEvent.VK_S:
				controls.setDownPlayer1(false);
				break;
					
			case KeyEvent.VK_Y:
				controls.setContinuePause(false);
				break;
			
			case KeyEvent.VK_N:
				controls.setStopPause(false);
				break;
		}
	}

	public Controls getControls() {
		return controls;
	}
}
