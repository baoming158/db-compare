package com.hskj.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hskj.dbunit.DBComponent;
import com.hskj.dbunit.Table;
import com.hskj.main.Comparation;
import com.hskj.service.CompareService;

@Controller
public class CompareController {
	@Autowired
	CompareService compareService; 
	
	@RequestMapping("/showDiff.do")
	public String showDiff(HttpServletRequest request,HttpSession session,ModelMap modelMap){
		DBComponent c = compareService.getComponentBase(request);
		List<DBComponent> compareTables = compareService.getComponentOthers(request);
		Comparation comparation = new Comparation();
		comparation._compare(c, compareTables);
		session.setAttribute("list", compareTables);
		session.setAttribute("db_base", c);
		return "compare";
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
}
