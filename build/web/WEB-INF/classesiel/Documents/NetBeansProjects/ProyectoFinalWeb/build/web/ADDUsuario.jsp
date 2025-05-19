<%-- 
    Document   : ADDUsuario
    Created on : 13/05/2025, 8:15:42 p. m.
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
            <h1>Añadir Usuario</h1>
        </div>
        <div>
            <form action="ControladorUsuarios" method="POST">
                Usuario: <br>
                <input type="text" name="usuario"><br>
                Contraseña: <br>
                <input type="password" name="contraseña"><br>
                <input type="submit" name="accion" value="Guardar">
            </form>
        </div>
    </center>
</body>
</html>
