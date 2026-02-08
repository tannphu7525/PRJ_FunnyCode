<%-- 
    Document   : login.jsp
    Created on : Feb 5, 2026, 9:46:06 AM
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
        <form action="main" method="POST">
            <input type="hidden" name="action" value="login"/>
            Username <input type="text" name="username" required/> <br/>
            Password <input type="password" name="password" required/> <br/>
            <input type="submit" value="SUBMIT" />
        </form>
    </body>
</html>
