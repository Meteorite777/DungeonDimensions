package Tile_Library;
import java.awt.*;
public class Door_Tile extends Tile{
	protected String connectedMap, tileType;

	public Door_Tile(int xPos, int yPos, int width, Container frame, String image, String nextMap) {
		super(xPos, yPos, width, frame, image);
		connectedMap = nextMap;
	}
	
	public String getNextMap(){
		return connectedMap;
	}
	
	public String getTileType(){
		return tileType;
	}

}
