package com.ysl.service;

public interface UserService {
	String UserLogin(String username,String password);
	void UserRegister(String username, String password, String realname, String tel, String address,
			String zip, String email);
}
