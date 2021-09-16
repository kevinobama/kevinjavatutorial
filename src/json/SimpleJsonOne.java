package json;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;
import java.util.*;

public class SimpleJsonOne {
	public static void main(String[] args) {
		System.out.println("start");
		//decodeJson();
		//decodeJsonThree();
	}
	
	 
	
	public static void decodeJsonTwo() {
		String jsonData = "{\n" + 
				"   \"notifyType\": \"deviceDatasChanged\",\n" + 
				"   \"requestId\": null,\n" + 
				"   \"deviceId\": \"72fd326c-3cde-48cf-b5e0-9da5e05c30a6\",\n" + 
				"   \"gatewayId\": \"72fd326c-3cde-48cf-b5e0-9da5e05c30a6\",\n" + 
				"   \"services\": [\n" + 
				"      {\n" + 
				"         \"serviceId\": \"Device\",\n" + 
				"         \"serviceType\": \"Device\",\n" + 
				"         \"data\": {\n" + 
				"            \"RSRQ\": -4,\n" + 
				"            \"CSQ\": 15,\n" + 
				"            \"SNR\": 25,\n" + 
				"            \"DataLength\": 108,\n" + 
				"            \"RAWData\": \"6811D200050107D200040164D200280108D20023020005D20029020118D20025020003D20039020004D20043020002D200440105EA16\",\n" + 
				"            \"IMEI\": \"861050042936008\",\n" + 
				"            \"CellID_Length\": 7,\n" + 
				"            \"Cell_ID\": \"B2B42D1\"\n" + 
				"         },\n" + 
				"         \"eventTime\": \"20210908T104234Z\"\n" + 
				"      }\n" + 
				"   ]\n" + 
				"}";
		
		try {
			  JSONParser parser = new JSONParser();
		      Object jsonDataOject = parser.parse(jsonData);
		      JSONObject servicesJsonObject = (JSONObject)jsonDataOject;
		      
		      String notifyType = servicesJsonObject.get("notifyType").toString();
		      
		      JSONArray servicesArray = (JSONArray)servicesJsonObject.get("services");
	      		      
		      System.out.println(servicesJsonObject.get("services"));
		      System.out.println(servicesArray.get(0));
		      
		      JSONObject servicesJsonObjectOne = (JSONObject)servicesArray.get(0);
		      JSONObject deviceJsonObject = (JSONObject)servicesJsonObjectOne.get("data");
		      String rawData = deviceJsonObject.get("RAWData").toString();
		      
		      System.out.println(deviceJsonObject.get("IMEI"));
		      System.out.println(deviceJsonObject.get("RAWData"));
		      		      
		      System.out.println(RawdataDecode.decodeWithDefinition(rawData));
		      System.out.println(RawdataDecode.decode(rawData));
		      
		      Map<String,String> result = RawdataDecode.decode(rawData);
		      
		      String DeviceStatus = result.get("0005");
		      String liquidLevel = result.get("0023");
		      
		      System.out.println(DeviceStatus);
		      System.out.println(liquidLevel);
		      
	      } catch(ParseException e) {
	         System.out.println("position: " + e.getPosition());
	         System.out.println(e);
	      }				
	}	 
}