package graphics;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class Assets
{
	private static final int width = 32, height = 32;
	
	public static BufferedImage stone, wall;
	public static BufferedImage[] player_down, player_up, player_left, player_right;
	
	public static void init()
	{
		SpriteSheet playerSprites = new SpriteSheet(ImageLoader.loadImage("/textures/linkFormatted.png"));
		SpriteSheet stones = new SpriteSheet(ImageLoader.loadImage
				("/textures/dungeon_tiles_formatted_v2.png"));
		//player = playerSprites.crop(0, 0, width, height);
		
		player_down = new BufferedImage[11];
		player_up = new BufferedImage[7];
		player_left = new BufferedImage[8];
		player_right = new BufferedImage[8];
		
		//player_up[0] = playerSprites.crop(width * 0, height * 3, width, height);
		player_up[0] = playerSprites.crop(width * 1, height * 3, width, height);
		player_up[1] = playerSprites.crop(width * 2, height * 3, width, height);
		player_up[2] = playerSprites.crop(width * 3, height * 3, width, height);
		player_up[3] = playerSprites.crop(width * 4, height * 3, width, height);
		player_up[4] = playerSprites.crop(width * 5, height * 3, width, height);
		player_up[5] = playerSprites.crop(width * 6, height * 3, width, height);
		player_up[6] = playerSprites.crop(width * 7, height * 3, width, height);
		
		player_left[0] = playerSprites.crop(width * 0, height * 1, width, height);
		player_left[1] = playerSprites.crop(width * 1, height * 1, width, height);
		player_left[2] = playerSprites.crop(width * 2, height * 1, width, height);
		player_left[3] = playerSprites.crop(width * 3, height * 1, width, height);
		player_left[4] = playerSprites.crop(width * 4, height * 1, width, height);
		player_left[5] = playerSprites.crop(width * 5, height * 1, width, height);
		player_left[6] = playerSprites.crop(width * 6, height * 1, width, height);
		player_left[7] = playerSprites.crop(width * 7, height * 1, width, height);
		
		player_right[0] = playerSprites.crop(width * 0, height * 0, width, height);
		player_right[1] = playerSprites.crop(width * 1, height * 0, width, height);
		player_right[2] = playerSprites.crop(width * 2, height * 0, width, height);
		player_right[3] = playerSprites.crop(width * 3, height * 0, width, height);
		player_right[4] = playerSprites.crop(width * 4, height * 0, width, height);
		player_right[5] = playerSprites.crop(width * 5, height * 0, width, height);
		player_right[6] = playerSprites.crop(width * 6, height * 0, width, height);
		player_right[7] = playerSprites.crop(width * 7, height * 0, width, height);
		
		//player_down[0] = playerSprites.crop(width * 0, height * 2, width, height);
		player_down[0] = playerSprites.crop(width * 1, height * 2, width, height);
		player_down[1] = playerSprites.crop(width * 2, height * 2, width, height);
		player_down[2] = playerSprites.crop(width * 3, height * 2, width, height);
		player_down[3] = playerSprites.crop(width * 4, height * 2, width, height);
		//player_down[5] = playerSprites.crop(width * 5, height * 2, width, height);
		player_down[4] = playerSprites.crop(width * 6, height * 2, width, height);
		player_down[5] = playerSprites.crop(width * 7, height * 2, width, height);
		
		player_down[6] = playerSprites.crop(width * 6, height * 2, width, height);
		//player_down[9] = playerSprites.crop(width * 5, height * 2, width, height);
		player_down[7] = playerSprites.crop(width * 4, height * 2, width, height);
		player_down[8] = playerSprites.crop(width * 3, height * 2, width, height);
		player_down[9] = playerSprites.crop(width * 2, height * 2, width, height);
		player_down[10] = playerSprites.crop(width * 1, height * 2, width, height);

		
		stone  = stones.crop(0, 0, width, height);
		//wall = stones.crop(1 * width, 5 * height, width, height);
		wall = new BufferedImage(64, 64, 1);
	}
}
