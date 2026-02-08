<%-- 
    Document   : welcome
    Created on : Feb 5, 2026, 10:25:56 AM
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
        <c:if test="${not empty user}">
            <<h1>WELCOME, ${user.fullName}</h1>

            <a href="search.jsp"">SEARCH</a>
            <br/>
            <form action="main" method="POST" style="display: inline;">
                <input type="hidden" name="action" value="logout" />
                <button type="submit" class="link-button">Logout</button>
            </form>
        </c:if>

        <c:if test="${empty user}">
            <c:redirect url = "login.jsp"/>
        </c:if>
    </body>
</html>
