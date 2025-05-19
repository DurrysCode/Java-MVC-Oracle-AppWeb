<%-- 
    Document   : EDITAsignacion
    Created on : 18/05/2025, 10:03:23 p. m.
    Author     : Gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <center>
        <div>
            <h1>Actualizar Asignacion</h1>
        </div>
        <div>
            <form action="ControladorAsignaciones" method="POST">
                Numero de Asignacion (Numerico)<br>
                <input type="hidden" name="asignacion" value="${datos.getCodigoAsignacion()}">
                <input type="number" value="${datos.getCodigoAsignacion()}" disabled="true"><br>
                Codigo del curso: <br>
                <input type="text" name="curso" value="${datos.getCodigoCurso()}"><br>
                Carnet del estudiante: (Numerico)<br>
                <input type="number" name="carnet" value="${datos.getCodigoCarnet()}"><br>
                Fecha: <br>
                <input type="date" name="fecha" value="${datos.getFecha()}"><br>
                <input type="submit" name="accion" value="Actualizar">
            </form>
        </div>
    </center>
    </body>
</html>
