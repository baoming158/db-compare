package com.hskj.dbunit;

import java.util.ArrayList;
import java.util.List;

import com.hskj.util.DBSumary;

public class Table{
	private String TABLE_SCHEMA;//数据库名称
	private String TABLE_NAME;//表名称
	private String ENGINE;//表驱动
	private boolean is_exit = true;//对方是否存在
	private boolean is_extra_table;//是否为多出的表
	List<Column> columnList ;
	List<Column> rm_list = new ArrayList<Column>();//不存在的表
	List<String> err_filed = new ArrayList<String>();
	
	public boolean isIs_extra_table() {
		return is_extra_table;
	}
	public void setIs_extra_table(boolean is_extra_table) {
		this.is_extra_table = is_extra_table;
	}
	public List<String> getErr_filed() {
		return err_filed;
	}
	public void setErr_filed(List<String> err_filed) {
		this.err_filed = err_filed;
	}
	public List<Column> getRm_list() {
		return rm_list;
	}
	public void setRm_list(List<Column> rm_list) {
		this.rm_list = rm_list;
	}
	public boolean isIs_exit() {
		return is_exit;
	}
	public void setIs_exit(boolean is_exit) {
		this.is_exit = is_exit;
	}
	public String getTABLE_SCHEMA() {
		return TABLE_SCHEMA;
	}
	public void setTABLE_SCHEMA(String table_schema) {
		TABLE_SCHEMA = table_schema;
	}
	public String getTABLE_NAME() {
		return TABLE_NAME;
	}
	public void setTABLE_NAME(String table_name) {
		TABLE_NAME = table_name;
	}
	public String getENGINE() {
		return ENGINE;
	}
	public void setENGINE(String engine) {
		ENGINE = engine;
	}
	
	public List<Column> getColumnList() {
		return columnList;
	}
	public void setColumnList(List<Column> columnList) {
		this.columnList = columnList;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Table other = (Table) obj;
		if (ENGINE == null) {
			if (other.ENGINE != null){
				DBSumary.addTableMsg("err:表"+this.TABLE_NAME+"驱动（ENGINE）不同");
				return false;
			}
		} else if (!ENGINE.equals(other.ENGINE)){
			DBSumary.addTableMsg("err:表"+this.TABLE_NAME+"驱动（ENGINE）不同");
			return false;
		}
		if (TABLE_NAME == null) {
			if (other.TABLE_NAME != null){
				DBSumary.addTableMsg("err:表"+this.TABLE_NAME+"名称（table_name）不同");
				return false;
			}
		} else if (!TABLE_NAME.equals(other.TABLE_NAME)){
			DBSumary.addTableMsg("err:表"+this.TABLE_NAME+"名称（table_name）不同");
			return false;
		}
		return true;
	}
	public Column getColumnByName(String table_name,String column_name) {
		for(Column c:columnList){
			if(c.getColumn_name().equals(column_name)&&c.getTable_name().equals(table_name)){
				return c;
			}
		}
		return null;
	}
	
}
