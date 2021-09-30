package scheduler;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TextClock {
	public static void main(String[] args) {
		TextClockTimer task1=new TextClockTimer("clock");

        Timer timer=new Timer();
        
        timer.scheduleAtFixedRate(task1, 0, 1000);
        
        TextClockTimerTicker ticker=new TextClockTimerTicker("clock");
        
        timer.scheduleAtFixedRate(ticker, 0, 20000);
	}
}