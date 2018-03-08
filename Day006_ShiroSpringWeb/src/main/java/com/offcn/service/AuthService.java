package com.offcn.service;

import com.offcn.po.ActiveUser;

public interface AuthService {
	public ActiveUser authenticat(String usercode, String password)
			throws Exception;
}
