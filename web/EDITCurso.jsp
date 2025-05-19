<%-- 
    Document   : EDITCurso
    Created on : 18/05/2025, 1:12:49 p. m.
    Author     : Gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cursos</title>
    </head>
    <body>
        <div class="container mt-5">
            <div class="row justify-content-center">
                <div class="col-md-6">
                    <div class="card shadow-sm">
                        <div class="card-header bg-info text-white text-center">
                            <h4>Actualizar Curso</h4>
                        </div>
                        <div class="card-body">
                            <form action="ControladorCursos" method="POST">
                                <input type="hidden" name="codigo" value="${datos.getCodigo()}">
                                <div class="mb-3">
                                    <label class="form-label">Código del Curso</label>
                                    <input type="number" class="form-control" value="${datos.getCodigo()}" disabled>
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Nombre del Curso</label>
                                    <input type="text" class="form-control" name="curso" value="${datos.getCurso()}">
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Créditos</label>
                                    <input type="number" class="form-control" name="creditos" value="${datos.getCreditos()}">
                                </div>
                                <div class="d-grid">
                                    <button type="submit" class="btn btn-success" name="accion" value="Actualizar">Actualizar</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
