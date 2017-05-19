package com.kitri.user.game;


import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.kitri.user.order.OrderListener;

import javax.swing.JInternalFrame;
import java.awt.FlowLayout;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JFormattedTextField;

public class UserProgramView extends JFrame {
	public  GameViewMouseListener gmListener;
	private JPanel backgroundPane;
	private JPanel emptyPane;
	private JLabel emptyTitleLabel;
	public JPanel gameListPane;
	public JPanel gameContentsPane;
	public JButton enternetBtn;
	public JButton actionGameBtn;
	public JButton issueGameBtn;
	public CardLayout clGameContentsPane = new CardLayout();
	public JButton onlineGameBtn;
	public InternetPane gameEnternetPane;
	public HotGamePane hotGamePane;
	public OnlineGamePane onlineGamePane;
	public JButton cdGameBtn;
	public JButton sportsGameBtn;
	public JButton ectBtn;
	public GameChangeActionListener gListener;
	public ActionGamePane actionGamePane;
	public CdGamePane cdGamePane;
	public SportsGamePane sportsGamePane;
	public EctGamePane ectGamePane;
	
	/**
	 * 
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {		
//				try {
//					UserProgramView frame = new UserProgramView();
//					frame.setVisible(true);
////					frame.setLocationRelativeTo(null);
//					Dimension frameSize = frame.getSize(); // 프레임 사이즈
//					Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // 모니터 사이즈
//					frame.setLocation((screenSize.width - frameSize.width), (screenSize.height - screenSize.height));
//					frame.setResizable(false);//창크기변경불가능하게하는거
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	UserProgramView frame;
	/**
	 * Create the frame.
	 */
	public UserProgramView() {

		gmListener = new GameViewMouseListener(this);
		gListener = new GameChangeActionListener(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		backgroundPane = new JPanel();
		backgroundPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(backgroundPane);
		backgroundPane.setLayout(new BorderLayout(0, 0));
		
		emptyPane = new JPanel();
		backgroundPane.add(emptyPane, BorderLayout.NORTH);
		emptyPane.setLayout(new BorderLayout(100, 100));
		
		emptyTitleLabel = new JLabel("              ");
		emptyTitleLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 31));
		emptyPane.add(emptyTitleLabel);
		
		gameListPane = new JPanel();
		backgroundPane.add(gameListPane, BorderLayout.WEST);
		gameListPane.setLayout(new GridLayout(7, 1, 0, 0));
		
		gameContentsPane = new JPanel();
		
		gameContentsPane.setLayout(clGameContentsPane);
		hotGamePane = new HotGamePane(this);
		onlineGamePane= new OnlineGamePane(this);
		gameEnternetPane = new InternetPane(this);
		
		
		gameContentsPane.add(gameEnternetPane, "1");
		gameContentsPane.add(hotGamePane,"2");
		gameContentsPane.add(onlineGamePane,"3");
		
		backgroundPane.add(gameContentsPane, BorderLayout.CENTER);
		
		actionGamePane = new ActionGamePane(this);
		gameContentsPane.add(actionGamePane, "4");
		
		cdGamePane = new CdGamePane(this);
		gameContentsPane.add(cdGamePane, "5");
		
		sportsGamePane = new SportsGamePane(this);
		gameContentsPane.add(sportsGamePane, "6");
		
		ectGamePane = new EctGamePane(this);
		gameContentsPane.add(ectGamePane, "7");
		
		

		enternetBtn = new JButton("\uC778\uD130\uB137\uBE0C\uB77C\uC6B0\uC800");
		gameListPane.add(enternetBtn);
		

		issueGameBtn = new JButton("\uC778\uAE30\uAC8C\uC784");
		gameListPane.add(issueGameBtn);
		
		onlineGameBtn = new JButton("\uC628\uB77C\uC778\uAC8C\uC784");
		gameListPane.add(onlineGameBtn);
		
		actionGameBtn = new JButton("\uC561\uC158&FPS");
		gameListPane.add(actionGameBtn);
		
		cdGameBtn = new JButton("CD\uAC8C\uC784");
		gameListPane.add(cdGameBtn);
		
		sportsGameBtn = new JButton("\uC2A4\uD3EC\uCE20&\uB808\uC774\uC2F1");
		gameListPane.add(sportsGameBtn);
		
		ectBtn = new JButton("\uAE30\uD0C0");
		gameListPane.add(ectBtn);
		
		
		enternetBtn.addActionListener(gListener);
		issueGameBtn.addActionListener(gListener);
		onlineGameBtn.addActionListener(gListener);
		actionGameBtn.addActionListener(gListener);
		cdGameBtn.addActionListener(gListener);
		sportsGameBtn.addActionListener(gListener);
		ectBtn.addActionListener(gListener);
		
		this.setLocationRelativeTo(null);
		
	
		
		
	}
	
}
