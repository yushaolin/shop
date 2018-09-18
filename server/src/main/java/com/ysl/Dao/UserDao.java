package com.ysl.Dao;

import ysl.com.Beans.User;

public interface UserDao {
		void addUser(String username,String password,String realname,String tel,String address,String zip,String email);
		User findUserByUsrename(String username,String password);
}
