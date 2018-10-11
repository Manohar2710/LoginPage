package com.felight.services.dto;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.felight.services.DBConnector;

public class RegistrationUpdate {
	public static void updateDetails() {
		try {
			//int activationcode=(int)(Math.random()*100000)+1000000;
			//request.setAttribute("activationcode",activationcode);
			Connection connection = DBConnector.getConnection();
			 // Connection connection = DriverManager
				         //.getConnection("jdbc:mysql://localhost:3306/webpage","root","new password");
			PreparedStatement statement=connection.prepareStatement("INSERT INTO userdetails VALUES(?,?,?,?,?,?,?,?,?)");
			statement.setString(1,Users.getFullName());
			statement.setString(2,Users.getEmail());
			statement.setString(3,Users.getNumber());
			statement.setString(4,Users.getAddress());
			statement.setString(5,Users.getPassword());
			statement.setString(6,Users.getGender());
			statement.setString(7,Users.getDob());
			statement.setInt(8,Users.getActivationCode());
			statement.setInt(9,0);
			statement.executeUpdate(); 
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
