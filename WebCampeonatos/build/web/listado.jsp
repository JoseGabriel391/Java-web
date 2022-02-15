<%-- 
    Document   : listado
    Created on : 13-feb-2022, 17:31:43
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
        <h1>Listado de Equipo</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>Equipo</th>
                    <th>Cant. jugadores</th>
                    <th>Campeonato</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="i" items="${lista}">
                    <tr>
                        <td>${i.nombreEquipo}</td>
                        <td>${i.cantJugadores}</td>
                        <td>${i.nombreCampeonato}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
