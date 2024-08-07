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
 * Servlet implementation class AddQuestionsServlet
 */
public class AddQuestionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddQuestionsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String testName = request.getParameter("testName");
		System.out.println(testName);
	}
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String testName = request.getParameter("testName");
		int id = 0;
		int numOfQuestion = 0;
		System.out.println("check" + numOfQuestion);
		try {
			Connection conn = DatabaseConnection.getConnection();
			String query = "SELECT * FROM testdata WHERE subjectName = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, testName);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				id = rs.getInt("id");
				numOfQuestion= rs.getInt("numOfQuestion");
			}
			conn.close();
			System.out.println("Database Connection Closed");
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		for(int i = 1; i <= numOfQuestion; i++)
		{
			String question = request.getParameter("question" + i);
			String optionA = request.getParameter("optionA" + i);
			String optionB = request.getParameter("optionB" + i);
			String optionC = request.getParameter("optionC" + i);
			String optionD = request.getParameter("optionD" + i);
			String correctOption = request.getParameter("correctOption" + i);
			
			GetAndSetQuestion questionobj = new GetAndSetQuestion();
			
			questionobj.setId(id);
			questionobj.setQuestion(question);
			questionobj.setOptionA(optionA);
			questionobj.setOptionB(optionB);
			questionobj.setOptionC(optionC);
			questionobj.setOptionD(optionD);
			questionobj.setCorrectOption(correctOption);
			
			AddQuestions.addQuestions(questionobj);
			
		}
		
		response.sendRedirect("admindashboard.jsp");
		
	}

}
