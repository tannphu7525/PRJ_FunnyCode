<%-- 
    Document   : update.jsp
    Created on : Feb 7, 2026, 4:49:17 PM
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
        <<h1>UPDATE UNIVERSITY FORM</h1>
        
        <form action="main" method="POST">
            <input type="hidden" name="action" value="update" /> <br/>
            ID: <input type="text" name="id" value="${requestScope.university.getId}" /> <br/>
            Name: <input type="text" name="name" value="${requestScope.university.getName}" /> <br/>
            Short Name <input type="text" name="shortName" value="${requestScope.university.getShortName}" /> <br/>
            Description <input type="text" name="description" value="${requestScope.university.getDescription}" /> <br/>
            Founded Year <input type="text" name="foundedYear" value="${requestScope.university.getFoundedYear}" /> <br/>
            Address <input type="text" name="address" value="${requestScope.university.getAddress}" /> <br/>
            City <input type="text" name="city" value="${requestScope.university.getCity}" /> <br/>
            Region <input type="text" name="region" value="${requestScope.university.getRegion}" /> <br/>
            <label for="type" >Type</label> <br/>
            <select name="type" > <br/>
                <option value="requestScope.university.getType1">Đại học Quốc gia</option>  <br/>
                <option value="requestScope.university.getType2">Đại học Công lập</option>  <br/>
                <option value="requestScope.university.getType3">Đại học Tư thục</option>  <br/>
            </select>
            <br/>
            Total Students <input type="text" name="totalStudents" value="${requestScope.university.getTotalStudents}" /> <br/>
            Total Faculties <input type="text" name="totalFaculties" value="${requestScope.university.getTotalFaculties}" /> <br/>
            Total isDraft <input type="checkbox" name="isDraft" checked="${requestScope.university.isIsDraft}"/> <br/>
            <input type="submit" value="Update" /> <br/>            
        </form>
    </body>
</html>
