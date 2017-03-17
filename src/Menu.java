import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;


public class Menu extends OptionsMenu implements ActionListener{
	
	private SoundClipTest test;
	
	public Menu(SoundClipTest t) {
		super(t);
		test = t;
	}


	public void actionPerformed(ActionEvent e) {
		JButton clicked = (JButton) e.getSource();
		String buttonTxt = clicked.getText();
		
		//closes the menu and returns to the game
		if(buttonTxt.equals("Back")){
		setVisible(false);
		}
		//turns the background music off
		if(buttonTxt.equals("Music Off")){
			test.turnOff();
		}
		//turns the background music on
		if(buttonTxt.equals("Music On")){
			test.repeat();
		}
		//sets the movement to the "WASD keys"
	if(buttonTxt.equals("WASD")){
		int key = KeyEvent.VK_W;
		setUp(key);
		int key1 = KeyEvent.VK_A;
		setLeft(key1);
		int key2 = KeyEvent.VK_S;
		setDown(key2);
		int key3 = KeyEvent.VK_D;
		setRight(key3);
	}
	//sets the movement controls to the arrow keys
	if(buttonTxt.equals("Arrow Keys")){
		int key = KeyEvent.VK_UP;
		setUp(key);
		int key1 = KeyEvent.VK_LEFT;
		setLeft(key1);
		int key2 = KeyEvent.VK_DOWN;
		setDown(key2);
		int key3 = KeyEvent.VK_RIGHT;
		setRight(key3);
	}
	}
	public int getUp(){
		System.out.println(up);
		return up;
	}
}