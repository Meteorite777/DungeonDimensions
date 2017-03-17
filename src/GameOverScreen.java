import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class GameOverScreen extends JFrame implements ActionListener {

	public static final int Frame_Width = 600;
	public static final int Frame_Height = 600;
	public static final int Frame_X = 350;
	public static final int Frame_Y = 100;
	public static final int Button_Width = 100;
	public static final int Button_Height = 30;
	private JButton cont, quit;
	private SoundClipTest test, gOver;
	
	public GameOverScreen(SoundClipTest t){
		test = t;
		test.turnOff();
		gOver = new SoundClipTest("GameOver_Music.wav");
		gOver.playOnce();
		Container contentPane = getContentPane();
		contentPane.setLayout(null);
		this.setSize(Frame_Width, Frame_Height);
		this.setResizable(false);
		this.setTitle("Game Over");
		this.setLocation(Frame_X, Frame_Y);
		
		//adds the continue to new game button
		cont = new JButton("Continue");
		cont.setBounds(150, 500, Button_Width, Button_Height);
		cont.addActionListener(this);
		contentPane.add(cont);
		
		//adds the quit button
		quit = new JButton("Quit");
		quit.setBounds(350, 500, Button_Width, Button_Height);
		quit.addActionListener(this);
		contentPane.add(quit);
		
		//adds the Game Over Image
		
		ImageIcon image = new ImageIcon(NewGame.class.getClassLoader().getResource("GameOver.png"));
		JLabel label = new JLabel (image);
		label.setBounds(0,0,Frame_Width, Frame_Height);
		contentPane.add(label);
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	public void actionPerformed(ActionEvent event) {
		JButton clicked = (JButton) event.getSource();
		String buttonTxt = clicked.getText();
		if(buttonTxt.equals("Continue")){
			StartScreen game = new StartScreen(test);
			gOver.turnOff();
			setVisible(false);
			test.repeat();
			game.setVisible(true);
		}
		if(buttonTxt.equals("Quit")){
			setVisible(false);
			test.turnOff();
		}
	}
}
