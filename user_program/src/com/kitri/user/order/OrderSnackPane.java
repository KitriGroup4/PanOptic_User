package com.kitri.user.order;

import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class OrderSnackPane extends JPanel {

    // String snack_name[]={"����� ","ī��Ÿ�� ","���͸�
    // ","���Ͽ�","������Ʈ","�ξ�Ŀ","���ڼ���","����ٽ�","��ũ","�����","����Ĩ","�Ƕ�","ĭ��","������","���ֶ�","���ֶ�"};
    // String snack_price[]
    // ={"2500��","2500��","3000��","4000��","4000��","4000��","3000��"
    // ,"2500��","2500��","2500��","2500��","3000��","3000��","3000��","4000��","3000��"};
    /**
     * Create the panel.
     */

    Vector col = new Vector<>();
    Vector rowDatas = new Vector<>();
    JTable table;

    public OrderSnackPane() {
	col.add("����");
	col.add("�����޴�");
	col.add("����");

	JTable jTable = new JTable(rowDatas, col);

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
