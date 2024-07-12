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
 * Servlet implementation class EditTestInfo
 */
public class EditTestInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditTestInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.sendRedirect("admindashboard.jsp");
		
		String testId = request.getParameter("id");
		String subjectName = "";
		int numOfQuestion = 0;
		if(testId != null)
		{
			try {
				Connection conn = DatabaseConnection.getConnection();
				String query = "SELECT subjectName, numOfQuestion, passMarks FROM testdata WHERE id = ?";
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setString(1, testId);
				ResultSet rs = ps.executeQuery();
				if(rs.next())
				{
					subjectName = rs.getString("subjectName");
					numOfQuestion = rs.getInt("numOfQuestion");
				}
				conn.close();
				System.out.println("Database Connection Closed");
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				request.setAttribute("testId", testId);
				request.setAttribute("subjectName", subjectName);
				request.setAttribute("numOfQuestion", numOfQuestion);
				request.getRequestDispatcher("editTest.jsp").forward(request, response);
			}
			
		}
		else
		{
			request.setAttribute("javax.servlet.error.status_code", 404);
            request.setAttribute("javax.servlet.error.message", "Edit Test Page not found.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
		}
		
	}

}
