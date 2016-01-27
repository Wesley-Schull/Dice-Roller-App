package edu.bsu.cs222;

public class Dice {

	public int faces;
	public int rolls;

	public Dice(int rolls, int faces) {
		this.rolls = rolls;
		this.faces = faces;
	}

	public String roll() {
		String result = "";

		for (int i = 0; i < rolls; i++) {
			result += "Roll #" + (i + 1) + ":" + (int)((Math.random() * faces) + 1) + "\n";
		}
		return result;
	}

	public int getFaces() {
		return faces;
	}

	public int getRolls() {
		return rolls;
	}
}
