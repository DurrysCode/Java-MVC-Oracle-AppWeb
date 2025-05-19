<%-- 
    Document   : READAsignaciones
    Created on : 18/05/2025, 4:38:56 p. m.
    Author     : Gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Asignaciones</title>
    </head>
    <body>
        <jsp:include page="NavBar.jsp"/>
    <div class="container mt-5">
        <div class="text-center mb-4">
            <h1 class="display-6">Asignaciones</h1>
            <form action="ControladorAsignaciones" method="POST" class="d-inline">
                <button type="submit" name="accion" value="Listar" class="btn btn-primary me-2">Listar</button>
            </form>
            <form action="ControladorAsignaciones" method="POST" class="d-inline">
                <button type="submit" name="accion" value="Nuevo" class="btn btn-success">Nuevo</button>
            </form>
        </div>

        <div class="table-responsive">
            <table class="table table-striped table-bordered table-hover align-middle text-center">
                <thead class="table-dark">
                    <tr>
                        <th>Fecha</th>
                        <th>No. Asignación</th>
                        <th>Código del Curso</th>
                        <th>Carnet</th>
                        <th>Parcial #1</th>
                        <th>Parcial #2</th>
                        <th>Actividades</th>
                        <th>Examen Final</th>
                        <th>Nota Total</th>
                        <th>Recuperación</th>
                        <th>Examen Recuperación</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="datos" items="${datos}">
                        <tr>
                            <td>${datos.asignacion.fecha}</td>
                            <td>${datos.asignacion.codigoAsignacion}</td>
                            <td>${datos.asignacion.codigoCurso}</td>
                            <td>${datos.asignacion.codigoCarnet}</td>
                            <td>${datos.nota.primerParcial}</td>
                            <td>${datos.nota.segundoParcial}</td>
                            <td>${datos.nota.actividades}</td>
                            <td>${datos.nota.examenFinal}</td>
                            <td>${datos.notaTotal}</td>
                            <td>${datos.recuperacion}</td>
                            <td>${datos.nota.examenRecuperacion}</td>
                            <td>
                                <form action="ControladorAsignaciones" method="POST" class="d-grid gap-1">
                                    <input type="hidden" name="asignacion" value="${datos.asignacion.codigoAsignacion}">
                                    <input type="hidden" name="parcial1" value="${datos.nota.primerParcial}">
                                    <input type="hidden" name="parcial2" value="${datos.nota.segundoParcial}">
                                    <input type="hidden" name="actividades" value="${datos.nota.actividades}">
                                    <input type="hidden" name="examenFinal" value="${datos.nota.examenFinal}">
                                    <input type="hidden" name="examenRecuperacion" value="${datos.nota.examenRecuperacion}">
                                    <input type="hidden" name="recuperacion" value="${datos.recuperacion}">
                                    <button type="submit" name="accion" value="Editar" class="btn btn-info btn-sm">Editar</button>
                                    <button type="submit" name="accion" value="Eliminar" class="btn btn-danger btn-sm">Eliminar</button>
                                    <button type="submit" name="accion" value="Agregar Nota" class="btn btn-sm">Agregar Nota</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js" integrity="sha384-j1CDi7MgGQ12Z7Qab0qlWQ/Qqz24Gc6BM0thvEMVjHnfYGF0rmFCozFSxQBxwHKO" crossorigin="anonymous"></script>
</body>
</html>
