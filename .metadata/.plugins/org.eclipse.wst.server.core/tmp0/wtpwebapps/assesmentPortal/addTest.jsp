<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.sql.*, com.assesmentPortal.DatabaseConnection" %>


<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
	
	if (session.getAttribute("user") == null) {
	    response.sendRedirect("index.jsp");
	    return;
	}

    if ("POST".equalsIgnoreCase(request.getMethod())) {
        String tag = request.getParameter("tag");
        int numOfQuestions = Integer.parseInt(request.getParameter("numOfQuestions"));
        int numOfPeople = 0;  // Default to 0 when adding a new test

        try {
            Connection connection = DatabaseConnection.getConnection();
            String insertQuery = "INSERT INTO testsubjects (subjectName, noOfQuestion, noOfPersons) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, tag);
            preparedStatement.setInt(2, numOfQuestions);
            preparedStatement.setInt(3, numOfPeople);
            preparedStatement.executeUpdate();
            response.sendRedirect("subjectQuestions.jsp");  // Redirect to dashboard after adding
            connection.close();
            System.out.println("Database Connection Closed");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Adding Question</title>
</head>

<style>
	form {
	    max-width: 400px;
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

<body>

<header>
    <h1>Add Test</h1>
</header>


<form method="post">
    <div>
        <label for="tag">Test Name</label>
        <input type="text" id="tag" name="tag" required>
    </div>
    <div>
        <label for="numOfQuestions">Number of Questions</label>
        <input type="number" id="numOfQuestions" name="numOfQuestions" required>
    </div>
    <div>
        <button type="submit">Add Test</button>
    </div>
</form>
<footer>
    <p>&copy; 2023 Your Company</p>
</footer>

</body>
</html>