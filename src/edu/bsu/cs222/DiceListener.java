package edu.bsu.cs222;

import java.util.EventListener;

public interface DiceListener extends EventListener {
	void diceEventOccurred(DiceEvent event);
}
