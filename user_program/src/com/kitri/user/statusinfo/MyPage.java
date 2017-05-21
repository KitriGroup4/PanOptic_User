package com.kitri.user.statusinfo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class MyPage extends JFrame {

    private JPanel backgroundPane;
    public JPasswordField mypgPwTf;
    public JTextField mypgHpTf;
    public JTextField mypgMailTf;
    private JPanel middlePane;
    public JLabel mypgName;
    private JLabel mypgNameLabel;
    private JLabel mypgIdLabel;
    private JLabel mypgPwLabel;
    private JLabel mypgHpLabel;
    private JLabel mypgMailLabel;
    private JLabel mypgAccuTimeLabel;
    public JLabel mypgId;
    private JLabel mypgPointLabel;
    public JLabel mypgRestTime;
    public JLabel mypgAccuTime;
    private JLabel mypgRestTimeLabel;
    public JLabel mypgPoint;
    public JButton mypgChangeBtn;
    public JButton mypgCancelBtn;
    private JLabel mypageTitleLabel;
    private JPanel bottomPane;
    private JPanel titlePane;
    public MyPageListener listener;
    public JLabel mppgPwCheckLabel;
    public JPasswordField  mypgPwCheck;
    /**
     * Launch the application.
     */

    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    // mypage frame = new mypage();
		    // frame.setVisible(true);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }

    /**
     * Create the frame.
     */
    public MyPage() {
	listener = new MyPageListener(this);
	setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	setBounds(100, 100, 382, 489);
	backgroundPane = new JPanel();
	backgroundPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(backgroundPane);
	backgroundPane.setLayout(null);

	middlePane = new JPanel();
	middlePane.setBounds(0, 79, 366, 302);
	backgroundPane.add(middlePane);
	middlePane.setLayout(null);

	mypgName = new JLabel("New label");
	mypgName.setBounds(186, 37, 116, 15);
	middlePane.add(mypgName);

	mypgNameLabel = new JLabel("회원이름");
	mypgNameLabel.setHorizontalAlignment(SwingConstants.TRAILING);
	mypgNameLabel.setVerticalAlignment(SwingConstants.TOP);
	mypgNameLabel.setBounds(79, 37, 69, 15);
	middlePane.add(mypgNameLabel);

	mypgIdLabel = new JLabel("ID");
	mypgIdLabel.setHorizontalAlignment(SwingConstants.TRAILING);
	mypgIdLabel.setBounds(79, 67, 69, 15);
	middlePane.add(mypgIdLabel);

	mypgPwLabel = new JLabel("PW");
	mypgPwLabel.setHorizontalAlignment(SwingConstants.TRAILING);
	mypgPwLabel.setBounds(79, 97, 69, 15);
	middlePane.add(mypgPwLabel);

	mypgHpLabel = new JLabel("핸드폰번호");
	mypgHpLabel.setHorizontalAlignment(SwingConstants.TRAILING);
	mypgHpLabel.setBounds(79, 155, 69, 15);
	middlePane.add(mypgHpLabel);

	mypgMailLabel = new JLabel("이메일주소");
	mypgMailLabel.setHorizontalAlignment(SwingConstants.TRAILING);
	mypgMailLabel.setBounds(79, 185, 69, 15);
	middlePane.add(mypgMailLabel);

	mypgAccuTimeLabel = new JLabel("누적사용시간");
	mypgAccuTimeLabel.setHorizontalAlignment(SwingConstants.TRAILING);
	mypgAccuTimeLabel.setBounds(68, 210, 80, 15);
	middlePane.add(mypgAccuTimeLabel);

	mypgRestTimeLabel = new JLabel("잔여시간");
	mypgRestTimeLabel.setHorizontalAlignment(SwingConstants.TRAILING);
	mypgRestTimeLabel.setBounds(68, 241, 80, 15);
	middlePane.add(mypgRestTimeLabel);

	mypgId = new JLabel("New label");
	mypgId.setBounds(186, 67, 116, 15);
	middlePane.add(mypgId);

	mypgPwTf = new JPasswordField();
	mypgPwTf.setBounds(186, 94, 116, 21);
	middlePane.add(mypgPwTf);
	mypgPwTf.setColumns(10);
	
	mppgPwCheckLabel = new JLabel("Pw Check");
	mppgPwCheckLabel.setHorizontalAlignment(SwingConstants.TRAILING);
	mppgPwCheckLabel.setBounds(79, 125, 69, 15);
	
	middlePane.add(mppgPwCheckLabel);
	mypgPwCheck = new JPasswordField();
	mypgPwCheck.setColumns(10);
	mypgPwCheck.setBounds(186, 122, 116, 21);
	middlePane.add(mypgPwCheck);
	
	mypgHpTf = new JTextField();
	mypgHpTf.setColumns(10);
	mypgHpTf.setBounds(186, 152, 116, 21);
	middlePane.add(mypgHpTf);

	mypgMailTf = new JTextField();
	mypgMailTf.setColumns(10);
	mypgMailTf.setBounds(186, 182, 116, 21);
	middlePane.add(mypgMailTf);
	
	

	mypgAccuTime = new JLabel("New label");
	mypgAccuTime.setBounds(186, 213, 116, 15);
	middlePane.add(mypgAccuTime);

	mypgRestTime = new JLabel("New label");
	mypgRestTime.setBounds(186, 241, 116, 15);
	middlePane.add(mypgRestTime);

	mypgPointLabel = new JLabel("포인트");
	mypgPointLabel.setHorizontalAlignment(SwingConstants.TRAILING);
	mypgPointLabel.setBounds(68, 266, 80, 15);
	middlePane.add(mypgPointLabel);

	mypgPoint = new JLabel("New label");
	mypgPoint.setBounds(186, 266, 116, 15);
	middlePane.add(mypgPoint);

	bottomPane = new JPanel();
	bottomPane.setBounds(84, 378, 185, 62);
	backgroundPane.add(bottomPane);

	mypgChangeBtn = new JButton("\uC218\uC815");

	bottomPane.add(mypgChangeBtn);

	mypgCancelBtn = new JButton("\uCDE8\uC18C");
	bottomPane.add(mypgCancelBtn);

	titlePane = new JPanel();
	titlePane.setBounds(54, 46, 268, 48);
	backgroundPane.add(titlePane);

	mypageTitleLabel = new JLabel("MyPage");
	mypageTitleLabel.setFont(new Font("굴림", Font.PLAIN, 25));
	titlePane.add(mypageTitleLabel);

	setVisible(false);
	mypgCancelBtn.addActionListener(listener);
	mypgChangeBtn.addActionListener(listener);
    }

	public void pwTooShort() {
		JOptionPane.showMessageDialog(this, "8자리 이상 비밀번호를 입력해주세요.", "비밀번호 오류", JOptionPane.WARNING_MESSAGE);
	}
	public void pwCheckError() {
		JOptionPane.showMessageDialog(this, "비밀번호가 같지않습니다.", "비밀번호확인 실패", JOptionPane.WARNING_MESSAGE);
	}

	public void emailInputError() {
		JOptionPane.showMessageDialog(this, "이메일주소오류입니다.", "메일주소확인 실패", JOptionPane.WARNING_MESSAGE);
	}

	public void hpInputError() {
		JOptionPane.showMessageDialog(this, "핸드폰번호입력오류입니다..", "핸드폰번호입력실패", JOptionPane.WARNING_MESSAGE);
	}
	
}
