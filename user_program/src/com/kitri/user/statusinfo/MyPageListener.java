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
	if (o == mp.mypg_change_btn) {

	}
	if (o == mp.mypg_cancel_btn) {
	    mp.setVisible(false);
	}

    }

    public void setMyPageField() {

	mp.mypg_name.setText(Main.network.view.dto.getUserName());
	mp.mypg_id.setText(Main.network.view.dto.getUserId());
	mp.mypg_pw_tf.setText(Main.network.view.dto.getUserPw());
	mp.mypg_hp_tf.setText(Main.network.view.dto.getUserHp());
	mp.mypg_mail_tf.setText(Main.network.view.dto.getUserEmail());
	mp.mypg_accu_time.setText(Main.network.view.dto.getUserAccuTime());
	mp.mypg_rest_time.setText(Main.network.view.dto.getUserLeftTime());

    }

    public void getMyPageField(MyPage mp) {

	dto.setUserEmail(mp.mypg_mail_tf.getText());
	dto.setUserHp(mp.mypg_hp_tf.getText());
	dto.setUserPw(mp.mypg_pw_tf.getText());
    }
}
