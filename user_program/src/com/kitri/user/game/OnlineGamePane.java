package com.kitri.user.game;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class OnlineGamePane extends JPanel {
	JLabel gameLabel[];
	UserProgramView uView;
	/**
	 * Create the panel.
	 */
	public OnlineGamePane(UserProgramView uView) {
		this.uView =uView;
		setLayout(new GridLayout(7, 8, 10, 10));
		gameLabel = new JLabel[56];
		int len = gameLabel.length;
		for (int i = 0; i < len; i++) {
			gameLabel[i] = new JLabel("on");
			gameLabel[i
			          ].addMouseListener(uView.gmListener);
			add(gameLabel[i]);
		}
	}
}
