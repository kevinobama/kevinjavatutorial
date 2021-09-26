package integer;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class IntegerExample {
	public static void main(String[] args) {
		
//		int a = 40;
//		
//		if(a>30)
//			System.out.println("yes");
//		else
//			System.out.println("no");
//		
//		if(a>50)
//			System.out.println("yes");
//		else
//			System.out.println("no");
		
		BigDecimal liquidLevel  = new BigDecimal(50);
		BigDecimal liquidAlarmLevel  = new BigDecimal(40);
		
		String liquidStatus = "normal";
		
		if (liquidLevel.compareTo(liquidAlarmLevel) > 0 )  liquidStatus = "预警";
		
		System.out.println(liquidStatus);
	}

}
