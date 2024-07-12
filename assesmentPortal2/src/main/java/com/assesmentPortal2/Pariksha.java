package com.assesmentPortal2;

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
 * Servlet implementation class Pariksha
 */
public class Pariksha extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	
    public Pariksha() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String testName = request.getParameter("testName");
		System.out.println("The data are" + id + "     " + testName);
		if(id != null)
		{
			request.setAttribute("id", id);
			request.setAttribute("testName", testName);
			request.getRequestDispatcher("parikshaPage.jsp").forward(request, response);
		}
		
		try {
			int numOfPeople = 0;
			int newNumOfPeople = 0;
			Connection conn = DatabaseConnection.getConnection();
			String query1 = "SELECT numOfPeople FROM testdata WHERE id = ?";
			PreparedStatement ps1 = conn.prepareStatement(query1);
			ps1.setString(1, id);
			ResultSet rs = ps1.executeQuery();
			if(rs.next())
			{
				numOfPeople = rs.getInt("numOfPeople");
			}
			
			newNumOfPeople = numOfPeople + 1;
			
			String query2 = "UPDATE testdata SET numOfPeople = ? WHERE id = ?";
			PreparedStatement ps2  = conn.prepareStatement(query2);
			ps2.setInt(1, newNumOfPeople);
			ps2.setString(2, id);
			ps2.executeUpdate();
			conn.close();
			System.out.println("Database Connection Closed");
		}catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("Database Error");
		}
	}

}
