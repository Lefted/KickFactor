package dev.lefted.display;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

import dev.lefted.graphics.ImageLoader;

public class Display {

	// VARIABLES
	private JFrame frame;
	private Canvas canvas;

	private String title;
	private int width, height;

	// CONSTRUCTOR
	public Display(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;

		createDisplay();
	}

	// CREATING and INITialising the display
	private void createDisplay() {
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setIconImage(ImageLoader.loadImage("/textures/DisplayIcon.png"));
		// TODO image

		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));

		// add things to the frame
		frame.add(canvas);
		frame.pack();
		// show frame at last to reduce graphic bugs at program start
		frame.setVisible(true);
	}

	// GETTERS AND SETTER
	public Canvas getCanvas() {
		return canvas;
	}

}
