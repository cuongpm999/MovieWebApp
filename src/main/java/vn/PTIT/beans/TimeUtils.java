package vn.PTIT.beans;

import java.util.Calendar;

public class TimeUtils {
	public static int editTime() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, -1);
		return cal.get(Calendar.YEAR);		
	}
	
	public static int filterTime() {
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.YEAR);		
	}
	
	public static int filterTime1() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, -1);
		return cal.get(Calendar.YEAR);		
	}
	
	public static int filterTime2() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, -2);
		return cal.get(Calendar.YEAR);		
	}
	
	public static int filterTime3() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, -3);
		return cal.get(Calendar.YEAR);		
	}
	
	public static int filterTime4() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, -4);
		return cal.get(Calendar.YEAR);		
	}

}
