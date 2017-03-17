import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class OptionsMenu extends JFrame implements ActionListener {
	
	public static final int Frame_Width = 600;
	public static final int Frame_Height = 600;
	public static final int Frame_X = 350;
	public static final int Frame_Y = 100;
	public static final int Button_Width = 100;
	public static final int Button_Height = 30;
	public SoundClipTest test;
	private JButton on, off, back, easy, hard, set1, set2;
	private JLabel music, difficulty, keys; 
	public int up, left, down, right;
	
	public OptionsMenu(SoundClipTest t){
		Container contentPane = getContentPane();
		contentPane.setLayout(null);
		setSize(Frame_Width, Frame_Height);
		setResizable(false);
		setTitle("Options");
		setLocation(Frame_X, Frame_Y);
		
		//adds a Music On button
		on = new JButton("Music On");
		on.setBounds(150, 100, Button_Width, Button_Height);
		on.addActionListener(this);
		contentPane.add(on);
		
		//adds a Music Off button
		off = new JButton("Music Off");
		off.setBounds(275, 100, Button_Width, Button_Height);
		off.addActionListener(this);
		contentPane.add(off);
		
		//adds a Back button
		back = new JButton("Back");
		back.setBounds(450, 500, Button_Width, Button_Height);
		back.addActionListener(this);
		contentPane.add(back);
		
		
		music = new JLabel("Music:");
		music.setBounds(50, 100, Button_Width, Button_Height);
		contentPane.add(music);
		
		
		easy = new JButton("Easy Mode");
		easy.setBounds(150, 200, Button_Width, Button_Height);
		contentPane.add(easy);
		
		
		hard = new JButton("Hard Mode");
		hard.setBounds(275, 200, Button_Width, Button_Height);
		contentPane.add(hard);
		
		
		difficulty = new JLabel("Set Difficulty:");
		difficulty.setBounds(50, 200, Button_Width, Button_Height);
		contentPane.add(difficulty);
		
		
		keys = new JLabel("Set Keys:");
		keys.setBounds(50,350, Button_Width, Button_Height);
		contentPane.add(keys);
		
		set1 = new JButton("WASD");
		set1.setBounds(150, 350, Button_Width, Button_Height);
		set1.addActionListener(this);
		contentPane.add(set1);
		
		set2 = new JButton("Arrow Keys");
		set2.setBounds(275, 350, 200, Button_Height);
		set2.addActionListener(this);
		contentPane.add(set2);
		
		up = KeyEvent.VK_W;
		left = KeyEvent.VK_A;
		down = KeyEvent.VK_S;
		right = KeyEvent.VK_D;
		
		test = t;
	}
	
	public void actionPerformed(ActionEvent e) {
		JButton clicked = (JButton) e.getSource();
		String buttonTxt = clicked.getText();
		if(buttonTxt.equals("Back")){
			StartScreen S = new StartScreen(test);
			S.setVisible(true);
			setVisible(false);
		}
		if(buttonTxt.equals("Music On")){
			test.repeat();
		}
		if(buttonTxt.equals("Music Off")){
			test.turnOff();
		}
		
	}
	//sets the up control
	public void setUp(int u){
		up = u;
	}
	//sets the left control
	public void setLeft(int l){
		left = l;
	}
	//sets the down control
	public void setDown(int d){
		down = d;
	}
	//sets the right control
	public void setRight(int r){
		right = r;
	}
	//retrieves the up control
	public int getUp(){
		return up;
	}
	//retrieves the left control
	public int getLeft(){
		return left;
	}
	//retrieves the down control
	public int getDown(){
		return down;
	}
	//retrieves the right control
	public int getRight(){
		return right;
	}
}
