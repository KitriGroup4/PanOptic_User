package com.kitri.user.statusinfo;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.kitri.user.dto.UserInfoDto;
import com.kitri.user.login.UserLogin;
import com.kitri.user.messenger.Messenger;
import com.kitri.user.order.Order;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class StatusInfo extends JFrame {
    public Order order;
    public MyPage mp;
    public Messenger msg;
    private JPanel statusIdPane;
    private JPanel statusComPane;
    private JPanel statusInfoPane;
    private JPanel statusBottomPane;
    private JPanel backgroundPane;
    private JPanel statusImagePane;
    private JLabel statusIdLabel;
    public JLabel statusId;
    public JLabel statusComNumLabel;
    public JLabel statusComNum;
    private JLabel usetimeLabel;
    public JLabel point;
    private JLabel pointLabel;
    public JLabel restTime;
    private JLabel restTimeLabel;
    public JLabel usetime;
    public JButton statusMypageBtn;
    public JButton statusMessengerBtn;
    public JButton statusOrderBtn;
    public JButton comMoveBtn;
    public JButton logoutBtn;
    public StatusInfoListener listener;
    public TextField tf;
    public UserLogin login;

    // public UserInfoDto userInfo;
    public UseTimer useTimer;
    public SimpleDateFormat format;
    public long useTimeLong;
    public long leftTimeLong;
    public Calendar useTimeCal;
    public Calendar leftTimeCal;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    StatusInfo frame = new StatusInfo(null);
		    frame.setVisible(true);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }

    /**
     * Create the frame.
     */
    public StatusInfo(UserLogin login) {
	this.login = login;
	useTimeCal = Calendar.getInstance();
	leftTimeCal = Calendar.getInstance();

	useTimeLong = 0;
	leftTimeLong = 0;
	format = new SimpleDateFormat("hh:mm:ss");
	order = new Order();
	mp = new MyPage();
	msg = new Messenger();
	tf = new TextField();
	listener = new StatusInfoListener(this);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 279, 465);
	backgroundPane = new JPanel();
	backgroundPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(backgroundPane);
	backgroundPane.setLayout(null);
	statusIdPane = new JPanel();
	statusIdPane.setBounds(98, 52, 165, 30);
	backgroundPane.add(statusIdPane);
	statusIdPane.setLayout(new GridLayout(1, 2, 0, 0));

	statusIdLabel = new JLabel("ID");
	statusIdLabel.setHorizontalAlignment(SwingConstants.LEFT);
	statusIdPane.add(statusIdLabel);

	statusId = new JLabel("New label");
	statusId.setHorizontalAlignment(SwingConstants.CENTER);
	statusIdPane.add(statusId);

	statusComPane = new JPanel();
	statusComPane.setBounds(98, 22, 165, 30);
	backgroundPane.add(statusComPane);
	statusComPane.setLayout(new GridLayout(1, 2, 0, 0));

	statusComNumLabel = new JLabel("\uC88C\uC11D");
	statusComNumLabel.setHorizontalAlignment(SwingConstants.LEFT);
	statusComPane.add(statusComNumLabel);

	// statusComNum = new JLabel("PC1");
	statusComNum = new JLabel();
	statusComNum.setHorizontalAlignment(SwingConstants.CENTER);
	statusComPane.add(statusComNum);

	statusInfoPane = new JPanel();
	statusInfoPane.setBounds(98, 81, 165, 93);
	backgroundPane.add(statusInfoPane);
	statusInfoPane.setLayout(new GridLayout(3, 2, 0, 0));

	usetimeLabel = new JLabel("\uC0AC\uC6A9\uC2DC\uAC04");
	usetimeLabel.setHorizontalAlignment(SwingConstants.LEFT);
	statusInfoPane.add(usetimeLabel);

	usetime = new JLabel("New label");
	usetime.setHorizontalAlignment(SwingConstants.CENTER);
	statusInfoPane.add(usetime);

	restTimeLabel = new JLabel("\uC794\uC5EC\uC2DC\uAC04");
	restTimeLabel.setHorizontalAlignment(SwingConstants.LEFT);
	statusInfoPane.add(restTimeLabel);

	restTime = new JLabel("New label");
	restTime.setHorizontalAlignment(SwingConstants.CENTER);
	statusInfoPane.add(restTime);

	pointLabel = new JLabel("\uD3EC\uC778\uD2B8");
	pointLabel.setHorizontalAlignment(SwingConstants.LEFT);
	statusInfoPane.add(pointLabel);

	point = new JLabel("New label");
	point.setHorizontalAlignment(SwingConstants.CENTER);
	statusInfoPane.add(point);

	statusBottomPane = new JPanel();
	statusBottomPane.setBounds(0, 200, 263, 216);
	backgroundPane.add(statusBottomPane);
	statusBottomPane.setLayout(new GridLayout(4, 1, 0, 0));

	statusMypageBtn = new JButton("마이페이지");

	statusBottomPane.add(statusMypageBtn);

	statusOrderBtn = new JButton("주문");
	statusBottomPane.add(statusOrderBtn);

	statusMessengerBtn = new JButton("메신저");
	statusBottomPane.add(statusMessengerBtn);

	comMoveBtn = new JButton("\uC790\uB9AC\uC774\uB3D9");
	statusBottomPane.add(comMoveBtn);

	logoutBtn = new JButton("로그아웃");
	statusBottomPane.add(logoutBtn);

	statusImagePane = new JPanel();
	statusImagePane.setBounds(0, 22, 100, 152);
	backgroundPane.add(statusImagePane);

	statusOrderBtn.addActionListener(listener);
	statusMypageBtn.addActionListener(listener);
	statusMessengerBtn.addActionListener(listener);
	comMoveBtn.addActionListener(listener);
	logoutBtn.addActionListener(listener);

	Dimension frameSize = this.getSize();
	Toolkit.getDefaultToolkit().getScreenSize();
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	this.setLocation((screenSize.width - frameSize.width), (screenSize.height - screenSize.height));
	this.setResizable(false);
	this.setUndecorated(true);
    }

    public String getLeftTime() {
	return leftTimeCal.get(Calendar.HOUR) + ":" + leftTimeCal.get(Calendar.MINUTE) + ":" + leftTimeCal.get(Calendar.SECOND);
    }
    
    public String getUseTime() {
	return useTimeCal.get(Calendar.HOUR) + ":" + useTimeCal.get(Calendar.MINUTE) + ":" + useTimeCal.get(Calendar.SECOND);
    }

}
