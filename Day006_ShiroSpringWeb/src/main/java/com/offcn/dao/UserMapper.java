package com.offcn.dao;

import org.apache.ibatis.annotations.Param;

import com.offcn.po.User;

public interface UserMapper {
	 //�û���¼��֤
    User selectByAuth(@Param("username") String username,@Param("password") String password);
}
