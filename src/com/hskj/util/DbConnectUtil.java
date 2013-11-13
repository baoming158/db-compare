package com.hskj.util;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.commons.dbcp.BasicDataSource;

public class DbConnectUtil {
	private static BasicDataSource dataSource = null;
	private static Lock lock = new ReentrantLock();

	public static Connection getConn(String url,String username,String password) throws SQLException {
			try{
				lock.lock();
//				if(dataSource == null){
					dataSource = new BasicDataSource();
//				}
				dataSource.setDriverClassName("com.mysql.jdbc.Driver");
				dataSource.setUrl(url);
				dataSource.setUsername(username);
				dataSource.setPassword(password);
				dataSource.setValidationQuery("select 1");
				dataSource.setTestOnBorrow(true);
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				lock.unlock();
			}
		return dataSource.getConnection();
	}
	@Override
	protected void finalize() throws Throwable {
		try{
			dataSource.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
