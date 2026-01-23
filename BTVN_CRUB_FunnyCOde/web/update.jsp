<%-- 
    Document   : update
    Created on : Jan 24, 2026, 1:18:25 AM
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
        <h1>Update User Info</h1>
        
        <form method="controller">
            <input type="hidden" name="action" value="update" /> 
            <input type="hidden" name="id" value="${USER.id}" /> 
            
            Full Name: <input type="text" name="fullName" required/> <br/>
            
            Gender:
            <input type="radio" name="gender" value="male" /> Male
            <input type="radio" name="gender" value="female" /> Female
            
            Date Of Birth: <input type="date" name="dob" required="" /> <br/>
            Email <input type="text" name="email" required/> <br/>
            Phone <input type="text" name="phone" pattern="[0-9]{10,11}"/> <br/>
            
            <input type="submit" value="UPDATE NOW" />
        </form>
    </body>
</html>
