package com.hskj.util;


import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

public class DbConnectUtil {
	private static BasicDataSource dataSource = null;

	public static Connection getConn(String url,String username,String password) throws SQLException {
			try{
//				if(dataSource == null){
					dataSource = new BasicDataSource();
//				}
				dataSource.setDriverClassName("com.mysql.jdbc.Driver");
				dataSource.setUrl(url);
				dataSource.setUsername(username);
				dataSource.setPassword(password);
				dataSource.setValidationQuery("select 1");
				dataSource.setTestOnBorrow(true);
				dataSource.setTestWhileIdle(true);
				dataSource.setTestOnReturn(true);
				dataSource.setMaxWait(60000);
			}catch(Exception e){
				e.printStackTrace();
			}
		return dataSource.getConnection();
	}
	@Override
	protected void finalize() throws Throwable {
		try{
			dataSource.close();
			super.finalize(); 
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
