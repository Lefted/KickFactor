package dev.lefted.states;

import java.awt.Graphics;

// PARENT CLASS
public abstract class State {

	public abstract void tick();

	public abstract void render(Graphics gfx);

}
