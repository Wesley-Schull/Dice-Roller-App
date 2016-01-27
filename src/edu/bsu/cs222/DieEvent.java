package edu.bsu.cs222;

import java.util.EventObject;

public class DieEvent extends EventObject {

	private static final long serialVersionUID = 1L;

	private String text;

	public DieEvent(Object source, String output) {
		super(source);
		this.text = output;
	}

	public String getOutput() {
		return text;
	}

}
