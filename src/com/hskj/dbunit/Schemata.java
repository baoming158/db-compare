package com.hskj.dbunit;

import java.util.ArrayList;
import java.util.List;

public class Schemata {
	private String SCHEMA_NAME;
	private String DEFAULT_CHARACTER_SET_NAME;
	private String DEFAULT_COLLATION_NAME;
	List<String> err_filed = new ArrayList<String>();
	
	public List<String> getErr_filed() {
		return err_filed;
	}
	public void setErr_filed(List<String> err_filed) {
		this.err_filed = err_filed;
	}
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
	
	
}