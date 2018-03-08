package com.offcn.realm;

import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.offcn.po.ActiveUser;
import com.offcn.po.Permission;
import com.offcn.po.Role;
import com.offcn.service.AuthService;

public class CustomRealm1 extends AuthorizingRealm {

	@Autowired
	AuthService authService;
	
	public String getName(){
		return "CustomRealm1";
	}
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		ActiveUser auser=(ActiveUser) principals.getPrimaryPrincipal();
		
		//创建授权对象
		SimpleAuthorizationInfo ainfo=new SimpleAuthorizationInfo();
		List<Role> listroles = auser.getRoles();
		for (Role role : listroles) {
			if(role!=null){
			String rolename=role.getRoleSign();
		     ainfo.addRole(rolename);
		 
			}
		}
		List<Permission> listpers = auser.getPermissions();
		for (Permission permission : listpers) {
			if(permission!=null){
			ainfo.addStringPermission(permission.getPermissionSign());
			}
		}
		
		
		return ainfo;
	}

	//认证方法
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//从token获取账号
		String username=(String) token.getPrincipal();
		//从token获取密码
		String password=String.valueOf((char[])token.getCredentials());
		//调用service的认证方法
		ActiveUser auser=null;
		try {
			auser=authService.authenticat(username, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//判断auser是否为空
		if(auser==null){
			throw new UnknownAccountException("账号密码错误");
		}
		//返回认证对象AuthenticationInfo
		SimpleAuthenticationInfo ainfo=new SimpleAuthenticationInfo(auser, password, getName());
		return ainfo;
	}

}
