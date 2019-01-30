package dev.lefted.core;

public class Launcher {

	public static Game game;
	
	// LAUNCHER creates the game with standart parameters
	public static void main(String[] args) {
		game = new Game("KickFactor", 800, 600);
		game.start();
	}
}
