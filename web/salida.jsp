<%@page import="com.emergentes.modelo.Rectangulo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Rectangulo miobj=(Rectangulo) request.getAttribute("miobj");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Area del rectangulo</h1>
        <p>El area del rectangulo es: <%= miobj.getArea()%></p>
        
        <a href="ejer6.jsp">Volver</a>
    </body>
</html>
