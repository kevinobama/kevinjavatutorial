package http;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class JavaPostRequest {

    private static HttpURLConnection con;

    public static void main(String[] args) throws Exception {

//        String url = "https://httpbin.org/post";
//        String urlParameters = "name=Jack&occupation=programmer";
//        byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);
//
//        try {
//
//        	URL myurl = new URL(url);
//            con = (HttpURLConnection) myurl.openConnection();
//
//            con.setDoOutput(true);
//            con.setRequestMethod("POST");
//            con.setRequestProperty("User-Agent", "Java client");
//            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
//
//            try (var wr = new DataOutputStream(con.getOutputStream())) {
//
//                wr.write(postData);
//            }
//
//            StringBuilder content;
//
//            try (var br = new BufferedReader(
//                    new InputStreamReader(con.getInputStream()))) {
//
//                String line;
//                content = new StringBuilder();
//
//                while ((line = br.readLine()) != null) {
//                    content.append(line);
//                    content.append(System.lineSeparator());
//                }
//            }
//
//            System.out.println(content.toString());
//
//        } finally {
//
//            con.disconnect();
//        }
    	
    	postJsonOne();
    }
    
    
    public static void postJsonOne() throws Exception {
    	URL url = new URL("https://device.api.ct10649.com:8743/iocm/app/sub/v1.2.0/subscriptions");
    	HttpURLConnection http = (HttpURLConnection)url.openConnection();
    	http.setRequestMethod("POST");
    	http.setDoOutput(true);
    	http.setRequestProperty("Content-Type", "application/json");

    	String data = "{\"notifyType\":\"deviceDatasChanged\",\"callbackUrl\":\"http://110.42.169.212/consumer/callback\"}";

    	byte[] out = data.getBytes(StandardCharsets.UTF_8);

    	OutputStream stream = http.getOutputStream();
    	stream.write(out);

    	System.out.println(http.getResponseCode() + " " + http.getResponseMessage());
    	http.disconnect();
    } 
    
}