<%-- 
    Document   : index
    Created on : Jan 26, 2016, 4:42:36 PM
    Author     : iwuvhugs
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dbsample.DBSample" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%=DBSample.getTable()%>
    </body>
</html>
