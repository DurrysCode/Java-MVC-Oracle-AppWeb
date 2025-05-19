/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.UsuarioDAO;
import Modelo.Usuario;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 *
 * @author Gabriel
 */
public class ControladorUsuarios extends HttpServlet {

    UsuarioDAO dao = new UsuarioDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //LOGICA
        String accion = request.getParameter("accion");
        switch (accion) {
            case "Listar":
                ArrayList<Usuario> datos = dao.listar();
                System.out.println();
                request.setAttribute("datos", datos);
                request.getRequestDispatcher("READUsuarios.jsp").forward(request, response);
                break;
            case "Nuevo":
                request.getRequestDispatcher("ADDUsuario.jsp").forward(request, response);
                break;
            case "Guardar":
                UsuarioDAO modelo = new UsuarioDAO();
                String user = request.getParameter("usuario");
                String pass = request.getParameter("contraseña");
                modelo.agregarUsuario(user, pass);
                request.setAttribute("listado", modelo.listar());
                request.getRequestDispatcher("READUsuarios.jsp").forward(request, response);
                break;
            case "Editar":
                String usuario = request.getParameter("usuario");
                Usuario us = dao.listarUsuario(usuario);
                //System.out.println(us.getUsuario() + " | " + us.getPassword());
                request.setAttribute("usuario", us);
                //System.out.println("Usuario enviado a la vista");
                request.getRequestDispatcher("EDITUsuario.jsp").forward(request, response);
                break;
            case "Actualizar":
                String usuario1 = request.getParameter("usuario");
                String contraseña1 = request.getParameter("contraseña");
                Usuario usu = new Usuario(usuario1, contraseña1);
                dao.actualizar(usu);
                request.getRequestDispatcher("ControladorUsuarios?accion=Listar").forward(request, response);
                break;
            case "Eliminar":
                String usuario2 = request.getParameter("usuario");
                dao.eliminar(usuario2);
                request.getRequestDispatcher("ControladorUsuarios?accion=Listar").forward(request, response);
                break;
            default:
                throw new AssertionError();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
