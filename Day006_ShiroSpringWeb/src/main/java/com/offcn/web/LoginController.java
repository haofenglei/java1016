package com.offcn.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.offcn.po.ActiveUser;
import com.offcn.service.AuthService;

@Controller
public class LoginController {	
    @RequestMapping(value="/login")
	public String  login(HttpServletRequest requet,HttpSession session) throws Exception{
    	String exceptionName=(String) requet.getAttribute("shiroLoginFailure");
    	if(exceptionName!=null){
    		if(UnknownAccountException.class.getName().equals(exceptionName)){
    			session.setAttribute("msg", "’À∫≈√‹¬Î¥ÌŒÛ");
    		}else{
    			throw new Exception();
    		}
    		
    	}
    		return "redirect:/login.jsp";
    
    	
	}
    
   
}
