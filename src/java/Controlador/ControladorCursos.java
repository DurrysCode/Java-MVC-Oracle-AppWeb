/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.CursoDAO;
import java.io.IOException;
import Modelo.Curso;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 *
 * @author Gabriel
 */
public class ControladorCursos extends HttpServlet {

    CursoDAO dao = new CursoDAO();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String accion = request.getParameter("accion");
        
        switch (accion) {
            case "Listar":
                ArrayList<Curso> listaCursos = dao.listar();
                request.setAttribute("datos", listaCursos);
                request.getRequestDispatcher("READCursos.jsp").forward(request, response);
                break;
            case "Nuevo":
                request.getRequestDispatcher("ADDCurso.jsp").forward(request, response);
                break;
            case "Guardar":
                String codigoTxt = request.getParameter("codigo");
                int codigo = Integer.parseInt(codigoTxt);
                String curso = request.getParameter("curso");
                String creditosTxt = request.getParameter("creditos");
                int creditos = Integer.parseInt(creditosTxt);
                Curso c = new Curso(codigo, creditos, curso);
                dao.añadirCurso(c);
                request.getRequestDispatcher("READCursos.jsp").forward(request, response);
                break;
            case "Editar":
                String codigoTxt1 = request.getParameter("codigo");
                int codigo1 = Integer.parseInt(codigoTxt1);
                Curso c1 = dao.listarCursoPorCodigo(codigo1);
                request.setAttribute("datos", c1);
                request.getRequestDispatcher("EDITCurso.jsp").forward(request, response);
                break;
            case "Actualizar":
                Curso c2 = new Curso();
                String codigoTxt2 = request.getParameter("codigo");
                int codigo2 = Integer.parseInt(codigoTxt2);
                c2.setCodigo(codigo2);
                c2.setCurso(request.getParameter("curso"));
                String creditosTxt2 = request.getParameter("creditos");
                int creditos2 = Integer.parseInt(creditosTxt2);
                c2.setCreditos(creditos2);
                dao.actualizarCurso(c2);
                request.getRequestDispatcher("ControladorCursos?accion=Listar").forward(request, response);
                break;
            case "Eliminar":
                String codigoTxt3 = request.getParameter("codigo");
                int codigo3 = Integer.parseInt(codigoTxt3);
                dao.eliminarCurso(codigo3);
                request.getRequestDispatcher("ControladorCursos?accion=Listar").forward(request, response);
                break;
            default:
                throw new AssertionError();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
