package http;

import java.net.*;
import java.io.*;

public class HttpUrlConnectionExample {
	  public static void main(String[] args) throws Exception {		  		 		  
		  //httpURLConnectionOne();
		  //httpURLConnectionTwo();
		  httpURLConnectionRequest();
	  }
	  
	public static void httpURLConnectionOne() {
		  try {    
			  URL url=new URL("http://localhost");    
			  HttpURLConnection connection=(HttpURLConnection)url.openConnection();  

			  BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	          String line;
	          while ((line = in.readLine()) != null)
	          {
	              System.out.println(line);
	          }
			  
	          connection.disconnect();   
			  } catch(Exception e) {
				  System.out.println(e);
			  }    
	}
	  
	public static void httpURLConnectionTwo() throws Exception {		  		 
	  System.out.println("http Url connection");
	  StringBuilder result = new StringBuilder();
      BufferedReader in = null;
      try
      {
          //String url = "https://sj.eihoo.com/login";
      	String url = "http://www.bing.com";
 
          URL realUrl = new URL(url);
          URLConnection connection = realUrl.openConnection();
          connection.setRequestProperty("accept", "*/*");
          connection.setRequestProperty("connection", "Keep-Alive");
          connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
          connection.connect();
          in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
          String line;
          while ((line = in.readLine()) != null)
          {
              result.append(line);
          }
      }
      catch (ConnectException e)
      {
      	System.out.println("调用HttpUtils.sendGet ConnectException, url=");
      }
		System.out.println(result.toString());
	}	  
	
	public static void httpURLConnectionPost() throws Exception {		  		 
		  System.out.println("http Url connection");
		  StringBuilder result = new StringBuilder();
	      BufferedReader in = null;
	      try
	      {
	          //String url = "https://sj.eihoo.com/login";
	      	String url = "http://localhost:8081/order";
	 
	          URL realUrl = new URL(url);
	          URLConnection connection = realUrl.openConnection();
	          connection.setRequestProperty("accept", "*/*");
	          connection.setRequestProperty("connection", "Keep-Alive");
	          connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
	          
	          connection.connect();
	          in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	          String line;
	          while ((line = in.readLine()) != null)
	          {
	              result.append(line);
	          }
	      }
	      catch (ConnectException e)
	      {
	      	System.out.println("调用HttpUtils.sendGet ConnectException, url=");
	      }
		  System.out.println(result.toString());
	}
	
	public static void httpURLConnectionRequest() throws Exception {		  		 
		  System.out.println("http Url connection");
		  String requestPara ="{\"order_user_name\": \"kevin gates\", \"order_id\": \"1\"}";
		  
		  StringBuilder result = new StringBuilder();
	      BufferedReader in = null;
	      try {
	          //String url = "https://sj.eihoo.com/login";
	      	  String url = "http://localhost:8081/order";
	    	  //String url ="http://localhost:8081/order/create";
	      	  
	          URL realUrl = new URL(url);
	          HttpURLConnection connection = (HttpURLConnection)realUrl.openConnection();
	          connection.setRequestProperty("Content-Type", "application/json; utf-8");
	          connection.setRequestMethod("GET");
	          connection.setDoOutput(true);

	          connection.connect();
	          
	          try(OutputStream os = connection.getOutputStream()) {
	        	    byte[] input = requestPara.getBytes("utf-8");
	        	    os.write(input, 0, input.length);			
	        	}
	                
	          in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	          String line;
	          while ((line = in.readLine()) != null)
	          {
	              result.append(line);
	          }
	      }
	      catch (ConnectException e)
	      {
	      	System.out.println("error:"+e.getMessage());
	      }
		  System.out.println(result.toString());
	}
}
