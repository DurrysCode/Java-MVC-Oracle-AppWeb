<%-- 
    Document   : ADDAsignacion
    Created on : 18/05/2025, 6:50:22 p. m.
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
            <h1>Añadir Asignacion</h1>
        </div>
        <div>
            <form action="ControladorAsignaciones" method="POST">
                Numero de Asignacion (Numerico)<br>
                <input type="number" name="asignacion"><br>
                Codigo del curso: <br>
                <input type="text" name="curso"><br>
                Carnet del estudiante: (Numerico)<br>
                <input type="number" name="carnet"><br>
                Fecha: <br>
                <input type="date" name="fecha"><br>
                <input type="hidden" name="notas" value="0">
                <input type="submit" name="accion" value="Guardar">
            </form>
        </div>
    </center>
</body>
</html>
