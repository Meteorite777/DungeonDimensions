import javax.swing.*;

import Tile_Library.*;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameWindow implements KeyListener, ActionListener  {
	
	private String projDir;
	private JFrame frame;
	private JPanel map, hpBar, defBar, strBar;
	private JLabel health, strength, defense, keyLabel;
	private Tile[][] mapArray;
	private Character_Tile player1;
	final int frameSize, tileCount, tileSize, mapSize;
	private ImageIcon Opened_Chest;		
	private String selectedPlayer, stat;
	private JButton options;
	private int length;
	public SoundClipTest test, chest;
	private int playerHp, playerStr, playerDef, keys;
	private Projectile_Tile playerProj;
	private Menu m;
	private FileLoader file;
	
	public GameWindow(String select){
		m = new Menu(test);
		length = select.length();
		selectedPlayer = select + "_Down.png";
		frameSize = 900;
		tileCount = 11;
		tileSize = 64;
		mapSize = tileCount * tileSize;
		
		frame = new JFrame("Dungeon Dimensions");
		//frame.setResizable(false);
		frame.setLayout(null);
		map = new JPanel();
		map.setLayout(null);
		frame.setSize(frameSize, frameSize);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(map);
		
		health = new JLabel("Health: ");
		health.setBounds(20,0,50,30);
		frame.add(health);
		hpBar = new JPanel();
		defense = new JLabel("Defense: ");
		defense.setBounds(20,20,70,30);
		frame.add(defense);
		defBar = new JPanel();
		strength = new JLabel("Strength: ");
		strength.setBounds(20,40,70,30);
		strBar = new JPanel();
		frame.add(strength);
		keys = 0;
		keyLabel = new JLabel("Keys: " + keys);
		keyLabel.setBounds(20,60,70,30);
		frame.add(keyLabel);
		
		
		//allows an in-game menu to appear
		options = new JButton("Options");
		options.setBounds(700,0,100,50);
		options.addActionListener(this);
		options.setFocusable(false);
		frame.add(options);
		map.setVisible(true);
		map.setBounds((frameSize-mapSize)/2,(frameSize-mapSize)/2, mapSize, mapSize);
		mapArray = new Tile[tileCount][tileCount];
		frame.addKeyListener(this);
		//puts focus on the KeyListener
		frame.setFocusable(true);
		
		/**Set Player Stats**/
		stat = selectedPlayer.substring(0, length);
		if(stat.equals("Wizard")){
			playerHp = 10;
			playerStr = 6;
			playerDef = 2;
		}
		if(stat.equals("Warrior")){
			playerHp = 20;
			playerStr = 3;
			playerDef = 5;
		}
		if(stat.equals("Archer")){
			playerHp = 15;
			playerStr = 4;
			playerDef = 3;
		}
		
		/**Load Player Attribute Bars**/
		hpBar.setBounds(120, 0, playerHp*20, 20);
		hpBar.setBackground(Color.red);
		frame.add(hpBar);
		
		strBar.setBounds(120, 50, playerStr*20,20);
		strBar.setBackground(Color.blue);
		frame.add(strBar);

		defBar.setBounds(120, 25, playerDef*20,20);
		defBar.setBackground(Color.green);
		frame.add(defBar);
		
		
		/**force repaint**/
		frame.setSize(frameSize + 1, frameSize + 1);
		frame.setSize(frameSize, frameSize);	
		
		makeMaps( "map0.txt", 0, 0);
	}
	
	public void makeMaps( String f, int x , int y){

		file = new FileLoader(map, mapArray);
		
		/**Load Grass Tiles**/
		
		for (int i = 0; i < 11; i++){
			for (int j = 0; j < 11; j++){	
				mapArray[i][j] = new Tile(i,j, tileSize, map, "Grass_Tile.png");
			}
		}
		mapArray = file.makeMap(f);
		player1 = new Character_Tile(x, y, tileSize,map, selectedPlayer, length, mapArray, playerHp, playerStr, playerDef, 2);
		player1.stopAttacking();
		
		//mapArray[10][10] = new Tile(9,9,tileSize,map, "Brick_Tile.png");
		
		/**force repaint**/
		frame.setSize(frameSize + 1, frameSize + 1);
		frame.setSize(frameSize, frameSize);
	}
	
	

	@Override
	public void keyPressed(KeyEvent e) {
		//Move up
		if (e.getKeyCode() == m.getUp()){
			if (player1.moving == false && player1.getMapY() - 1 >= 0 ){
				try{
					if (player1.checkPassable(mapArray[player1.getMapX()][player1.getMapY() - 1]) == true){
						player1.move("UP");	  	
						
						// Attempt to change maps
						if( mapArray[player1.getMapX()][player1.getMapY()-1].getImageFile() == "Walk_Tile.png"){
							//System.out.println( "TEST: " + player1.getMapX() + "    " + player1.getMapY() );
							//System.out.println(mapArray[10][3].getNextMap() );
							int x,y;
							// Figure out where x location of character in next map
							//System.out.println( tileCount + "      " + player1.getMapX() );
							if( player1.getMapX() == tileCount-1 ){
								x = 0;
							}
							else if( player1.getMapX() == 0 ){
								x = tileCount-1;
							}
							else{
								x = player1.getMapX();
							}
							// Figure out where y location of character in next map
							if( player1.getMapY()-1 == tileCount-1 ){
								y = 0;
							}
							else if( player1.getMapY()-1 == 0 ){
								y = tileCount-1;
							}
							else{
								y = player1.getMapY()-1;
							}
							makeMaps( mapArray[player1.getMapX()][player1.getMapY()-1].getNextMap(), x, y );	
						}
						if( mapArray[player1.getMapX()][player1.getMapY()-1].getImageFile() == "Portal.png"){
							loseHealth(999);
						}
					}
				}
				catch(ArrayIndexOutOfBoundsException e1){
					
				}
			}
		}
			
		//Move left
		else if (e.getKeyCode() == m.getLeft()){
			if (player1.moving == false && player1.getMapX() - 1 >= 0){
				try{
					if (player1.checkPassable(mapArray[player1.getMapX() - 1][player1.getMapY()]) == true){
						player1.move("LEFT");	 
						
						// Attempt to change maps
						if( mapArray[player1.getMapX()-1][player1.getMapY()].getImageFile() == "Walk_Tile.png"){
							//System.out.println( "TEST: " + player1.getMapX() + "    " + player1.getMapY() );
							//System.out.println(mapArray[10][3].getNextMap() );
							int x,y;
							// Figure out where x location of character in next map
							//System.out.println( tileCount + "      " + player1.getMapX() );
							if( player1.getMapX()-1 == tileCount-1 ){
								x = 0;
							}
							else if( player1.getMapX()-1 == 0 ){
								x = tileCount-1;
							}
							else{
								x = player1.getMapX() - 1;
							}
							// Figure out where y location of character in next map
							if( player1.getMapY() == tileCount-1 ){
								y = 0;
							}
							else if( player1.getMapY() == 0 ){
								y = tileCount-1;
							}
							else y = player1.getMapY();{
								makeMaps( mapArray[player1.getMapX()-1][player1.getMapY()].getNextMap(), x, y );
							}
						}
						if( mapArray[player1.getMapX()-1][player1.getMapY()].getImageFile() == "Portal.png"){
							loseHealth(999);
						}
					}
				}
				catch(ArrayIndexOutOfBoundsException e1){
					
				}
			}	
		}
		
		//Move down
		else if (e.getKeyCode() == m.getDown()){
			if (player1.moving == false && player1.getMapY() + 1 <= tileCount){
				try{
					if (player1.checkPassable(mapArray[player1.getMapX()][player1.getMapY() + 1]) == true){
						player1.move("DOWN");	  	
						
						// Attempt to change maps
						if( mapArray[player1.getMapX()][player1.getMapY()+1].getImageFile() == "Walk_Tile.png"){
							//System.out.println( "TEST: " + player1.getMapX() + "    " + player1.getMapY() );
							//System.out.println(mapArray[10][3].getNextMap() );
							int x,y;
							// Figure out where x location of character in next map
							//System.out.println( tileCount + "      " + player1.getMapX() );
							if( player1.getMapX() == tileCount-1 ){
								x = 0;
							}
							else if( player1.getMapX() == 0 ){
								x = tileCount-1;
							}
							else{
								x = player1.getMapX();
							}
							// Figure out where y location of character in next map
							if( player1.getMapY()+1 == tileCount-1 ){
								y = 0;
							}
							else if( player1.getMapY()+1 == 0 ){
								y = tileCount-1;
							}
							else{
								y = player1.getMapY();
							
							}
								makeMaps( mapArray[player1.getMapX()][player1.getMapY() +1].getNextMap(), x, y );
							}
						if( mapArray[player1.getMapX()][player1.getMapY() + 1].getImageFile() == "Portal.png"){
							loseHealth(999);
						}
					}
				}
				catch(ArrayIndexOutOfBoundsException e1){
					
				}
			}
		}
		
		//Move right
		else if (e.getKeyCode() == m.getRight()){	
			if (player1.moving == false && player1.getMapX() + 1 <= tileCount){
				try{
					if (player1.checkPassable(mapArray[player1.getMapX() + 1][player1.getMapY()]) == true){
						player1.move("RIGHT");	  	
						
						// Attempt to change maps
						if( mapArray[player1.getMapX()+1][player1.getMapY()].getImageFile() == "Walk_Tile.png"){
							//System.out.println( "TEST: " + player1.getMapX() + "    " + player1.getMapY() );
							//System.out.println(mapArray[10][3].getNextMap() );
							int x,y;
							// Figure out where x location of character in next map
							//System.out.println( tileCount + "      " + player1.getMapX() );
							if( player1.getMapX()+1 == tileCount-1 ){
								x = 0;
							}
							else if( player1.getMapX()+1 == 0 ){
								x = tileCount-1;
							}
							else{
								x = player1.getMapX()+1;
							}
							// Figure out where y location of character in next map
							if( player1.getMapY() == tileCount-1 ){
								y = 0;
							}
							else if( player1.getMapY() == 0 ){
								y = tileCount-1;
							}
							else{
								y = player1.getMapY();
							}
								makeMaps( mapArray[player1.getMapX()+1][player1.getMapY()].getNextMap(), x, y );
							}
						if( mapArray[player1.getMapX()+1][player1.getMapY()].getImageFile() == "Portal.png"){
							loseHealth(999);
						}
					}
				}
				catch(ArrayIndexOutOfBoundsException e1){
					
				}
			}
		}
		
		else if (e.getKeyCode() == KeyEvent.VK_SPACE){		
			//loseHealth(2);
				try{
					
					if(selectedPlayer.substring(0,length).equals("Wizard")){
						SoundClipTest attackSFX = new SoundClipTest("Cs341_attack2.wav");
						attackSFX.playOnce();
						}else{
						SoundClipTest attackSFX = new SoundClipTest("CS341_attack1.wav");
						attackSFX.playOnce();
						}
					player1.attack();
				}
				catch(Exception e1){
					System.out.println("BROKE");
				}
			
		}
		
		else if(e.getKeyCode() == KeyEvent.VK_E){
			try{
				if(mapArray[player1.getMapX()][player1.getMapY()].getImageFile().equals("key.png")){
					keys = keys + 1;
					keyLabel.setText("Keys: " + keys);
					mapArray[player1.getMapX()][player1.getMapY()] = new Tile(player1.getMapX(),player1.getMapY(), tileSize, map, "Grass_Tile.png");
					/**force repaint**/
					frame.setSize(frameSize + 1, frameSize + 1);
					frame.setSize(frameSize, frameSize);		
				}
				else if(mapArray[player1.getMapX()][player1.getMapY()].getImageFile().equals("Closed_Chest.png") && keys > 0){
					keys = keys - 1;
					keyLabel.setText("Keys: " + keys);
					chest = new SoundClipTest("CS341_chest1.wav");
					chest.playOnce();
					mapArray[player1.getMapX()][player1.getMapY()] = new Tile(player1.getMapX(),player1.getMapY(), tileSize, map, "Opened_Chest.png");
					gainHealth(1);
					/**force repaint**/
					frame.setSize(frameSize + 1, frameSize + 1);
					frame.setSize(frameSize, frameSize);	
				}
				pushTile();
				
			}
			catch(Exception e2){
				System.out.println("Use Button Error");
				e2.printStackTrace();
			}
		}
		else if(e.getKeyCode() == KeyEvent.VK_R){
			loseHealth(1);
		}
	}

	//Unused Method for KeyListener Interface
	@Override
	public void keyReleased(KeyEvent e) {	
	}
	
	//Unused Method for KeyListener Interface
	@Override
	public void keyTyped(KeyEvent e) {
	}


	//creates the in-game menu
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		JButton clicked = (JButton) event.getSource();
		String buttonTxt = clicked.getText();
		if(buttonTxt.equals("Options")){
			m.setVisible(true);
		}
	}
	//method to set the stats depending on which character you chose
	public void setStats(int h, int s, int d, JFrame f){
		
			hpBar.setBounds(120, 0, h *20, 20);
			defBar.setBounds(120, 25, d*20,20);
			strBar.setBounds(120, 50, s*20,20);
	}
	
	public void loseHealth(int damage ){
		playerHp = playerHp - damage;
		hpBar.setBounds(120, 0, playerHp*20, 20);
		if(playerHp <= 0){
			GameOverScreen youSuck = new GameOverScreen(test);
			frame.setVisible(false);
			youSuck.setVisible(true);
			
		}
	}
	
	public void gainHealth(int gained){
		playerHp = playerHp + gained;
		hpBar.setBounds(120, 0, playerHp*20, 20);
	}
	
	private void pushTile(){
			if(player1.getDir() == "UP" && player1.getMapY() > 0 && mapArray[player1.getMapX()][player1.getMapY()-1].getPushable() == true){
				Tile pushTile = mapArray[player1.getMapX()][player1.getMapY()-1];
				//pushTile.setPassable(true);
				pushTile.move("UP");
				//pushTile.setPassable(false);
			}
			else if(player1.getDir() == "DOWN" && player1.getMapY() < 10 && mapArray[player1.getMapX()][player1.getMapY()+1].getPushable() == true){
				Tile pushTile = mapArray[player1.getMapX()][player1.getMapY()+1];
				pushTile.move("DOWN");
			}
			else if(player1.getDir() == "LEFT" && player1.getMapX() > 0 && mapArray[player1.getMapX()-1][player1.getMapY()].getPushable() == true){
				Tile pushTile =  mapArray[player1.getMapX()-1][player1.getMapY()];
				pushTile.move("LEFT");
			}
			else if(player1.getDir() == "RIGHT" && player1.getMapY() < 10 && mapArray[player1.getMapX()+1][player1.getMapY()].getPushable() == true){
				Tile pushTile = mapArray[player1.getMapX()+1][player1.getMapY()];
				pushTile.move("RIGHT");
			}
	}
}
