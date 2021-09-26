package http;

import java.io.BufferedReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class TickerController {
	public static void main(String[] args) throws IOException, InterruptedException, ParseException {
		String cmd = "curl -x socks5h://localhost:8888 https://api.bitfinex.com/v1/pubticker/ethusd";//ethusd
		Runtime run = Runtime.getRuntime();
		Process pr = run.exec(cmd);
		pr.waitFor();
		
		BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
		String line = "";
		StringBuilder json = new StringBuilder();
		while ((line=buf.readLine())!=null) {
			json.append(line);
		}
				
	  JSONParser parser = new JSONParser();
      Object jsonDataOject = parser.parse(json.toString());
      JSONObject tickerJsonObject = (JSONObject)jsonDataOject;
      
      String price = tickerJsonObject.get("last_price").toString();
      System.out.println(price);	      
	}
}