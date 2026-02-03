<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <c:if test="${empty sessionScope.user}">
            <c:choose>
                <c:when test="${not empty cookie.cuser}">
                    <c:redirect url="login">
                        <c:param name="action" value="autologin"/>
                    </c:redirect>
                </c:when>
                
                <c:otherwise>
                    <c:redirect url="login.jsp"/>
                </c:otherwise>
            </c:choose>
        </c:if>

        <c:if test="${not empty sessionScope.user}">
            <h1>Xin chào, ${sessionScope.user.username}</h1>
            <a href="logout">Logout</a>
        </c:if>
    </body>
</html>