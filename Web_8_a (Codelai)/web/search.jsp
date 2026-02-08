<%-- 
    Document   : search.jsp
    Created on : Feb 5, 2026, 10:34:14 AM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <jsp:include page="welcome.jsp" />
         
         <c:if test="${empty user}">
             <c:redirect url = "login.jsp"/>
            </c:if>
         
         <br/>
         <a href="university_form.jsp" style="display: inline;">Insert</a> <br/>
         
         
         <c:if test="${not empty mess}">
             <p style="color: green; font-weight: bold;">${mess}</p>
         </c:if>
         <c:if test="${not empty messEr}">
             <p style="color: red; font-weight: bold;">${messEr}</p>
         </c:if>
         
       <c:if test="${not empty user}">

           <form action="main" method="POST">
                <input type="hidden" name="action" value="search"/>
                Input name:
                <input type="text" name="keywords" value="${keywords}" />
                <input type="submit" value="Search"/>
            </form>
            <hr/>

            <c:if test="${empty list}">
                No data matching the search criteria found!
            </c:if>

            <c:if test="${not empty list}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Name</th>
                            <th>Short Name</th>
                            <th>City</th>
                            <th>Region</th>
                            <th>Type</th>
                            <th>Founded Year</th>
                            <th>Students</th>
                            <th>Faculties</th>
                            <th></th>
                        </tr>
                    </thead>

                    <c:forEach items="${list}" var="u">
                        <tr>
                            <td>${u.id}</td>
                            <td>${u.name}</td>
                            <td>${u.shortName}</td>
                            <td>${u.city}</td>
                            <td>${u.region}</td>
                            <td>${u.type}</td>
                            <td>${u.foundedYear}</td>
                            <td>${u.totalStudents}</td>
                            <td>${u.totalFaculties}</td>
                            <td>
                                <form action="main" method="POST"
                                      onsubmit = "return confirm('Bạn có chắc chắn muốn cập nhật không?');">
                                    <input type="hidden" name="action" value="update" />
                                    <input type="hidden" name="id" value="${u.id}" />
                                    <input type="submit" value="Update" />
                                </form>                                  
                            </td>
                            <td>
                                <form action="main" method="POST"
                                      onsubmit = "return confirm('Bạn có chắc chắn muốn xóa trường đại học này không?');">
                                    <input type="hidden" name="action" value="delete" />
                                    <input type="hidden" name="id" value="${u.id}" />
                                    <input type="hidden" name="keywords" value="${keywords}" />
                                    <input type="submit" value="Delete" />
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
        </c:if>         
    </body>
</html>
