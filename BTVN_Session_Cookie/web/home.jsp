<%-- 
    Document   : home
    Created on : Jan 30, 2026, 7:33:52 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>\
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:if test="${not empty user}">
            <h1>Xin chào, ${user.username}</h1>

            <a href="logout">Logout</a> <br/>  
        </c:if>

        <c:if test="${empty user}">
            <c:redirect url="login.jsp"/>
        </c:if>
    </body>
</html>
