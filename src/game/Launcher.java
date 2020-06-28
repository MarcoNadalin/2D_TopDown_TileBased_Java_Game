package game;

import display.Display;

public class Launcher
{
	
	
	public static void main(String[] args)
	{
		Game game = new Game("Title", 400, 400);
		game.start();
	}
}
