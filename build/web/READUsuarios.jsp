<%-- 
    Document   : READUsuarios
    Created on : 13/05/2025, 6:36:33 p. m.
    Author     : Gabriel
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
        <title>Usuarios</title>
    </head>
    <body>
        <jsp:include page="NavBar.jsp"/>
        <div class="container mt-5">
            <div class="text-center mb-4">
                <h1 class="display-6">Usuarios</h1>
                <form action="ControladorUsuarios" method="POST" class="d-inline">
                    <button type="submit" name="accion" value="Listar" class="btn btn-primary me-2">Listar</button>
                </form>
                <form action="ControladorUsuarios" method="POST" class="d-inline">
                    <button type="submit" name="accion" value="Nuevo" class="btn btn-success">Nuevo</button>
                </form>
            </div>

            <div class="table-responsive">
                <table class="table table-striped table-bordered table-hover text-center align-middle">
                    <thead class="table-dark">
                        <tr>
                            <th>Usuario</th>
                            <th>Contraseña</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="datos" items="${datos}">
                            <tr>
                                <td>${datos.usuario}</td>
                                <td>${datos.password}</td>
                                <td>
                                    <form action="ControladorUsuarios" method="POST" class="d-grid gap-1">
                                        <input type="hidden" name="usuario" value="${datos.usuario}">
                                        <button type="submit" name="accion" value="Editar" class="btn btn-light">Editar</button>
                                        <button type="submit" name="accion" value="Eliminar" class="btn btn-danger btn-sm">Eliminar</button>
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
