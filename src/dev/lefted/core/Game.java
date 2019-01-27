package dev.lefted.core;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import dev.lefted.display.Display;
import dev.lefted.graphics.ImageLoader;

public class Game implements Runnable {

	// VARIABLES
	private Display display;
	private Thread thread;

	public String title;
	public int width, height;
	private boolean running = false;

	private BufferStrategy buffer;
	private Graphics gfx;

	private BufferedImage test;
	
	// CONSTRUCTOR
	public Game(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
	}

	// INITialising
	private void init() {
		display = new Display(title, width, height);
		test = ImageLoader.loadImage("/textures/DisplayIcon.png");
	}

	// TICK
	private void tick() {

	}

	// RENDER using bufferstrategy, graphics and canvas
	private void render() {
		buffer = display.getCanvas().getBufferStrategy();
		if (buffer == null) {
			display.getCanvas().createBufferStrategy(2);
			return;
		}
		gfx = buffer.getDrawGraphics();

		gfx.drawImage(test, 20, 20, null);

		// Draw Buffer down and clear graphics 'cache'
		buffer.show();
		gfx.dispose();
	}

	@Override
	public void run() {
		init();

		while (running) {
			tick();
			render();
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
