package com.kitri.user.order;

import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class OrderBeveragePane extends JPanel {
//	private String beverageName[] ={"�Ƹ޸�ī��","īǪġ��","ī���","ī��Ḷ���ƶ�","�����ī",
//			"���ڶ��","������","�������","������","�����ƾ��̽�Ƽ","������̽�Ƽ","�ݶ�","���̴�","ȯŸ","��������Ʈ","����ƾ��"};
//	private String beveragePrice[] ={"3000��","4000��","3500��","5000��","5000��","3500��","3500��",
//			"3500��","3500��","3500��","4000��","4000��","4000��","4000��","3000��","3000��","3000��"};
//	
	Vector col = new Vector<>();
	Vector rowDatas = new Vector<>();
	JTable table;
	/**
	 * Create the panel.
	 */
	public OrderBeveragePane() {
	col.add("����");
	col.add("����޴�");
	col.add("����");

	table = new JTable(rowDatas, col);

	JScrollPane scrollPane = new JScrollPane(table);
	add(scrollPane);

	}
	
	private void setRowData() {
		int size = 90;

		Vector temp = new Vector();
		int count = 0;
		for (int i = 0; i < size; i++) {
			if (count < 3) {
				temp.add(i);
				count++;
			} else {
				rowDatas.addElement(temp);
				temp = new Vector();
				count = 0;
			}
			
		}
		
	}

}
