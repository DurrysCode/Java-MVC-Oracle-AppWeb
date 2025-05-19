/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.Asignacion;
import Modelo.AsignacionCompleta;
import Modelo.AsignacionCompletaDAO;
import Modelo.Nota;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.util.ArrayList;


/**
 *
 * @author Gabriel
 */
public class ControladorAsignaciones extends HttpServlet {

    AsignacionCompletaDAO dao = new AsignacionCompletaDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String accion = request.getParameter("accion");

        switch (accion) {
            case "Listar":
                ArrayList<AsignacionCompleta> listaDeAsignaciones = dao.listar();
                request.setAttribute("datos", listaDeAsignaciones);
                request.getRequestDispatcher("READAsignaciones.jsp").forward(request, response);
                break;
            case "Nuevo":
                request.getRequestDispatcher("ADDAsignacion.jsp").forward(request, response);
                break;
            case "Guardar":
                String asignacionTxt = request.getParameter("asignacion");
                int asignacion = Integer.parseInt(asignacionTxt);
                String cursoTxt = request.getParameter("curso");
                int curso = Integer.parseInt(cursoTxt);
                String carnetTxt = request.getParameter("carnet");
                int carnet = Integer.parseInt(carnetTxt);

                String fechaTxt = request.getParameter("fecha");
                System.out.println(fechaTxt);

                //FUNCIONES PARA CONVRTIR String A Date
                LocalDate localDate = LocalDate.parse(fechaTxt);  // usa formato ISO_LOCAL_DATE por defecto
                java.sql.Date fecha = java.sql.Date.valueOf(localDate);

                Asignacion asign = new Asignacion(asignacion, curso, carnet, fecha);
                dao.añadirAsignacion(asign);
                dao.añadirNotasPorAsignacion(asign.getCodigoAsignacion());
                request.getRequestDispatcher("ControladorAsignaciones?accion=Listar").forward(request, response);
                break;
            case "Agregar Nota":
                String asignacionTxt1 = request.getParameter("asignacion");
                int asignacion1 = Integer.parseInt(asignacionTxt1);
                int primerParcial = Integer.parseInt(request.getParameter("parcial1"));
                int segundoParcial = Integer.parseInt(request.getParameter("parcial2"));
                int actividades = Integer.parseInt(request.getParameter("actividades"));
                int examenFinal = Integer.parseInt(request.getParameter("examenFinal"));
                int examenRecuperacion = Integer.parseInt(request.getParameter("examenRecuperacion"));
                
                String recuperacionTxt = request.getParameter("recuperacion");
                boolean recuperacion = Boolean.parseBoolean(recuperacionTxt);
                Nota nota1 = new Nota(asignacion1, primerParcial, segundoParcial, actividades, examenFinal, examenRecuperacion);
                request.setAttribute("recuperacion", recuperacion);
                request.setAttribute("datos", nota1);
                request.getRequestDispatcher("ADDNotas.jsp").forward(request, response);
                break;
            case "Guardar Nota":
                int asignacion2 = Integer.parseInt(request.getParameter("asignacion"));
                int primerParcial2 = Integer.parseInt(request.getParameter("parcial1"));
                int segundoParcial2 = Integer.parseInt(request.getParameter("parcial2"));
                int actividades2 = Integer.parseInt(request.getParameter("actividades"));
                int examenFinal2 = Integer.parseInt(request.getParameter("examenFinal"));
                String examenRecuperacionTxt2 = request.getParameter("examenRecuperacion");
                int examenRecuperacion2;
                if( examenRecuperacionTxt2 == null){
                    examenRecuperacion2 = 0;
                } else{
                    examenRecuperacion2 = Integer.parseInt(examenRecuperacionTxt2);
                }
                Nota nota2 = new Nota(asignacion2, primerParcial2, segundoParcial2, actividades2, examenFinal2, examenRecuperacion2);
                dao.actualizarNotaPorAsignacion(nota2);
                request.getRequestDispatcher("ControladorAsignaciones?accion=Listar").forward(request, response);
                break;
            case "Editar":
                int asignacion3 = Integer.parseInt(request.getParameter("asignacion"));
                Asignacion asign3 = dao.buscarAsignacion(asignacion3);
                request.setAttribute("datos", asign3);
                request.getRequestDispatcher("EDITAsignacion.jsp").forward(request, response);
                break;
            case "Actualizar":
                String asignacionTxt4 = request.getParameter("asignacion");
                int asignacion4 = Integer.parseInt(asignacionTxt4);
                String cursoTxt4 = request.getParameter("curso");
                int curso4 = Integer.parseInt(cursoTxt4);
                String carnetTxt4 = request.getParameter("carnet");
                int carnet4 = Integer.parseInt(carnetTxt4);

                String fechaTxt4 = request.getParameter("fecha");
                System.out.println(fechaTxt4);

                //FUNCIONES PARA CONVRTIR String A Date
                LocalDate localDate4 = LocalDate.parse(fechaTxt4);  // usa formato ISO_LOCAL_DATE por defecto
                java.sql.Date fecha4 = java.sql.Date.valueOf(localDate4);

                Asignacion asign4 = new Asignacion(asignacion4, curso4, carnet4, fecha4);
                dao.actualizarAsignacion(asign4);
                request.getRequestDispatcher("ControladorAsignaciones?accion=Listar").forward(request, response);
                break;
            case "Eliminar":
                String asignacionTxt5 = request.getParameter("asignacion");
                int asignacion5 = Integer.parseInt(asignacionTxt5);
                dao.eliminarNotaPorAsignacion(asignacion5);
                dao.eliminarAsignacion(asignacion5);
                request.getRequestDispatcher("ControladorAsignaciones?accion=Listar").forward(request, response);
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
