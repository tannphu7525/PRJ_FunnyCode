<%-- 
    Document   : update
    Created on : Jan 24, 2026, 1:18:25 AM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update User</title>
    </head>
    <body>
        <h1>Update User Info</h1>
        
        <form action="controller" method="POST">
            <input type="hidden" name="action" value="update" /> 
            <input type="hidden" name="id" value="${USER.id}" /> 
            
            Full Name: <input type="text" name="fullName" value="${USER.fullName}" required/> <br/>
            
            Gender:
            <input type="radio" name="gender" value="male" <c:if test="${USER.gender}">checked</c:if> /> Male
            <input type="radio" name="gender" value="female" <c:if test="${!USER.gender}">checked</c:if> /> Female
            <br/>
            
            Date Of Birth: <input type="date" name="dob" value="${USER.dob}" required /> <br/>
            Email: <input type="text" name="email" value="${USER.email}" required/> <br/>
            Phone: <input type="text" name="phone" value="${USER.phone}" pattern="[0-9]{10,11}"/> <br/>
            
            <input type="submit" value="UPDATE NOW" />
        </form>
    </body>
</html>