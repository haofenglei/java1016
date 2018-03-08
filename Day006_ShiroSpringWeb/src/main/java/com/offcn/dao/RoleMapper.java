package com.offcn.dao;

import java.util.List;

import com.offcn.po.Role;

public interface RoleMapper {
	List<Role> findRoleList(String userid);
}
