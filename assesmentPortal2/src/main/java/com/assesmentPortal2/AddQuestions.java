package com.assesmentPortal2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddQuestions {
	public static void addQuestions(GetAndSetQuestion questionobj)
	{
		try
		{
			Connection conn = DatabaseConnection.getConnection();
			String query = "INSERT INTO questions (testid, question, optionA, optionB, optionC, optionD, correctOption) VALUES(?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1,questionobj.getId());
			ps.setString(2, questionobj.getQuestion());
			ps.setString(3, questionobj.getOptionA());
			ps.setString(4, questionobj.getOptionB());
			ps.setString(5, questionobj.getOptionC());
			ps.setString(6, questionobj.getOptionD());
			ps.setString(7, questionobj.getCorrectOption());
			ps.executeUpdate();
			conn.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("Database Connection Error");
		}
	}
}
