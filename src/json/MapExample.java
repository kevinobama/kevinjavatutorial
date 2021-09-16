package json;

import java.util.*;

public class MapExample {

	public static void main(String[] args) {

		Map<Long,String> locations = new HashMap<>();
		
		locations.put(1L, "kevin");
		locations.put(2L, "billgates");
		
		System.out.println(locations);
		
	}
}
