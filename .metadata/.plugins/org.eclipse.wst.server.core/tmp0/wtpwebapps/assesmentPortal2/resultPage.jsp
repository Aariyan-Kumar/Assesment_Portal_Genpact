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
	


    String id = request.getParameter("id");
    String score = request.getParameter("score");
    String testName = request.getParameter("testName");
    String status = request.getParameter("status");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%= testName %> Result</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resultPage.css">
</head>
<body>
    <div class="result-container">
        <h1>Exam Results</h1>
        <div class="result-box">
            <h2><%= testName %> Exam</h2>
            <p>Test ID: <%= id %></p>
            <p>Your Score: <span class="score"><%= score %></span></p>
            <p>Status: <span class="<%= status.toLowerCase() %>"><%= status %></span></p>
            <button onclick="window.location.href='studentdashboard.jsp'">Back to Home</button>
        </div>
    </div>
</body>
</html>