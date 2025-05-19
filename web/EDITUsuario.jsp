<%-- 
    Document   : EDITUsuario
    Created on : 14/05/2025, 9:56:00 a. m.
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
            <h1>Actualizar Usuario</h1>
        </div>
        <div>
            <form action="ControladorUsuarios" method="POST">
                Usuario: <br>
                <input type="text" value="${usuario.getUsuario()}" disabled="true">
                <input type="hidden" name="usuario" value="${usuario.getUsuario()}"><br>
                Contraseña: <br>
                <input type="password" name="contraseña" value="${usuario.getPassword()}"><br>
                <input type="submit" name="accion" value="Actualizar">
            </form>
        </div>
    </center>
</body>
</html>
