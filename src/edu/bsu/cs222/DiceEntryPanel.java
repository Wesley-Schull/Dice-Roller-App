package edu.bsu.cs222;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.EventListenerList;

class DiceEntryPanel extends JPanel {
	private EventListenerList listenerList = new EventListenerList();
	DiceEntryPanel() {
		Dimension size = getPreferredSize();
		size.width = 250;
		setPreferredSize(size);
		setBorder(BorderFactory.createTitledBorder("Roll (number of dice) D (number of faces)"));
		JLabel instructions = new JLabel("Only enter integers");
		JLabel rollsLabel = new JLabel("Rolls: ");
		JLabel facesLabel = new JLabel("Faces: ");
		JLabel dLabel = new JLabel("D");
		JButton rollButton = new JButton("Roll");
		final JTextField rollsField = new JTextField(10);
		final JTextField facesField = new JTextField(10);
		rollButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent roll) {
				Dice userDice = new Dice(Integer.parseInt(rollsField.getText()), Integer.parseInt(facesField.getText()));
				String result = userDice.roll();
				activateDiceEvent(new DiceEvent(this, result));
			}
		});
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		gc.anchor = GridBagConstraints.LINE_END;
		gc.weightx = .5;
		gc.weighty = .5;
		gc.gridx = 0;
		gc.gridy = 0;
		add(instructions, gc);
		gc.gridy = 1;
		add(rollsLabel, gc);
		gc.gridy = 3;
		add(facesLabel, gc);
		gc.anchor = GridBagConstraints.CENTER;
		gc.gridx = 1;
		gc.gridy = 1;
		add(rollsField, gc);
		gc.gridy = 2;
		add(dLabel, gc);
		gc.gridy = 3;
		add(facesField, gc);
		gc.weighty = 10;
		gc.anchor = GridBagConstraints.NORTH;
		gc.gridx = 1;
		gc.gridy = 4;
		add(rollButton, gc);
	}
	private void activateDiceEvent(DiceEvent rollAction) {
		Object[] listOfListeners = listenerList.getListenerList();
		for (int i = 0; i < listOfListeners.length; i += 2) {
			if (listOfListeners[i] == DiceListener.class) {
				((DiceListener) listOfListeners[i + 1]).diceEventOccurred(rollAction);
			}
		}
	}
	public void addDiceListener(DiceListener listener) {
		listenerList.add(DiceListener.class, listener);
	}
}
