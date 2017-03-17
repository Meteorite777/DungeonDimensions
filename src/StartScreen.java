

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class StartScreen extends JFrame implements ActionListener {
	public static final int Frame_Width = 600;
	public static final int Frame_Height = 600;
	public static final int Frame_X = 350;
	public static final int Frame_Y = 100;
	public static final int Button_Width = 100;
	public static final int Button_Height = 30;
	private SoundClipTest test;
	private JButton game, option;
	/*
	static StartScreen frame;
	
	public static void main(String[] args) {
		frame = new StartScreen();
		frame.setVisible(true);
	}
	*/
	public StartScreen(SoundClipTest t){
		Container contentPane = getContentPane();
		
		setSize(Frame_Width, Frame_Height);
		setResizable(false);
		setTitle("Dungeon Dimension");
		setLocation(Frame_X, Frame_Y);
		
		contentPane.setLayout(null);
		
		game = new JButton("New Game");
		game.setBounds(150, 500, Button_Width, Button_Height);
		contentPane.add(game);
		
		option = new JButton("Options");
		option.setBounds(350, 500, Button_Width, Button_Height);
		contentPane.add(option);
		
		game.addActionListener(this);
		option.addActionListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		ImageIcon image = new ImageIcon(NewGame.class.getClassLoader().getResource("dimension.png"));
		JLabel label = new JLabel (image);
		label.setBounds(0,0,Frame_Width, Frame_Height);
		contentPane.add(label);
		
		test = t;
	}

	public void actionPerformed(ActionEvent event) {
		JButton clicked = (JButton) event.getSource();
		String buttonTxt = clicked.getText();
		if(buttonTxt.equals("New Game")){
			NewGame game = new NewGame(test);
			setVisible(false);
			game.setVisible(true);
		}
		else if(buttonTxt.equals("Options")){
			OptionsMenu menu = new OptionsMenu(test);
			setVisible(false);
			menu.setVisible(true);
		}
		
	}
	
}
