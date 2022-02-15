<%-- 
    Document   : editarEquipo
    Created on : 13-feb-2022, 20:20:20
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
        <h1>Editar Equipo</h1>
        <form action="ModificarServlet" method="POST">
            <table borde="1">
                <input type="hidden" name="txtId" value="${id}">
                <tr>
                    <td>Equipo:</td>
                    <td>
                        <input type="text" name="txtNombre" value="${equipo.nombre}">
                    </td>
                </tr>
                <tr>
                    <td><label for="cboCampeonato">Campeonato</label></td>
                    <td>
                        <select name="cboCampeonato">
                            <c:forEach var="i" items="${lista}">
                                <option value="${i.id}">
                                       ${i.denominacion}
                                </option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        Cantidad de jugadores:
                    </td>
                    <td><input type="number" name="txtJugadores" value="${equipo.jugadores}"></td>
                </tr>
                <tr>
                    <td>Cena:</td>
                    <td>
                        <input type="radio" name="opcion" value="1">si <br>
                        <input type="radio" name="opcion" value="0">no <br>
                    </td>
                </tr>
                <br>
                <br>
                <tr>
                    <td> <input type="submit" value="registrar"> </td>
                </tr>
                
            </table>

        </form>
    </body>
</html>
