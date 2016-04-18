package edu.bsu.cs222;
public class Dice {
	private int rolls;
	private int faces;
	public Dice(int rolls, int faces) {
		this.rolls = rolls;
		this.faces = faces;
	}
	String roll() {
		String result = "";
		for (int counter = 0; counter < rolls; counter++) {
			result += "Roll #" + (counter + 1) + ":\t" + generateRandomNumber(faces) + "\n";
		}
		return result;
	}
	private int generateRandomNumber(int factor){
		return (int) ((Math.random() * factor) + 1);
	}
}
