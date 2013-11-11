package com.hskj.dbunit;

import java.util.HashSet;
import java.util.Set;

import com.hskj.util.DBSumary;




public class Column {
	private String table_catalog;
	private String table_schema;
	private String table_name;
	private String column_name;
	
	private int ordinal_position;
	private String column_default;
	private String is_nullable;
	private String data_type;
	private String character_maximum_length;
	private String character_octet_length;
	private String numeric_precision;
	private String numeric_scale;
	private String character_set_name;
	private String collation_name;
	private String column_type;
	private String column_key;
	private String extra;
	private String privileges;
	private String column_comment;
	private boolean is_extra_column;
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
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Column other = (Column) obj;
		if (character_maximum_length == null) {
			if (other.character_maximum_length != null){
				DBSumary.addColumnMsg("err:表 "+this.table_name+" 所在列 "+this.column_name+" 的字符串长度（character_maximum_length）不同");
				return false;
			}
		} else if (!character_maximum_length
				.equals(other.character_maximum_length)){
			DBSumary.addColumnMsg("err:表 "+this.table_name+" 所在列 "+this.column_name+" 的字符串长度（character_maximum_length）不同");
			return false;
		}
		if (character_set_name == null) {
			if (other.character_set_name != null){
				DBSumary.addColumnMsg("err:表 "+this.table_name+" 所在列 "+this.column_name+" 的字符字符编码（character_set_name）不同");
				return false;
			}
		} else if (!character_set_name.equals(other.character_set_name)){
			DBSumary.addColumnMsg("err:表 "+this.table_name+" 所在列 "+this.column_name+" 的字符字符编码（character_set_name）不同");
			return false;
		}
		if (collation_name == null) {
			if (other.collation_name != null){
				DBSumary.addColumnMsg("err:表 "+this.table_name+" 所在列 "+this.column_name+" 的定序（collation_name）方式不同");
				return false;
			}
		} else if (!collation_name.equals(other.collation_name)){
			DBSumary.addColumnMsg("err:表 "+this.table_name+" 所在列 "+this.column_name+" 的定序（collation_name）方式不同");
			return false;
		}
		if (column_default == null) {
			if (other.column_default != null){
				DBSumary.addColumnMsg("err:表 "+this.table_name+" 所在列 "+this.column_name+" 默认值（column_default）不同");
				return false;
			}
		} else if (!column_default.equals(other.column_default)){
			DBSumary.addColumnMsg("err:表 "+this.table_name+" 所在列 "+this.column_name+" 默认值（column_default）不同");
			return false;
		}
		if (column_key == null) {
			if (other.column_key != null){
				DBSumary.addColumnMsg("err:表 "+this.table_name+" 所在列 "+this.column_name+" 主键（column_key）设置不同");
				return false;
			}
		} else if (!column_key.equals(other.column_key)){
			DBSumary.addColumnMsg("err:表 "+this.table_name+" 所在列 "+this.column_name+" 主键（column_key）设置不同");
			return false;
		}
		if (column_name == null) {
			if (other.column_name != null){
				DBSumary.addColumnMsg("err:表 "+this.table_name+" 所在列 "+this.column_name+" 名称（column_name）不同");
				return false;
			}
		} else if (!column_name.equals(other.column_name)){
			DBSumary.addColumnMsg("err:表 "+this.table_name+" 所在列 "+this.column_name+" 名称（column_name）不同");
			return false;
		}
		if (column_type == null) {
			if (other.column_type != null){
				DBSumary.addColumnMsg("err:表 "+this.table_name+" 所在列 "+this.column_name+" 类型（column_type）不同");
				return false;
			}
		} else if (!column_type.equals(other.column_type)){
			DBSumary.addColumnMsg("err:表 "+this.table_name+" 所在列 "+this.column_name+" 类型（column_type）不同");
			return false;
		}
		if (data_type == null) {
			if (other.data_type != null)
				DBSumary.addColumnMsg("err:表 "+this.table_name+" 所在列 "+this.column_name+" 数据类型（data_type）不同");
				return false;
		} else if (!data_type.equals(other.data_type)){
			DBSumary.addColumnMsg("err:表 "+this.table_name+" 所在列 "+this.column_name+" 数据类型（data_type）不同");
			return false;
		}
		if (extra == null) {
			if (other.extra != null){
				DBSumary.addColumnMsg("err:表 "+this.table_name+" 所在列 "+this.column_name+" 附加信息（extra）不同");
				return false;
			}
		} else if (!extra.equals(other.extra)){
			DBSumary.addColumnMsg("err:表 "+this.table_name+" 所在列 "+this.column_name+" 附加信息（extra）不同");
			return false;
		}
		if (is_nullable == null) {
			if (other.is_nullable != null){
				DBSumary.addColumnMsg("err:表 "+this.table_name+" 所在列 "+this.column_name+" 非空定义（is_nullable）不同");
				return false;
			}
		} else if (!is_nullable.equals(other.is_nullable)){
			DBSumary.addColumnMsg("err:表 "+this.table_name+" 所在列 "+this.column_name+" 非空定义（is_nullable）不同");
			return false;
		}
		if (ordinal_position != other.ordinal_position){
			DBSumary.addColumnMsg("err:表 "+this.table_name+" 所在列 "+this.column_name+" 顺序（ordinal_position）不同");
			return false;
		}
		if (table_name == null) {
			if (other.table_name != null)
				DBSumary.addColumnMsg("err:表 "+this.table_name+" 所在列 "+this.column_name+" 表名（table_name）不同");
				return false;
		} else if (!table_name.equals(other.table_name)){
			DBSumary.addColumnMsg("err:表 "+this.table_name+" 所在列 "+this.column_name+" 表名（table_name）不同");
			return false;
		}
		return true;
	}
	
	
	
	
}

