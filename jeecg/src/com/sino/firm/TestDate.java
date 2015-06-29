package com.sino.firm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



public class TestDate
{
	public static void main(String[] args)
	{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		try
		{
			Date time1 = df.parse("2015-06-23 12:01:01");
			Date time2 = df.parse("2015-06-23 12:58:46");
			System.out.println(df.format(time1));
			System.out.println(time1.getTime());
			System.out.println(time2.getTime());
			
			System.out.println((float)(time2.getTime()-time1.getTime())/60/1000/60);
		} catch (ParseException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
