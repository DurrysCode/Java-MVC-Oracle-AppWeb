<%-- 
    Document   : EDITEstudiante
    Created on : 17/05/2025, 3:26:12 p. m.
    Author     : Gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Estudiantes</title>
    </head>
    <body>
        <div class="container mt-5">
            <div class="row justify-content-center">
                <div class="col-md-6">
                    <div class="card shadow-sm">
                        <div class="card-header bg-secondary text-white text-center">
                            <h4>Actualizar Estudiante</h4>
                        </div>
                        <div class="card-body">
                            <form action="ControladorEstudiantes" method="POST">
                                <input type="hidden" name="ca" value="${est.getCarnet()}">
                                <div class="mb-3">
                                    <label class="form-label">Carnet</label>
                                    <input type="number" class="form-control" value="${est.getCarnet()}" disabled>
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Nombre</label>
                                    <input type="text" class="form-control" name="nombre" value="${est.getNombre()}">
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Teléfono</label>
                                    <input type="number" class="form-control" name="telefono" value="${est.getTelefono()}">
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Correo Electrónico</label>
                                    <input type="text" class="form-control" name="correo" value="${est.getCorreo()}">
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Dirección</label>
                                    <input type="text" class="form-control" name="direccion" value="${est.getDireccion()}">
                                </div>
                                <div class="d-grid">
                                    <button type="submit" class="btn btn-dark" name="accion" value="Actualizar">Actualizar</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
