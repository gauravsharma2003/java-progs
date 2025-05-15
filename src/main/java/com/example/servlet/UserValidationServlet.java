package com.example.servlet;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.Person;

@WebServlet("/validate-user")
public class UserValidationServlet extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    
    // Email validation regex
    private static final Pattern EMAIL_PATTERN = 
        Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Forward to the JSP page
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user-form.jsp");
        dispatcher.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Get form parameters
        String name = request.getParameter("name");
        String ageStr = request.getParameter("age");
        String email = request.getParameter("email");
        
        boolean isValid = true;
        StringBuilder errors = new StringBuilder();
        
        // Validate name
        if (name == null || name.trim().isEmpty()) {
            isValid = false;
            errors.append("<p class='error'>Name is required.</p>");
        } else if (name.length() < 2) {
            isValid = false;
            errors.append("<p class='error'>Name must be at least 2 characters long.</p>");
        }
        
        // Validate age
        int age = 0;
        try {
            age = Integer.parseInt(ageStr);
            if (age < 1 || age > 120) {
                isValid = false;
                errors.append("<p class='error'>Age must be between 1 and 120.</p>");
            }
        } catch (NumberFormatException e) {
            isValid = false;
            errors.append("<p class='error'>Age must be a valid number.</p>");
        }
        
        // Validate email
        if (email == null || email.trim().isEmpty()) {
            isValid = false;
            errors.append("<p class='error'>Email is required.</p>");
        } else if (!EMAIL_PATTERN.matcher(email).matches()) {
            isValid = false;
            errors.append("<p class='error'>Invalid email format.</p>");
        }
        
        // Store validation results in request
        request.setAttribute("isValid", isValid);
        
        // If validation passes, create Person bean
        if (isValid) {
            Person person = new Person();
            person.setName(name);
            person.setAge(age);
            person.setEmail(email);
            
            // Store bean in session for later use
            request.getSession().setAttribute("personBean", person);
            
            // Also add it to the request for the JSP
            request.setAttribute("person", person);
        } else {
            request.setAttribute("errors", errors.toString());
        }
        
        // Forward to results JSP
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/validation-result.jsp");
        dispatcher.forward(request, response);
    }
} 