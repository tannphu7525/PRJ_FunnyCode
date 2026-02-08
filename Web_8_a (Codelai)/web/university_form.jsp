<%-- 
    Document   : university_form
    Created on : Feb 5, 2026, 11:02:56 AM
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
        <form action="main" method="POST">
            <input type="hidden" name="action" value="add" /> <br/>
            ID: <input type="text" name="id" value="${u.id}" /> <br/>
            Name: <input type="text" name="name" value="${u.name}" /> <br/>
            Short Name <input type="text" name="shortName" value="${u.shortName}" /> <br/>
            Description <input type="text" name="description" value="${u.description}" /> <br/>
            Founded Year <input type="text" name="foundedYear" value="${u.foundedYear}" /> <br/>
            Address <input type="text" name="address" value="${u.address}" /> <br/>
            City <input type="text" name="city" value="${u.city}" /> <br/>
            Region <input type="text" name="region" value="${u.region}" /> <br/>
            <label for="type">Type</label> <br/>
            <select name="type"> <br/>
                <option value="type1">Đại học Quốc gia</option>  <br/>
                <option value="type2">Đại học Công lập</option>  <br/>
                <option value="type3">Đại học Tư thục</option>  <br/>
            </select>
            <br/>
            Total Students <input type="text" name="totalStudents" value="${u.totalStudents}" /> <br/>
            Total Faculties <input type="text" name="totalFaculties" value="${u.totalFaculties}" /> <br/>
            Total isDraft <input type="checkbox" name="isDraft" checked="${u.isDraft}"/> <br/>
            <input type="submit" value="ADD" /> <br/>
        </form>
    </body>

    <p style="color: green">${mess}</p>
    <p style="color: red">${err}</p>

</body>
</html>
