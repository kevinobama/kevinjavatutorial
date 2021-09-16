package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class DateTimeUtil {

	public static void main(String[] args) throws ParseException {
		
//		long unixTime = System.currentTimeMillis() / 1000L;
//		System.out.println(unixTime);

		
			/**
			* 生成DateFormat类对象的固定格式
			* */
			DateFormat df = new SimpleDateFormat("yyyy-MM-DD HH:mm:ss");
			/**
			* 获取日期转换为Unix时间戳
			*/
			long epoch = df.parse("2021-08-01 0:0:0").getTime();
			System.out.println(epoch);
						
			epoch = df.parse("2021-08-31 16:0:0").getTime();
			System.out.println(epoch);
			//1420777414000
	
//			/**
//			* 根据Unix时间戳得到时间
//			* */
//			Date d = new Date(epoch);
//			/**
//			* 转换为日期
//			*/
//			String t = df.format(d);
//			System.out.println(t + " " + epoch);
		
		}
}