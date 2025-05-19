<%-- 
    Document   : READCursos
    Created on : 18/05/2025, 11:07:27 a. m.
    Author     : Gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="NavBar.jsp"/>
        <div class="container mt-5">
            <div class="text-center mb-4">
                <h1 class="display-6">Cursos</h1>
                <form action="ControladorCursos" method="POST" class="d-inline">
                    <button type="submit" name="accion" value="Listar" class="btn btn-primary me-2">Listar</button>
                </form>
                <form action="ControladorCursos" method="POST" class="d-inline">
                    <button type="submit" name="accion" value="Nuevo" class="btn btn-success">Nuevo</button>
                </form>
            </div>

            <div class="table-responsive">
                <table class="table table-striped table-bordered table-hover text-center align-middle">
                    <thead class="table-dark">
                        <tr>
                            <th>Código</th>
                            <th>Curso</th>
                            <th>Créditos</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="datos" items="${datos}">
                            <tr>
                                <td>${datos.codigo}</td>
                                <td>${datos.curso}</td>
                                <td>${datos.creditos}</td>
                                <td>
                                    <form action="ControladorCursos" method="POST" class="d-grid gap-1">
                                        <input type="hidden" name="codigo" value="${datos.codigo}">
                                        <button type="submit" name="accion" value="Editar" class="btn btn-warning btn-sm">Editar</button>
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
