package com.offcn.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.offcn.dao.PermissionMapper;
import com.offcn.dao.RoleMapper;
import com.offcn.dao.UserMapper;
import com.offcn.po.ActiveUser;
import com.offcn.po.User;
import com.offcn.service.AuthService;
@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	UserMapper userMapper;
	@Autowired
	PermissionMapper permissionMapper;
	@Autowired
	RoleMapper roleMapper;
	@Override
	public ActiveUser authenticat(String usercode, String password) throws Exception {
		
		 User user = userMapper.selectByAuth(usercode, password);
		 ActiveUser auser=null;
		 
		 if(user!=null){
			 auser=new ActiveUser();
			 auser.setUserid(user.getId()+"");
			 auser.setUsercode(user.getUsername());
			 auser.setPermissions(permissionMapper.findSysPermissionList(usercode));
			 auser.setRoles(roleMapper.findRoleList(usercode));
		 }
		 return auser;
		 
	}
	
	

}
