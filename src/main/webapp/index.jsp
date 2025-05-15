<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Servlet Demo</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
        }
        h1 {
            color: #333;
        }
        .btn {
            display: inline-block;
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            text-decoration: none;
            border-radius: 4px;
            margin-top: 20px;
            margin-right: 10px;
        }
        .btn:hover {
            background-color: #45a049;
        }
        .btn.blue {
            background-color: #2196F3;
        }
        .btn.blue:hover {
            background-color: #0b7dda;
        }
        .btn.purple {
            background-color: #9c27b0;
        }
        .btn.purple:hover {
            background-color: #7b1fa2;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Welcome to Servlet Demo</h1>
        <p>This is a simple Java Servlet application with JSP.</p>
        <p>Click the buttons below to access the servlets:</p>
        
        <a href="<%= request.getContextPath() %>/hello" class="btn">Hello Servlet</a>
        <a href="<%= request.getContextPath() %>/validate-user" class="btn blue">User Validation Form</a>
        <a href="<%= request.getContextPath() %>/display-person" class="btn purple">View Person Bean</a>
        
        <div style="margin-top: 30px;">
            <h2>Current Time</h2>
            <p><%= new java.util.Date() %></p>
        </div>
    </div>
</body>
</html> 