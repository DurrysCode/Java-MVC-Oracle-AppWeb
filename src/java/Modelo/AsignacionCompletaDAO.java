/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author Gabriel
 */
public class AsignacionCompletaDAO {

    private Connection getConexion() {
        ConexionBDD conexion = new ConexionBDD();
        return conexion.conectar();
    }
    
    public void actualizarAsignacion(Asignacion asign){
        String consulta = "UPDATE asignaciones SET "
                + "codigo_curso=?, carnet=?, fecha=? WHERE asignacion=?";
        try {
            Connection con = getConexion();
            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setInt(1, asign.getCodigoCurso());
            ps.setInt(2, asign.getCodigoCarnet());
            ps.setDate(3, asign.getFecha());
            ps.setInt(4, asign.getCodigoAsignacion());
            
            int resultado = ps.executeUpdate();
            System.out.println("actualizarAsignacion: " + resultado);
        } catch (SQLException e) {
            System.out.println("Error en actualizarAsignacion() DAO " + e.toString());
        }
    }
    
    public Asignacion buscarAsignacion(int asignacion){
        String consulta = "SELECT * FROM asignaciones WHERE asignacion = ?";
        Asignacion asign;
        try {
            Connection con = getConexion();
            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setInt(1, asignacion);
            
            ResultSet rs = ps.executeQuery();
            rs.next();
            asign = new Asignacion(rs.getInt("asignacion"), rs.getInt("codigo_curso"), rs.getInt("carnet"), rs.getDate("fecha"));
        } catch (SQLException e) {
            System.out.println("Error en buscarAsignacion() DAO " + e.toString());
            return null;
        }
        return asign;
    }
    
    public void actualizarNotaPorAsignacion(Nota n){
        String consulta = "UPDATE notas SET "
                + "primer_parcial=?, segundo_parcial=?, actividades=?, examen_final=?, examen_recuperacion=? "
                + "WHERE asignacion=?";
        try {
            Connection con = getConexion();
            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setInt(1, n.getPrimerParcial());
            ps.setInt(2, n.getSegundoParcial());
            ps.setInt(3, n.getActividades());
            ps.setInt(4, n.getExamenFinal());
            ps.setInt(5, n.getExamenRecuperacion());
            ps.setInt(6, n.getAsignacion());
            
            int resultado = ps.executeUpdate();
            System.out.println("actualizarNotaPorAsignacion: " + resultado);
            
        } catch (SQLException e) {
            System.out.println("Error en actualizarNotaPorAsignacion() DAO " + e.toString());
        }
    }

    public void eliminarAsignacion(int asignacion) {
        String consulta = "DELETE asignaciones WHERE asignacion=?";
        try {
            Connection con = getConexion();
            PreparedStatement ps = con.prepareStatement(consulta);
            ps.setInt(1, asignacion);
            int resultado = ps.executeUpdate();
            System.out.println("eliminarAsignacion: " + resultado);
        } catch (SQLException e) {
            System.out.println("Error en eliminarAsignacion() DAO " + e.toString());
        }
    }

    public void eliminarNotaPorAsignacion(int asignacion) {
        String consulta = "DELETE notas WHERE asignacion=?";
        try {
            Connection con = getConexion();
            PreparedStatement ps = con.prepareStatement(consulta);
            ps.setInt(1, asignacion);
            int resultado = ps.executeUpdate();
            System.out.println("eliminarNotaporAsignacion: " + resultado);
        } catch (SQLException e) {
            System.out.println("Error en eliminarNotaporAsignacion() DAO " + e.toString());
        }
    }

    public void añadirNotasPorAsignacion(int codigoAsignacion) {
        String consulta = "INSERT INTO "
                + "notas(asignacion, primer_parcial, segundo_parcial, actividades, examen_final, examen_recuperacion)"
                + " VALUES(?,0,0,0,0,0)";
        try {
            Connection con = getConexion();
            PreparedStatement ps = con.prepareStatement(consulta);
            ps.setInt(1, codigoAsignacion);
            int resultado = ps.executeUpdate();
            System.out.println("añadirNotasPorAsignacion: " + resultado);
        } catch (SQLException e) {
            System.out.println("Error en añadirNotasPorAsignacion() DAO " + e.toString());
        }
    }

    public void añadirAsignacion(Asignacion asignacion) {
        String consulta = "INSERT INTO "
                + "asignaciones(asignacion, codigo_curso, carnet, fecha) VALUES(?,?,?,?)";
        try {
            Connection con = getConexion();
            PreparedStatement ps = con.prepareStatement(consulta);
            ps.setInt(1, asignacion.getCodigoAsignacion());
            ps.setInt(2, asignacion.getCodigoCurso());
            ps.setInt(3, asignacion.getCodigoCarnet());
            ps.setDate(4, asignacion.getFecha());
            int resultado = ps.executeUpdate();
            System.out.println("AñadirAsignacion: " + resultado);
        } catch (SQLException e) {
            System.out.println("Error en añadirAsignacion() DAO " + e.toString());
        }
    }

    public ArrayList<AsignacionCompleta> listar() {
        ArrayList<AsignacionCompleta> lista = new ArrayList<>();
        String consulta = "SELECT a.asignacion, a.codigo_curso, a.carnet, a.fecha, "
                + "n.primer_parcial, n.segundo_parcial, n.actividades, n.examen_final, n.examen_recuperacion "
                + "FROM asignaciones a JOIN notas n ON a.asignacion = n.asignacion";

        try {
            Connection con = getConexion();
            PreparedStatement ps = con.prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
           
            
            while (rs.next()) {
                // DATOS DE ASIGNACIONES
                int codigoAsignacion = rs.getInt("asignacion");
                System.out.println("1");
                int codigoCurso = rs.getInt("codigo_curso");
                System.out.println("2");
                int codigoCarnet = rs.getInt("carnet");
                System.out.println("3");
                Date fecha = rs.getDate("fecha");
                System.out.println("4");
                Asignacion asignacion = new Asignacion(codigoAsignacion, codigoCurso, codigoCarnet, fecha);

                // DATOS DE NOTAS
                int primerParcial = rs.getInt("primer_parcial");
                System.out.println("5");
                int segundoParcial = rs.getInt("segundo_parcial");
                System.out.println("6");
                int actividades = rs.getInt("actividades");
                System.out.println("7");
                int examenFinal = rs.getInt("examen_final");
                System.out.println("8");
                int examenRecuperacion = rs.getInt("examen_recuperacion");
                System.out.println("9");
                Nota nota = new Nota(codigoAsignacion, primerParcial, segundoParcial, actividades, examenFinal, examenRecuperacion);

                // CALCULO DE NOTA TOTAL Y RECUPERACION
                int notaTotal = nota.calcularNotaTotal();
                boolean recuperacion = nota.necesitaRecuperacion();

                // COMPOSICIÓN FINAL
                AsignacionCompleta asignacionCompleta = new AsignacionCompleta(asignacion, nota, notaTotal, recuperacion);

                // AÑADIR A LA LISTA
                lista.add(asignacionCompleta);
            }
        } catch (SQLException e) {
            System.out.println("Error en listar() DAO" + e.toString());
        }
        return lista;
    }
}
