<%-- 
    Document   : cantCategoria
    Created on : 13-feb-2022, 17:02:27
    Author     : jose.romero
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Cantidad de equipos por categoria</h1>
        
        <table border="1">
            <thead>
                <tr>
                    <th>Cant. Equipos</th>
                    <th>Categoria</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="i" items="${lista}">
                    <tr>
                        <td>${i.cant}</td>
                        <td>${i.denominacion}</td>
                    </tr>
                
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
