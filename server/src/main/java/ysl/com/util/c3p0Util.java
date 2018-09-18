package ysl.com.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mysql.jdbc.PreparedStatement;

public class c3p0Util {
	private static ComboPooledDataSource dataSource=new ComboPooledDataSource("mysql");
	public static ComboPooledDataSource getDataSource(){
		return dataSource;
	}
	public static Connection getConnection(){
		try {
			System.out.println("数据库连接成功！");
			return dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	public c3p0Util() {
		// TODO Auto-generated constructor stub
	}
	public static void close(Connection connection,PreparedStatement preparedStatement,ResultSet resultSet){
		try {
			if (resultSet != null) {
				resultSet.close();
			}
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (connection != null) {
				connection.close();
			} 
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	@Test
	public void test(){
		getConnection();
	}
}
