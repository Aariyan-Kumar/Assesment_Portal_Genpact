<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String error = request.getParameter("error");
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/index.css">
<meta charset="UTF-8">
<script type="text/javascript">
    function redirectToPage() {
        window.location.href = 'register.jsp'; // Replace 'targetPage.jsp' with the desired URL
    }
</script>
<title>Login Page</title>
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
        <h2>Login</h2>
        <%
        	if(error != null)
        	{        
        %>
        <p class="p">ERROR:- <%= error %></p>
        <%
        	}
        %>
	    <form action="LoginServlet" method="post">
	        <input type="text" name="username" placeholder="User ID" required>
	        <input type="password" name="password" placeholder="Password" required>
	        <button type="submit">Login</button>
	    </form>
		<button class="button" type="button" onclick="redirectToPage()">Register</button>
    </div>
</main>
<footer>
    <p>&copy; 2024 Our Company. All rights reserved.</p>
</footer>
</body>
</html>