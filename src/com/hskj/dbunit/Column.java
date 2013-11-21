package com.hskj.dbunit;

import java.util.HashSet;
import java.util.Set;


public class Column {
	private String table_catalog;
	private String table_schema;//库名称
	private String table_name;//表名称*
	private String column_name;//列名称*
	
	private int ordinal_position;//顺序*
	private String column_default;//默认值
	private String is_nullable;//是否为空
	private String data_type;//数据类型 *varchar
	private String character_maximum_length;//字符最大长度
	private String character_octet_length;//字符八进制长度
	private String numeric_precision;//精度
	private String numeric_scale;//数字大小范围
	private String character_set_name;//字符编码
	private String collation_name;//定序
	private String column_type;//列属性*varchar(22)
	private String column_key;//是否为主键
	private String extra;//额外信息 （auto_increment）
	private String privileges;//权限（select,insert,update,references）
	private String column_comment;//注释
	private boolean is_extra_column;//是否为多出的列
	private Column base_column;
	
	Set<String> err_filed = new HashSet<String>();
	
	public boolean isIs_extra_column() {
		return is_extra_column;
	}
	public void setIs_extra_column(boolean is_extra_column) {
		this.is_extra_column = is_extra_column;
	}
	public Set<String> getErr_filed() {
		return err_filed;
	}
	public void setErr_filed(Set<String> err_filed) {
		this.err_filed = err_filed;
	}
	public Column(String table_name,String column_name){
		this.table_name = table_name;
		this.column_name = column_name;
	}
	public Column(){
	}
	public String getTable_name() {
		return table_name;
	}
	public void setTable_name(String table_name) {
		this.table_name = table_name;
	}
	public String getColumn_name() {
		return column_name;
	}
	public void setColumn_name(String column_name) {
		this.column_name = column_name;
	}
	public int getOrdinal_position() {
		return ordinal_position;
	}
	public void setOrdinal_position(int ordinal_position) {
		this.ordinal_position = ordinal_position;
	}
	public String getColumn_default() {
		return column_default;
	}
	public void setColumn_default(String column_default) {
		this.column_default = column_default;
	}
	public String getIs_nullable() {
		return is_nullable;
	}
	public void setIs_nullable(String is_nullable) {
		this.is_nullable = is_nullable;
	}
	public String getData_type() {
		return data_type;
	}
	public void setData_type(String data_type) {
		this.data_type = data_type;
	}
	public String getCharacter_maximum_length() {
		return character_maximum_length;
	}
	public void setCharacter_maximum_length(String character_maximum_length) {
		this.character_maximum_length = character_maximum_length;
	}
	public String getCharacter_octet_length() {
		return character_octet_length;
	}
	public void setCharacter_octet_length(String character_octet_length) {
		this.character_octet_length = character_octet_length;
	}
	public String getNumeric_scale() {
		return numeric_scale;
	}
	public void setNumeric_scale(String numeric_scale) {
		this.numeric_scale = numeric_scale;
	}
	public String getCharacter_set_name() {
		return character_set_name;
	}
	public void setCharacter_set_name(String character_set_name) {
		this.character_set_name = character_set_name;
	}
	public String getCollation_name() {
		return collation_name;
	}
	public void setCollation_name(String collation_name) {
		this.collation_name = collation_name;
	}
	public String getColumn_type() {
		return column_type;
	}
	public void setColumn_type(String column_type) {
		this.column_type = column_type;
	}
	public String getColumn_key() {
		return column_key;
	}
	public void setColumn_key(String column_key) {
		this.column_key = column_key;
	}
	public String getExtra() {
		return extra;
	}
	public void setExtra(String extra) {
		this.extra = extra;
	}
	public String getPrivileges() {
		return privileges;
	}
	public void setPrivileges(String privileges) {
		this.privileges = privileges;
	}
	public String getColumn_comment() {
		return column_comment;
	}
	public void setColumn_comment(String column_comment) {
		this.column_comment = column_comment;
	}
	public String getTable_catalog() {
		return table_catalog;
	}
	public void setTable_catalog(String table_catalog) {
		this.table_catalog = table_catalog;
	}
	public String getTable_schema() {
		return table_schema;
	}
	public void setTable_schema(String table_schema) {
		this.table_schema = table_schema;
	}
	public String getNumeric_precision() {
		return numeric_precision;
	}
	public void setNumeric_precision(String numeric_precision) {
		this.numeric_precision = numeric_precision;
	}
	
	public Column getBase_column() {
		return base_column;
	}
	public void setBase_column(Column base_column) {
		this.base_column = base_column;
	}
	
	
	
	
}

