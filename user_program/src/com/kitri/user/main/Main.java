package com.kitri.user.main;

import com.kitri.user.login.UserLogin;
import com.kitri.user.network.Network;

public class Main {
	// public static UserLogin mView;
	public static boolean isLog = true;
	public static Network network;

	public static void main(String[] args) {
		// mView = new UserLogin();
		// mView.setVisible(true);
		network = new Network();
		Thread thread = new Thread(network);
	}

	public static void log(String str) {
		if (isLog) {
			System.out.println(str);
		}
	}

	public static void log(int num) {
		if (isLog) {
			System.out.println(num);
		}
	}
}
