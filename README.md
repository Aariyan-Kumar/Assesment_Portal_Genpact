# Assesment_Portal_Genpact

# Assessment Portal

This is an admin dashboard for managing exams within the assessment portal. The admin can add, edit, and delete exams, as well as set the pass marks. This section outlines the steps for admin functionalities.
This is a web-based assessment portal where users can take exams, submit their answers, and view their results. The application is built using Java, JSP, and Servlets, and connects to an MYSQL database to fetch and store exam data.

## Features

- Admin and Student Login
- Dashboard to view, add, edit, and delete tests
- Add questions to tests
- Set pass marks
- Fetch and display exam questions
- Submit answers and calculate scores
- Display results with pass/fail status
- Clear responses for individual questions
- Prevent refreshing and navigating back during the exam
- Logout

## Admin Workflow

1. **Initial Setup**
    - The admin's details will be pre-loaded in the database.

2. **Login**
    - The admin can log in using their username and password.

3. **Dashboard Access**
    - Upon successful login, the admin will be redirected to the dashboard.

4. **Dashboard Overview**
    - The dashboard displays a list of different tests and their details:
        - S. No: Serial number
        - Tag: Test subject/tag
        - No of questions: Number of questions in the test
        - No of people who took the test: Number of users who attempted the test
        - Action1: Option to edit the test
        - Action2: Option to delete the test

    ```plaintext
    S. No | Tag              | No of questions | No of people who took the test | Action1 | Action2
    ------|------------------|-----------------|--------------------------------|---------|---------
    1     | C Programming    | 25              | 5                              | Edit    | Delete
    2     | C++ Programming  | 10              | 4                              | Edit    | Delete
    3     | C# Programming   | 15              | 3                              | Edit    | Delete
    4     | Java             | 5               | 0                              | Edit    | Delete
    ```

5. **Add New Test**
    - The dashboard includes an option to add a new test.
    - On clicking the add button, a form with 2 fields will open:
        - Tag
        - Number of questions

    - Example:
        - Tag: Java Programming
        - Number of questions: 5

6. **Submit New Test**
    - After filling in the details, click on the submit button.
    - This will display forms to add the specified number of questions.

7. **Add Questions**
    - The question addition form includes the following fields:
        - Question
        - Option 1
        - Option 2
        - Option 3
        - Option 4
        - Correct answer

8. **Update Test List**
    - Once all questions are added, the test list on the dashboard will be updated with the new test details.

9. **Set Pass Mark**
    - The admin can set the pass mark for each test.

10. **Logout**
    - The admin can log out from the dashboard.


## Prerequisites

- Java JDK 8 or above
- Apache Tomcat 9 or above
- MYSQL Server Using Xampp
- IDE (Eclipse, IntelliJ IDEA, etc.)

## Getting Started

### 1. Clone the Repository

- https://github.com/Aariyan-Kumar/Assesment_Portal_Genpact.git
- cd assessment-portal

### 2. Set Up the Database
- Create a database in MYSQL Server.
- Execute the SQL script database/schema.sql to create the necessary tables.
- Update the database connection details in DatabaseConnection.java:

### DatabaseConnection.java


```sh
java Copy code
private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=YourDatabaseName";
private static final String USER = "your-username";
private static final String PASSWORD = "your-password";
```
### 3. Build the Project

- Install Tomcat from the below link
- https://tomcat.apache.org/download-90.cgi

### 4. Deploy to Tomcat

- Copy the generated WAR file from target/assessment-portal.war to the web apps directory of your Tomcat installation.
- Start the Tomcat server.

### 5. Access the Application
- Open your web browser and navigate to http://localhost:8080/assessment-portal.


## Usage

### Admin

- Login: Use the admin credentials provided in the database to log in.
- Manage Tests: Add, edit, and delete tests from the dashboard.
- Add Questions: Add questions to the tests as per the required format.
- Set Pass Mark: Define the pass mark for each test.
-Logout: Securely log out from the dashboard.

### Student

- Login: Use the credentials provided in the database to log in.
- Start Exam: Select an exam to start. The questions will be fetched from the database.
- Answer Questions: Select the answers and use the "Clear Response" button if needed.
- Submit Exam: Submit the exam to view your score and pass/fail status.
- Prevent Refresh/Back: The application will prevent refreshing and navigating back to ensure the integrity of the exam.
-Logout: Securely log out from the dashboard.


### Code Overview

- Important Files and Directories
- src/main/java/com/assessmentPortal2/: Contains the Java source code.
- ParikshResult.java: Servlet for handling exam result calculation and display.
- DatabaseConnection.java: Utility class for establishing database connections.
- GetAndSetQuestion.java: Model class for exam questions.
- GetQuestionData.java: Data access object for fetching questions from the database.
- src/main/webapp/: Contains the web resources.
- index.jsp: The home page of the application.
- examPage.jsp: The page where users take the exam.
- resultPage.jsp: The page displaying the exam results.
- parikshaPage.css: The CSS file for styling the exam page.
- resultPage.css: The CSS file for styling the result page.
