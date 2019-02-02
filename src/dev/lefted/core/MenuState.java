package dev.lefted.core;

import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;

import dev.lefted.display.Display;
import dev.lefted.states.State;

public class MenuState extends State {

	// VARIABLES
	private JButton start;
	@SuppressWarnings("unused")
	private JButton option;
	@SuppressWarnings("unused")
	private JButton end;

	private Display display;
	@SuppressWarnings("unused")
	private JFrame frame;

	public MenuState(Display display) {
		this.display = display;
		this.frame = display.getFrame();
		init();
	}

	// PARENT method not used
	@Override
	public void tick() {
		// TODO Auto-generated method stub

	}
	public void render(Graphics gfx) {
	}

	// adding components to the panel of the frame
	private void init() {
		start = new JButton("Start game");
		start.setBounds(Launcher.game.getWidth() / 2 - 200, 100, 400, 80);
		start.setVisible(true);
		display.getPanel().add(start);

		// refresh the window
		display.getPanel().revalidate();
		display.getPanel().repaint();
	}
}
