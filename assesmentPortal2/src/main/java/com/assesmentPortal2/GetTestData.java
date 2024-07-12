package com.assesmentPortal2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class GetTestData {
	public static List<TestInfo> getAllTest()
	{
		List<TestInfo> tests = new ArrayList<>();
		try {
			Connection conn = DatabaseConnection.getConnection();
			String query = "SELECT * FROM testdata";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) 
			{
				TestInfo test = new TestInfo();
				test.setId(rs.getInt("id"));
				test.setTestName(rs.getString("subjectName"));
				test.setNumOfQuestion(rs.getInt("numOfQuestion"));
				test.setPassMarks(rs.getInt("passMarks"));
				test.setNumOfPeople(rs.getInt("numOfPeople"));
				tests.add(test);
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("Database Connection error occured");
		}
		return tests;
		
	}
}
