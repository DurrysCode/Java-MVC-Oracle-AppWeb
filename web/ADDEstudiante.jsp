<%-- 
    Document   : ADDEstudiante
    Created on : 17/05/2025, 11:44:18 a. m.
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
                        <div class="card-header bg-primary text-white text-center">
                            <h4>Añadir Estudiante</h4>
                        </div>
                        <div class="card-body">
                            <form action="ControladorEstudiantes" method="POST">
                                <div class="mb-3">
                                    <label class="form-label">Carnet (Numérico)</label>
                                    <input type="number" class="form-control" name="carnet" required>
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Nombre</label>
                                    <input type="text" class="form-control" name="nombre" required>
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Teléfono (Numérico)</label>
                                    <input type="number" class="form-control" name="telefono" required>
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Correo Electrónico</label>
                                    <input type="email" class="form-control" name="correo" required>
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Dirección</label>
                                    <input type="text" class="form-control" name="direccion" required>
                                </div>
                                <div class="d-grid">
                                    <button type="submit" class="btn btn-success" name="accion" value="Guardar">Guardar</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js" integrity="sha384-j1CDi7MgGQ12Z7Qab0qlWQ/Qqz24Gc6BM0thvEMVjHnfYGF0rmFCozFSxQBxwHKO" crossorigin="anonymous"></script>
    </body>
</html>
