package com.offcn.dao;

import java.util.List;

import com.offcn.po.Permission;

public interface PermissionMapper {
	 //通过userid获取用户权限
    List<Permission> findSysPermissionList(String userid);
}
