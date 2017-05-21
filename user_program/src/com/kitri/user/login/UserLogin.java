package com.kitri.user.login;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.kitri.user.dto.UserInfoDto;
import com.kitri.user.game.UserProgramView;
import com.kitri.user.join.UserJoin;
import com.kitri.user.statusinfo.StatusInfo;

import java.awt.*;

public class UserLogin extends JFrame {

    private JPanel contentPane;
    public JPasswordField pwTf;
    private JPanel emptyPane;
    private JPanel emptyPane1;
    private JPanel userMainComPane;
    public JButton joinBtn;
    private JPanel bottomBackgrounPane;
    private JPanel backgroundCentPane;
    private JPanel northEmptyPane;
    private JPanel bottomEmptyPane1;
    private JPanel westEmptyPane;
    private JLabel emptyLabel;
    private JLabel emptyLabel1;
    private JPanel eastEmptyPane;
    private JLabel emptyLabel2;
    private JPanel LoginLabePane;
    private JLabel label;
    private JLabel label1;
    private JPanel loginInputPane;
    public JTextField idTf;
    public JButton loginBtn;
    private JLabel emptyLabel9;
    private JLabel emptyLabel8;
    private JLabel emptyLabel5;
    private JLabel emptyLabel4;
    private JLabel emptyLabel6;
    private JLabel emptyLabel7;
    private JLabel emptyLabel_1;
    public JTextField mainComNum;
    public UserLoginListener listener;
    public UserJoin join;
    public UserInfoDto userInfo;
    public int userPoint;
    public StatusInfo statusInfo;
    public int userNum;
    public UserProgramView programView;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    UserLogin frame = new UserLogin();
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
    public UserLogin() {
	statusInfo = new StatusInfo(this);
	programView = new UserProgramView();
	join = new UserJoin();
	listener = new UserLoginListener(this);

	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 556, 445);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(new BorderLayout(0, 0));

	contentPane.add(join);

	northEmptyPane = new JPanel();
	contentPane.add(northEmptyPane, BorderLayout.NORTH);
	northEmptyPane.setLayout(new GridLayout(1, 0, 0, 0));

	emptyLabel = new JLabel("         ");
	emptyLabel.setHorizontalTextPosition(SwingConstants.CENTER);
	northEmptyPane.add(emptyLabel);

	bottomEmptyPane1 = new JPanel();
	contentPane.add(bottomEmptyPane1, BorderLayout.SOUTH);

	emptyLabel_1 = new JLabel("         ");
	bottomEmptyPane1.add(emptyLabel_1);

	westEmptyPane = new JPanel();
	contentPane.add(westEmptyPane, BorderLayout.WEST);

	emptyLabel1 = new JLabel("         ");
	westEmptyPane.add(emptyLabel1);

	eastEmptyPane = new JPanel();
	contentPane.add(eastEmptyPane, BorderLayout.EAST);

	emptyLabel2 = new JLabel("         ");
	eastEmptyPane.add(emptyLabel2);

	backgroundCentPane = new JPanel();
	contentPane.add(backgroundCentPane, BorderLayout.CENTER);
	backgroundCentPane.setLayout(new BorderLayout(0, 0));

	bottomBackgrounPane = new JPanel();
	backgroundCentPane.add(bottomBackgrounPane, BorderLayout.SOUTH);
	bottomBackgrounPane.setLayout(new GridLayout(0, 2, 0, 0));

	LoginLabePane = new JPanel();
	bottomBackgrounPane.add(LoginLabePane);
	LoginLabePane.setLayout(new GridLayout(2, 2, 0, 0));

	emptyLabel4 = new JLabel("");
	LoginLabePane.add(emptyLabel4);

	label = new JLabel("ID");
	label.setHorizontalAlignment(SwingConstants.CENTER);
	LoginLabePane.add(label);

	emptyLabel5 = new JLabel("");
	LoginLabePane.add(emptyLabel5);

	label1 = new JLabel("Password");
	label1.setHorizontalAlignment(SwingConstants.CENTER);
	LoginLabePane.add(label1);

	loginInputPane = new JPanel();
	bottomBackgrounPane.add(loginInputPane);
	loginInputPane.setLayout(new GridLayout(0, 2, 0, 0));

	idTf = new JTextField();
	loginInputPane.add(idTf);
	idTf.setColumns(10);

	emptyLabel6 = new JLabel("");
	loginInputPane.add(emptyLabel6);

	pwTf = new JPasswordField();
	pwTf.setColumns(10);
	loginInputPane.add(pwTf);

	emptyLabel7 = new JLabel("");
	loginInputPane.add(emptyLabel7);

	emptyPane = new JPanel();
	bottomBackgrounPane.add(emptyPane);
	emptyPane.setLayout(new GridLayout(1, 2, 0, 0));

	emptyLabel8 = new JLabel("");
	emptyPane.add(emptyLabel8);

	joinBtn = new JButton("\uD68C\uC6D0\uAC00\uC785");
	emptyPane.add(joinBtn);

	emptyPane1 = new JPanel();
	bottomBackgrounPane.add(emptyPane1);
	emptyPane1.setLayout(new GridLayout(1, 2, 0, 0));

	loginBtn = new JButton("\uB85C\uADF8\uC778");
	emptyPane1.add(loginBtn);

	emptyLabel9 = new JLabel("");
	emptyPane1.add(emptyLabel9);

	userMainComPane = new JPanel();
	FlowLayout fl_UserMainComPane = (FlowLayout) userMainComPane.getLayout();
	fl_UserMainComPane.setVgap(50);
	fl_UserMainComPane.setHgap(50);
	backgroundCentPane.add(userMainComPane, BorderLayout.WEST);

	mainComNum = new JTextField();
	mainComNum.setFont(new Font("굴림", Font.PLAIN, 20));
	mainComNum.setEditable(false);
	mainComNum.setHorizontalAlignment(SwingConstants.CENTER);
//	mainComNum.setText("PC1");
	userMainComPane.add(mainComNum);
	mainComNum.setColumns(10);

	GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
	GraphicsDevice device = environment.getDefaultScreenDevice();
	this.setUndecorated(true);
	device.setFullScreenWindow(this);

	joinBtn.addActionListener(listener);
	loginBtn.addActionListener(listener);
	pwTf.addActionListener(listener);
	idTf.addActionListener(listener);
    }

    public void loginFail() {
	JOptionPane.showMessageDialog(this, "아이디, 비밀번호 혹은 시간을 확인해주세요.", "로그인 실패", JOptionPane.WARNING_MESSAGE);

    }

    public void fieldEmpty() {
	JOptionPane.showMessageDialog(this, "아이디 비밀번호를 입력해주세요.", "공백", JOptionPane.WARNING_MESSAGE);

    }

    public void joinSuccess() {
	join.setVisible(false);
	JOptionPane.showMessageDialog(this, "회원가입을 축하드립니다!!", "회원가입성공", JOptionPane.DEFAULT_OPTION);

    }
}
