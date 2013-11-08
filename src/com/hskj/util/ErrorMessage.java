package com.hskj.util;
import java.util.ArrayList;
import java.util.List;


public class ErrorMessage {
	private List<String> schmata_msg = new ArrayList<String>();
	private List<String>  table_msg = new ArrayList<String>();
	private List<String>  column_msg =  new ArrayList<String>();
	public List<String> getSchmata_msg() {
		return schmata_msg;
	}
	public void setSchmata_msg(List<String> schmata_msg) {
		this.schmata_msg = schmata_msg;
	}
	public List<String> getTable_msg() {
		return table_msg;
	}
	public void setTable_msg(List<String> table_msg) {
		this.table_msg = table_msg;
	}
	public List<String> getColumn_msg() {
		return column_msg;
	}
	public void setColumn_msg(List<String> column_msg) {
		this.column_msg = column_msg;
	}
	@Override
	public String toString() {
		String schemata_err="";
		for(String str:schmata_msg){
			schemata_err +=str+"\r\n";
		}
		String table_err="";
		for(String str:table_msg){
			table_err +=str+"\r\n";
		}
		String column_err="";
		for(String str:column_msg){
			column_err +=str+"\r\n";
		}
		String msg = "数据库属性：\r\n"+schemata_err;
		msg += "表属性：\r\n"+table_err;
		msg += "列属性：\r\n"+column_err;
		return msg;
	}
	public void empty(){
		schmata_msg.clear();
		table_msg.clear();
		column_msg.clear();
	}
	
}
