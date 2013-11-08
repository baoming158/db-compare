package com.hskj.util;


public class DBSumary {
	private static String summary = "";
	private static ErrorMessage errMsg = new ErrorMessage();
	public static void addSchemataMsg(String msg){
		errMsg.getSchmata_msg().add(msg);
	}
	public static void addTableMsg(String msg){
		errMsg.getTable_msg().add(msg);
	}
	public static void addColumnMsg(String msg){
		errMsg.getColumn_msg().add(msg);
	}
	public static String getErrorMessage(){
		return errMsg.toString();
	}
	
	public static String getSummary() {
		return summary;
	}
	public static void setSummary(String summary) {
		DBSumary.summary = summary;
	}
	public static String nextMessage(){
		String tmp = summary+":\r\n"+errMsg.toString();
		errMsg.empty();
		summary="";
		return tmp;
	}
}
