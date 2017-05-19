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
		if (o == order.BeveragePane.table) {
			if (order.BeveragePane.table.getSelectedRow() >= 0) {
				selectedRow = order.BeveragePane.table.getSelectedRow();
				sum += (int) order.BeveragePane.table.getValueAt(selectedRow, 2);
				sum1 = String.valueOf(sum);
				order.totalPriceLabel.setText("합계:" + sum1);
				
			}
		} else if (o == order.FoodPane.table) {
			if (order.FoodPane.table.getSelectedRow() >= 0) {
				selectedRow = order.FoodPane.table.getSelectedRow();
				sum += (int) order.FoodPane.table.getValueAt(selectedRow, 2);
				sum1 = String.valueOf(sum);
				order.totalPriceLabel.setText("합계:" + sum1);
			}

		} else if (o == order.SnackPane.table) {
			if (order.SnackPane.table.getSelectedRow() >= 0) {
				selectedRow = order.SnackPane.table.getSelectedRow();
				sum += (int) order.SnackPane.table.getValueAt(selectedRow, 2);
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
