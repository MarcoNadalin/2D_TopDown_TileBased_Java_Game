package game;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import display.Display;
import graphics.Assets;
import graphics.GameCamera;
import input.KeyManager;
import state.GameState;
import state.MenuState;
import state.State;

public class Game implements Runnable
{
    private Display display;	
    private int width, height;
    private String title;

    private boolean running = false;
    private Thread thread;

    private BufferStrategy bs;
    private Graphics g;

    //States
    private State gameState;	
    private State menuState;

    //Input
    private KeyManager keyManager = new KeyManager();

    //Camera
    private GameCamera gameCamera;

    //Handler
    private Handler handler;

    public Game(String title, int width, int height)
    {
	this.width = width;
	this.height = height;
	this.title = title;
    }

    private void init()
    {
	display = new Display(title, width, height);
	display.getFrame().addKeyListener(keyManager);
	Assets.init();

	gameCamera = new GameCamera(this, 0, 0);
	handler = new Handler(this);

	gameState = new GameState(handler);
	menuState = new MenuState(handler);
	State.setState(gameState);
    }


    private void tick()
    {
	keyManager.tick();

	if(State.getState() != null)
	{
	    State.getState().tick();
	}
    }

    private void render()
    {
	bs = display.getCanvas().getBufferStrategy();
	if(bs == null)
	{
	    display.getCanvas().createBufferStrategy(3);
	    return;
	}
	g = bs.getDrawGraphics();
	//Clear Screen
	g.clearRect(0, 0, width, height);
	//Draw
	if(State.getState() != null)
	{
	    State.getState().render(g);
	}
	//End Drawing
	bs.show();
	g.dispose();
    }

    @Override
    public void run()
    {
	init();

	int fps = 60;
	double timePerTick = 1000000000 / fps;
	double delta = 0;
	long now;
	long lastTime = System.nanoTime();

	long timer = 0;
	int ticks = 0;

	while(running)
	{
	    now = System.nanoTime();
	    delta = (now - lastTime);
	    timer += now - lastTime;



	    if(delta >= timePerTick)
	    {
		lastTime = now;
		tick();
		render();
		ticks++;
		delta = 0;
	    }

	    if(timer >= 1000000000)
	    {
		System.out.println(ticks);
		ticks = 0;
		timer = 0; 
	    }
	}
    }

    public KeyManager getKeyManager()
    {
	return this.keyManager;
    }

    public GameCamera getGameCamera()
    {
	return this.gameCamera;
    }

    public int getWidth()
    {
	return width;
    }

    public int getHeight()
    {
	return height;
    }

    public synchronized void start()
    {
	if(!running)
	{
	    running = true;
	    thread = new Thread(this);
	    thread.start();
	}		
    }

    public synchronized void stop()
    {
	if(running)
	{
	    running = false;
	    try
	    {
		thread.join();
	    } catch (InterruptedException e)
	    {
		e.printStackTrace();
	    }
	}		
    }
}
