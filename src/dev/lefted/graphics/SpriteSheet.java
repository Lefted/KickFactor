package dev.lefted.graphics;

import java.awt.image.BufferedImage;

public class SpriteSheet {

	// VARIABLES
	private BufferedImage sheet;
	private final int WIDTH;
	private final int HEIGHT;

	// CONSTRUCTOR
	public SpriteSheet(BufferedImage sheet, int WIDTH, int HEIGHT) {
		this.sheet = sheet;
		this.WIDTH = WIDTH;
		this.HEIGHT = HEIGHT;
	}

	// METHOD OVERLOADING
	// crop sheet to one section using coordinates
	public BufferedImage crop(int x, int y, int width, int height) {
		return sheet.getSubimage(x, y, width, height);
	}

	// crop sheet to one section using grid counting
	public BufferedImage crop(int x, int y) {
		return sheet.getSubimage(x * WIDTH, y * HEIGHT, WIDTH, HEIGHT);
	}
}
