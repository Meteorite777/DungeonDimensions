import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class NewGame extends JFrame implements ActionListener {

	public static final int Frame_Width = 600;
	public static final int Frame_Height = 600;
	public static final int Frame_X = 350;
	public static final int Frame_Y = 100;
	public static final int Button_Width = 100;
	public static final int Button_Height = 30;
	private JButton archer, wizard, warrior, berns;
	private JLabel pick, hp1, hp2, hp3, s1, s2, s3, d1, d2, d3;
	private SoundClipTest test;
	
	public NewGame(SoundClipTest t) {
		test = t;
		Container contentPane = getContentPane();
		contentPane.setLayout(null);
		setSize(Frame_Width, Frame_Height);
		setResizable(false);
		setTitle("New Game");
		setLocation(Frame_X, Frame_Y);
		archer = new JButton("Archer");
		archer.setBounds(75, 250, Button_Width, Button_Height);
		archer.addActionListener(this);
		contentPane.add(archer);
		hp1 = new JLabel("Health:  15");
		hp1.setBounds(85, 300, 100, 30);
		hp1.setFont(new Font("Serif", Font.PLAIN, 14));
		contentPane.add(hp1);
		s1 = new JLabel("Strength:  4");
		s1.setBounds(85, 350, 100, 30);
		s1.setFont(new Font("Serif", Font.PLAIN, 14));
		contentPane.add(s1);
		d1 = new JLabel("Defense:  3");
		d1.setBounds(85, 400, 100, 30);
		d1.setFont(new Font("Serif", Font.PLAIN, 14));
		contentPane.add(d1);
		wizard = new JButton("Wizard");
		wizard.setBounds(250, 250, Button_Width, Button_Height);
		wizard.addActionListener(this);
		contentPane.add(wizard);
		hp2 = new JLabel("Health:  10");
		hp2.setBounds(275, 300, 100, 30);
		hp2.setFont(new Font("Serif", Font.PLAIN, 14));
		contentPane.add(hp2);
		s2 = new JLabel("Strength:  6");
		s2.setBounds(275, 350, 100, 30);
		s2.setFont(new Font("Serif", Font.PLAIN, 14));
		contentPane.add(s2);
		d2 = new JLabel("Defense:  2");
		d2.setBounds(275, 400, 100, 30);
		d2.setFont(new Font("Serif", Font.PLAIN, 14));
		contentPane.add(d2);
		warrior = new JButton("Warrior");
		warrior.setBounds(425, 250, Button_Width, Button_Height);
		warrior.addActionListener(this);
		contentPane.add(warrior);
		hp3 = new JLabel("Health:  20");
		hp3.setBounds(450, 300, 100, 30);
		hp3.setFont(new Font("Serif", Font.PLAIN, 14));
		contentPane.add(hp3);
		s3 = new JLabel("Strength:  3");
		s3.setBounds(450, 350, 100, 30);
		s3.setFont(new Font("Serif", Font.PLAIN, 14));
		contentPane.add(s3);
		d3 = new JLabel("Defense:  5");
		d3.setBounds(450, 400, 100, 30);
		d3.setFont(new Font("Serif", Font.PLAIN, 14));
		contentPane.add(d3);
		
		//SECRET BUTTON
		berns = new JButton("");
		berns.setBounds(0, 0, 5, 5);
		berns.addActionListener(this);
		contentPane.add(berns);
		
		pick = new JLabel( "CHOOSE A CHARACTER!");
		pick.setBounds(25, 0, Frame_Width, 100);
		pick.setFont(new Font("Serif", Font.PLAIN, 48));
		contentPane.add(pick);
		
		ImageIcon image = new ImageIcon (NewGame.class.getResource("Wizard_Down.png"));
		JLabel label = new JLabel(image);
		label.setBounds(265, 150, 80, 80);
		contentPane.add(label);
		
		ImageIcon image2 = new ImageIcon (NewGame.class.getResource("Warrior_Down.png"));
		JLabel label2 = new JLabel(image2);
		label2.setBounds(435, 150, 80, 80);
		contentPane.add(label2);
		
		ImageIcon image3 = new ImageIcon (NewGame.class.getResource("Archer_Down.png"));
		JLabel label3 = new JLabel(image3);
		label3.setBounds(90, 150, 80, 80);
		contentPane.add(label3);
	}
	
	public void actionPerformed(ActionEvent event) {
		JButton clicked = (JButton) event.getSource();
		String buttonTxt = clicked.getText();
		if (buttonTxt.equals("Archer")){
			GameWindow g = new GameWindow("Archer");
			setVisible(false);
		    //g.setVisible(true);
		}else if(buttonTxt.equals("Warrior")){
			GameWindow g = new GameWindow("Warrior");
			setVisible(false);
			//g.setVisible(true);
		}else if(buttonTxt.equals("Wizard")){
			GameWindow g = new GameWindow("Wizard");
			setVisible(false);
			//g.setVisible(true);
		}else if(buttonTxt.equals("")){
			GameWindow g = new GameWindow("Berns");
			setVisible(false);
			//g.setVisible(true);
		}
		
	}

}
