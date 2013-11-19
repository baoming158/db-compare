package com.hskj.main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hskj.dbunit.DBComponent;
import com.hskj.util.DbConnectUtil;
import com.hskj.util.FileProReader;

public class MainStart {
	public void console_start(){
		DBComponent compareTable = null;
		DBComponent compareTable1 = null;
		DBComponent compareTable2 = null;
		try {
			compareTable = new DBComponent("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=gbk","root","root");
			
			compareTable1 = new DBComponent("jdbc:mysql://localhost:3306/test1?useUnicode=true&characterEncoding=gbk","root","root");
			
			compareTable2 = new DBComponent("jdbc:mysql://localhost:3306/test2?useUnicode=true&characterEncoding=gbk","root","root");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		List<DBComponent> list = new ArrayList<DBComponent>();
		list.add(compareTable1);
		list.add(compareTable2);
		list.add(compareTable);
		
		Comparation c = new Comparation();
		c._compare(compareTable,list);
		for(DBComponent d: list){
			if(d.isModified()){
				c._consolePrint(d);
			}
		}
	}
	
	public void file_start(){
		List<String> url_list = FileProReader.read("url");
		List<String> username_list = FileProReader.read("username");
		List<String> password_list = FileProReader.read("password");
		List<DBComponent> db_list = new ArrayList<DBComponent>();
		int i = 0;
		for(String url:url_list){
			if(url!=null&&!"".equals(url)){
				
				boolean status = testConnection(url,username_list.get(i),password_list.get(i));
				if(!status){
					System.exit(0);
				}
				DBComponent db = null;
				try {
					db = new DBComponent(url_list.get(i),username_list.get(i),password_list.get(i));
				} catch (SQLException e) {
					e.printStackTrace();
				}
				db_list.add(db);
				i++;
			}
		}
		if(db_list!=null&&db_list.size()>1){
			DBComponent db_base = db_list.get(0);
			db_list = db_list.subList(1, db_list.size());
			Comparation c = new Comparation();
			System.out.println("开始比较。。。");
			c._compare(db_base,db_list);
			System.out.println("比较结束");
			String path = "d:/diff_result_"+System.currentTimeMillis()+".txt";
			System.out.println("开始输出到 "+path+" 文件中。。。");
			for(DBComponent d: db_list){
				if(d.isModified()){
					try {
						c._fileWrite(d,path);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			System.out.println("输出结束 请打开文件查看详情");
		}else{
			System.out.println("请正确填写url（至少两个）");
		}
	}
	public boolean testConnection(String url,String username,String password) {
		Connection conn = null;
		System.out.println("测试连接：url:"+url+"\tusername:"+username+"\tpassword:"+password);
		try {
			conn = DbConnectUtil.getConn(url,username,password);
			if(conn!=null){
				System.out.println("\t\t连接成功");
				return true;
			}else{
				System.out.println("\t\t连接失败");
				return false;
			}
		}catch(Exception e){
			System.out.println("\t\t连接失败");
			e.printStackTrace();
			return false;
		}finally{
			try {
				if(conn!=null&&!conn.isClosed()){
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) throws Exception{
		
		MainStart m = new MainStart();
//		m.console_start();
		m.file_start();
	}
}
