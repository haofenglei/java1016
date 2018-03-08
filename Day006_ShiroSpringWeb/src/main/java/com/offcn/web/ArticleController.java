package com.offcn.web;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ArticleController {

	@RequiresRoles(value="admin")
	@RequestMapping(value="/articel/list")
	public String list(){	
		return "article-list";
	}
	
	@RequiresPermissions(value="user:create")
	@RequestMapping(value="/articel/list2")
	public String test_add(){	
		return "article-list";
	}
}
