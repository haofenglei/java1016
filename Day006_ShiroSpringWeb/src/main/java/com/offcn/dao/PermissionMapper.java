package com.offcn.dao;

import java.util.List;

import com.offcn.po.Permission;

public interface PermissionMapper {
	 //ͨ��userid��ȡ�û�Ȩ��
    List<Permission> findSysPermissionList(String userid);
}
