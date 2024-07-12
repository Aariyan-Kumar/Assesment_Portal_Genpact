package com.assesmentPortal2;

import jakarta.servlet.ServletException; 
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String username = request.getParameter("username");
		  String password = request.getParameter("password");
		  
		  try {
			  Connection conn = DatabaseConnection.getConnection();
			  String query = "SELECT * FROM userdetails WHERE user_id = ? AND password = ?";
			  PreparedStatement ps = conn.prepareStatement(query) ;
			  ps.setString(1, username);
			  ps.setString(2, password);
			  ResultSet rs = ps.executeQuery();
			
			  
			  if (rs.next()) {
	            	String position = rs.getString("position");
	            	if(position.equals("admin"))
	            	{
	            		HttpSession session = request.getSession();
	                    session.setAttribute("user", username);
	                    response.sendRedirect("admindashboard.jsp");
	            	}
	            	else if(position.equals("student"))
	            	{
	            		HttpSession session = request.getSession();
	                    session.setAttribute("user", username);
	                    response.sendRedirect("studentdashboard.jsp");
	            	}
	            	else {
	            		response.sendRedirect("index.jsp?error=Invalid username or password");
	            		System.out.println("Incorrect user");
	            	}
	            } 
	            else {
	                response.sendRedirect("index.jsp?error=Invalid username or password");
	            }
	            conn.close();
	            System.out.println("DatabaseConnection closed");
		  }catch(SQLException e) {
			  e.printStackTrace();
			  response.sendRedirect("index.jsp?error=Database error");
		  }
	}
}
