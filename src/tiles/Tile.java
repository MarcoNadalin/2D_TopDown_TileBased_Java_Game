package tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile
{
	public static Tile[] tiles = new Tile[64];
	public static Tile stoneTile = new StoneTile(0);
	public static Tile rockTile = new RockTile(1);
	
	public static final int TILE_WIDTH = 64, TILE_HEIGHT = 64;
	
	protected BufferedImage texture;
	protected final int ID;
	
	public Tile(BufferedImage texture, int id)
	{
		this.texture = texture;
		this.ID = id;
		
		tiles[id] = this;
	}
	
	public void tick()
	{
		
	}
	
	public void render(Graphics g, int x, int y)
	{
		g.drawImage(texture, x, y, TILE_WIDTH, TILE_HEIGHT, null);
	}
	
	public boolean isSolid()
	{
		return false;
	}
	
	public int getID()
	{
		return this.ID;
	}
	
}
