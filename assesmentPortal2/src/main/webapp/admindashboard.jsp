<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.assesmentPortal2.TestInfo, com.assesmentPortal2.GetTestData, java.util.*" %>
<% 

response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);

if (session.getAttribute("user") == null) {
    response.sendRedirect("index.jsp");
    return;
}

%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/adminDashboard.css">
<head>
<script type="text/javascript">
    function redirectToPage() {
        window.location.href = 'Logout'; // Replace 'targetPage.jsp' with the desired URL
    }
</script>
<meta charset="UTF-8">
<title>Admin Dashboard</title>
</head>
<body>
	<header>
    	<h1>Welcome to Admin Dashboard</h1>
	</header>
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
	            List<TestInfo> tests = GetTestData.getAllTest();
	            int i = 1;
	            for (TestInfo test : tests) {
	        %>
        	<tr>
        		<td><%= i++ %></td>
        		<td><%= test.getTestName() %></td>
        		<td><%= test.getNumOfQuestion() %></td>
        		<td><%= test.getNumOfPeople() %></td>
        		<td><a href="EditTestInfo?id=<%= test.getId() %>">Edit</a></td>
        		<td><a href="DeleteTestInfo?id=<%= test.getId() %>">Delete</a></td>
        	</tr>
        	<%
            	}
        	%>
        </tbody>
    </table>
    <div class="button-container">
       	<button onclick="window.location.href='addTest.jsp'">Add New Test</button>
		<button onclick="redirectToPage()">Logout</button>
	</div>
	
	<footer>
    	<p>&copy; 2023 Our Company</p>
	</footer>
</body>
</html>