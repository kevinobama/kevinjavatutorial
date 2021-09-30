package datetime;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;

public class ClockOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Clock clock = Clock.system(ZoneId.of("Asia/Calcutta"));
		Clock clock = Clock.system(ZoneId.of("Asia/Shanghai"));
		Instant instant = clock.instant();
		System.out.println(instant);
		
		ZoneId zoneSingapore = ZoneId.of("Asia/Singapore");  
		Clock clockSingapore = Clock.system(zoneSingapore); 
		System.out.println(clockSingapore.instant());
		
	}
}