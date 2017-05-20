package com.kitri.user.order;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JTable;

import com.kitri.user.dto.FoodDto;
import com.kitri.user.dto.OrderInfoDto;
import com.kitri.user.main.Main;
import com.kitri.user.network.PacketInformation;

public class OrderMouseListener extends MouseAdapter {

    Order order;
    int selectedRow;
    public int sum;
    String sum1;
    final int PRICE_COL = 3;
    final int NUM_COL = 0;
    final int MENU_COL = 2;
    int selectedMenu;
    String menu = "";

    ArrayList<OrderInfoDto> orderFoods;

    public OrderMouseListener(Order order) {
	this.order = order;
	orderFoods = new ArrayList<>();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
	super.mouseClicked(e);

	Object o = e.getSource();
	if (o == order.beveragePane.table) {
	    if (order.beveragePane.table.getSelectedRow() >= 0) {

		addOrderInfo((int) order.foodPane.table.getValueAt(selectedRow, NUM_COL), order.beverages);
		selectMenu(order.beveragePane.table);

	    }
	} else if (o == order.foodPane.table) {
	    if (order.foodPane.table.getSelectedRow() >= 0) {
//		selectedRow = order.foodPane.table.getSelectedRow();
//		sum += (int) order.foodPane.table.getValueAt(selectedRow, PRICE_COL);
		addOrderInfo((int) order.foodPane.table.getValueAt(selectedRow, NUM_COL), order.foods);
//
//		order.totalPriceLabel.setText("합계 : " + sum);
		selectMenu(order.foodPane.table);
	    }

	} else if (o == order.snackPane.table) {
	    if (order.snackPane.table.getSelectedRow() >= 0) {
//		selectedRow = order.snackPane.table.getSelectedRow();
//		sum += (int) order.snackPane.table.getValueAt(selectedRow, PRICE_COL);
		addOrderInfo((int) order.snackPane.table.getValueAt(selectedRow, NUM_COL), order.snacks);
//
//		order.totalPriceLabel.setText("합계  : " + sum);
		selectMenu(order.snackPane.table);
	    }

	} else if (o == order.orderCancelBtn) {
	    resetOrder();
	} else if (o == order.pointPaybtn) {
	    orderByPoint();
	}

    }

    private void selectMenu(JTable table) {
	selectedRow = table.getSelectedRow();
	sum += (int) table.getValueAt(selectedRow, PRICE_COL);
	addOrderInfo((int) table.getValueAt(selectedRow, NUM_COL), order.beverages);
	menu += (String) table.getValueAt(selectedRow, MENU_COL) + "\n";

	order.totalPriceLabel.setText("합계 : " + sum);
	order.orderedList.setText(menu);
    }

    private void resetOrder() {
	sum = 0;
	Main.log(Arrays.toString(orderFoods.toArray()));
	orderFoods = new ArrayList<>();
	System.out.println("합계 : " + sum);
	order.totalPriceLabel.setText("합계 : " + sum);
    }

    public void orderByPoint() {
	OrderInfoDto dto = new OrderInfoDto();

	int size = orderFoods.size();

	Main.network.sendPacket(PacketInformation.Operation.START, PacketInformation.PacketType.FOOD,
		PacketInformation.PacketType.IS_START);
	for (int i = 0; i < size; i++) {
	    Main.network.sendPacket(PacketInformation.Operation.BUY, PacketInformation.PacketType.FOOD,
		    orderFoods.get(i).toString());
	}
	Main.network.sendPacket(PacketInformation.Operation.END, PacketInformation.PacketType.FOOD,
		PacketInformation.PacketType.IS_END);

	resetOrder();

    }

    public void addOrderInfo(int num, ArrayList foodList) {
	Main.log("addOrderInfo : " + num);
	int size = orderFoods.size();

	OrderInfoDto dto = new OrderInfoDto();
	if (size == 0) {
	    setOrderInfo(num, dto, foodList);

	} else {
	    boolean isFind = false;
	    Main.log("orderFood : " + size);
	    for (int i = 0; i < size; i++) {
		dto = orderFoods.get(i);
		if (dto.getFoodNum() == num) {
		    dto.setOrderCount(dto.getOrderCount() + 1);
		    isFind = true;
		    break;
		}
	    }

	    dto = new OrderInfoDto();

	    if (!isFind) {
		setOrderInfo(num, dto, foodList);
	    }
	}

    }

    private void setOrderInfo(int num, OrderInfoDto dto, ArrayList list) {
	FoodDto foodDto = findFood(num, list);
	Main.log("foodNum : " + dto.getFoodNum());
	dto.setUserNum(Main.network.view.userNum);
	dto.setFoodNum(foodDto.getFoodNum());
	dto.setOrderMoney(foodDto.getFoodPrice());
	dto.setOrderCount(1);
	dto.setComNum(Main.network.comNum);
	orderFoods.add(dto);
    }

    public FoodDto findFood(int num, ArrayList list) {
	FoodDto dto = null;
	int size = list.size();

	for (int i = 0; i < size; i++) {
	    dto = (FoodDto) list.get(i);
	    if (num == dto.getFoodNum()) {
		break;
	    }
	}

	return dto;

    }
}
