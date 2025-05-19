<%-- 
    Document   : ADDCurso
    Created on : 18/05/2025, 12:42:30 p. m.
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
            <h1>Añadir Curso</h1>
        </div>
        <div>
            <form action="ControladorCursos" method="POST">
                Codigo del curso: (Numerico)<br>
                <input type="number" name="codigo"><br>
                Nombre del Curso: <br>
                <input type="text" name="curso"><br>
                Creditos del curso: (Numerico)<br>
                <input type="number" name="creditos"><br>
                <input type="submit" name="accion" value="Guardar">
            </form>
        </div>
    </center>
</body>
</html>
