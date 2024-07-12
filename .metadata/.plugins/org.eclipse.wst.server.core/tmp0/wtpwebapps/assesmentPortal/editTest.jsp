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
	
    String id = request.getParameter("id");
    String tag = "";
    int numOfQuestions = 0;
    int numOfPeople = 0;

    if (id != null) {
        try {
            Connection connection = DatabaseConnection.getConnection();
            String selectQuery = "SELECT subjectName, noOfQuestion FROM testsubjects WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setInt(1, Integer.parseInt(id));
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                tag = resultSet.getString("subjectName");
                numOfQuestions = resultSet.getInt("noOfQuestion");
            }
            connection.close();
            System.out.println("Database Connection Closed");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    if ("POST".equalsIgnoreCase(request.getMethod())) {
        tag = request.getParameter("tag");
        numOfQuestions = Integer.parseInt(request.getParameter("numOfQuestions"));

        try {
            Connection connection = DatabaseConnection.getConnection();
            String updateQuery = "UPDATE testsubjects SET subjectName = ?, noOfQuestion = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setString(1, tag);
            preparedStatement.setInt(2, numOfQuestions);
            preparedStatement.setInt(3, Integer.parseInt(id));
            preparedStatement.executeUpdate();
            response.sendRedirect("admindashboard.jsp");
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
<title>Insert title here</title>
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
</style>
<body>

<h2>Edit Test</h2>

<form method="post">
    <div>
        <label for="tag">Test Name</label>
        <input type="text" id="tag" name="tag" value="<%= tag %>" required>
    </div>
    <div>
        <label for="numOfQuestions">Number of Questions</label>
        <input type="number" id="numOfQuestions" name="numOfQuestions" value="<%= numOfQuestions %>" required>
    </div>
    <div>
        <button type="submit">Update Test</button>
    </div>
</form>

</body>
</html>