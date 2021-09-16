package json;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public class ComplexJson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<String, Object> map = new HashMap();

        map.put("key1", "value1");
        map.put("key2", "value2");
 
       JSONObject json =  new JSONObject(map);
        System.out.printf( "JSON: %s", json);
        
        
		
	}
}
