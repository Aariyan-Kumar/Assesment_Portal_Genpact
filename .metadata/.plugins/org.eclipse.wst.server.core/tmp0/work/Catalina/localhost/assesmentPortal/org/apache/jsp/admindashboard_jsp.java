/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.1.25
 * Generated at: 2024-06-30 17:03:24 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;
import java.sql.*;
import java.util.*;
import com.assesmentPortal.DatabaseConnection;

public final class admindashboard_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports,
                 org.apache.jasper.runtime.JspSourceDirectives {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(7);
    _jspx_imports_packages.add("java.sql");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = new java.util.LinkedHashSet<>(2);
    _jspx_imports_classes.add("com.assesmentPortal.DatabaseConnection");
  }

  private volatile jakarta.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public boolean getErrorOnELNotFound() {
    return false;
  }

  public jakarta.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final jakarta.servlet.http.HttpServletRequest request, final jakarta.servlet.http.HttpServletResponse response)
      throws java.io.IOException, jakarta.servlet.ServletException {

    if (!jakarta.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final jakarta.servlet.jsp.PageContext pageContext;
    jakarta.servlet.http.HttpSession session = null;
    final jakarta.servlet.ServletContext application;
    final jakarta.servlet.ServletConfig config;
    jakarta.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    jakarta.servlet.jsp.JspWriter _jspx_out = null;
    jakarta.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write(" \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

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

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Dashboard</title>\r\n");
      out.write("</head>\r\n");
      out.write("<style>\r\n");
      out.write("*{\r\n");
      out.write("	margin 0;\r\n");
      out.write("}\r\n");
      out.write("table {\r\n");
      out.write("	\r\n");
      out.write("    width: 80%;\r\n");
      out.write("    border-collapse: collapse;\r\n");
      out.write("    margin: 0 auto;\r\n");
      out.write("}\r\n");
      out.write("th, td {\r\n");
      out.write("    padding: 10px;\r\n");
      out.write("    text-align: left;\r\n");
      out.write("    border: 1px solid #ddd;\r\n");
      out.write("}\r\n");
      out.write("th {\r\n");
      out.write("    background-color: #f2f2f2;\r\n");
      out.write("}\r\n");
      out.write("header, footer {\r\n");
      out.write("    background-color: #333;\r\n");
      out.write("    color: white;\r\n");
      out.write("    text-align: center;\r\n");
      out.write("    padding: 10px 0;\r\n");
      out.write("}\r\n");
      out.write("button {\r\n");
      out.write("	padding: 10px 20px;\r\n");
      out.write("	background-color: #4CAF50;\r\n");
      out.write("	color: white;\r\n");
      out.write("	border: none;\r\n");
      out.write("	cursor: pointer;\r\n");
      out.write("	border-radius: 5px;\r\n");
      out.write("	font-size: 16px;\r\n");
      out.write("	width: 10%;\r\n");
      out.write("	\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("button{\r\n");
      out.write("	margin: 0 auto;\r\n");
      out.write("}\r\n");
      out.write("button:hover {\r\n");
      out.write("    background-color: #45a049;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<header>\r\n");
      out.write("    <h1>Welcome to Admin Dashboard</h1>\r\n");
      out.write("</header>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<main>\r\n");
      out.write("    \r\n");
      out.write("    <table>\r\n");
      out.write("        <thead>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <th>S.No.</th>\r\n");
      out.write("                <th>Tags</th>\r\n");
      out.write("                <th>No. of Questions</th>\r\n");
      out.write("                <th>No. of People Who Took It</th>\r\n");
      out.write("                <th>Action 1</th>\r\n");
      out.write("                <th>Action 2</th>\r\n");
      out.write("            </tr>\r\n");
      out.write("        </thead>\r\n");
      out.write("        <tbody>\r\n");
      out.write("        ");

            int serialNumber = 1;
            for (Test test : tests) {
        
      out.write("\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td>");
      out.print( serialNumber++ );
      out.write("</td>\r\n");
      out.write("                <td>");
      out.print( test.tag );
      out.write("</td>\r\n");
      out.write("                <td>");
      out.print( test.numOfQuestions );
      out.write("</td>\r\n");
      out.write("                <td>");
      out.print( test.numOfPeople );
      out.write("</td>\r\n");
      out.write("                <td><a href=\"editTest.jsp?id=");
      out.print( test.id );
      out.write("\">Edit</a></td>\r\n");
      out.write("                <td><a href=\"deleteTest.jsp?id=");
      out.print( test.id );
      out.write("\">Delete</a></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("        ");

            }
        
      out.write("\r\n");
      out.write("        </tbody>\r\n");
      out.write("    </table>\r\n");
      out.write("    <button onclick=\"window.location.href='addTest.jsp'\">Add New Test</button> \r\n");
      out.write("    <button onclick=\"window.location.href='logout.jsp'\">Logout</button>   \r\n");
      out.write("</main>\r\n");
      out.write("\r\n");
      out.write("<footer>\r\n");
      out.write("    <p>&copy; 2023 Your Company</p>\r\n");
      out.write("</footer>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof jakarta.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
