package csv;

import java.io.BufferedReader;  
import java.io.FileReader;  
import java.io.IOException; 

public class ReadCSVExample1  
{  
	public static void main(String[] args) throws Exception  {  
		//Scanner sc = new Scanner(new File("/home/kevin/Documents/smartWaterMonitor/devices.csv"));
		String file = "/home/kevin/Documents/smartWaterMonitor/devices.csv";
  
		String line = "";  
		String splitBy = ",";  
		try {  
			//parsing a CSV file into BufferedReader class constructor  
			BufferedReader br = new BufferedReader(new FileReader(file));  
			while ((line = br.readLine()) != null)   //returns a Boolean value  
			{  
				String[] device = line.split(splitBy);    // use comma as separator  
				if(device[0].isEmpty()) {
					System.out.println(" re use data 0=" + device[0] + "  1=" + device[1] + ", 2=" + device[2]+ ", 3=" + device[3]);
				} else {
					System.out.println("data 0=" + device[0] + ", 1=" + device[1] + ", 2=" + device[2]+ ", 3=" + device[3]);	
				}				  
			}  
		} catch (IOException e) {  
			e.printStackTrace();  
		} 
	}  
} 