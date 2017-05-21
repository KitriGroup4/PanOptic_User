package com.kitri.user.statusinfo;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import com.kitri.user.main.Main;

public class UseTimer {

    final long TIME_GAP = TimeUnit.MINUTES.toMillis(10);
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
	status.useTimeLong = 0;

	timer.scheduleAtFixedRate(new TimerTask() {

	    @Override
	    public void run() {
		if (!isEnd) {
		    status.useTimeLong += TIME_GAP;
		    status.leftTimeLong -= TIME_GAP;
		    status.useTimeCal.setTimeInMillis(status.useTimeLong);
		    status.leftTimeCal.setTimeInMillis(status.leftTimeLong);
		    Main.log(status.leftTimeCal.get(Calendar.HOUR) + ":" + status.leftTimeCal.get(Calendar.MINUTE) + ":" + status.leftTimeCal.get(Calendar.SECOND));
		    Main.log(status.useTimeCal.get(Calendar.HOUR) + ":" + status.useTimeCal.get(Calendar.MINUTE) + ":" + status.useTimeCal.get(Calendar.SECOND));
		} else {
		    Main.log("stop Timer !!");
		    timer.cancel();
		}

	    }
	}, cal.getTime(), TimeUnit.SECONDS.toMillis(1));

    }

}