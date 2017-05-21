package com.kitri.user.statusinfo;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import com.kitri.user.main.Main;

public class UseTimer {

    public boolean isEnd;
    public StatusInfo status;
    public Timer timer;
    Calendar cal;

    public UseTimer(StatusInfo status) {
	Main.log("start timer !!");
	cal = Calendar.getInstance();
	isEnd = false;
	this.status = status;
	timer = new Timer(true);

	timer.scheduleAtFixedRate(new TimerTask() {

	    @Override
	    public void run() {
		if (!isEnd) {
		    status.useTimeLong += TimeUnit.SECONDS.toMillis(1);
		    status.useTimeCal.setTimeInMillis(status.useTimeLong);
//		    Main.log(status.useTimeCal.get(Calendar.HOUR) + ":" + status.useTimeCal.get(Calendar.MINUTE) + ":" + status.useTimeCal.get(Calendar.SECOND));
		} else {
		    Main.log("stop Timer !!");
		    timer.cancel();
		}

	    }
	}, cal.getTime(), TimeUnit.SECONDS.toMillis(1));

    }

}
