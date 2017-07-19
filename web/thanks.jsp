<%-- 
    Document   : thanks
    Created on : Jul 18, 2017, 5:22:43 PM
    Author     : Bill Adams
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <span>${student.firstName}</span><br>
        <label>Last name:</label>
        <span>${student.lastName}</span><br>
        <label>Age:</label>
        <span>${student.age}</span><br>
        
        <label>Classes taken:</label>
        <c:choose>
            <c:when test="${student.classes != null}">
                <ul>
                    <c:forEach var="theClass" items="${student.classes}">
                        <li>${theClass}</li>
                    </c:forEach>
                </ul>
            </c:when> 
            <c:otherwise>
                <p>No classes taken</p>
            </c:otherwise>
        </c:choose>
        
        <c:if test="${student.classes != null}">

        </c:if>  
        
        <label>Color chosen</label>
        <span>${student.color}</span><br>
        
        <label>Hobbies:</label>
        <c:choose>
            <c:when test="${student.hobbies != null}">
                <ul>
                    <c:forEach var="theHobby" items="${student.hobbies}">
                        <li>${theHobby}</li>
                    </c:forEach>
                </ul>                
            </c:when>
            <c:otherwise>
                <p>Student does not have any hobbies</p>
            </c:otherwise>
        </c:choose>
                
        <label>Expected graduation date:</label>
        <span>${student.formatGraduationDate()}</span><br>
        <label>Days until graduation date:</label>
        <span>${student.daysUntilGraduation()}</span>
    </body>
</html>