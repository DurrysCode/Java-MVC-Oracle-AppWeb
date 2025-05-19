/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.Estudiante;
import Modelo.EstudianteDAO;
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
public class ControladorEstudiantes extends HttpServlet {

    EstudianteDAO dao = new EstudianteDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String accion = request.getParameter("accion");
        switch (accion) {
            case "Listar":
                ArrayList<Estudiante> lista = dao.listar();
                request.setAttribute("datos", lista);
                request.getRequestDispatcher("READEstudiantes.jsp").forward(request, response);
                break;
            case "Nuevo":
                request.getRequestDispatcher("ADDEstudiante.jsp").forward(request, response);
                break;
            case "Guardar":
                String CarnetTxt = request.getParameter("carnet");
                int carnet = Integer.parseInt(CarnetTxt);
                String nombre = request.getParameter("nombre");
                String telefonoTxt = request.getParameter("telefono");
                int telefono = Integer.parseInt(telefonoTxt);
                String correo = request.getParameter("correo");
                String direccion = request.getParameter("direccion");
                Estudiante e = new Estudiante(nombre, correo, direccion, telefono, carnet);
                dao.añadirEstudiante(e);
                request.setAttribute("datos", dao.listar());
                request.getRequestDispatcher("READEstudiantes.jsp").forward(request, response);
                break;
            case "Editar":
                String car = request.getParameter("carnet");    
                int carn = Integer.parseInt(car);
                Estudiante est = dao.listarEstudiante(carn);
                request.setAttribute("est", est);
                request.getRequestDispatcher("EDITEstudiante.jsp").forward(request, response);
                break;
            case "Actualizar":
                String nombre1 = request.getParameter("nombre");
                String carnet1 = request.getParameter("ca");
                System.out.println(carnet1);
                int car1 = Integer.parseInt(carnet1);
                String telefono1 = request.getParameter("telefono");
                int tel1 = Integer.parseInt(telefono1);
                //System.out.println(car1 + " | " + tel1);
                String correo1 = request.getParameter("correo");
                String direccion1 = request.getParameter("direccion");
                //System.out.println(nombre1 + " | " + tel1 + " | " + correo1 + " | " + direccion1);
                String resultado = dao.actualizarEstudiante(nombre1, car1, tel1, correo1, direccion1);
                System.out.println(resultado); 
                request.getRequestDispatcher("ControladorEstudiantes?accion=Listar").forward(request, response);
                break;
            case "Eliminar":
                String car2 = request.getParameter("carnet");
                int carn2 = Integer.parseInt(car2);
                System.out.println(dao.eliminarEstudiante(carn2));
                ArrayList<Estudiante> lista2 = dao.listar();
                request.setAttribute("datos", lista2);
                request.getRequestDispatcher("READEstudiantes.jsp").forward(request, response);
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
