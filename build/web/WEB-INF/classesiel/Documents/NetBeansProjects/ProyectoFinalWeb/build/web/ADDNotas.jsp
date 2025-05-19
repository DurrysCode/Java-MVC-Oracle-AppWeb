<%-- 
    Document   : ADDNotas
    Created on : 18/05/2025, 8:39:03 p. m.
    Author     : Gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
                        <div class="card-header bg-primary text-white text-center">
                            <h4>Añadir Nota a la Asignación: ${datos.getAsignacion()}</h4>
                        </div>
                        <div class="card-body">
                            <form action="ControladorAsignaciones" method="POST">
                                <input type="hidden" name="asignacion" value="${datos.getAsignacion()}">

                                <div class="mb-3">
                                    <label class="form-label">Primer Parcial</label>
                                    <input type="number" class="form-control" name="parcial1" value="${datos.getPrimerParcial()}" required>
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Segundo Parcial</label>
                                    <input type="number" class="form-control" name="parcial2" value="${datos.getSegundoParcial()}" required>
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Actividades</label>
                                    <input type="number" class="form-control" name="actividades" value="${datos.getActividades()}" required>
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Examen Final</label>
                                    <input type="number" class="form-control" name="examenFinal" value="${datos.getExamenFinal()}" required>
                                </div>

                                <c:if test="${recuperacion}">
                                    <div class="mb-3">
                                        <label class="form-label">Examen Recuperación</label>
                                        <input type="number" class="form-control" name="examenRecuperacion" value="${datos.getExamenRecuperacion()}">
                                    </div>
                                </c:if>

                                <div class="d-grid">
                                    <button type="submit" class="btn btn-success" name="accion" value="Guardar Nota">Guardar Nota</button>
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
