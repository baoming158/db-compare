package com.hskj.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.hskj.dbunit.DBComponent;

@Service
public class CompareService {

	public DBComponent getComponentBase(HttpServletRequest request) throws SQLException{
		String[] url = request.getParameterValues("url");
		String[] username = request.getParameterValues("username");
		String[] password = request.getParameterValues("password");
		DBComponent c = new DBComponent(url[0],username[0],password[0]);
		return c;
	}

	public List<DBComponent> getComponentOthers(HttpServletRequest request) throws SQLException{
		List<DBComponent> list = new ArrayList<DBComponent>();
		String[] url = request.getParameterValues("url");
		String[] username = request.getParameterValues("username");
		String[] password = request.getParameterValues("password");
		for(int i = 1;i<url.length;i++){
			if(url!=null&&!"".equals(url)){
				DBComponent c = new DBComponent(url[i],username[i],password[i]);
				list.add(c);
			}
		}
		return list;
	}
}
