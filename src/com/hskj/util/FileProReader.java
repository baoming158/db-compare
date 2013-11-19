package com.hskj.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;


public class FileProReader {
	private static Properties prop = new Properties();
	@SuppressWarnings("unchecked")
	public static List<String> read(String url){
		try {
			loadProp();
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<String> list = new ArrayList<String>();
		Enumeration<String> myenum =(Enumeration<String>) prop.propertyNames();
		List<String> key_list = new ArrayList<String>();
		while(myenum.hasMoreElements()){
			key_list.add(myenum.nextElement());
		}
		Collections.sort(key_list);//默认升序的
		for(String key:key_list){
			if(key.startsWith(url)){
				list.add(prop.getProperty(key));
			}
		}
		return list;
	}
	
	private static void loadProp() throws IOException{
		prop.load(new FileInputStream("d:/db.properties"));
//		prop.load(MainStart.class.getClassLoader().getResourceAsStream("db.properties"));
	}
}
