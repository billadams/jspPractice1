<%-- 
    Document   : thanks
    Created on : Jul 18, 2017, 5:22:43 PM
    Author     : Bill Adams
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Servlet formServlet</title>
        <link rel="stylesheet" href="styles/main.css" type="text/css">
    </head>
    <body>
        <h1>Thank you for sharing your information with us!</h1>
        <label>First name:</label>
        <span>${student.firstName}</span>
        <label>Last name:</label>
        <span>${student.lastName}</span>
        <label>Age:</label>
        <span>${student.age}</span>
        
        <label>Classes taken:</label>
        
    </body>
</html>



<!--                // Logic for the checkboxes that were submitted.
                if (student.getClasses() != null) {
                    out.println("<p>Classes taken:</p>");
                    out.println("<ul>");
                    for (String theClass : student.getClasses()) {
                        out.println("<li>" + theClass + "</li>");
                    }            
                    out.println("</ul>");   
                } else {
                    out.println("<p>No classes taken</p>");
                }

                out.println("<p>Color chosen: " + student.getColor() + "</p>");

                // Logic for the options of the select that were submitted.
                if (student.getHobbies() != null) {
                out.println("<p>Hobbies:</p>");
                out.println("<ul>");
                    for (String hobby : student.getHobbies()) {
                        out.println("<li>" + hobby + "</li>");
                    }
                out.println("</ul>");               
                } else {
                    out.println("<p>Student doesn't have any hobbies</p>");
                }

                // Format the date the user selected and output it.
                out.println("<p>Expected graduation date: " + student.formatGraduationDate() + "</p>");
                
                // Get and output the days until graduation.
                out.println("<p>Days until graduation date: " + student.daysUntilGraduation() + "</p>");
  -->
