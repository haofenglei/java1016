package com.offcn.util;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.ResourceBundle;

public class ResourcesUtil {
public static List<String> getResourKeyList(String filepath){
	List<String> list=new ArrayList<String>();
	ResourceBundle rb=ResourceBundle.getBundle(filepath);
	Enumeration<String> keys = rb.getKeys();
	while (keys.hasMoreElements()) {
		String key=keys.nextElement();
		
		list.add(key);
	}
	return list;
}
}
