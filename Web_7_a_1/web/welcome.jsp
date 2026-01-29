<%-- 
    Document   : welcome
    Created on : Jan 27, 2026, 12:04:16 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:if test="${not empty user}">
            <h1>Welcome, ${user.fullName}</h1>
            
            <a href="controller?action=logout">Logout</a> <br/>
            <a href="search.jsp">Search</a>
        </c:if>
            
            <c:if test="${empty user}">
                <c:redirect url="login.jsp"/>
            </c:if>
    </body>
</html>
