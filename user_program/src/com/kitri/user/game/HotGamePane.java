package com.kitri.user.game;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

public class HotGamePane extends JPanel {

	public JLabel gameLabel[];
	UserProgramView uView;

	/**
	 * Create the panel.
	 */
	public HotGamePane(UserProgramView uView){
		this.uView =uView;
		setLayout(new GridLayout(7, 8, 10, 10));

		gameLabel = new JLabel[56];
		int len = gameLabel.length;
		for (int i = 0; i < len; i++) {
			gameLabel[i] = new JLabel("gm");
			gameLabel[i].addMouseListener(uView.gmListener);
			add(gameLabel[i]);
		}
	}
}
