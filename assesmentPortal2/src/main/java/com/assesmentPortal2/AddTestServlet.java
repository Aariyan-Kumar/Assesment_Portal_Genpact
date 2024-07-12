package com.assesmentPortal2;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class AddTestServlet
 */
public class AddTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String testName = request.getParameter("testname");
		int numOfQuestion = Integer.parseInt(request.getParameter("numofquestion"));
		int passMarks = Integer.parseInt(request.getParameter("passmarks"));
		
		if(isTestExist(testName, response))
		{
			request.setAttribute("errorMessage","Test Exist please go in edit section");
		    RequestDispatcher rd = request.getRequestDispatcher("/addTest.jsp");
		    rd.forward(request, response);
		}
		else
		{
			addTest(testName, numOfQuestion, passMarks, request, response);
		}
	}
	
	private boolean isTestExist(String testName, HttpServletResponse response)throws ServletException, IOException
	{
		int count = 0;
		String query = "SELECT COUNT(*) as count FROM testdata WHERE subjectName = ?";
		try {
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1,testName);
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
			response.sendRedirect("addTest.jsp");
		}
		return count > 0;
	}
	
	private void addTest(String testName, int numOfQuestion, int passMarks, HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	{
		try {
			Connection conn = DatabaseConnection.getConnection();
			String query = "INSERT INTO testdata (subjectName, numOfQuestion, passMarks) VALUES(?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, testName);
			ps.setInt(2, numOfQuestion);
			ps.setInt(3, passMarks);
			ps.executeUpdate();
			response.sendRedirect("addQuestion.jsp?testName="+ URLEncoder.encode(testName, "UTF-8") + "&numOfQuestion=" + numOfQuestion);
			conn.close();
			System.out.println("Database Connection Closed");
		}catch(SQLException e)
		{
			e.printStackTrace();
			response.sendRedirect("addTest.jsp?error=Database error");
		}
	}
	
}
