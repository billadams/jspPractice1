<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Form To Servlet</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="styles/main.css" type="text/css"/>
    </head>
    <body>
        <h1>Please enter the requested information:</h1>
        <c:if test="${messages != null}">
            <ul class="error">
                <c:forEach var="theMessage" items="${messages}">
                    <li>${theMessage}</li>
                </c:forEach>
            </ul>
        </c:if>
            
        <form action="formServlet" method="post">
            <input type="hidden" name="action" value="submit">
            <label for="first_name" class="input_text_label">First Name:</label>
            <input type="text" id="first_name" name="firstName" value="${student.firstName}" autofocus><br>
            <label for="last_name" class="input_text_label">Last Name:</label>
            <input type="text" id="last_name" name="lastName" value="${student.lastName}"><br>          
            <label for="age"class="input_text_label">Age:</label>
            <input type="text" id="age" name="age" value="${student.age}"><br><br>
            
            <fieldset>
                <legend>Classes taken:</legend>
                
                <input type="checkbox" id="class_1520" name="classes" value="1520">
                <label for="class_1520">Computer Programming</label><br>
                
                <input type="checkbox" id="class_1425" name="classes" value="1425">
                <label for="class_1425">Home Economics</label><br>
                
                <input type="checkbox" id="class_1550" name="classes" value="1550">
                <label for="class_1550">Good Housekeeping Skills</label>
            </fieldset><br><br>

            
            <label for="color">Select a color:</label><br>
            <input type="color" id="color" name="color"><br><br>
            
            <label for="hobbies">Hobbies (hold ctrl or cmd to select multiple):</label><br>
            <select name="hobbies" id="hobbies" size="6" multiple>
                <option value="run">Running</option>
                <option value="hike">Hiking</option>
                <option value="swim">Swimming</option>
                <option value="bike">Biking</option>
                <option value="lift">Lifting</option>
                <option value="fish">Fishing</option>
                <option value="roller">Roller Skating</option>
                <option value="skateboard">Skate Boarding</option>
            </select><br><br>
            
            <label for="grad_date">What is your expected graduation date?</label><br>
            <input type="date" id="grad_date" name="gradDate"><br><br>
            
            <input type="submit" id="submit" value="Send It">
        </form>
    </body>
</html>

