<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
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
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/addTest.css">
<script type="text/javascript">
    function redirectToPage() {
        window.location.href = 'admindashboard.jsp'; // Replace 'targetPage.jsp' with the desired URL
    }
</script>
<title>Add Test Name</title>
</head>
<body>
<header>
       <h1>Welcome to Our Assessment Login Portal</h1>
</header>
<div class="login-container">
	<h2>Add The Test Details</h2>
	<form action="AddTestServlet" method="post">
		<% 
	      	String message = (String) request.getAttribute("errorMessage");
	      	if(message != null)
	      	{
	  	%>
	      	<p style="color:  red;"><%= request.getAttribute("errorMessage") %></p>
	  	<%} %>
		<input type="text" name="testname" placeholder="Enter the Test Subject Name" required>
	    <input type="number" name="numofquestion" placeholder="Enter the no. of Questions" required>
	    <input type="number" name="passmarks" placeholder="Enter the passing Marks of the subject" required>
	    <div class="button-container">
            <button type="submit">Add Test</button>
            <button type="button" onclick="redirectToPage()">Go Back</button>
        </div>
	</form>
</div>
<footer>
    <p>&copy; 2024 Our Company. All rights reserved.</p>
</footer>
</body>
</html>