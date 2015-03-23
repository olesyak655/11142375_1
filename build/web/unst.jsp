<%-- 
    Document   : unst
    Created on : 13.03.2015, 12:11:36
    Author     : Олеся
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!JSP directive to associate the error handling page with JSP pages>
<%@ page errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Handling Example</title>
    </head>
    <body>
        <%
            // Throw an exception to invoke the error page
            int x = 1;
            if (x == 1) {
                throw new RuntimeException("Error condition!!!");
            }
        %>
    </body>
</html>

