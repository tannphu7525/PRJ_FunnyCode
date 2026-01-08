<%-- 
    Document   : index.
    Created on : Jan 8, 2026, 6:31:36 AM
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
        <div>Calculator</div>
        
        <form action="cal" method="GET">
            Number 1: <input type="text" name="num1" value="" /> <br>
            Number 2: <input type="text" name="num2" value="" /> <br>
            
            Operator: <br>
            <input type="radio" name="op" value="+" /> + <br>
            <input type="radio" name="op" value="-" /> - <br>
            <input type="radio" name="op" value="*" /> * <br>
            <input type="radio" name="op" value="/" /> / <br>
            <input type="submit" value="SUBMIT" />
        </form>
    </body>
</html>
