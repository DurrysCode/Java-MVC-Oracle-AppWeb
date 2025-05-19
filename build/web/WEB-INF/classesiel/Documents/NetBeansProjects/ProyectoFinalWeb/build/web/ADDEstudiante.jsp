<%-- 
    Document   : ADDEstudiante
    Created on : 17/05/2025, 11:44:18 a. m.
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
            <h1>Añadir Estudiante</h1>
        </div>
        <div>
            <form action="ControladorEstudiantes" method="POST">
                Carnet: (Numerico)<br>
                <input type="number" name="carnet"><br>
                Nombre: <br>
                <input type="text" name="nombre"><br>
                Telefono: (Numerico)<br>
                <input type="number" name="telefono"><br>
                Correo Electronico: <br>
                <input type="text" name="correo"><br>
                Direccion: <br>
                <input type="text" name="direccion"><br>
                <input type="submit" name="accion" value="Guardar">
            </form>
        </div>
    </center>
    </body>
</html>
