package com.ysl.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

//import org.json.JSONObject;

import com.ysl.service.impl.UserServiceImpl;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/api/user/login")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("userName");
		String password=request.getParameter("password");
		String VerificationCode=request.getParameter("VerificationCode");
		String Verification_Code=(String) request.getSession().getAttribute("VerificationCode");
		if (VerificationCode.equalsIgnoreCase(Verification_Code)) {
			UserServiceImpl impl=new UserServiceImpl();
			String result= impl.UserLogin(name, password);
			if (result.equals("success")) {
				response.getWriter().println(result);
			}else{
				response.getWriter().println(result);
			}
		}else{
			//JSONObject jsonObject=new JSONObject("验证码错误，请重新输入！");
			response.getWriter().println("验证码错误，请重新输入！");
		}
		
	}

}
