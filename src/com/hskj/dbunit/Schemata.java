package com.hskj.dbunit;

import com.hskj.util.DBSumary;

public class Schemata {
	private String SCHEMA_NAME;
	private String DEFAULT_CHARACTER_SET_NAME;
	private String DEFAULT_COLLATION_NAME;
	public String getSCHEMA_NAME() {
		return SCHEMA_NAME;
	}
	public void setSCHEMA_NAME(String schema_name) {
		SCHEMA_NAME = schema_name;
	}
	public String getDEFAULT_CHARACTER_SET_NAME() {
		return DEFAULT_CHARACTER_SET_NAME;
	}
	public void setDEFAULT_CHARACTER_SET_NAME(String default_character_set_name) {
		DEFAULT_CHARACTER_SET_NAME = default_character_set_name;
	}
	public String getDEFAULT_COLLATION_NAME() {
		return DEFAULT_COLLATION_NAME;
	}
	public void setDEFAULT_COLLATION_NAME(String default_collation_name) {
		DEFAULT_COLLATION_NAME = default_collation_name;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Schemata other = (Schemata) obj;
		if (DEFAULT_CHARACTER_SET_NAME == null) {
			if (other.DEFAULT_CHARACTER_SET_NAME != null)
				DBSumary.addSchemataMsg("err:数据库"+this.SCHEMA_NAME+"字符编码（DEFAULT_CHARACTER_SET_NAME）不同");
				return false;
		} else if (!DEFAULT_CHARACTER_SET_NAME
				.equals(other.DEFAULT_CHARACTER_SET_NAME)){
			DBSumary.addSchemataMsg("err:数据库"+this.SCHEMA_NAME+"字符编码（DEFAULT_CHARACTER_SET_NAME）不同");
			return false;
		}
		if (DEFAULT_COLLATION_NAME == null) {
			if (other.DEFAULT_COLLATION_NAME != null){
				DBSumary.addSchemataMsg("err:数据库"+this.SCHEMA_NAME+"定序方式（DEFAULT_COLLATION_NAME）不同");
				return false;
			}
		} else if (!DEFAULT_COLLATION_NAME.equals(other.DEFAULT_COLLATION_NAME)){
			DBSumary.addSchemataMsg("err:数据库"+this.SCHEMA_NAME+"定序方式（DEFAULT_COLLATION_NAME）不同");
			return false;
		}
		return true;
	}
	
	
}