package fileandio;

import java.util.*;
import java.io.*;
public class FileinputStreamExample {

	public static void main(String[] args) {
		try {
			InputStream file = new FileInputStream("/var/tmp/ctwing.json");
			System.out.println(file);
			
	         int size = file.available();

	         for(int i = 0; i < size; i++) {
	            System.out.print((char)file.read());
	         }
	         file.close();
	         	         							
		} catch (Exception e) {
			System.out.println("test"+e);
		}
	}	
}