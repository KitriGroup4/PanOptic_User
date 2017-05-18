package com.kitri.user.statusinfo;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import com.kitri.user.messenger.Messenger;
import com.kitri.user.order.Order;
import java.awt.GridLayout;
import java.awt.TextField;

public class StatusInfo extends JFrame {
    public Order c;
    public MyPage mp;
    public Messenger msg;
    private JPanel StatusIdPane;
    private JPanel StatusComPane;
    private JPanel StatusInfoPane;
    private JPanel StatusBottomPane;
    private JPanel BackgroundPane;
    private JPanel StatusImagePane;
    private JLabel statusIdLabel;
    public JLabel statusId;
    private JLabel statusComNumLabel;
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
    public StatusInfoListener listener;
    public TextField tf;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    StatusInfo frame = new StatusInfo();
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
    public StatusInfo() {
	c = new Order();
	mp = new MyPage();
	msg = new Messenger();
	tf = new TextField();
	listener = new StatusInfoListener(this);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 279, 465);
	BackgroundPane = new JPanel();
	BackgroundPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(BackgroundPane);
	BackgroundPane.setLayout(null);
	StatusIdPane = new JPanel();
	StatusIdPane.setBounds(98, 52, 165, 30);
	BackgroundPane.add(StatusIdPane);
	StatusIdPane.setLayout(new GridLayout(1, 2, 0, 0));

	statusIdLabel = new JLabel("ID");
	statusIdLabel.setHorizontalAlignment(SwingConstants.LEFT);
	StatusIdPane.add(statusIdLabel);

	statusId = new JLabel("New label");
	statusId.setHorizontalAlignment(SwingConstants.CENTER);
	StatusIdPane.add(statusId);

	StatusComPane = new JPanel();
	StatusComPane.setBounds(98, 22, 165, 30);
	BackgroundPane.add(StatusComPane);
	StatusComPane.setLayout(new GridLayout(1, 2, 0, 0));

	statusComNumLabel = new JLabel("\uC88C\uC11D");
	statusComNumLabel.setHorizontalAlignment(SwingConstants.LEFT);
	StatusComPane.add(statusComNumLabel);

	statusComNum = new JLabel("PC1");
	statusComNum.setHorizontalAlignment(SwingConstants.CENTER);
	StatusComPane.add(statusComNum);

	StatusInfoPane = new JPanel();
	StatusInfoPane.setBounds(98, 81, 165, 93);
	BackgroundPane.add(StatusInfoPane);
	StatusInfoPane.setLayout(new GridLayout(3, 2, 0, 0));

	usetimeLabel = new JLabel("\uC0AC\uC6A9\uC2DC\uAC04");
	usetimeLabel.setHorizontalAlignment(SwingConstants.LEFT);
	StatusInfoPane.add(usetimeLabel);

	usetime = new JLabel("New label");
	usetime.setHorizontalAlignment(SwingConstants.CENTER);
	StatusInfoPane.add(usetime);

	restTimeLabel = new JLabel("\uC794\uC5EC\uC2DC\uAC04");
	restTimeLabel.setHorizontalAlignment(SwingConstants.LEFT);
	StatusInfoPane.add(restTimeLabel);

	restTime = new JLabel("New label");
	restTime.setHorizontalAlignment(SwingConstants.CENTER);
	StatusInfoPane.add(restTime);

	pointLabel = new JLabel("\uD3EC\uC778\uD2B8");
	pointLabel.setHorizontalAlignment(SwingConstants.LEFT);
	StatusInfoPane.add(pointLabel);

	point = new JLabel("New label");
	point.setHorizontalAlignment(SwingConstants.CENTER);
	StatusInfoPane.add(point);

	StatusBottomPane = new JPanel();
	StatusBottomPane.setBounds(0, 200, 263, 216);
	BackgroundPane.add(StatusBottomPane);
	StatusBottomPane.setLayout(new GridLayout(4, 1, 0, 0));

	statusMypageBtn = new JButton("����������");

	StatusBottomPane.add(statusMypageBtn);

	statusOrderBtn = new JButton("�ֹ�");
	StatusBottomPane.add(statusOrderBtn);

	statusMessengerBtn = new JButton("�޽���");
	StatusBottomPane.add(statusMessengerBtn);

	comMoveBtn = new JButton("\uC790\uB9AC\uC774\uB3D9");
	StatusBottomPane.add(comMoveBtn);

	StatusImagePane = new JPanel();
	StatusImagePane.setBounds(0, 22, 100, 152);
	BackgroundPane.add(StatusImagePane);

	statusOrderBtn.addActionListener(listener);
	statusMypageBtn.addActionListener(listener);
	statusMessengerBtn.addActionListener(listener);
	comMoveBtn.addActionListener(listener);
    }

}
