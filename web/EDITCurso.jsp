<%-- 
    Document   : EDITCurso
    Created on : 18/05/2025, 1:12:49 p. m.
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
            <form action="ControladorCursos" method="POST">
                Codigo del curso: (Numerico)<br>
                <input type="hidden" name="codigo" value="${datos.getCodigo()}">
                <input type="number" value="${datos.getCodigo()}" disabled="true"><br>
                Nombre del Curso: <br>
                <input type="text" name="curso" value="${datos.getCurso()}"><br>
                Creditos del curso: (Numerico)<br>
                <input type="number" name="creditos" value="${datos.getCreditos()}"><br>
                <input type="submit" name="accion" value="Actualizar">
            </form>
        </div>
    </center>
</body>
</html>
