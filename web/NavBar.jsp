<%-- 
    Document   : NavBar
    Created on : 17/05/2025, 10:54:06 a. m.
    Author     : Gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%-- NavBar.jsp --%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark shadow">
    <div class="container-fluid">
        <a class="navbar-brand fw-bold" href="#">Proyecto #2 Estructura de Datos</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarContent"
            aria-controls="navbarContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarContent">
            <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link text-danger" href="index.html">
                        <i class="bi bi-box-arrow-right"></i> Logout
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="READUsuarios.jsp">
                        <i class="bi bi-person-badge"></i> Usuarios
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="READEstudiantes.jsp">
                        <i class="bi bi-mortarboard"></i> Estudiantes
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="READCursos.jsp">
                        <i class="bi bi-book"></i> Cursos
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="READAsignaciones.jsp">
                        <i class="bi bi-journal-check"></i> Asignaciones
                    </a>
                </li>
            </ul>
        </div>
    </div>
</nav>

