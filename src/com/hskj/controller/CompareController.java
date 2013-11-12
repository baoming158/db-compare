package com.hskj.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hskj.dbunit.DBComponent;
import com.hskj.main.Comparation;
import com.hskj.service.CompareService;
import com.hskj.util.DBSumary;

@Controller
public class CompareController {
	@Autowired
	CompareService compareService; 
	
	@RequestMapping("/showDiff.do")
	public String showDiff(HttpServletRequest request,ModelMap modelMap){
		DBComponent c = compareService.getComponentBase(request);
		List<DBComponent> compareTables = compareService.getComponentOthers(request);
		Comparation comparation = new Comparation();
		comparation._compare(c, compareTables);
		modelMap.addAttribute("list",compareTables).addAttribute("db_base",c);;
		return "compare";
//		return "diffResult";
	}
}
