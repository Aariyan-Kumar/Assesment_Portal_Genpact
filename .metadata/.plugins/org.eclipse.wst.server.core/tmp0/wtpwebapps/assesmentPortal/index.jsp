<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<style>
	body {
	    font-family: Arial, sans-serif;
	    margin: 0;
	    padding: 0;
	    display: flex;
	    flex-direction: column;
	    height: 100vh;
	}
	header, footer {
	    background-color: #333;
	    color: white;
	    text-align: center;
	    padding: 10px 0;
	}
	main {
	    display: flex;
	    justify-content: space-between;
	    align-items: center;
	    padding: 20px;
	    width: 70%;
	    margin: 0 auto;
	}
	.image-container {
	    flex: 1;
	    max-width: 50%;
	    
	}
	.image-container img {
	    width: 100%;
	    height: auto;
	    margin: 0 15px;
	}
	.login-container {
	    flex: 1;
	    max-width: 50%;
	    padding: 20px;
	    background-color: #f4f4f4;
	    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
	    margin: 0 15px;
	}
	.login-container h2 {
	    margin-bottom: 20px;
	}
	.login-container input {
	    width: 90%;
	    padding: 10px;
	    margin: 10px 0;
	    border: 1px solid #ccc;
	    border-radius: 4px;
	}
	.login-container button {
	    width: 40%;
	    padding: 10px;
	    background-color: #333;
	    color: white;
	    border: none;
	    border-radius: 4px;
	    cursor: pointer;
	}
	.login-container button:hover {
	    background-color: #555;
	}
</style>
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
            <form action="LoginServlet" method="post">
                <input type="text" name="username" placeholder="User ID" required>
                <input type="password" name="password" placeholder="Password" required>
                <button type="submit">Login</button>
            </form>
        </div>
    </main>
    <footer>
        <p>&copy; 2024 Our Company. All rights reserved.</p>
    </footer>
</body>
</html>