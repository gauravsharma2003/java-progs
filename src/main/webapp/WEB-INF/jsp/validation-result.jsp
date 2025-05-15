<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.example.Person" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Validation Results</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; }
        .container { max-width: 600px; margin: 0 auto; padding: 20px; border: 1px solid #ddd; border-radius: 5px; }
        .success { color: green; }
        .error { color: red; }
        .field { margin-bottom: 10px; }
        .label { font-weight: bold; }
        .btn { display: inline-block; padding: 10px 15px; background-color: #4CAF50; color: white; text-decoration: none; border-radius: 5px; margin-right: 10px; }
        .btn.blue { background-color: #2196F3; }
    </style>
</head>
<body>
    <div class="container">
        <h1>Validation Results</h1>
        
        <% 
        Boolean isValid = (Boolean)request.getAttribute("isValid");
        if (isValid != null && isValid) {
            Person person = (Person)request.getAttribute("person");
        %>
            <h2 class="success">Validation Successful!</h2>
            <div class="field"><span class="label">Name:</span> <%= person.getName() %></div>
            <div class="field"><span class="label">Age:</span> <%= person.getAge() %></div>
            <div class="field"><span class="label">Email:</span> <%= person.getEmail() %></div>
            
            <div style="margin-top: 20px;">
                <a href="display-person" class="btn blue">View Person Details</a>
                <a href="validate-user" class="btn">Validate Another Person</a>
            </div>
        <% 
        } else { 
            String errors = (String)request.getAttribute("errors");
        %>
            <h2 class="error">Validation Failed</h2>
            <%= errors %>
            <p><a href="validate-user" class="btn">Try Again</a></p>
        <% } %>
        
        <p><a href="<%= request.getContextPath() %>/">Back to Home</a></p>
    </div>
</body>
</html> 