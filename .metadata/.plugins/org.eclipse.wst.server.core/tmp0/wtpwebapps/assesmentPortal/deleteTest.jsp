<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, com.assesmentPortal.DatabaseConnection" %>
<%
    String id = request.getParameter("id");

    if (id != null) {
        try {
            Connection connection = DatabaseConnection.getConnection();
            String deleteQuery = "DELETE FROM testsubjects WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setInt(1, Integer.parseInt(id));
            preparedStatement.executeUpdate();
            response.sendRedirect("admindashboard.jsp");
            connection.close();
            System.out.println("Database Connection Closed");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } else {
        response.sendRedirect("admindashboard.jsp");
    }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>