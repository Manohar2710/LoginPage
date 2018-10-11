package com.felight.servlets;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.felight.services.Activationmail;
import com.felight.services.EmailValidator;
import com.felight.services.dto.RegistrationUpdate;
import com.felight.services.dto.Users;
@WebServlet("/Registration")

public class RegistrationPageServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fullName=request.getParameter("fullName");
		String email=request.getParameter("email");
		String number=request.getParameter("number");;
		String address=request.getParameter("address");
		String dateOfBirth=request.getParameter("dob");
		String password=request.getParameter("password");
		String gender=request.getParameter("gender");
		EmailValidator valid=new EmailValidator();
		int activationcode=(int)(Math.random()*100000)+1000000;
		RequestDispatcher rd = request.getRequestDispatcher("RegistrationPage.jsp");
		new Users(fullName,email,number,dateOfBirth,gender,address,password,activationcode,0);
		
		if(Users.getFullName().isEmpty()||Users.getEmail().isEmpty()||Users.getNumber().isEmpty()||Users.getAddress().isEmpty()||Users.getDob().isEmpty()||Users.getPassword().isEmpty()||Users.getGender().isEmpty())
		{
			response.getWriter().println("<font color=red>Please fill all the fields</font>");
			rd.include(request, response);
		}else if(number.length()!=10) {
			response.getWriter().println("<font color=red>Please enter valid 10 digit mobie number</font>");
			rd.include(request, response);
		}else if(!valid.validateEmail(email)) {
			response.getWriter().println("<font color=red>Please enter valid email ID</font>");
			rd.include(request, response);
		}else
		{
			//Connector.getConnection();
			RegistrationUpdate.updateDetails();
			Activationmail.sender(activationcode,email,fullName);	
					
			rd = request.getRequestDispatcher("LoginPage.jsp");
			rd.forward(request, response);
		}
	}

}
