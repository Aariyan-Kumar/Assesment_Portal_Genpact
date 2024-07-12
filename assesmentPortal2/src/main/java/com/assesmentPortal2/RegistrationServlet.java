package com.assesmentPortal2;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException; 
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String fullName = request.getParameter("fullname");
		String position = request.getParameter("role");
		
		if(isUserNameExist(username, response))
		{
			request.setAttribute("errorMessage","User Id Exist please choose another userid");
		    RequestDispatcher rd = request.getRequestDispatcher("/register.jsp");
		    rd.forward(request, response);
		}
		else
		{
			registerUser(username, password, fullName, position, request, response);
		}
		
		
	}

	private boolean isUserNameExist(String username, HttpServletResponse response)throws ServletException, IOException
	{
		int count = 0;
		String query = "SELECT COUNT(*) as count FROM userdetails WHERE user_id = ?";
		try {
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				count = rs.getInt("count");
			}
			
			conn.close();
			System.out.println("Database Connection Closed");
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Database Connection error occured");
			response.sendRedirect("register.jsp");
		}
		return count > 0;
	}
	
	private void registerUser(String username, String password, String fullName, String position, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try {
			Connection conn = DatabaseConnection.getConnection();
			String query = "INSERT INTO userdetails (user_id, password, full_name, position) VALUES (?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, fullName);
			ps.setString(4, position);
			ps.executeUpdate();
			response.sendRedirect("index.jsp");
			conn.close();
			System.out.println("Database Connection Closed");
		}catch(SQLException e) {
			e.printStackTrace();
			response.sendRedirect("register.jsp?error=Databaseerror");
		}
	}
	
}
