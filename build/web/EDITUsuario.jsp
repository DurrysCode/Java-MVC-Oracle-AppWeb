<%-- 
    Document   : EDITUsuario
    Created on : 14/05/2025, 9:56:00 a. m.
    Author     : Gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuarios</title>
    </head>
    <body>
    <div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-5">
            <div class="card shadow-sm">
                <div class="card-header bg-dark text-white text-center">
                    <h4>Actualizar Usuario</h4>
                </div>
                <div class="card-body">
                    <form action="ControladorUsuarios" method="POST">
                        <input type="hidden" name="usuario" value="${usuario.getUsuario()}">
                        <div class="mb-3">
                            <label class="form-label">Usuario</label>
                            <input type="text" class="form-control" value="${usuario.getUsuario()}" disabled>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Contraseña</label>
                            <input type="password" class="form-control" name="contraseña" value="${usuario.getPassword()}">
                        </div>
                        <div class="d-grid">
                            <button type="submit" class="btn btn-warning" name="accion" value="Actualizar">Actualizar</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
