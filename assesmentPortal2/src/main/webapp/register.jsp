<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/index.css">
<meta charset="UTF-8">
<script type="text/javascript">
    function redirectToPage() {
        window.location.href = 'index.jsp'; // Replace 'targetPage.jsp' with the desired URL
    }
</script>
<title>Registration Page</title>
</head>
<body>
<header>
        <h1>Welcome to Our Assessment Login Portal</h1>
</header>
<main>
    <div class="image-container">
        <img src="./Image/6325230.jpg" alt="Image Description">
    </div>
    <div class="login-container">
        <h2>Registration</h2>
        <form action="RegistrationServlet" method="post">
        	<% 
        	
        	String message = (String) request.getAttribute("errorMessage");
        	if(message != null)
        	{
        	%>
        	<p style="color:  red;"><%= request.getAttribute("errorMessage") %></p>
        	<%} %>
        	
            <input type="text" name="username" placeholder="User ID" required>
            <input type="password" name="password" placeholder="Password" required>
            <input type="text" name="fullname" placeholder="Full Name" required>
	        <select class = "select-style" id="role" name="role" required>
	        	<option value="" disabled selected>Select your role</option>
	            <option value="admin">Admin</option>
	            <option value="student">Student</option>
	        </select>
            <button type="submit">Submit</button>
        </form>
        <button class="button" type="button" onclick="redirectToPage()">Login</button>
    </div>
</main>
<footer>
    <p>&copy; 2024 Our Company. All rights reserved.</p>
</footer>
</body>
</html>