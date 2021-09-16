package json;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;
import java.util.*;

public class SimpleJson {
	public static void main(String[] args) {
		System.out.println("start");
		//decodeJson();
		decodeJsonThree();
	}
	
	public static void decodeJson() {
		  JSONParser parser = new JSONParser();
	      String s = "[0,{\"1\":{\"2\":{\"3\":{\"4\":[5,{\"6\":7}]}}}}]";
			
	      try{
	         Object obj = parser.parse(s);
	         JSONArray array = (JSONArray)obj;
				
	         System.out.println("The 2nd element of array");
	         System.out.println(array.get(1));
	         System.out.println();

	         JSONObject obj2 = (JSONObject)array.get(1);
	         System.out.println("Field \"1\"");
	         System.out.println(obj2.get("1"));    

	         s = "{}";
	         obj = parser.parse(s);
	         System.out.println(obj);

	         s = "[5,]";
	         obj = parser.parse(s);
	         System.out.println(obj);

	         s = "[5,,2]";
	         obj = parser.parse(s);
	         System.out.println(obj);
	      }catch(ParseException pe) {
			
	         System.out.println("position: " + pe.getPosition());
	         System.out.println(pe);
	      }
	}
	
	public static void decodeJson1() {
		String jsonData = "{\n" + 
				"  \"upPacketSN\": -1,\n" + 
				"  \"upDataSN\": -1,\n" + 
				"  \"topic\": \"v1/up/ad19\",\n" + 
				"  \"timestamp\": 1630403930495,\n" + 
				"  \"tenantId\": \"2000050324\",\n" + 
				"  \"serviceId\": 1,\n" + 
				"  \"protocol\": \"lwm2m\",\n" + 
				"  \"productId\": \"15081413\",\n" + 
				"  \"payload\": {\n" + 
				"    \"liquid_level\": 402\n" + 
				"  },\n" + 
				"  \"messageType\": \"dataReport\",\n" + 
				"  \"deviceType\": \"\",\n" + 
				"  \"deviceId\": \"5e5a54e224b9436f93900c27f0787f61\",\n" + 
				"  \"assocAssetId\": \"\",\n" + 
				"  \"IMSI\": \"undefined\",\n" + 
				"  \"IMEI\": \"861050042916166\"\n" + 
				"}";
		
		try {
			  JSONParser parser = new JSONParser();
		      Object jsonDataOject = parser.parse(jsonData);
		      JSONObject topicJsonObject = (JSONObject)jsonDataOject;
		      
		      JSONObject payloadJsonObject = (JSONObject)topicJsonObject.get("payload");
		      
		      System.out.println(jsonDataOject);
		      System.out.println(topicJsonObject.get("deviceId"));
		      System.out.println(topicJsonObject.get("topic"));
		      System.out.println(payloadJsonObject.get("liquid_level"));
		      
	      } catch(ParseException e) {			
	         System.out.println("position: " + e.getPosition());
	         System.out.println(e);
	      }				
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
	
	
	public static void decodeJsonThree() {
		String jsonData = "{\n" + 
				"   \"notifyType\": \"deviceDataChanged\",\n" + 
				"   \"deviceId\": \"72fd326c-3cde-48cf-b5e0-9da5e05c30a6\",\n" + 
				"   \"gatewayId\": \"72fd326c-3cde-48cf-b5e0-9da5e05c30a6\",\n" + 
				"   \"requestId\": null,\n" + 
				"   \"service\": {\n" + 
				"      \"serviceId\": \"Device\",\n" + 
				"      \"serviceType\": \"Device\",\n" + 
				"      \"data\": {\n" + 
				"         \"RSRQ\": -4,\n" + 
				"         \"CSQ\": 15,\n" + 
				"         \"SNR\": 25,\n" + 
				"         \"DataLength\": 108,\n" + 
				"         \"RAWData\": \"6811D200050107D200040164D200280108D20023020005D20029020118D20025020003D20039020004D20043020002D200440105EA16\",\n" + 
				"         \"IMEI\": \"861050042936008\",\n" + 
				"         \"CellID_Length\": 7,\n" + 
				"         \"Cell_ID\": \"B2B42D1\"\n" + 
				"      },\n" + 
				"      \"eventTime\": \"20210908T104234Z\"\n" + 
				"   }\n" + 
				"}";
		
		try {
			  JSONParser parser = new JSONParser();
		      Object jsonDataOject = parser.parse(jsonData);
		      JSONObject servicesJsonObject = (JSONObject)jsonDataOject;
		      
		      String notifyType = servicesJsonObject.get("notifyType").toString();
		      
		      JSONObject servicesJsonObjectOne = (JSONObject)servicesJsonObject.get("service");
	      		      		       		     		      
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