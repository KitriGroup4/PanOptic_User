package com.kitri.user.statusinfo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import com.kitri.user.dto.UserInfoDto;
import com.kitri.user.main.Main;

public class StatusInfoListener implements ActionListener {
    StatusInfo status;
    UserInfoDto dto;

    public StatusInfoListener(StatusInfo status) {
	this.status = status;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

	Object o = e.getSource();

	if (o == status.statusOrderBtn) {
	    status.order.setVisible(true);
	}
	if (o == status.statusMypageBtn) {
	    status.mp.setVisible(true);
	}
	if (o == status.statusMessengerBtn) {
	    status.msg.setVisible(true);
	}
	if (o == status.comMoveBtn) {
	    String name = JOptionPane.showInputDialog("�̵����ڸ��� �Է��ϼ���.");
	    if (name != null)
		status.tf.setText(name);
	}
    }

    public void setStatusInfoField() {
	status.statusId.setText(Main.network.view.dto.getUserId());
	status.restTime.setText(Main.network.view.dto.getUserLeftTime());
	// status.usetime.setText();
	status.statusComNum.setText(Main.network.view.mainComNum.getText());
	// status.point.setText(Main.network.login.dto.);����Ʈ

    }

}
