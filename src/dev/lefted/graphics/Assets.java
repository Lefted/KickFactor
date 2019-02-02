package dev.lefted.graphics;

import java.awt.image.BufferedImage;

public class Assets {

	// VARIABLES
	public static BufferedImage player;

	// LOAD IN all assets
	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/SpriteSheet.png"), 128, 128);

		// cropping goes here
		player = sheet.crop(0, 0);
	}

}
