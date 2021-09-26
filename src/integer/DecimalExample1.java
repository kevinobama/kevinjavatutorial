package integer;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DecimalExample1 {
	public static void main(String[] args) {
		
		BigDecimal liquidLevel;
		liquidLevel = new BigDecimal(8.99999);
		
		System.out.println(liquidLevel.setScale(2, RoundingMode.CEILING));
				
	}	
}
