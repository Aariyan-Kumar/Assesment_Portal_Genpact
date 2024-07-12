<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.assesmentPortal2.TestInfo, com.assesmentPortal2.GetTestData, java.util.*, java.net.URLEncoder" %>

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
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/studentdashboard.css">
<title>Student Dashboard</title>
</head>
<script type="text/javascript">
    function redirectToPage() {
        window.location.href = 'Logout'; // Replace 'targetPage.jsp' with the desired URL
    }
</script>
<body>
	<body>
    <div class="container">
        <div class="header">
            <h1>Welcome to the Test Assessment Dashboard</h1>
        </div>
        <div class="cards">
        <%
	        List<TestInfo> tests = GetTestData.getAllTest();
	        int i = 1;
	        for (TestInfo test : tests) {
        %>
            <div class="card">
                <h2><%= test.getTestName() %></h2>
                <a href="Pariksha?id=<%= test.getId()%>&testName=<%= URLEncoder.encode(test.getTestName(), "UTF-8")%> ">Start Test</a>
            </div>
        <%
	        }
        %>
        </div>
    </div>
    
    <div class="container">
        <h1>Instructions for the MCQ Exam</h1>
        <ul>
            <li><strong>Question Format:</strong> The exam consists of all multiple-choice questions.</li>
            <li><strong>Answering Format:</strong> Each question has four options (A, B, C, D). Only one option is correct.</li>
            <li><strong>Marking Scheme:</strong>
                <ul>
                    <li><strong>Correct Answer:</strong> 10 marks will be awarded for each correct answer.</li>
                    <li><strong>Incorrect Answer:</strong> 0 marks will be deducted for each incorrect answer.</li>
                    <li><strong>Unanswered Questions:</strong> No marks will be awarded or deducted for unanswered questions.</li>
                </ul>
            </li>
            <li><strong>How to Answer:</strong>
                <ul>
                    <li>Select the option you believe is correct.</li>
                    <li>Ensure you select only one option for each question.</li>
                </ul>
            </li>
            <li><strong>Submission:</strong>
                <ul>
                    <li>Ensure all answers are marked clearly before submitting your exam.</li>
                    <li>Once submitted, you will not be able to make any changes.</li>
                </ul>
            </li>
            <li><strong>Exam Conduct:</strong>
                <ul>
                    <li>No communication with other candidates is allowed during the exam.</li>
                    <li>Use of electronic devices, books, or notes is strictly prohibited.</li>
                    <li>Any form of cheating will result in immediate disqualification.</li>
                </ul>
            </li>
            <li><strong>Clarifications:</strong>
                <ul>
                    <li>If you have any doubts or need clarification during the exam, raise your hand, and an invigilator will assist you.</li>
                    <li>Do not discuss the questions with other candidates.</li>
                </ul>
            </li>
            <li><strong>Post-Exam:</strong>
                <ul>
                    <li>Remain seated until all exams are collected and you are instructed to leave.</li>
                    <li>Do not discuss the questions or answers with other candidates after the exam.</li>
                </ul>
            </li>
        </ul>
        <p>Please read and understand these instructions carefully. Good luck with your exam!</p>
    </div>
    <div class="button-container">
		<button onclick="redirectToPage()">Logout</button>
	</div>
    <footer>
    	<p>&copy; 2023 Our Company</p>
	</footer>
</body>
</body>
</html>