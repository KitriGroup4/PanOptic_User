package com.kitri.user.network;

import com.kitri.user.dto.FoodDto;
import com.kitri.user.dto.FoodTypeDto;
import com.kitri.user.main.Main;

public class Services {

    private Network network;

    public Services(Network network) {
	this.network = network;

    }

    public void checkId(String data) {
	Main.log("checkId(Response)");
	if (data.equals("0")) {
	    network.view.join.checkId = false;
	    network.view.join.checkIdFalseDialog();
	} else {
	    network.view.join.checkId = true;
	    network.view.join.checkIdTrueDialog();
	}
    }

    public void respinseFoodTypeDatas(String data) {
	FoodTypeDto dto = new FoodTypeDto();
	dto.setField(data);
	// Main.log(dto.toString());
	network.view.statusInfo.order.foodTypes.add(dto);
    }

    public void responseFoodDatas(String data) {
	FoodDto dto = new FoodDto();
	dto.setField(data);
	// Main.log(dto.toString());
//	int size = network.view.statusInfo.order.foodTypes.size();
//	int type;
//	for (int i = 0; i < size; i++) {
//	    type = network.view.statusInfo.order.foodTypes.get(i).getFoodTypeNum();
//	    
//	}
	switch(dto.getFoodTypeNum()){
	case 0: // 음식
	    network.view.statusInfo.order.foods.add(dto);
	    break;
	case 1: // 스낵
	    network.view.statusInfo.order.snacks.add(dto);
	    break;
	case 2: // 음료
	    network.view.statusInfo.order.beverages.add(dto);
	    break;
	    default:
	}
    }
    
    public void isEnd(String data){
	switch(Integer.parseInt(data)){
	case PacketInformation.PacketType.FOOD:
	    network.view.statusInfo.order.FoodPane.setRowData();
	    network.view.statusInfo.order.BeveragePane.setRowData();
	    network.view.statusInfo.order.SnackPane.setRowData();
	    break;
	}
    }

    public void loginSuccess(String data) {
	network.view.setVisible(false);
	network.view.userNum = Integer.parseInt(data);
	network.view.statusInfo.setVisible(true);
	// if (network.view.payType == PacketInformation.PacketType.POINT) {
	// if (network.view.payment.isPoint) {
	// network.view.pointException();
	// } else {
	// Main.network.sendPacket(PacketInformation.Operation.BUY,
	// PacketInformation.PacketType.TIME,
	// PacketInformation.PacketType.POINT + "," + network.view.payment.index
	// + ","
	// + network.view.payment.userNum);
	// }
	// } else {
	// network.view.payment.setVisible(true);
	//
	// Main.log("loginSuccess userNum : " + network.view.payment.userNum);
	// }

    }
}
