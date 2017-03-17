package Tile_Library;

import java.awt.Container;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Projectile_Tile extends Animated_Tile {
	protected int damage, range, rangeLoop;
	protected Tile shooter;
	private javax.swing.Timer projectileTimer;
	protected Tile[][] mapArr;
	public Projectile_Tile(int xPos, int yPos, int width, Container frame, String imageFile, int l, Tile owner, final Tile[][] mapArray, int dmg) {
		super(xPos, yPos, width, frame, imageFile, l);
		damage = dmg;
		moveSpeed = 15;
		shooter = owner;
		rangeLoop = 0;
		if (owner.imageFile.equals("Archer_Down.png")){
			range = 4;
		}
		else if(owner.imageFile.equals("Wizard_Down.png")){
			range = 3;
		}
		else if(owner.imageFile.equals("Warrior_Down.png")){
			range = 2;
		}
		
		mapArr = mapArray;
	}
	
	public int getDamage(){
		return damage;
	}
	
	public void setDamage(int dmg){
		damage = dmg;
	}
	
	public void inflictDamage(Tile t){
		if (t.getPassable() == false){
			SoundClipTest attack = new SoundClipTest("CS341_attack2.wav");
			attack.playOnce();
			if(t.getHP() > 0){
				t.setHP(t.getHP() - damage);
				System.out.println("DAMAGE DONE! ENEMY REMAINING HEALTH: " + t.getHP());
			}
			if(t.getHP() <= 0){
				t.setPassable(true);
				t.getLabel().setVisible(false);	
				if(t.getAttackTimer() != null){
					t.getAttackTimer().stop();
				}
			}
			this.getLabel().setVisible(false);
			projectileTimer.stop();
		}
	}
	
	public void shoot(){
		if(this.moving == false){
			if(shooter.getImageFile().equals("Wizard_Down.png")){
				SoundClipTest attackSFX = new SoundClipTest("Cs341_attack2.wav");
				attackSFX.playOnce();
			}
			else if(shooter.getImageFile().equals("Warrior_Down.png")){
				SoundClipTest attackSFX = new SoundClipTest("CS341_attack.wav");
				attackSFX.playOnce();
			}
			else{
				SoundClipTest attackSFX = new SoundClipTest("CS341_attack1.wav");
				attackSFX.playOnce();
			}
			dir = shooter.getDir();			
			this.setMapLocation(shooter.getMapX(), shooter.getMapY());
			this.getLabel().setVisible(true);
			projectileTimer = new javax.swing.Timer(1, new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Tile nextTile = null;
							if (dir == "UP"){
								if(getMapY() - 1 >= 0)
									nextTile = mapArr[getMapX()][getMapY()-1];
							}
							else if (dir == "DOWN"){
								if(getMapY() + 1 <= 10)
									nextTile = mapArr[getMapX()][getMapY()+1];
							}
							else if (dir == "LEFT"){
								if(getMapX() - 1 >= 0)
									nextTile = mapArr[getMapX()-1][getMapY()];
							}
							else if (dir == "RIGHT"){
								if(getMapX() + 1 <= 10)
									nextTile = mapArr[getMapX()+1][getMapY()];
							}
							System.out.println("CHECK---" + rangeLoop);				
					if (moving == false){
						move(getDir());
						if(nextTile != null){
							inflictDamage(nextTile);
						}
						rangeLoop = rangeLoop + 1;
						System.out.println("SHOOT");
						if (rangeLoop == range){
							projectileTimer.stop();
							rangeLoop = 0;
							getLabel().setVisible(false);
						}
					}
				}
			});
			projectileTimer.start();
		}
	}
	
	

}
