package com.assesmentPortal2;

import jakarta.servlet.ServletException; 
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Servlet implementation class DeleteTestInfo
 */
public class DeleteTestInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteTestInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if(id != null)
		{
			try {
				
				Connection conn = DatabaseConnection.getConnection();
				String query = "DELETE FROM questions WHERE testid = ?";
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setInt(1, Integer.parseInt(id));
				ps.executeUpdate();
				conn.close();
				System.out.println("Database Connection CLosed");
			}catch(SQLException e)
			{
				e.printStackTrace();
				System.out.println("Database error");
			}
		}
		if(id != null)
		{
			try {
				Connection conn = DatabaseConnection.getConnection();
				String deletQuery = "DELETE FROM testdata WHERE id = ?";
				PreparedStatement ps = conn.prepareStatement(deletQuery);
				ps.setInt(1, Integer.parseInt(id));
				ps.executeUpdate();
				response.sendRedirect("admindashboard.jsp");
				conn.close();
				System.out.println("Database Connection closed");
			}catch(SQLException e)
			{
				e.printStackTrace();
				System.out.println("Database error");
			}
		}
		else
		{
			response.sendRedirect("admindashboard.jsp");
		}
	}

}
