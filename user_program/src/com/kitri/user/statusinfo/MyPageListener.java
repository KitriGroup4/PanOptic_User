package com.kitri.user.statusinfo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.kitri.user.dto.UserInfoDto;
import com.kitri.user.main.Main;

public class MyPageListener implements ActionListener {
    MyPage mp;
    UserInfoDto dto;

    public MyPageListener(MyPage mp) {
	this.mp = mp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	Object o = e.getSource();
	if (o == mp.mypgChangeBtn) {

	}
	if (o == mp.mypgCancelBtn) {
	    mp.setVisible(false);
	}

    }

    public void setMyPageField() {

	mp.mypgName.setText(Main.network.view.userInfo.getUserName());
	mp.mypgId.setText(Main.network.view.userInfo.getUserId());
	mp.mypgPwTf.setText(Main.network.view.userInfo.getUserPw());
	mp.mypgHpTf.setText(Main.network.view.userInfo.getUserHp());
	mp.mypgMailTf.setText(Main.network.view.userInfo.getUserEmail());
	mp.mypgAccuTime.setText(Main.network.view.userInfo.getUserAccuTime());
	mp.mypgRestTime.setText(Main.network.view.userInfo.getUserLeftTime());

    }

    public void getMyPageField(MyPage mp) {

	dto.setUserEmail(mp.mypgMailTf.getText());
	dto.setUserHp(mp.mypgHpTf.getText());
	dto.setUserPw(mp.mypgPwTf.getText());
    }
}
