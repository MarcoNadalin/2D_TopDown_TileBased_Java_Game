package worlds;

import java.awt.Graphics;

import game.Handler;
import tiles.Tile;

public class World
{
	private Handler handler;
	private int width, height;
	private int spawnX, spawnY;
	private int[][] tiles;
	
	public World(Handler handler, String path)
	{
		this.handler = handler;
		loadWorld(path);
	}
	
	public void tick()
	{
		
	}
	
	public void render(Graphics g)
	{
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILE_WIDTH);
		int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILE_WIDTH + 1);
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILE_HEIGHT);
		int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILE_HEIGHT + 1);
		
		for(int y = yStart ; y < yEnd ; y++)
		{
			for(int x = xStart ; x < xEnd ; x++)
			{
				getTile(x,y).render(g, (int) (x * Tile.TILE_WIDTH - handler.getGameCamera().getxOffset()), 
						(int)  (y * Tile.TILE_HEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
	}
	
	public Tile getTile(int x, int y)
	{
		if( x < 0 || y < 0 || x >= width || y >= height)
		{
			return Tile.stoneTile;
		}
		
		Tile t = Tile.tiles[tiles[x][y]];
		if(t == null)
		{
			return Tile.stoneTile;
		}
		return t;
	}
	
	private void loadWorld(String path)
	{
		width = 5;
		height = 5;
		
		tiles = new int[width][height];
		
		for(int x = 0 ; x < width ; x++)
		{
			for(int y = 0 ; y < height ; y++)
			{
				tiles[x][y] = 0;
			}
		}
		
		tiles[3][3] = 1;
	}
}
