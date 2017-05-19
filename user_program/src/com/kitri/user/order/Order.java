package com.kitri.user.order;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.kitri.user.dto.FoodDto;
import com.kitri.user.dto.FoodTypeDto;

import javax.swing.JInternalFrame;
import java.awt.FlowLayout;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JFormattedTextField;

public class Order extends JFrame {

    private JPanel backgroundPane;
    private JPanel orderTitlePane;
    private JLabel orderTitleLabel;
    private JPanel orderMenuPane;
    public JPanel orderContentsPane;
    public JButton orderFoodbtn;
    public JButton orderSnackbtn;
    private JLabel emptyLabel;
    private JLabel emptyLabel1;
    public JButton pointPaybtn;
    public JLabel totalPriceLabel;
    public JButton orderBeveragebtn;
    public OrderSnackPane snackPane;
    public OrderBeveragePane beveragePane;
    public OrderFoodPane foodPane;
    public OrderListener listener;
    public CardLayout clOrderContentsPane = new CardLayout();
    public OrderMouseListener mListener;
    public JButton orderCancelBtn;

    public ArrayList<FoodTypeDto> foodTypes;
    public ArrayList<FoodDto> foods;
    public ArrayList<FoodDto> snacks;
    public ArrayList<FoodDto> beverages;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    // adf frame = new adf();
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
    public Order() {
	listener = new OrderListener(this);
	mListener = new OrderMouseListener(this);

	setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	setBounds(100, 100, 900, 600);
	backgroundPane = new JPanel();
	backgroundPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(backgroundPane);
	backgroundPane.setLayout(new BorderLayout(0, 0));

	orderTitlePane = new JPanel();
	backgroundPane.add(orderTitlePane, BorderLayout.NORTH);
	orderTitlePane.setLayout(new BorderLayout(100, 100));

	orderTitleLabel = new JLabel("   Order\t");
	orderTitleLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 31));
	orderTitlePane.add(orderTitleLabel);

	orderMenuPane = new JPanel();
	backgroundPane.add(orderMenuPane, BorderLayout.WEST);
	orderMenuPane.setLayout(new GridLayout(7, 1, 0, 0));

	orderContentsPane = new JPanel();

	orderContentsPane.setLayout(clOrderContentsPane);
	beveragePane = new OrderBeveragePane(this);
	snackPane = new OrderSnackPane(this);
	foodPane = new OrderFoodPane(this);
	orderContentsPane.add(foodPane, "1");
	orderContentsPane.add(beveragePane, "2");
	orderContentsPane.add(snackPane, "3");

	backgroundPane.add(orderContentsPane, BorderLayout.CENTER);

	orderFoodbtn = new JButton("\uC74C\uC2DD");
	orderMenuPane.add(orderFoodbtn);

	orderSnackbtn = new JButton("\uC2A4\uB0B5");
	orderMenuPane.add(orderSnackbtn);

	orderBeveragebtn = new JButton("\uC74C\uB8CC");
	orderMenuPane.add(orderBeveragebtn);

	emptyLabel = new JLabel("");
	orderMenuPane.add(emptyLabel);

	orderCancelBtn = new JButton("\uC8FC\uBB38\uCDE8\uC18C");
	orderMenuPane.add(orderCancelBtn);

	totalPriceLabel = new JLabel("\uD569\uACC4:");
	orderMenuPane.add(totalPriceLabel);

	pointPaybtn = new JButton("\uD3EC\uC778\uD2B8\uACB0\uC81C");
	orderMenuPane.add(pointPaybtn);

	setVisible(false);
	orderFoodbtn.addActionListener(listener);
	orderBeveragebtn.addActionListener(listener);
	orderSnackbtn.addActionListener(listener);
	pointPaybtn.addActionListener(listener);
	orderCancelBtn.addMouseListener(mListener);
    }

}
