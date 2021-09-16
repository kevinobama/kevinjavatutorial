package json;

import java.util.*;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class Sever_08 {
	public static void main(String[] args) {		
//		String parameters = "{'cabinetId': '1','inst': 'Sever_08'，'data':["
//				+ "{'doorId':'001','status':'open'},"
//				+ "{'doorId':'002','status':'free'},"
//				+ "{'doorId':'003','status':'booked'},"
//				+ "{'doorId':'004','status':'received'}"
//				+ "]}";

		String parameters = "{'cabinetId':'1','inst':'Sever_08','data':[{'doorId':'001','status':'open'},{'doorId':'002','status':'close'},{'doorId':'003','status':'open'},{'doorId':'004','status':'close'}]}";		
		//System.out.println(parameters);
		
		JSONObject jsonObj = JSON.parseObject(parameters);
		
		if(jsonObj.containsKey("data") && jsonObj.containsKey("cabinetId") && jsonObj.containsKey("inst")) {
	        JSONArray dataParent = jsonObj.getJSONArray("data");
			
	        Long cabinetId = Long.valueOf(jsonObj.get("cabinetId").toString());
	        String inst = jsonObj.get("inst").toString();
	        
	        System.out.println("cabinetId:"+cabinetId+","+inst);
	        
			for(Object  dataChild : dataParent ) {			
				JSONObject jsonObj1 = JSON.parseObject(dataChild.toString());
				String doorId = jsonObj1.get("doorId").toString();
				String status = jsonObj1.get("status").toString();
				
				System.out.println(doorId+","+status);
			}
		} else {
			System.out.println("json data is wrong.");
		}
	
//		System.out.println(jsonObj);
//		System.out.println("==================================");
//		System.out.println(jsonObj.get("data"));
	}
}
