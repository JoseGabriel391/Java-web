<%-- 
    Document   : listadoEquipo
    Created on : 13-feb-2022, 19:06:24
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
        <h1>Listado de equipos</h1>
        
        <table border="1">
            <thead>
                <tr>
                    <th>id</th>
                    <th>Nombre</th>
                    <th>Campeonato</th>
                    <th>Jugadores</th>
                    <th>Cenas</th>
                    <th>Importe</th>
                    <th>Acciones</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="i" items="${lista}">
                    <tr>
                        <td>${i.id}</td>
                        <td>${i.nombre}</td>
                        <td>${i.campeonato.denominacion}</td>
                        <td>${i.jugadores}</td>
                        <td>${i.cena}</td>
                        <td>${i.importe}</td>
                        <td><a href="/WebCampeonatos/ModificarServlet?id=${i.id}">Modificar</a></td>
                        <td><a href="/WebCampeonatos/EliminarServlet?id=${i.id}">Eliminar</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
