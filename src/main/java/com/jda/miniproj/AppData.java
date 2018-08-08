package com.jda.miniproj;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AppData extends HttpServlet{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://10.0.0.160/db1000228", System.getenv("DBUSER"), System.getenv("DBPASSWORD"));
			PreparedStatement pst = connection.prepareStatement("insert into data (name, email, uname, password) values(?, ?, ?, ?)");
			pst.setString(1, request.getParameter("name"));
			pst.setString(2, request.getParameter("email"));
			pst.setString(3, request.getParameter("username"));
			pst.setString(4, request.getParameter("password"));
			pst.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			 e.printStackTrace();
		}
	}

}
