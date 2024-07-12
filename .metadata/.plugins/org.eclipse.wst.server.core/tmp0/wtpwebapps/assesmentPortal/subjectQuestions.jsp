<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, com.assesmentPortal.DatabaseConnection" %>
    <%	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
	
	if (session.getAttribute("user") == null) {
        response.sendRedirect("index.jsp");
        return;
    } %>
    
    <%
    String id = request.getParameter("id");
    String tag = "";
    int numOfQuestions = 0;
    try{
    	Connection conn = DatabaseConnection.getConnection();
    	String query = "Select * from testsubjects where id= ?";
    	PreparedStatement ps = conn.prepareStatement(query);
    	ps.setInt(1, Integer.parseInt(id));
    	ResultSet resultSet = ps.executeQuery();
    	
    	if (resultSet.next()){
    		tag = resultSet.getString("subjectName");
    		numOfQuestions = resultSet.getInt("noOfQuestion");
    	}
    	
    	System.out.println(tag + " " + numOfQuestions);
    	
    	
    }catch(SQLException e){
    	e.printStackTrace();    	
    }

    if ("POST".equalsIgnoreCase(request.getMethod())) {
        for (int i = 0; i < numOfQuestions; i++) {
            String question = request.getParameter("question" + i);
            String optionA = request.getParameter("optionA" + i);
            String optionB = request.getParameter("optionB" + i);
            String optionC = request.getParameter("optionC" + i);
            String optionD = request.getParameter("optionD" + i);
            String correctOption = request.getParameter("correctOption" + i);

            try {
                Connection connection = DatabaseConnection.getConnection();
                String insertQuery = "INSERT INTO question (testSubjectName, testQuestion, optionA, optionB, optionC, optionD, correctOption) VALUES (?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
                preparedStatement.setString(1, tag);
                preparedStatement.setString(2, question);
                preparedStatement.setString(3, optionA);
                preparedStatement.setString(4, optionB);
                preparedStatement.setString(5, optionC);
                preparedStatement.setString(6, optionD);
                preparedStatement.setString(7, correctOption);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        try{
        	String passMarks = request.getParameter("passMarks");
        	
        	Connection conn = DatabaseConnection.getConnection();
        	String query = "UPDATE testsubjects SET passMarks = ? where id= ?";
        	PreparedStatement ps = conn.prepareStatement(query);
        	ps.setInt(1, Integer.parseInt(passMarks));
        	ps.setInt(2, Integer.parseInt(id));
        	ps.executeUpdate();
			
        	
        	
        }catch(SQLException e){
        	e.printStackTrace();    	
        }
        response.sendRedirect("admindashboard.jsp");
    }
    
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Questions Adding</title>
<style>
	form {
	    max-width: 600px;
	    margin: auto;
	    padding: 1em;
	    background: #f9f9f9;
	    border-radius: 5px;
	}
	div {
	    margin-bottom: 1em;
	}
	label {
	    margin-bottom: .5em;
	    color: #333333;
	    display: block;
	}
	input {
	    border: 1px solid #CCCCCC;
	    padding: .5em;
	    width: calc(100% - 1em);
	    box-sizing: border-box;
	}
	button {
	    padding: 10px 20px;
	    background-color: #4CAF50;
	    color: white;
	    border: none;
	    cursor: pointer;
	    border-radius: 5px;
	    font-size: 16px;
	}
	button:hover {
	    background-color: #45a049;
	}
	header, footer {
    background-color: #333;
    color: white;
    text-align: center;
    padding: 10px 0;
}
</style>
</head>
<body>

<header>
    <h1>Add Question</h1>
</header>


<form method="post">
    <%
        for (int i = 0; i < numOfQuestions; i++) {
    %>
    <div>
        <label for="question<%=i%>">Question <%=i+1%></label>
        <input type="text" id="question<%=i%>" name="question<%=i%>" required>
    </div>
    <div>
        <label for="optionA<%=i%>">Option A</label>
        <input type="text" id="optionA<%=i%>" name="optionA<%=i%>" required>
    </div>
    <div>
        <label for="optionB<%=i%>">Option B</label>
        <input type="text" id="optionB<%=i%>" name="optionB<%=i%>" required>
    </div>
    <div>
        <label for="optionC<%=i%>">Option C</label>
        <input type="text" id="optionC<%=i%>" name="optionC<%=i%>" required>
    </div>
    <div>
        <label for="optionD<%=i%>">Option D</label>
        <input type="text" id="optionD<%=i%>" name="optionD<%=i%>" required>
    </div>
    <div>
        <label for="correctOption<%=i%>">Correct Option</label>
        <input type="text" id="correctOption<%=i%>" name="correctOption<%=i%>" required>
    </div>
    <div>
        <input type="hidden" id="tag" name="tag" value="<%= tag %>">
    </div>
    <hr>
    <% } %>
    
    <div>
        <label for="passMarks">Passing Marks</label>
        <input type="text" id="passMarks" name="passMarks" required>
    </div>
    
    <div>
        <button type="submit">Submit Questions</button>
    </div>
</form>
<footer>
    <p>&copy; 2023 Your Company</p>
</footer>

</body>
</html>