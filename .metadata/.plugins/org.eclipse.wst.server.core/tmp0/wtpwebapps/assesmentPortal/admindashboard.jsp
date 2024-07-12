<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ page import="java.sql.*, java.util.*, com.assesmentPortal.DatabaseConnection" %>


<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
	
	if (session.getAttribute("user") == null) {
        response.sendRedirect("index.jsp");
        return;
    }
	
    class Test {
        int id;
        String tag;
        int numOfQuestions;
        int numOfPeople;

        public Test(int id, String tag, int numOfQuestions, int numOfPeople) {
            this.id = id;
            this.tag = tag;
            this.numOfQuestions = numOfQuestions;
            this.numOfPeople = numOfPeople;
        }
    }

    ArrayList<Test> tests = new ArrayList<>();
    try {
        Connection connection = DatabaseConnection.getConnection();
        String query = "SELECT * FROM testsubjects";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String tag = resultSet.getString("subjectName");
            int numOfQuestions = resultSet.getInt("noOfQuestion");
            int numOfPeople = resultSet.getInt("noOfPersons");
            tests.add(new Test(id, tag, numOfQuestions, numOfPeople));
        }
        connection.close();
        System.out.println("Database Connection Closed");
    } catch (SQLException e) {
        e.printStackTrace();
    }
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
</head>
<style>
*{
	margin 0;
}
table {
	
    width: 80%;
    border-collapse: collapse;
    margin: 0 auto;
}
th, td {
    padding: 10px;
    text-align: left;
    border: 1px solid #ddd;
}
th {
    background-color: #f2f2f2;
}
header, footer {
    background-color: #333;
    color: white;
    text-align: center;
    padding: 10px 0;
}
button {
	padding: 10px 20px;
	background-color: #4CAF50;
	color: white;
	border: none;
	cursor: pointer;
	border-radius: 5px;
	font-size: 16px;
	width: 10%;
	
}

button{
	margin: 0 auto;
}
button:hover {
    background-color: #45a049;
}
</style>
<body>

<%-- Header --%>
<header>
    <h1>Welcome to Admin Dashboard</h1>
</header>

<%-- Main Content --%>
<main>
    
    <table>
        <thead>
            <tr>
                <th>S.No.</th>
                <th>Tags</th>
                <th>No. of Questions</th>
                <th>No. of People Who Took It</th>
                <th>Action 1</th>
                <th>Action 2</th>
            </tr>
        </thead>
        <tbody>
        <%
            int serialNumber = 1;
            for (Test test : tests) {
        %>
            <tr>
                <td><%= serialNumber++ %></td>
                <td><%= test.tag %></td>
                <td><%= test.numOfQuestions %></td>
                <td><%= test.numOfPeople %></td>
                <td><a href="editTest.jsp?id=<%= test.id %>">Edit</a></td>
                <td><a href="deleteTest.jsp?id=<%= test.id %>">Delete</a></td>
            </tr>
        <%
            }
        %>
        </tbody>
    </table>
    <button onclick="window.location.href='addTest.jsp'">Add New Test</button> 
    <button onclick="window.location.href='logout.jsp'">Logout</button>   
</main>
<%-- Footer --%>
<footer>
    <p>&copy; 2023 Your Company</p>
</footer>

</body>
</html>