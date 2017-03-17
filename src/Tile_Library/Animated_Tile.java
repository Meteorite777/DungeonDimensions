/**Author: Nicholas Frank
 * Date: 2/23/2014
 * This is a parent "Tile" class that will be used to create an array of specific tiles with specific 
 * properties to create a game "map".
 */
package Tile_Library;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Animated_Tile extends Tile{
	public boolean moving;
	protected int moveSpeed, animTimer, animationFrames;
	protected javax.swing.Timer animationTimer;
	protected String image, fUp, fLeft, fRight;
	protected ImageIcon img1, img2, img3;
	
	public Animated_Tile(int xPos, int yPos, int width, Container frame, String imageFile, int l){		
		super(xPos, yPos, width, frame, imageFile);
		image = imageFile.substring(0, l);
		System.out.println(image);
		fUp = image + "_Up.png";
		img1 = new ImageIcon(Tile.class.getClassLoader().getResource(fUp));
		fLeft = image + "_Left.png";
		img2 = new ImageIcon(Tile.class.getClassLoader().getResource(fLeft));
		fRight = image + "_Right.png";
		img3 = new ImageIcon(Tile.class.getClassLoader().getResource(fRight));
		
		/** Animation Variables**/
		moving = false;		
		moveSpeed = 25;				//Lower this to increase animation speed
		animationFrames = 16;		//Increase this smooth out animation, but it will take longer
		animTimer = 0;
		System.out.println("1Char X,Y: " + this.getMapX() + ", " + this.getMapY());
		System.out.println("constructor ran");
	}
	
	public void setPassable(boolean p){
		super.setPassable(p);
	}
	
	/** Checks if a given tile is passable or not **/
	
	public boolean getPassable(){
		return passable;
	}
	
	/** Sets the location of our tile in a map or two dimensional array**/
	public void setMapLocation(int xPos, int yPos){
		System.out.println("2Char X,Y: " + xPos + ", " + yPos);
		super.setMapLocation(xPos, yPos);
	}
	
	/** Returns this tiles X location in a map or two dimensional array**/
	public int getMapX(){
		return mapX;
	}
	
	/** Returns this tiles Y location in a map or two dimensional array**/
	public int getMapY(){
		return mapY;
	}
		
	/** Sets the ACTUAL (X,Y) coordinates in a container of our tile**/
	protected void setTileBounds(int xPos, int yPos, int width){
		System.out.println("3Char X,Y: " + xPos + ", " + yPos);
		super.setTileBounds(xPos, yPos, width);
	}
	
	/** Returns the JLabel object containing the Image Icon for this tile**/
	public JLabel getLabel()
	{
		return tile;
	}
	
	/** Returns the Direction of this object**/
	public String getDir(){
		return dir;
	}
	/** Sets the Direction of this object**/
	public void setDir(String direction){
		dir = direction;
	}
	
		
	/** Method to move a tile using Swing Timers for animation**/
	public void move(String d){
		moving = true;
		dir = d;
		
		//We must check if we are in the middle of an Animation and if so, don't do anything.
		if (animTimer == 0){	
			//Creating a timer and instantiating it with our timer delay (movespeed) and a listener.
			animationTimer = new javax.swing.Timer(moveSpeed, new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//Moves tile Up
					if (dir == "UP"){
						y = y - (tileSize/animationFrames);
						tile.setIcon(img1);
						setTileBounds(x, y, tileSize);					
						System.out.println(x + ", " + y);
						System.out.println("Anim: " + animTimer);
						animTimer++;
						if (animTimer > animationFrames - 1){
							animationTimer.stop();
							animTimer = 0;
							mapY--;
							moving = false;
							System.out.println("MOVING = FALSE");
						}
					}
					//Moves tile Left
					else if (dir == "LEFT"){
						x = x - (tileSize/animationFrames);
						tile.setIcon(img2);
						setTileBounds(x, y, tileSize);
						System.out.println(x + ", " + y);
						System.out.println("Anim: " + animTimer);
						animTimer++;
						if (animTimer > animationFrames - 1){
							animationTimer.stop();
							animTimer = 0;	 	
							moving = false;
							mapX--;
							System.out.println("MOVING = FALSE");
						}
					}
					//Moves tile Down
					else if (dir == "DOWN"){
						y = y + (tileSize/animationFrames);
						tile.setIcon(img);
						setTileBounds(x, y, tileSize);
						System.out.println(x + ", " + y);
						System.out.println("Anim: " + animTimer);
						animTimer++;
						if (animTimer > animationFrames - 1){
							animationTimer.stop();
							animTimer = 0;
							moving = false;
							mapY++;
							System.out.println("MOVING = FALSE");
						}
					}
					//Moves tile Right
					else if (dir == "RIGHT"){
						x = x + (tileSize/animationFrames);
						tile.setIcon(img3);
						setTileBounds(x, y, tileSize);
						System.out.println(x + ", " + y);
						System.out.println("Anim: " + animTimer);
						animTimer++;
						//Check Health Loss
						if (animTimer > animationFrames - 1){
							animationTimer.stop();
							animTimer = 0;
							moving = false;
							mapX++;
							System.out.println("MOVING = FALSE");
						}
					}
				}	          
			});
			animationTimer.start();
				
		}
	}
		

}
