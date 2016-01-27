package edu.bsu.cs222;

import java.util.EventObject;

public class DiceEvent extends EventObject {
	private String text;
	public DiceEvent(Object source, String output) {
		super(source);
		this.text = output;
	}
	public String getOutput() {
		return text;
	}
}
