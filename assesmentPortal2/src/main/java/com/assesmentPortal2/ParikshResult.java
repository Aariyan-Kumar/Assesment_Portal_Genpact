package com.assesmentPortal2;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 * Servlet implementation class ParikshResult
 */
public class ParikshResult extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ParikshResult() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		List<GetAndSetQuestion> questions = GetQuestionData.getAllQuestions(id);
		int i = 1; 
		int score = 0;
		for(GetAndSetQuestion question : questions)
		{
			String answer = request.getParameter("options" + i);
			
			System.out.println(answer);
			
			if(answer != null)
			{
				String correctAnswer = question.getCorrectOption();
				if(answer.equals(correctAnswer))
				{
					score = score + 10;
				}
			}
			i = i + 1;
		}
		
		int passMarks = 0;
		String subjectName = "";
		
		try {
			
			Connection conn = DatabaseConnection.getConnection();
			String query = "SELECT passMarks, subjectName FROM testdata WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				passMarks = rs.getInt("passMarks");
				subjectName = rs.getString("subjectName");
			}
			conn.close();
			System.out.println("Database Connection Closed");
		}catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("Database Connection Error");
		}
		
		if(score < passMarks)
		{
			//Fail
			response.sendRedirect("resultPage.jsp?id=" + id + "&score=" + score + "&testName=" + URLEncoder.encode(subjectName, "UTF-8") + "&status=Failed");
		}
		else
		{
			//pass
			response.sendRedirect("resultPage.jsp?id=" + id + "&score=" + score + "&testName=" + URLEncoder.encode(subjectName, "UTF-8") + "&status=Passed");
		}
		
	}

}
