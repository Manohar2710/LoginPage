package com.felight.servlets;

import java.io.IOException;


import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.felight.services.DBConnector;
import com.felight.services.DBConnector;
@WebServlet("/login")
public class LoginPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String fullname=request.getParameter("fullname");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		//Connector.getConnection();	
		RequestDispatcher rd = request.getRequestDispatcher("LoginPage.jsp");
		if(email.isEmpty()||password.isEmpty()) {
			response.getWriter().println("<font color=red>Please fill all the fields</font>");
			rd.include(request, response);
		}else {
		try {
			
			boolean i=true;
			Connection connection = DBConnector.getConnection();
			    Statement statement = connection.createStatement();
	            ResultSet res = statement.executeQuery("SELECT email,password,activationkey FROM userdetails");
	   
			while(res.next()) {	 
				if(res.getString(1).equals(email)&&res.getString(2).equals(password)) {
					if(res.getInt(3)==1) {
					//	rd = request.getRequestDispatcher("LoginPage.jsp");
						rd = request.getRequestDispatcher("DashBoard.jsp");
						rd.forward(request, response);
						break;
					}else {
						response.getWriter().println("<font color=red>Please activate your account by the link which is sent to email ID</font>");
						rd.include(request, response);
						i=false;
						response.getWriter().flush();
						response.getWriter().close();
						break;
					}
					
				}else {
					continue;
				}
			}
			
			if(i) {
				//PrintWriter out = response.getWriter();
				response.getWriter().println("<font color=red>Please enter valid details or if new user create an new acoount by clicking Register  </font>");
			rd.include(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
		}
		}
		
	}

}
