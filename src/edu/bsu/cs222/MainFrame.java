package edu.bsu.cs222;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class MainFrame extends JFrame {
	public MainFrame(String title) {
		super(title);
		final JTextArea textArea = new JTextArea();
		DiceEntryPanel dicePanel = new DiceEntryPanel();
		dicePanel.addDiceListener(new DiceListener() {
			public void diceEventOccurred(DiceEvent roll) {
				String rollResult = roll.getOutput();
				textArea.setText(rollResult);
			}
		});
		setLayout(new BorderLayout());
		Container container = getContentPane();
		container.add(textArea, BorderLayout.CENTER);
		container.add(dicePanel, BorderLayout.WEST);
	}
}
