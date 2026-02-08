<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update University</title>
    </head>
    <body>
        <h1>UPDATE UNIVERSITY FORM</h1>

        <h3 style="color: red">${requestScope.err}</h3>

        <form action="main" method="POST">
            <input type="hidden" name="action" value="update" />           

            ID: <input type="text" name="id" value="${u.id}" readonly /> <br/>            
            Name: <input type="text" name="name" value="${u.name}" /> <br/>            
            Short Name: <input type="text" name="shortName" value="${u.shortName}" /> <br/>            
            Description: <input type="text" name="description" value="${u.description}" /> <br/>          
            Founded Year: <input type="text" name="foundedYear" value="${u.foundedYear}" /> <br/>          
            Address: <input type="text" name="address" value="${u.address}" /> <br/>           
            City: <input type="text" name="city" value="${u.city}" /> <br/>         
            Region: <input type="text" name="region" value="${u.region}" /> <br/>         
            <label for="type">Type</label> <br/>
            <select name="type">
                <option value="Đại học Quốc gia" ${u.type == 'Đại học Quốc gia' ? 'selected' : ''}>Đại học Quốc gia</option>
                <option value="Đại học Công lập" ${u.type == 'Đại học Công lập' ? 'selected' : ''}>Đại học Công lập</option>
                <option value="Đại học Tư thục" ${u.type == 'Đại học Tư thục' ? 'selected' : ''}>Đại học Tư thục</option>
            </select>
            <br/>         
            Total Students: <input type="text" name="totalStudents" value="${u.totalStudents}" /> <br/>           
            Total Faculties: <input type="text" name="totalFaculties" value="${u.totalFaculties}" /> <br/>           
            Is Draft: <input type="checkbox" name="isDraft" ${u.isDraft ? 'checked' : ''} /> <br/>         
            <input type="submit" value="Update" />
        </form>
    </body>
</html>