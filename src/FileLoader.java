import java.awt.*;
import java.io.*;
import Tile_Library.*;


public class FileLoader {

	private Container map;
	protected Tile[][] mapArr;
	private final int size = 11;

	public FileLoader(Container m, final Tile[][] mapArray ){
		
		map = m;
		mapArr = mapArray;
	}


	public Tile[][] makeMap(String textFile){


		Tile[][] tiles = new Tile [size][size];
		try{
			BufferedReader reader = new BufferedReader( new FileReader( textFile ));
			String str = reader.readLine();
			//int counter = 0;
			
			if( textFile.equals("map6.txt")){
				tiles[5][6] = new Tile( 5, 6, 64, map, "DungeonGround_Tile.png");
				
				tiles[3][7] = new Tile( 3, 7, 64, map, "DungeonGround_Tile.png");
				tiles[7][7] = new Tile( 7, 7, 64, map, "DungeonGround_Tile.png");
				tiles[4][7] = new Tile( 4, 7, 64, map, "DungeonGround_Tile.png");
				tiles[6][7] = new Tile( 6, 7, 64, map, "DungeonGround_Tile.png");
				tiles[5][9] = new Tile( 5, 9, 64, map, "DungeonGround_Tile.png");
				
				tiles[3][3] = new Tile( 3, 3, 64, map, "DungeonGround_Tile.png");
				tiles[3][5] = new Tile( 3, 5, 64, map, "DungeonGround_Tile.png");
				tiles[7][3] = new Tile( 7, 3, 64, map, "DungeonGround_Tile.png");
				tiles[7][5] = new Tile( 7, 5, 64, map, "DungeonGround_Tile.png");
				
				tiles[4][5] = new Tile( 4, 5, 64, map, "DungeonGround_Tile.png");
				tiles[6][5] = new Tile( 6, 5, 64, map, "DungeonGround_Tile.png");
				
				tiles[5][4] = new Tile( 5, 4, 64, map, "DungeonGround_Tile.png");
				tiles[7][4] = new Tile( 7, 4, 64, map, "DungeonGround_Tile.png");
				tiles[6][3] = new Tile( 6, 3, 64, map, "DungeonGround_Tile.png");
				tiles[3][4] = new Tile( 3, 4, 64, map, "DungeonGround_Tile.png");
				
				
				
				
			}
			for( int counter = 0; counter < size; counter++ ){
				for( int i = 0; i < size; i++ ){
					if( str.charAt(i) == 'w'){
						tiles[i][counter] = new Tile( i, counter, 64, map, "Water_Tile.png");
						tiles[i][counter].setPassable(false);
						//System.out.print( "w" );
					}
					else if( str.charAt(i) == 'g'){
						tiles[i][counter] = new Tile( i, counter, 64, map, "Grass_Tile.png");
						//System.out.print( "g" );
					}
					else if( str.charAt(i) == 'c'){
						tiles[i][counter] = new Tile( i, counter, 64, map, "Closed_Chest.png");
						tiles[i][counter].setPassable(true);
						//System.out.print( "c" );
					}
					else if(str.charAt(i) == 'o'){
						tiles[i][counter] = new Tile( i, counter, 64, map, "Opened_Chest.png");
						tiles[i][counter].setPassable(true);
					}
					else if( str.charAt(i) == 'z'){
						tiles[i][counter] = new Tile( i, counter, 64, map, "Goblin_Down.png");
						tiles[i][counter].setPassable(false);
						//System.out.print( "b" );
					}
					else if(str.charAt(i) == 'b'){
						tiles[i][counter] = new Tile( i, counter, 64, map, "Brick_Tile.png");
						tiles[i][counter].setPassable(false);
					}
					else if(str.charAt(i) == 's'){
						tiles[i][counter] = new Tile( i, counter, 64, map, "Sand_Tile.png");
						tiles[i][counter].setPassable(true);
					}
					else if(str.charAt(i) == 't'){
						tiles[i][counter] = new Tile( i, counter, 64, map, "Tree_Tile.png");
						tiles[i][counter].setPassable(false);
					}
					else if(str.charAt(i) == 'd'){
						tiles[i][counter] = new Tile( i, counter, 64, map, "DungeonGround_Tile.png");
						tiles[i][counter].setPassable(true);
					}
					else if(str.charAt(i) == 'D'){
						tiles[i][counter] = new Tile( i, counter, 64, map, "DungeonWall_Tile.png");
						tiles[i][counter].setPassable(false);
					}
					else if(str.charAt(i) == 'L'){
						tiles[i][counter] = new Tile( i, counter, 64, map, "CaveStal_Tile.png");
						tiles[i][counter].setPassable(false);
					}
					else if(str.charAt(i) == 'l'){
						tiles[i][counter] = new Tile( i, counter, 64, map, "Cave_Tile.png");
						tiles[i][counter].setPassable(true);
					}
					else if(str.charAt(i) == 'k'){
						tiles[i][counter] = new Tile( i, counter, 64, map, "key.png");
						tiles[i][counter].setPassable(true);
					}
					else if(str.charAt(i) == 'p'){
						tiles[i][counter] = new Animated_Tile( i, counter, 64, map, "Sword_Up.png", 5);
						tiles[i][counter].setPassable(false);
						tiles[i][counter].setPushable(true);
					}
					else if(str.charAt(i) == '!'){
						tiles[i][counter] = new Character_Tile( i, counter, 64, map, "Archer_Up.png", 6, mapArr, 1,2,3,1);
						tiles[i][counter].setDir("UP");
						tiles[i][counter].setPassable(false);
					}
					else if(str.charAt(i) == '@'){
						//tiles[i][counter] = new Character_Tile( i, counter, 64, map, "Soldier_Down.png", 6, mapArr, 1,2,3,1);
						tiles[i][counter] = new Tile( i, counter, 64, map, "Soldier_Down.png");
						tiles[i][counter].setPassable(false);
					}
					else if(str.charAt(i) == '#'){
						tiles[i][counter] = new Tile( i, counter, 64, map, "Skeleton_Down.png");
						tiles[i][counter].setPassable(false);
					}
					else if(str.charAt(i) == '*'){
						tiles[i][counter] = new Tile( i, counter, 64, map, "Bone_Left.png");
						tiles[i][counter].setPassable(true);
					}
					else if(str.charAt(i) == '^'){
						tiles[i][counter] = new Tile( i, counter, 64, map, "Bone_Up.png");
						tiles[i][counter].setPassable(true);
					}
					else if(str.charAt(i) == 'A'){
						tiles[i][counter] = new Tile( i, counter, 64, map, "Berns_Down.png");
						tiles[i][counter].setPassable(false);
					}
					else if(str.charAt(i) == 'E'){
						tiles[i][counter] = new Tile( i, counter, 64, map, "Portal.png");
						tiles[i][counter].setPassable(true);
					}
					else if( str.charAt(i) == '0'){
						tiles[i][counter] = new Door_Tile( i, counter, 64, map, "Walk_Tile.png", "map0.txt" );
						
						//System.out.print( "0" );
					}
					else if( str.charAt(i) == '1'){
						tiles[i][counter] = new Door_Tile( i, counter, 64, map, "Walk_Tile.png", "map1.txt" );
						//System.out.print( "1" );
					}
					else if( str.charAt(i) == '2'){
						tiles[i][counter] = new Door_Tile( i, counter, 64, map, "Walk_Tile.png", "map2.txt" );
						
						//System.out.print( "0" );
					}
					else if( str.charAt(i) == '3'){
						tiles[i][counter] = new Door_Tile( i, counter, 64, map, "Walk_Tile.png", "map3.txt" );
						
						//System.out.print( "0" );
					}
					else if( str.charAt(i) == '4'){
						tiles[i][counter] = new Door_Tile( i, counter, 64, map, "Walk_Tile.png", "map4.txt" );
						
						//System.out.print( "0" );
					}
					else if( str.charAt(i) == '5'){
						tiles[i][counter] = new Door_Tile( i, counter, 64, map, "Walk_Tile.png", "map5.txt" );
						
						//System.out.print( "0" );
					}
					else if( str.charAt(i) == '6'){
						tiles[i][counter] = new Door_Tile( i, counter, 64, map, "Walk_Tile.png", "map6.txt" );
						
						//System.out.print( "0" );
					}
					
					
				}
				str = reader.readLine();
				//System.out.println();
				//counter++;
			}
			reader.close();
		}
		catch (Exception e){
			System.out.println("error");
		}

		return tiles;
	}
}
