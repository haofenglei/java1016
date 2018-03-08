package com.offcn.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.offcn.dao.RoleMapper;
import com.offcn.po.Role;

public class TestDao {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml");
		RoleMapper roledao=(RoleMapper) context.getBean("roleMapper");
		
		List<Role> rolelist = roledao.findRoleList("admin");
		for (Role role : rolelist) {
			System.out.println(role.getRoleName()+" "+role.getRoleSign());
		}
	}

}
