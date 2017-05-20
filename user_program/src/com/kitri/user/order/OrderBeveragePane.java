package com.kitri.user.order;

import java.awt.Dimension;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.kitri.user.dto.FoodDto;
import com.kitri.user.main.Main;

public class OrderBeveragePane extends JPanel {
    // private String beverageName[] ={"�Ƹ޸�ī��","īǪġ��","ī���","ī��Ḷ���ƶ�","�����ī",
    // "���ڶ��","������","�������","������","�����ƾ��̽�Ƽ","������̽�Ƽ","�ݶ�","���̴�","ȯŸ","��������Ʈ","����ƾ��"};
    // private String beveragePrice[]
    // ={"3000��","4000��","3500��","5000��","5000��","3500��","3500��",
    // "3500��","3500��","3500��","4000��","4000��","4000��","4000��","3000��","3000��","3000��"};
    //
    Vector rowDatas = new Vector<>();
    JTable table;
    Order order;
    JScrollPane scrollPane;

    /**
     * Create the panel.
     */
    public OrderBeveragePane(Order order) {
	this.order = order;

	// Vector temp = new Vector();
	// temp.add("img");
	// temp.add("�Ƹ޸�ī��");
	// temp.add(3000);
	// rowDatas.addElement(temp);
	// temp = new Vector<>();
	// temp.add("img");
	// temp.add("ī���");
	// temp.add(4000);
	// rowDatas.addElement(temp);

	table = new JTable();

    }

    public void setRowData() {
	int size = order.beverages.size();
	Main.log("setRowData : " + size);
	rowDatas = new Vector<>();
	Vector temp;
	FoodDto foodTemp;
	for (int i = 0; i < size; i++) {
	    foodTemp = order.beverages.get(i);
	    temp = new Vector<>();
	    temp.add(foodTemp.getFoodNum());
	    temp.add("tmp.jpg");
	    temp.add(foodTemp.getFoodName());
	    temp.add(foodTemp.getFoodPrice());
	    rowDatas.addElement(temp);

	}

	DefaultTableModel model = new DefaultTableModel(rowDatas, order.col) {
	    @Override
	    public boolean isCellEditable(int row, int column) {
		return false;
	    }
	};

	table = new JTable(model);
	table.getTableHeader().setReorderingAllowed(false);
	table.getTableHeader().setResizingAllowed(false);

	table.addMouseListener(order.mListener);
	scrollPane = new JScrollPane(table);

	Dimension d = table.getPreferredSize();
	scrollPane.setPreferredSize(new Dimension(630, 500));
	add(scrollPane);

    }

}
