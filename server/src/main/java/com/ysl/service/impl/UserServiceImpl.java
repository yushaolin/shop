package com.ysl.service.impl;

import com.ysl.Dao.impl.UserDaoImpl;
import com.ysl.service.UserService;

import ysl.com.Beans.User;

public class UserServiceImpl implements UserService {

	@Override
	public String UserLogin(String username, String password) {
		// TODO Auto-generated method stub
		UserDaoImpl daoImpl=new UserDaoImpl();
		User user= daoImpl.findUserByUsrename(username, password);
		if (user!=null) {
			return "sucess";
		}
		else{
			return "fail";
		}
	}

	@Override
	public void UserRegister(String username, String password, String realname, String tel, String address, String zip,
			String email) {
		// TODO Auto-generated method stub
		UserDaoImpl daoImpl=new UserDaoImpl();
		daoImpl.addUser(username, password, realname, tel, address, zip, email);
	}

}
