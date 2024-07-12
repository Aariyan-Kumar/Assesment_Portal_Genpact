package com.assesmentPortal2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetQuestionData {
	public static  List<GetAndSetQuestion> getAllQuestions(String testId)
	{
		
		List<GetAndSetQuestion> questions = new ArrayList<>();
		try {
			Connection conn = DatabaseConnection.getConnection();
			String query = "SELECT * FROM questions WHERE testid = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, Integer.parseInt(testId));
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				GetAndSetQuestion gsquestionobj = new GetAndSetQuestion();
				gsquestionobj.setQuestion(rs.getString("question"));
				gsquestionobj.setOptionA(rs.getString("optionA"));
				gsquestionobj.setOptionB(rs.getString("optionB"));
				gsquestionobj.setOptionC(rs.getString("optionC"));
				gsquestionobj.setOptionD(rs.getString("optionD"));
				gsquestionobj.setCorrectOption(rs.getString("correctOption"));
				gsquestionobj.setId(rs.getInt("id"));
				questions.add(gsquestionobj);
			}
			conn.close();
			System.out.println("Database Connection Closed");
		}catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("Database Connection error occured");
		}
		
		return questions;
		
	}
}
