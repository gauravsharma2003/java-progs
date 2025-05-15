<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Hello Servlet</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
        }
        h1 {
            color: pink;
            text-align: center;
            border: 2px solid black;
            border-radius: 10px;
            padding: 10px;
        }
        p {
            color: pink;
            text-align: center;
            font-size: 20px;
        }
        .back-link {
            display: block;
            text-align: center;
            margin-top: 30px;
        }
    </style>
</head>
<body>
    <h1>Hello, Servlet World!</h1>
    <p>This is a simple Java Servlet running with JSP.</p>
    
    <a href="<%= request.getContextPath() %>/" class="back-link">Back to Home</a>
</body>
</html> 