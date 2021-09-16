package fileandio;

import java.io.*;
public class CopyFile {

   public static void main(String args[]) throws IOException {  
      FileInputStream in = null;
      FileOutputStream out = null;

      try {
         in = new FileInputStream("/var/tmp/ctwing.json");
         out = new FileOutputStream("output.txt");
         
         int c;
         while ((c = in.read()) != -1) {
        	System.out.println(c);
        	//String data = new String(Integer.valueOf(c));
        	
        	
            out.write(c);
         }
      } catch(Exception e) {    	  
          System.out.println(e);          
        } finally {
         if (in != null) {
            in.close();
         }
         if (out != null) {
            out.close();
         }
      }
   }
}