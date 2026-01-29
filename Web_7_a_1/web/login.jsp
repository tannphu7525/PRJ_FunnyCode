<%-- 
    Document   : login
    Created on : Jan 26, 2026, 4:51:13 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="controller" method="">
            Username: <input type="text" name="username" value="" required /> <br/>
            Password: <input type="password" name="password" value="" required /> <br/>
            <input type="hidden" name="action" value="login" />
            <input type="submit" name="LOGIN" />
        </form>
        
        <c:if test="not empty user">
            ${message}
        </c:if>
    </body>
</html>
