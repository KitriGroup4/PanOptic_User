package com.kitri.user.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gamechangActionListener implements ActionListener{
	UserProgramView game;
	public gamechangActionListener(UserProgramView game) {
		this.game = game;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o == game.enternetBtn){
			game.cl_GameContentsPane.show(game.GameContentsPane, "1");
		}
		if(o == game.issueGameBtn){
			game.cl_GameContentsPane.show(game.GameContentsPane, "2");
		}
		if(o == game.onlineGameBtn){
			game.cl_GameContentsPane.show(game.GameContentsPane, "3");
		}
		if(o == game.actionGameBtn){
			game.cl_GameContentsPane.show(game.GameContentsPane, "4");
		}
		if(o == game.cdGameBtn){
			game.cl_GameContentsPane.show(game.GameContentsPane, "5");
		}
		if(o == game.sportsGameBtn){
			game.cl_GameContentsPane.show(game.GameContentsPane, "6");
		}
		if(o == game.ectBtn){
			game.cl_GameContentsPane.show(game.GameContentsPane, "7");
		}
		
	}

}
