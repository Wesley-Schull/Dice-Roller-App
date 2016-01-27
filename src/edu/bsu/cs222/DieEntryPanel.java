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

public class DieEntryPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private EventListenerList listenerList = new EventListenerList();

	public DieEntryPanel() {

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
				int rolls = Integer.parseInt(rollsField.getText());
				int faces = Integer.parseInt(facesField.getText());
				Dice userDice = new Dice(rolls, faces);
				String result = userDice.roll();
				activateDieEvent(new DieEvent(this, result));
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

	public void activateDieEvent(DieEvent rollAction) {
		Object[] listOfListeners = listenerList.getListenerList();

		for (int i = 0; i < listOfListeners.length; i += 2) {
			if (listOfListeners[i] == DieListener.class) {
				((DieListener) listOfListeners[i + 1]).dieEventOccurred(rollAction);
			}
		}
	}

	public void addDieListener(DieListener listener) {
		listenerList.add(DieListener.class, listener);
	}

	public void removeDieListener(DieListener listener) {
		listenerList.remove(DieListener.class, listener);

	}

}
