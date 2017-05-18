package com.kitri.user.network;

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
}
