package com.kitri.user.order;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OrderMouseListener extends MouseAdapter {

	Order order;
	int selectedRow;
	int sum;
	String sum1;

	public OrderMouseListener(Order order) {
		this.order = order;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);

		Object o = e.getSource();
		if (o == order.beveragePane.table) {
			if (order.beveragePane.table.getSelectedRow() >= 0) {
				selectedRow = order.beveragePane.table.getSelectedRow();
				sum += (int) order.beveragePane.table.getValueAt(selectedRow, 2);
				sum1 = String.valueOf(sum);
				order.totalPriceLabel.setText("합계:" + sum1);
				
			}
		} else if (o == order.foodPane.table) {
			if (order.foodPane.table.getSelectedRow() >= 0) {
				selectedRow = order.foodPane.table.getSelectedRow();
				sum += (int) order.foodPane.table.getValueAt(selectedRow, 2);
				sum1 = String.valueOf(sum);
				order.totalPriceLabel.setText("합계:" + sum1);
			}

		} else if (o == order.snackPane.table) {
			if (order.snackPane.table.getSelectedRow() >= 0) {
				selectedRow = order.snackPane.table.getSelectedRow();
				sum += (int) order.snackPane.table.getValueAt(selectedRow, 2);
				sum1 = String.valueOf(sum);
				order.totalPriceLabel.setText("합계:" + sum1);
			}
		 
		}
		else if( o == order.orderCancelBtn){
			sum = 0;
			String.valueOf(sum);
			System.out.println("합계:"+sum);
			order.totalPriceLabel.setText("합계:"+sum);
		}

	}
}
