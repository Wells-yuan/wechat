package com.util.time;

import java.util.Calendar;

public class Current {
	
	private static Calendar c = Calendar.getInstance();
	private static int year = getYear();
	private static int month = getMonth();
	
	
	public static String getCurTerm(){
		String term = "";
		if(month >= 9){
			term = String.valueOf(year) + "03";
		}else if(month <= 2){
			term = String.valueOf(year - 1) + "03";
		}else{
			term = String.valueOf(year) + "01";
		}
		return term;
	}
	
	public static String getLastTerm(){
		String term = getCurTerm();
		int year = Integer.valueOf(term.substring(0, 4));
		char t = term.charAt(5);
		if(t == '3'){
			term = String.valueOf(year) + "01";
		}else{
			term = String.valueOf(year-1) + "03";
		}
		return term;
	}
	
	public static int getYear(){
		return c.get(Calendar.YEAR);
	}
	
	public static int getMonth(){
		return c.get(Calendar.MONTH) + 1;
	}
	
	public static int getStuyear(String stuid){
		int grade = 0;
		String currentTerm = getCurTerm();
		int inYear = Integer.valueOf(stuid.substring(0, 4));
		int curYear = Integer.valueOf(currentTerm.substring(0, 4));
		int curTerm = currentTerm.charAt(5) - '0';
		if(curTerm - 3 == 0){
			grade = curYear - inYear + 1;
		}else{
			grade = curYear - inYear;
		}
		return grade;
	}
	
	public static void main(String[] args) {
//		System.out.println(getCurTerm());
		System.out.println(getStuyear("2014112213"));
	}
}
