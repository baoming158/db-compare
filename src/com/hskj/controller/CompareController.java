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
	@RequestMapping("/comparing.do")
	public String comparing(HttpServletRequest request,ModelMap modelMap){
		DBComponent c = compareService.getComponentBase(request);
		List<DBComponent> c1 = compareService.getComponentOthers(request);
		Comparation comparation = new Comparation();
		String msg = comparation.compare2(c, c1);
		modelMap.addAttribute("msg",msg).addAttribute("db_base",c);
		
		return "diffResult";
	}
	
	
	@RequestMapping("/showDiff.do")
	public String showDiff(HttpServletRequest request,ModelMap modelMap){
		DBComponent c = compareService.getComponentBase(request);
		List<DBComponent> compareTables = compareService.getComponentOthers(request);
		Comparation comparation = new Comparation();
		comparation._compare(c, compareTables);
//		if(compareTables!=null && compareTables.size()>0){
//			for(DBComponent compareTable:compareTables){
//				DBSumary.setSummary("±È½Ï"+compareTable.getUrl()+"ºÍ"+c.getUrl());
//				comparation._start(compareTable,c);
//				comparation._getMessage(c);
//			}
//		}
		modelMap.addAttribute("list",compareTables);
		return "diffResult";
	}
}
