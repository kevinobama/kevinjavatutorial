package http;

import java.net.*;
import java.io.*;

public class HttpUrlConnectionExample {
	  public static void main(String[] args) throws Exception {		  		 		  
		  //httpURLConnectionOne();
		  //httpURLConnectionTwo();
		  httpURLConnectionPost();
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
}
