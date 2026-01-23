<%-- 
    Document   : login
    Created on : Jan 23, 2026, 11:49:18 PM
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
        <form action="controller" method="POST">
            <h1>Add New User</h1>
            <input type="hidden" name="action" value="create" /> 
            Full Name: <input type="text" name="fullName" required/> <br/>
            
            Gender:
            <input type="radio" name="gender" value="male" /> Male
            <input type="radio" name="gender" value="female" /> Female
            
            Date Of Birth: <input type="date" name="dob" required /> <br/>
            Email <input type="text" name="email" required/> <br/>
            Phone <input type="text" name="phone" pattern="[0-9]{10,11}"/> <br/>
            
            <input type="submit" value="SUBMIT" />
        </form>
    </body>
</html>
