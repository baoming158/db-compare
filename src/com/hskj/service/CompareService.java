package com.hskj.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.hskj.dbunit.DBComponent;

@Service
public class CompareService {

	public DBComponent getComponentBase(HttpServletRequest request) {
		String url = request.getParameter("url");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		DBComponent c = new DBComponent(url,username,password);
		return c;
	}

	public List<DBComponent> getComponentOthers(HttpServletRequest request) {
		List<DBComponent> list = new ArrayList<DBComponent>();
		for(int i = 1;i<100;i++){
			String url = request.getParameter("url"+i);
			String username = request.getParameter("username"+i);
			String password = request.getParameter("password"+i);
			if(url!=null&&!url.equals("")){
				DBComponent c = new DBComponent(url,username,password);
				list.add(c);
			}else{
				break;
			}
		}
		return list;
	}
}
