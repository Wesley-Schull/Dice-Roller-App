package edu.bsu.cs222;
public class Dice {
	public int rolls;
	public int faces;
	public Dice(int rolls, int faces) {
		this.rolls = rolls;
		this.faces = faces;
	}
	public String roll() {
		String result = "";
		for (int i = 0; i < rolls; i++) {
			result += "Roll #" + (i + 1) + ":\t" + (int)((Math.random() * faces) + 1) + "\n";
		}
		return result;
	}
}
