package com.kitri.user.messenger;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;

public class Messenger extends JFrame {
	public JTextField msgTf;
	private JPanel backgroundPane;
	private JLabel msgTitleLabel;
	private JPanel msgTitlePane;
	private JScrollPane msgTextAreaPane;
	public JTextArea msgtextArea;
	private JPanel messageTfPane;
	private JPanel msgSendPane;
	public JButton msgBtn;
	public MessengerListener listener;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Messenger frame = new Messenger();
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
	public Messenger() {
		listener = new MessengerListener(this);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 427, 341);
		backgroundPane = new JPanel();
		backgroundPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(backgroundPane);
		backgroundPane.setLayout(null);
		
		msgTitlePane = new JPanel();
		FlowLayout fl_MsgTitlePane = (FlowLayout) msgTitlePane.getLayout();
		fl_MsgTitlePane.setAlignment(FlowLayout.LEFT);
		msgTitlePane.setBounds(12, 10, 175, 34);
		backgroundPane.add(msgTitlePane);
		
		msgTitleLabel = new JLabel("[ \uB300\uD654\uCC3D ]");
		msgTitleLabel.setHorizontalAlignment(SwingConstants.LEFT);
		msgTitleLabel.setFont(new Font("³ª´®¹Ù¸¥Ææ", Font.BOLD, 23));
		msgTitlePane.add(msgTitleLabel);
		
		msgTextAreaPane = new JScrollPane();
		msgTextAreaPane.setBounds(12, 54, 387, 189);
		backgroundPane.add(msgTextAreaPane);
		
		msgtextArea = new JTextArea();
		msgtextArea.setFont(new Font("Monospaced", Font.PLAIN, 18));
		msgTextAreaPane.setViewportView(msgtextArea);
		
		messageTfPane = new JPanel();
		messageTfPane.setBounds(12, 253, 276, 39);
		backgroundPane.add(messageTfPane);
		messageTfPane.setLayout(null);
		
		msgTf = new JTextField();
		msgTf.setBounds(0, 10, 276, 21);
		messageTfPane.add(msgTf);
		msgTf.setColumns(10);
		
		msgSendPane = new JPanel();
		msgSendPane.setBounds(289, 253, 122, 39);
		backgroundPane.add(msgSendPane);
		
		msgBtn = new JButton("      \uC804\uC1A1      ");
		msgBtn.setFont(new Font("³ª´®¹Ù¸¥Ææ", Font.PLAIN, 12));
		msgSendPane.add(msgBtn);
		
		setVisible(false);
		msgBtn.addActionListener(listener);
	}
}
