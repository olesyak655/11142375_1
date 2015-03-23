<%-- 
    Document   : error
    Created on : 04.03.2015, 14:01:19
    Author     : Олеся
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isErrorPage="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
    </head>
    <body>
        <h1>Opps...</h1>
        <p>Sorry, an error occurred.</p>
        <p>On top is the exception stack trace </p>
        <pre>
            <% exception.printStackTrace(response.getWriter());%>
        </pre>
    </body>
</html>
