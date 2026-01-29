<%-- 
    Document   : login
    Created on : Jan 24, 2026, 1:12:02 AM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Management</title>
        <style>
            table { border-collapse: collapse; width: 100%; }
            th, td { border: 1px solid black; padding: 8px; text-align: left; }
            th { background-color: #f2f2f2; }
        </style>
    </head>
    <body>
        <h1>LIST USER</h1>

        <a href="create.jsp" style="margin-bottom: 20px; display: block;"> + Add New User</a>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Full Name</th>
                    <th>Gender</th>
                    <th>Date Of Birth</th>
                    <th>Email</th>
                    <th>Phone</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${requestScope.USER_LIST}" var="u">
                    <tr>
                        <td>${u.id}</td>
                        <td>${u.fullName}</td>
                        <td>${u.gender}</td>
                        <td>${u.dob}</td>
                        <td>${u.email}</td>
                        <td>${u.phone}</td>
                        <td>
                            <a href="controller?action=edit&id=${u.id}">Edit</a>
                            <a href="controller?action=delete&id=${u.id}" onclick="return confirm('Are you sure?')">Delete</a>
                        </td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>

        </body>
    </html>
