package Tile_Library;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;


@SuppressWarnings("serial")
public class Character_Tile extends Animated_Tile{

	protected int health, strength, defense, damage, attackDelay;
	protected Tile[][] mapArr;
	protected String projImage;
	protected Projectile_Tile charProj;
	public Character_Tile(int xPos, int yPos, int width, Container frame, String imageFile, int l, final Tile[][] mapArray, int h, int s, int d, int dam) {
		super(xPos, yPos, width, frame, imageFile, l);
		hp = h;
		strength = s;
		defense = d;
		damage = dam;
		mapArr = mapArray;
		attackDelay = 15;
		projImage = "Arrow_Down.png";
		System.out.println(imageFile);
		if( image.equals("Archer")){
			projImage = "Arrow_Down.png";
		}
		else if(image.equals("Wizard")){
			projImage = "Blast_Down.png";
		}
		else if(image.equals("Warrior") || image.equals("Soldier")){
			projImage = "Sword_Down.png";
		}
		//projImage = "Blast_Down.png";
		System.out.println(projImage);
		
		charProj = new Projectile_Tile(this.getMapX(), this.getMapY(), tileSize, frame, projImage, 5, this, mapArr, 2);
		charProj.getLabel().setVisible(false);
		setPassable(false);
		this.keepAttacking();
	}
	
	public void attack(){
		this.charProj.shoot();
	}
	
	public void keepAttacking(){
		attackTimer = new javax.swing.Timer(attackDelay, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				charProj.shoot();
			
			}
		});
		this.attackTimer.start();
	}
	
	public void stopAttacking(){
		this.attackTimer.stop();
	}
	

}
