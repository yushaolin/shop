package com.ysl.Dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.ysl.Dao.UserDao;

import ysl.com.Beans.User;
import ysl.com.util.c3p0Util;

public class UserDaoImpl implements UserDao {

	public void addUser(String username, String password, String realname, String tel, String address,
			String zip, String email) {
		// TODO Auto-generated method stub
		String sql="insert into user(username,password,realname,tel,address,zip,email) values(?,?,?,?,?,?,?)";
		ComboPooledDataSource dataSource=c3p0Util.getDataSource();
		QueryRunner queryRunner=new QueryRunner(dataSource);
		try {
			int update = queryRunner.update(sql,username,password,realname,tel,address,zip,email);
			System.out.println("更新"+update+"条数据");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public User findUserByUsrename(String username,String password) {
		// TODO Auto-generated method stub
		String sql="select * from user where username=? and password=?";
		QueryRunner queryRunner=new QueryRunner(c3p0Util.getDataSource());
		User user = null;
		try {
			user = queryRunner.query(sql,new BeanHandler<User>(User.class),username, password);
			return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	@Test
	public void test(){
		UserDaoImpl daoImpl=new UserDaoImpl();
		User user = daoImpl.findUserByUsrename("小米", "sadsa");
		if (user==null) {
			System.out.println("查无此人！");
		}else {
			System.out.println(user.toString());
		}
	}
	@Test
	public void test1(){
		UserDaoImpl daoImpl=new UserDaoImpl();
		daoImpl.addUser( "小米", "sadsa", "雷军", "1221325465", "湖北仙桃", "433300", "1213232@qq.com");
	}
}
