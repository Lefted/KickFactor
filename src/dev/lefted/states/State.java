package dev.lefted.states;

import java.awt.Graphics;

public abstract class State {

	// PARENT CLASS
	public abstract void tick();

	public abstract void render(Graphics gfx);

}
