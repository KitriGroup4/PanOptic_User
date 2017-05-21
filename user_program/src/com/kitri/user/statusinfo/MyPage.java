package com.kitri.user.statusinfo;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.border.LineBorder;

public class MyPage extends JFrame {

    private JPanel backgroundPane;
    public JTextField mypgPwTf;
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
    
    
	ImageIcon wholeImageIcon = new ImageIcon("UserMainImage\\myPage.png");
	Image wholeIamge = wholeImageIcon.getImage();
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
	backgroundPane = new JPanel(){
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(wholeIamge, 0, 0, null);
			setOpaque(false);
		}
	};
	backgroundPane.setBackground(Color.WHITE);
	backgroundPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(backgroundPane);
	backgroundPane.setLayout(null);

	middlePane = new JPanel();
	middlePane.setOpaque(false);
	middlePane.setBounds(0, 80, 366, 267);
	backgroundPane.add(middlePane);
	middlePane.setLayout(null);

	mypgName = new JLabel("");
	mypgName.setBounds(186, 37, 116, 15);
	middlePane.add(mypgName);

	mypgNameLabel = new JLabel("È¸¿øÀÌ¸§");
	mypgNameLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
	mypgNameLabel.setHorizontalAlignment(SwingConstants.TRAILING);
	mypgNameLabel.setVerticalAlignment(SwingConstants.TOP);
	mypgNameLabel.setBounds(55, 37, 114, 15);
	middlePane.add(mypgNameLabel);

	mypgIdLabel = new JLabel("ID");
	mypgIdLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
	mypgIdLabel.setHorizontalAlignment(SwingConstants.TRAILING);
	mypgIdLabel.setBounds(55, 67, 114, 15);
	middlePane.add(mypgIdLabel);

	mypgPwLabel = new JLabel("PW");
	mypgPwLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
	mypgPwLabel.setHorizontalAlignment(SwingConstants.TRAILING);
	mypgPwLabel.setBounds(55, 97, 114, 15);
	middlePane.add(mypgPwLabel);

	mypgHpLabel = new JLabel("ÇÚµåÆù¹øÈ£");
	mypgHpLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
	mypgHpLabel.setHorizontalAlignment(SwingConstants.TRAILING);
	mypgHpLabel.setBounds(55, 127, 114, 15);
	middlePane.add(mypgHpLabel);

	mypgMailLabel = new JLabel("ÀÌ¸ÞÀÏÁÖ¼Ò");
	mypgMailLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
	mypgMailLabel.setHorizontalAlignment(SwingConstants.TRAILING);
	mypgMailLabel.setBounds(55, 157, 114, 15);
	middlePane.add(mypgMailLabel);

	mypgAccuTimeLabel = new JLabel("´©Àû»ç¿ë½Ã°£");
	mypgAccuTimeLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
	mypgAccuTimeLabel.setHorizontalAlignment(SwingConstants.TRAILING);
	mypgAccuTimeLabel.setBounds(44, 182, 125, 15);
	middlePane.add(mypgAccuTimeLabel);

	mypgRestTimeLabel = new JLabel("ÀÜ¿©½Ã°£");
	mypgRestTimeLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
	mypgRestTimeLabel.setHorizontalAlignment(SwingConstants.TRAILING);
	mypgRestTimeLabel.setBounds(44, 208, 125, 15);
	middlePane.add(mypgRestTimeLabel);

	mypgId = new JLabel("");
	mypgId.setBounds(186, 67, 116, 15);
	middlePane.add(mypgId);

	mypgPwTf = new JTextField();
	mypgPwTf.setBorder(new LineBorder(Color.WHITE));
	mypgPwTf.setBackground(SystemColor.controlHighlight);
	mypgPwTf.setBounds(186, 94, 116, 21);
	middlePane.add(mypgPwTf);
	mypgPwTf.setColumns(10);

	mypgHpTf = new JTextField();
	mypgHpTf.setBorder(new LineBorder(Color.WHITE));
	mypgHpTf.setBackground(SystemColor.controlHighlight);
	mypgHpTf.setColumns(10);
	mypgHpTf.setBounds(186, 124, 116, 21);
	middlePane.add(mypgHpTf);

	mypgMailTf = new JTextField();
	mypgMailTf.setBorder(new LineBorder(Color.WHITE));
	mypgMailTf.setBackground(SystemColor.controlHighlight);
	mypgMailTf.setColumns(10);
	mypgMailTf.setBounds(186, 154, 116, 21);
	middlePane.add(mypgMailTf);

	mypgAccuTime = new JLabel("");
	mypgAccuTime.setBounds(186, 185, 116, 15);
	middlePane.add(mypgAccuTime);

	mypgRestTime = new JLabel("");
	mypgRestTime.setBounds(186, 208, 116, 15);
	middlePane.add(mypgRestTime);

	mypgPointLabel = new JLabel("Æ÷ÀÎÆ®");
	mypgPointLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
	mypgPointLabel.setHorizontalAlignment(SwingConstants.TRAILING);
	mypgPointLabel.setBounds(44, 237, 125, 15);
	middlePane.add(mypgPointLabel);

	mypgPoint = new JLabel("");
	mypgPoint.setBounds(186, 237, 116, 15);
	middlePane.add(mypgPoint);

	bottomPane = new JPanel();
	bottomPane.setOpaque(false);
	bottomPane.setBounds(87, 357, 185, 62);
	backgroundPane.add(bottomPane);

	mypgChangeBtn = new JButton("\uC218\uC815");
	mypgChangeBtn.setBackground(new Color(135, 199, 255));
	mypgChangeBtn.setForeground(Color.WHITE);
	mypgChangeBtn.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
	mypgChangeBtn.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {
	    }
	});
	bottomPane.add(mypgChangeBtn);

	mypgCancelBtn = new JButton("\uCDE8\uC18C");
	mypgCancelBtn.setBackground(new Color(135, 199, 255));
	mypgCancelBtn.setForeground(Color.WHITE);
	mypgCancelBtn.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
	bottomPane.add(mypgCancelBtn);

	titlePane = new JPanel();
	titlePane.setOpaque(false);
	titlePane.setBounds(54, 46, 268, 48);
	backgroundPane.add(titlePane);

	mypageTitleLabel = new JLabel("      ");
	mypageTitleLabel.setFont(new Font("¹è´ÞÀÇ¹ÎÁ· µµÇö", Font.PLAIN, 20));
	titlePane.add(mypageTitleLabel);

	setVisible(false);
	mypgCancelBtn.addActionListener(listener);

    }
}
