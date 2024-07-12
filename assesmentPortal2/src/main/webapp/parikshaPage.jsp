<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.assesmentPortal2.GetAndSetQuestion, com.assesmentPortal2.GetQuestionData, java.util.*" %>
<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
	
	if (session.getAttribute("user") == null) {
	    response.sendRedirect("index.jsp");
	    return;
	}

	

	String id = (String)request.getAttribute("id");
	String testName = (String)request.getAttribute("testName");
	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/parikshaPage.css">
<title><%= testName %> Exam</title>
</head>
<script type="text/javascript">
	function clearResponse(questionIndex) {
	    var radios = document.querySelectorAll('input[name="q' + questionIndex + '"]');
	    radios.forEach(radio => radio.checked = false);
	}
	
	document.addEventListener('keydown', function(event) {
        if (event.key === 'F5' || (event.ctrlKey && event.key === 'r') || (event.metaKey && event.key === 'r')) {
            event.preventDefault();
            alert('Refreshing the page is not allowed.');
        }
    });

</script>
<body>
	<header>
    	<h1>Welcome to Pariksha Page</h1>
	</header>
	<h1><%= testName %> Exam</h1>
	<form action="ParikshResult?id=<%= id %>" method="post">
		<div class="container">
			<%
				List<GetAndSetQuestion> questions = GetQuestionData.getAllQuestions(id);
				int i = 1; 
				for(GetAndSetQuestion question : questions)
				{
			%>
		    <div class="questionContainer">
				<h4><%= i %>) <%= question.getQuestion() %></h4>
				<input type="radio" name="options<%= i %>" value="<%= question.getOptionA() %>"> <%= question.getOptionA() %> <br>
	            <input type="radio" name="options<%= i %>" value="<%= question.getOptionB() %>"> <%= question.getOptionB() %> <br>
	            <input type="radio" name="options<%= i %>" value="<%= question.getOptionC() %>"> <%= question.getOptionC() %> <br>
	            <input type="radio" name="options<%= i %>" value="<%= question.getOptionD() %>"> <%= question.getOptionD() %> <br>
	            <button type="button" onclick="clearResponse(<%= i %>)">Clear Response</button>
		    </div>
		    <%
		    	i++;
				}
		    %>
		    <button type="submit" >Submit</button>
		</div>
		
	</form>
	
	<footer>
    	<p>&copy; 2023 Our Company</p>
	</footer>
</body>
</html>