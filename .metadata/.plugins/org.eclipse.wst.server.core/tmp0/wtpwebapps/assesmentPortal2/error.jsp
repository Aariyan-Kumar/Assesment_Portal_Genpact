<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/error.css">
<title>ERROR Page</title>
</head>
<body>
    <div class="error-container">
        <h1>An Error Occurred</h1>
        <p>Sorry, something went wrong. Please try again later.</p>
        <h2>Error Details</h2>
        <%
            String errorMessage = (String) request.getAttribute("javax.servlet.error.message");
            Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
            Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");

            if (statusCode != null) {
                out.println("<p>Status Code: " + statusCode + "</p>");
            }
            if (errorMessage != null) {
                out.println("<p>Error Message: " + errorMessage + "</p>");
            }
            if (throwable != null) {
            	out.println("<p>Exception: " + throwable + "</p>");
                java.io.StringWriter sw = new java.io.StringWriter();
                java.io.PrintWriter pw = new java.io.PrintWriter(sw);
                throwable.printStackTrace(pw);
                out.println("<pre>" + sw.toString() + "</pre>");
            }
        %>
    </div>
    <footer>
    	<p>&copy; 2023 Our Company</p>
	</footer>
</body>
</html>