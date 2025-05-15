<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.example.Person" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Person Bean Details</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; }
        .container { max-width: 600px; margin: 0 auto; padding: 20px; border: 1px solid #ddd; border-radius: 5px; }
        .card { background-color: #f9f9f9; padding: 15px; border-radius: 5px; margin-top: 20px; }
        .field { margin-bottom: 10px; }
        .label { font-weight: bold; display: inline-block; width: 80px; }
        .no-data { color: #888; font-style: italic; }
        .btn { display: inline-block; padding: 10px 20px; background-color: #4CAF50; color: white; text-decoration: none; border-radius: 4px; margin-top: 20px; }
    </style>
</head>
<body>
    <div class="container">
        <h1>Person Bean Details</h1>
        
        <%
        Person person = (Person) session.getAttribute("personBean");
        if (person != null) {
        %>
            <div class="card">
                <div class="field"><span class="label">Name:</span> <%= person.getName() %></div>
                <div class="field"><span class="label">Age:</span> <%= person.getAge() %></div>
                <div class="field"><span class="label">Email:</span> <%= person.getEmail() %></div>
            </div>
        <% } else { %>
            <p class="no-data">No person data found in session. Please validate a user first.</p>
            <a href="validate-user" class="btn">Go to Validation Form</a>
        <% } %>
        
        <p><a href="<%= request.getContextPath() %>/">Back to Home</a></p>
    </div>
</body>
</html> 