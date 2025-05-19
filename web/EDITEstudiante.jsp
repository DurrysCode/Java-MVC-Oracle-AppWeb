<%-- 
    Document   : EDITEstudiante
    Created on : 17/05/2025, 3:26:12 p. m.
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
            <h1>Actualizar Estudiante</h1>
        </div>
        <div>
            <form action="ControladorEstudiantes" method="POST">
                Carnet: (Numerico)<br>
                <input type="number" value="${est.getCarnet()}" disabled>
                <input type="hidden" name="ca" value="${est.getCarnet()}"><br>
                Nombre: <br>
                <input type="text" name="nombre" value="${est.getNombre()}"><br>
                Telefono: (Numerico)<br>
                <input type="number" name="telefono" value="${est.getTelefono()}"><br>
                Correo Electronico: <br>
                <input type="text" name="correo" value="${est.getCorreo()}"><br>
                Direccion: <br>
                <input type="text" name="direccion" value="${est.getDireccion()}"><br>
                <input type="submit" name="accion" value="Actualizar">
            </form>
        </div>
    </center>
</body>
</html>
