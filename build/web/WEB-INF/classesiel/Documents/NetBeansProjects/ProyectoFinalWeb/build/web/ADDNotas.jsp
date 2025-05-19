<%-- 
    Document   : ADDNotas
    Created on : 18/05/2025, 8:39:03 p. m.
    Author     : Gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <div>
            <h1>Añadir Nota a la Asignacion: ${datos.getAsignacion()}</h1>
        </div>
        <div>
            <form action="ControladorAsignaciones" method="POST">
                <input type="hidden" name="asignacion" value="${datos.getAsignacion()}">
                Primer parcial: <br>
                <input type="number" name="parcial1" value="${datos.getPrimerParcial()}"><br>
                Segundo parcial: <br>
                <input type="number" name="parcial2" value="${datos.getSegundoParcial()}"><br>
                Actividades: <br>
                <input type="number" name="actividades" value="${datos.getActividades()}"><br>
                Examen Final: <br>
                <input type="number" name="examenFinal" value="${datos.getExamenFinal()}"><br>
                <!-- Solo mostrar esto si recuperacion == true -->
                <c:if test="${recuperacion}">
                    Examen Recuperación: <br>
                    <input type="number" name="examenRecuperacion" value="${datos.getExamenRecuperacion()}"><br>
                </c:if>
                <input type="submit" name="accion" value="Guardar Nota">
            </form>
        </div>
    </center>
</body>
</html>
