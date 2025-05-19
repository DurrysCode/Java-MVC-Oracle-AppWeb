<%-- 
    Document   : EDITAsignacion
    Created on : 18/05/2025, 10:03:23 p. m.
    Author     : Gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Asignaciones</title>
    </head>
    <body>
        <div class="container mt-5">
            <div class="row justify-content-center">
                <div class="col-md-6">
                    <div class="card shadow-sm">
                        <div class="card-header bg-warning text-white text-center">
                            <h4>Actualizar Asignación</h4>
                        </div>
                        <div class="card-body">
                            <form action="ControladorAsignaciones" method="POST">
                                <input type="hidden" name="asignacion" value="${datos.getCodigoAsignacion()}">
                                <div class="mb-3">
                                    <label class="form-label">Número de Asignación</label>
                                    <input type="number" class="form-control" value="${datos.getCodigoAsignacion()}" disabled>
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Código del Curso</label>
                                    <input type="text" class="form-control" name="curso" value="${datos.getCodigoCurso()}">
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Carnet del Estudiante</label>
                                    <input type="number" class="form-control" name="carnet" value="${datos.getCodigoCarnet()}">
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Fecha</label>
                                    <input type="date" class="form-control" name="fecha" value="${datos.getFecha()}">
                                </div>
                                <div class="d-grid">
                                    <button type="submit" class="btn btn-primary" name="accion" value="Actualizar">Actualizar</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
