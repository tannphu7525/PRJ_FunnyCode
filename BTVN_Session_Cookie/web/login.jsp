<%-- 
    Document   : login
    Created on : Jan 30, 2026, 12:10:36 AM
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
            <input type="hidden" name="action" value="login" />
            Username <input type="text" name="username" required/> <br/>
            Password <input type="password" name="password" required/> <br/>

            Remember Me <input type="checkbox" name="remember" value="ON" /> <br/>
            <input type="submit" value="Login" />
        </form>
    </body>
</html>
