package com.hskj.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbcp.BasicDataSource;

public class ConnectionUtils {

	private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();
	static BasicDataSource basicDataSource;

	public static Connection getConnection() {
		
		try {
			Connection connection = threadLocal.get();

			if (connection == null || connection.isClosed()) {
				if (basicDataSource == null) {
					basicDataSource = new BasicDataSource();
				}
				connection = basicDataSource.getConnection();
				threadLocal.set(connection);
				return connection;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static void closeConnection() {
		Connection connection = threadLocal.get();
		try {
			if (connection != null && !connection.isClosed()) {
				connection.close();
				threadLocal.set(null);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(ResultSet rs, Statement stmt) {

		try {
			threadLocal.get().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}