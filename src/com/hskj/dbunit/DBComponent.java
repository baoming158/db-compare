package com.hskj.dbunit;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hskj.util.DbConnectUtil;




public class DBComponent{
	private String url;
	private String dbname;
	private Connection conn = null;
	
	private List<Table> tableList;
	private List<Table> rm_list = new ArrayList<Table>();
	private List<Column> columnList;//一次性查询出来 避免对业务服务器过多的查询
	private boolean modified;
	private Schemata schemata;
	
	
	public boolean isModified() {
		return modified;
	}
	public void setModified(boolean modified) {
		this.modified = modified;
	}
	public List<Table> getRm_list() {
		return rm_list;
	}
	public void setRm_list(List<Table> rm_list) {
		this.rm_list = rm_list;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDbname() {
		return dbname;
	}
	public void setDbname(String dbname) {
		this.dbname = dbname;
	}
	public List<Table> getTableList() {
		return tableList;
	}
	public void setTableList(List<Table> tableList) {
		this.tableList = tableList;
	}
	public List<Column> getColumnList(String table_name){
		List<Column> list = new ArrayList<Column>();
		for(Column column:this.columnList){
			if(column.getTable_name().equals(table_name)){
				list.add(column);
			}
		}
		return list;
	}
	public void setColumnList(List<Column> columnList) {
		this.columnList = columnList;
	}
	public void setSchemata(Schemata schemata) {
		this.schemata = schemata;
	}
	
	public Schemata getSchemata() {
		return schemata;
	}
	public Column getColumnByColumnName(String table_name,String column_name){
		if(columnList!=null&&columnList.size()>0){
			for(Column column:columnList){
				if(column.getColumn_name().equals(column_name)&&column.getTable_name().equals(table_name)){
					return column;
				}
			}
		}
		return null;
	}
	public DBComponent(String url,String username,String password) throws SQLException{
		this.url = url;
		dbname = getDBName(url);
		try {
			this.conn = DbConnectUtil.getConn(url,username,password);
			this.columnList = getColumnsByTableName(null);
			this.tableList = getTableList(null);
			this.schemata = getDBSchemata();
		}finally{
			if(conn!=null&&!conn.isClosed()){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	private List<Table> getTableList(String table_name) throws SQLException {
		String sql = " select * from information_schema.TABLES where TABLE_SCHEMA='"+dbname+"'";
		if(table_name!=null){
			sql +=" and TABLE_NAME='"+table_name+"'";
		}
		PreparedStatement pst = conn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		List<Table> tablelist = new ArrayList<Table>();
		while(rs.next()){
			Table table = new Table();
			table.setENGINE(rs.getString("ENGINE"));
			table.setTABLE_NAME(rs.getString("TABLE_NAME"));
			table.setTABLE_SCHEMA(rs.getString("TABLE_SCHEMA"));
			tablelist.add(table);
			table.setColumnList(getTableColumns(table.getTABLE_NAME()));
		}
		return tablelist;
	}
	private List<Column> getTableColumns(String table_name){
		if(columnList!=null&&columnList.size()>0){
			List<Column> list = new ArrayList<Column>();
			for(Column c:columnList){
				if(c.getTable_name().equals(table_name)){
					list.add(c);
				}
			}
			return list;
		}
		return null;
	
	}
	private List<Column> getColumnsByTableName(String table_name) throws SQLException{
		String sql = "select * from information_schema.COLUMNS where TABLE_SCHEMA='"+dbname+"'";
		if(table_name!=null){
			sql +=" and TABLE_NAME='"+table_name+"'";
		}
		PreparedStatement pst = conn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		List<Column> columnlist = new ArrayList<Column>();
		while(rs.next()){
			Column column = new Column();
			column.setTable_catalog(rs.getString("TABLE_SCHEMA"));
			column.setTable_schema(rs.getString("TABLE_SCHEMA"));
			column.setTable_name(rs.getString("TABLE_NAME"));
			column.setColumn_name(rs.getString("COLUMN_NAME"));
			column.setOrdinal_position(rs.getInt("ORDINAL_POSITION"));
			column.setColumn_default(rs.getString("COLUMN_DEFAULT"));
			column.setIs_nullable(rs.getString("IS_NULLABLE"));
			column.setData_type(rs.getString("DATA_TYPE"));
			column.setCharacter_maximum_length(rs.getString("CHARACTER_MAXIMUM_LENGTH"));
			column.setCharacter_octet_length(rs.getString("CHARACTER_OCTET_LENGTH"));
			column.setNumeric_precision(rs.getString("NUMERIC_PRECISION"));
			column.setNumeric_scale(rs.getString("NUMERIC_SCALE"));
			column.setCharacter_set_name(rs.getString("CHARACTER_SET_NAME"));
			column.setCollation_name(rs.getString("COLLATION_NAME"));
			column.setColumn_type(rs.getString("COLUMN_TYPE"));
			column.setColumn_key(rs.getString("COLUMN_KEY"));
			column.setExtra(rs.getString("EXTRA"));
			column.setPrivileges(rs.getString("PRIVILEGES"));
			column.setColumn_comment(rs.getString("COLUMN_COMMENT"));
			columnlist.add(column);
		}
		return columnlist;
	}
	private Schemata getDBSchemata() throws SQLException{
		String sql = " select * from information_schema.SCHEMATA where SCHEMA_NAME='"+dbname+"'";
		PreparedStatement pst = conn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		if(rs.next()){
			Schemata schemata = new Schemata();
			schemata.setSCHEMA_NAME(rs.getString("SCHEMA_NAME"));
			schemata.setDEFAULT_CHARACTER_SET_NAME(rs.getString("DEFAULT_CHARACTER_SET_NAME"));
			schemata.setDEFAULT_COLLATION_NAME(rs.getString("DEFAULT_COLLATION_NAME"));
			return schemata;
		}else{
			return null;
		}
	}
	private static String getDBName(String url) {
		int start = url.lastIndexOf("/");
		int end = url.lastIndexOf("?")==-1?url.length():url.lastIndexOf("?");
		return url.substring(start+1, end);
	}
	public Table getTableByTableName(String table_name) {
		for(Table t:tableList){
			if(t.getTABLE_NAME().equals(table_name)){
				return t;
			}
		}
		return null;
	}
}
	
