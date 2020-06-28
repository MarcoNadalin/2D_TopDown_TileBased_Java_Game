package tiles;

import graphics.Assets;

public class RockTile extends Tile
{
	public RockTile(int id)
	{
		super(Assets.wall, id);
	}
	
	@Override
	public boolean isSolid()
	{
		return true;
	}
}
