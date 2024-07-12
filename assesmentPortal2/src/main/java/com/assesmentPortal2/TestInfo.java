package com.assesmentPortal2;

public class TestInfo {
	private int id;
	private String testName;
	private int numOfQuestion;
	private int numOfPepole;
	private int passMarks;
	
	//Getters
	public int getId()
	{
		return id;
	}
	
	public String getTestName()
	{
		return testName;
	}
	
	public int getNumOfQuestion()
	{
		return numOfQuestion;
	}
	
	public int getNumOfPeople()
	{
		return numOfPepole;
	}
	
	public int getPassMarks() {
		return passMarks;
	}
	
	//Setters
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public void setTestName(String testName)
	{
		this.testName = testName;
	}
	
	public void setNumOfQuestion(int numOfQuestion)
	{
		this.numOfQuestion = numOfQuestion;
	}
	
	public  void setNumOfPeople(int numOfPeople)
	{
		this.numOfPepole = numOfPeople;
	}
	
	public void setPassMarks(int passMarks) {
		this.passMarks = passMarks;
	}
}
