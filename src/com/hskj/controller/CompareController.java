package com.hskj.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hskj.dbunit.DBComponent;
import com.hskj.dbunit.Table;
import com.hskj.main.Comparation;
import com.hskj.service.CompareService;
import com.hskj.util.DbConnectUtil;

@Controller
public class CompareController {
	@Autowired
	CompareService compareService; 
	
	@RequestMapping("/showDiff.do")
	public String showDiff(HttpServletRequest request,HttpServletResponse response,HttpSession session,ModelMap modelMap) throws Exception{
		
		DBComponent c = null;
		
		List<DBComponent> compareTables = null;
		c = compareService.getComponentBase(request);
		compareTables = compareService.getComponentOthers(request);
		Comparation comparation = new Comparation();
		comparation._compare(c, compareTables);
		session.setAttribute("list", compareTables);
		session.setAttribute("db_base", c);
		return "compare";
	}
	@RequestMapping("/showDiff1.do")
	public String showDiff1(HttpServletRequest request,HttpServletResponse response,HttpSession session,ModelMap modelMap) throws Exception{
		String[] url = request.getParameterValues("url");
		String[] username = request.getParameterValues("username");
		String[] password = request.getParameterValues("password");
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/getFiledByTable.do")
	public String getFiledByTable(HttpServletRequest request,HttpSession session,ModelMap modelMap){
		String order = request.getParameter("order");
		String table_name = request.getParameter("table_name");
		String type  = request.getParameter("type");
		DBComponent db_base = (DBComponent)session.getAttribute("db_base");
		List<DBComponent> db_list = (List<DBComponent>)session.getAttribute("list");
		if(type.equals("original")){
			Table table = db_base.getTableByTableName(table_name);
			modelMap.addAttribute("t",table);
			return "field_original";
		}else if(type.equals("add")){
			DBComponent db_other = db_list.get(Integer.parseInt(order));
			Table table = db_other.getTableByTableName(table_name);
			modelMap.addAttribute("t",table);
			return "field_add";
		}else if(type.equals("rm")){
			Table table = db_base.getTableByTableName(table_name);
			modelMap.addAttribute("t",table);
			return "field_rm";
		}else if(type.equals("mod")){
			DBComponent db_other = db_list.get(Integer.parseInt(order));
			Table table = db_other.getTableByTableName(table_name);
			modelMap.addAttribute("t",table);
			return "field_mod";
		}
		return "compare";
	}
	@ResponseBody
	@RequestMapping("/testConnection.do")
	public String testConnection(HttpServletRequest request,HttpServletResponse response,HttpSession session,ModelMap modelMap){
		String url = request.getParameter("url");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Connection conn = null;
		try {
			conn = DbConnectUtil.getConn(url,username,password);
			if(conn!=null){
				return "ok";
			}else{
				return "err";
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return "err";
		}finally{
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
