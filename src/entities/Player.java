package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import game.Handler;
import graphics.Animation;
import graphics.Assets;

public class Player extends Creature
{	
	//Animations
	private Animation animDown, animUp, animLeft, animRight, animIdle;
	
	public Player(Handler handler, float x, float y)
	{
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		
		bounds.x = 16;
		bounds.y = 32;
		bounds.width = 32;
		bounds.height = 32;
		
		//animations
		animDown = new Animation(90, Assets.player_down);
		animUp = new Animation(75, Assets.player_up);
		animLeft = new Animation(75, Assets.player_left);
		animRight = new Animation(75, Assets.player_right);
		animIdle = new Animation(90, Assets.player_down);
	}

	@Override
	public void tick()
	{
		//Animations
		animDown.tick();
		animLeft.tick();
		animRight.tick();
		animUp.tick();
		
		//Animations
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
		System.out.println(x);
	}
	
	private void getInput()
	{
		xMove = 0;
		yMove = 0;
		if(handler.getKeyManager().up)
			yMove = -speed;
		if(handler.getKeyManager().down)
			yMove = speed;
		if(handler.getKeyManager().left)
			xMove = -speed;
		if(handler.getKeyManager().right)
			xMove = speed;
	}
	
	@Override
	public void render(Graphics g)
	{
		g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), 
				(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	}
	
	private BufferedImage getCurrentAnimationFrame()
	{
		//If player is moving left
		if(xMove < 0)
		{
			return animLeft.getCurrentFrame();
		}
		//If player is moving right
		else if(xMove > 0)
		{
			return animRight.getCurrentFrame();
		}
		//If player is moving up
		else if (yMove < 0)
		{
			return animUp.getCurrentFrame();
		}
		//If player is moving down
		else if (yMove > 0)
		{
			return animDown.getCurrentFrame();
		}
		//If player is moving not moving
		else
		{
			return animIdle.getCurrentFrame();
		}
	}

}
