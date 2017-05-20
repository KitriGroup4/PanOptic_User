package com.kitri.user.order;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.kitri.user.dto.FoodDto;
import com.kitri.user.dto.FoodTypeDto;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

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
    public JPanel orderedListPane;
    public JTextField orderedListTitle;
    public JTextArea orderedList;

    public ArrayList<FoodTypeDto> foodTypes;
    public ArrayList<FoodDto> foods;
    public ArrayList<FoodDto> snacks;
    public ArrayList<FoodDto> beverages;
    public Vector col = new Vector<>();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    Order frame = new Order();
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
    public Order() {
	listener = new OrderListener(this);
	mListener = new OrderMouseListener(this);

	col.add("번호");
	col.add("사진");
	col.add("음료메뉴");
	col.add("가격");

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
	orderTitleLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 31));
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

	orderedListPane = new JPanel();
	backgroundPane.add(orderedListPane, BorderLayout.EAST);
	orderedListPane.setLayout(new BorderLayout(0, 0));

	orderedListTitle = new JTextField();
	orderedListTitle.setEditable(false);
	orderedListTitle.setFont(new Font("굴림", Font.BOLD, 15));
	orderedListTitle.setHorizontalAlignment(SwingConstants.CENTER);
	orderedListTitle.setText("\uC8FC\uBB38\uB0B4\uC5ED");
	orderedListPane.add(orderedListTitle, BorderLayout.NORTH);
	orderedListTitle.setColumns(10);

	orderedList = new JTextArea();
	orderedList.setEditable(false);
	orderedListPane.add(orderedList);

	setVisible(false);
	orderFoodbtn.addActionListener(listener);
	orderBeveragebtn.addActionListener(listener);
	orderSnackbtn.addActionListener(listener);
	pointPaybtn.addMouseListener(mListener);
	orderCancelBtn.addMouseListener(mListener);
    }

    public void buyFoodSuccess() {
	JOptionPane.showMessageDialog(this, "음식 구매에 성공했습니다.", "성공", JOptionPane.WARNING_MESSAGE);

    }

    public void buyFoodFail() {
	JOptionPane.showMessageDialog(this, "음식 구매에 실패했습니다.", "실패", JOptionPane.WARNING_MESSAGE);

    }
    // public void setColData(Vector vec, JTable table, ArrayList list, JPanel
    // p, JScrollPane scroll) {
    // int size = vec.size();
    //
    // vec = new Vector<>();
    // Vector temp;
    // FoodDto foodTemp;
    // for (int i = 0; i < size; i++) {
    // foodTemp = (FoodDto) list.get(i);
    // temp = new Vector<>();
    // temp.add(foodTemp.getFoodNum());
    // temp.add("tmp.jpg");
    // temp.add(foodTemp.getFoodName());
    // temp.add(foodTemp.getFoodPrice());
    // vec.addElement(temp);
    // }
    //
    // DefaultTableModel model = new DefaultTableModel(vec, col) {
    // @Override
    // public boolean isCellEditable(int row, int column) {
    // return false;
    // }
    // };
    //
    // table = new JTable(model);
    // table.getTableHeader().setReorderingAllowed(false);
    // table.getTableHeader().setResizingAllowed(false);
    //
    // table.addMouseListener(mListener);
    // scroll = new JScrollPane(table);
    // p.add(scroll);
    // }

}
