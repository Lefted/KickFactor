package dev.lefted.states;

import java.awt.Graphics;

import dev.lefted.graphics.Assets;

public class GameState extends State {

	public GameState() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(Graphics gfx) {
		gfx.drawImage(Assets.player, 0, 0, null);

	}

}
