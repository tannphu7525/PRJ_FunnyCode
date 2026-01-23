<%-- 
    Document   : index
    Created on : Jan 16, 2026, 11:57:25 PM
    Author     : admin
--%>

<%@page import="model.Student"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        zzzzzzzzz
        <a href="create.jsp">CREATE NEW STUDENT</a>
        <table border="1">
            <thead>               
                <tr>
                    <th>StudentID</th>
                    <th>FirstName</th>
                    <th>LastName</th>
                    <th>DateOfBirth</th>
                    <th>Gender</th>
                    <th>SchoolID</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="i" items="${requestScope.listRes}">
                <tr>
                    <td>${i.getStudentID()}</td>
                    <td>${i.getFirstName()}</td>
                    <td>${i.getLastName()}</td>
                    <td>${i.getDateOfBirth()}</td>
                    <td>${i.getGender()}</td>
                    <td>${i.getSchoolID()}</td>
                    <td>
                        <a href="update?studentId=${}">Update</a>
                        <a href="remove?studentId=${}">Remove</a>
                    </td>
                </tr>
                 </c:forEach>
            </tbody>
        </table>

            
            
        
    </body>
</html>
