package dev.lefted.states;

public class StateManager {

	private static State currentState = null;

	// GETTERS AND SETTERS
	public static void setState(State state) {
		currentState = state;
	}

	public static State getState() {
		return currentState;
	}

}
