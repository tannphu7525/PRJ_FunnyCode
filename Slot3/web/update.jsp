<%-- 
    Document   : update
    Created on : Jan 21, 2026, 3:58:17 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Update New Student</h1>
        <form method="post" action="update">
            <input type="text" name="studentId" value="${requestScope.}" hidden/>  
        
        Student ID <input type="text" name="studentID" value="" required/> <br/>
        First Name <input type="text" name="firstName" value="" required/> <br/>
        Last Name<input type="text" name="lastName" value="" />
        DOB <input type="date" name="dateOfBirth" value="" />
        Gender 
        <select name="gender" required>
            <option value="">--Select Gender--</option>
            <option value="male">Male</option>
            <option value="female">Female</option>
        </select> <br/>
        School ID<input type="text" name="schoolID" value="" required/>
        <input type="submit" value="UPDATE" />            
        </form>
    </body>
</html>
