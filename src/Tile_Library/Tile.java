/**Author: Nicholas Frank
 * Date: 3/06/2014
 * This is a parent "Tile" class that will be used to create an array of specific tiles with specific 
 * properties to create a game "map".
 */
package Tile_Library;
import java.awt.*;
import javax.swing.*;


public class Tile{
	protected boolean passable, pushable;
	protected int mapX, mapY, x, y, tileSize;
	protected ImageIcon img;
	protected JLabel tile;
	protected Container window;
	protected String dir, imageFile;
	protected int hp;
	protected javax.swing.Timer attackTimer;
	
	public Tile(int xPos, int yPos, int width, Container frame, String image){
		passable = true;
		pushable = false;
		mapX = xPos;
		mapY = yPos;
		hp = 6;
		attackTimer = null;
		imageFile = image;
		System.out.println("Tile Constructor ran");
		//System.out.println("Char X,Y: " + xPos + ", " + yPos);	
		tileSize = width;
		window = frame;
		dir = "DOWN";
		img = new ImageIcon(Tile.class.getClassLoader().getResource(imageFile));
		tile = new JLabel(img);
		this.setMapLocation(mapX, mapY);
		window.add(tile, 0);						
		System.out.println("constructor ran");
	}
	
	/** Passable Methods and Checks**/
	public void setPassable(boolean p){
		if (p == true){
			passable = true;
		}
		else{
			passable = false;
		}	
	}
	
	public boolean getPassable(){
		return passable;
	}
	
	public boolean checkPassable( Tile t1 ){
		if (t1.getPassable() == true){
			return true;
		}
		else{
			return false;
		}
	}
	
	/** Pushable Methods and Checks**/
	public void setPushable(boolean p){
		if (p == true){
			pushable = true;
		}
		else{
			pushable = false;
		}	
	}
	
	public boolean getPushable(){
		return pushable;
	}
	
	public boolean checkPushable( Tile t1 ){
		if (t1.getPushable() == true){
			return true;
		}
		else{
			return false;
		}
	}
	
	
	/** Returns the Direction of this object**/
	public String getDir(){
		return dir;
	}
	/** Sets the Direction of this object**/
	public void setDir(String direction){
		dir = direction;
	}
	
	/** Sets the location of our tile in a map or two dimensional array**/
	public void setMapLocation(int xPos, int yPos){
		//System.out.println("Char X,Y: " + xPos + ", " + yPos);
		mapX = xPos;
		mapY = yPos;
		setTileBounds(mapX*tileSize, mapY*tileSize, tileSize);
	}
	
	/** Sets the ACTUAL (X,Y) coordinates in a container of our tile**/
	protected void setTileBounds(int xPos, int yPos, int width){
		//System.out.println("Char X,Y: " + xPos + ", " + yPos);
		x = xPos;
		y = yPos;
		tileSize = width;
		tile.setBounds(x, y, tileSize, tileSize);
	}
	
	public void move(String d){
		return;
	}
	
	/** Returns this tiles X location in a map or two dimensional array**/
	public int getMapX(){
		return mapX;
	}
	
	/** Returns this tiles Y location in a map or two dimensional array**/
	public int getMapY(){
		return mapY;
	}
		
	/** Returns the JLabel object containing the Image Icon for this tile**/
	public JLabel getLabel()
	{
		return tile;
	}	
	
	public int getHP(){
		return hp;
	}
	
	public void setHP( int h){
		hp = h;
	}
	
	public String getImageFile(){
		return imageFile;
	}
	
	public Timer getAttackTimer(){
		return attackTimer;
	}
	
	public String getNextMap(){
		return "";
	}
	
	public Container getContainer(){
		return window;
	}

}
