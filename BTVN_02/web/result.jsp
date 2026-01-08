<%-- 
    Document   : result
    Created on : Jan 8, 2026, 7:16:44 AM
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
        <h1>RESULT</h1>
            <%
                String error = (String) request.getAttribute("error");
                String result = (String) request.getAttribute("result");
                if (error != null) {
            %>
                <%= error %>
            <% } else if(result != null) { %>
                    <%= result %>
            <%  } %>
    </body>
</html>
