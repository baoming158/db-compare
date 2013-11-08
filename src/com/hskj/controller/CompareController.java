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
//		System.out.println(msg);
//		msg.replaceAll("\r\n", "<br/>");
		modelMap.addAttribute("msg",msg).addAttribute("db_base",c);
		
		return "diffResult";
	}
	@SuppressWarnings("unused")
	private String htmlspecialchars(String str){
		str = str.replaceAll("&","&amp;");
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll(">", "&gt;");
		str = str.replaceAll("\"", "&quot;");
		return str;
	}
}
