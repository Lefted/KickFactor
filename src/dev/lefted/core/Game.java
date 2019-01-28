package dev.lefted.core;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import dev.lefted.display.Display;
import dev.lefted.graphics.Assets;
import dev.lefted.graphics.ImageLoader;
import dev.lefted.graphics.SpriteSheet;

public class Game implements Runnable {

	// VARIABLES
	private Display display;
	private Thread thread;

	public String title;
	public int width, height;
	private boolean running = false;

	private BufferStrategy buffer;
	private Graphics gfx;

	private static final int FPS_RATE = 60;
	int posX = 0;

	// CONSTRUCTOR
	public Game(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
	}

	// INITialising
	private void init() {
		display = new Display(title, width, height);
		Assets.init();
	}

	// TICK
	private void tick() {
		posX++;
	}

	// RENDER using bufferstrategy, graphics and canvas
	private void render() {
		buffer = display.getCanvas().getBufferStrategy();
		if (buffer == null) {
			display.getCanvas().createBufferStrategy(2);
			return;
		}
		// clearing the screen before drawing
		gfx = buffer.getDrawGraphics();
		gfx.clearRect(0, 0, width, height);

		gfx.drawImage(Assets.player, posX, 0, null);

		// Draw Buffer down and clear graphics 'cache'
		buffer.show();
		gfx.dispose();
	}

	@Override
	public void run() {
		init();

		// some code to make everything run the same speed ignoring the fps
		int fps = FPS_RATE;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();

		while (running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			lastTime = now;

			if (delta >= 1) {
				tick();
				render();
				delta--;
			}
		}
		stop();
	}

	public synchronized void start() {
		// when first starting a new thread is created
		if (running) {
			return;
		}
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	public synchronized void stop() {
		// when stopping the thread is ended
		if (!running) {
			return;
		}
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
