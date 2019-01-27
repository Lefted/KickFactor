package dev.lefted.graphics;

import java.awt.image.BufferedImage;

public class SpriteSheet {

	// VARIABLES
	private BufferedImage sheet;

	// CONSTRUCTOR
	public SpriteSheet(BufferedImage sheet) {
		this.sheet = sheet;
	}

	// crop sheet to one section
	public BufferedImage crop(int x, int y, int width, int height) {
		return sheet.getSubimage(x, y, width, height);
	}

}
