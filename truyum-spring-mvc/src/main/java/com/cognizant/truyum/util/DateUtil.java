package com.cognizant.truyum.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public DateUtil() {
		// TODO Auto-generated constructor stub
	}
	
    public static Date convertToDate(String date) throws ParseException {
    	
    	 Date dateFormat=new SimpleDateFormat("dd/MM/yyyy").parse(date);  
		return dateFormat;
    	
    }
}
