<%@page import="com.emergentes.modelo.Personas"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if(session.getAttribute("listaest")==null){
        ArrayList<Personas> listaux=new ArrayList<Personas>();
        session.setAttribute("listaest",listaux);
    }
    
    ArrayList<Personas> lista =(ArrayList<Personas>) session.getAttribute("listaest");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Lista de personas</h1>
        <a href="Controlador?op=1">Nuevo</a>
        <table border="1">
            <tr>
                <th>id</th>
                <th>Nombres</th>
                <th>Apellidos</th>
                <th>Edad</th>
                <th></th>
                <th></th>
            </tr>
            <%
            if(lista!=null){
                for(Personas item : lista){
                                   
            %>
            <tr>
                <td><%= item.getId()%></td>
                <td><%= item.getNombres()%></td>
                <td><%= item.getApellidos()%></td>
                <td><%= item.getEdad()%></td>
                <td>
                    <a href="Controlador?op=2&id=<%= item.getId()%>">
                        Editar
                    </a>
                    
                </td>
                <td>
                    <a  href="Controlador?op=3&id=<%= item.getId()%>"
                        onclick="return confirm('Esta seguro?')">Eliminar</a>
                </td>
            </tr>
            <%
                }
            }    
            %>
        </table>
    </body>
</html>
