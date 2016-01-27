package edu.bsu.cs222;

import java.util.EventListener;

public interface DieListener extends EventListener {
	void dieEventOccurred(DieEvent event);
}
