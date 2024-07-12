package com.assesmentPortal2;

import jakarta.servlet.ServletException; 
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class UpdateQuestionsServlet
 */
public class UpdateQuestionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateQuestionsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try { 	 	
			Connection conn = DatabaseConnection.getConnection();
			
			for(int i = 1; ; i++)
			{
				String question = request.getParameter("question" + i);
				String optionA = request.getParameter("optionA" + i);
				String optionB = request.getParameter("optionB" + i);
				String optionC = request.getParameter("optionC" + i);
				String optionD = request.getParameter("optionD" + i);
				String correctOption = request.getParameter("correctOption" + i);
				String id = request.getParameter("testId" + i);
				
				if(id == null)
				{
					break;
				}
				
				String query = "UPDATE questions SET question = ?, optionA = ?, optionB = ?, optionC = ?, optionD = ?, correctOption = ? WHERE id = ?";
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setString(1, question);
				ps.setString(2, optionA);
				ps.setString(3, optionB);
				ps.setString(4, optionC);
				ps.setString(5, optionD);
				ps.setString(6, correctOption);
				ps.setInt(7, Integer.parseInt(id));
				ps.executeUpdate();
				
			}
			response.sendRedirect("admindashboard.jsp");
			conn.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
			request.setAttribute("javax.servlet.error.status_code", 500);
            request.setAttribute("javax.servlet.error.message", "Database error occurred while updating questions.");
            request.setAttribute("javax.servlet.error.exception", e);
            request.getRequestDispatcher("/error.jsp").forward(request, response);
			System.out.println("Database Error");
		}
	}

}
