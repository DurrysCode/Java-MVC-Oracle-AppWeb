/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriel
 */
public class EstudianteDAO {

    private Connection getConnection() {
        ConexionBDD conexion = new ConexionBDD();
        return conexion.conectar();
    }

    public ArrayList<Estudiante> listar() {
        ArrayList<Estudiante> listaEstudiantes = new ArrayList<>();
        String consulta = "SELECT * FROM estudiantes";

        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(consulta);
            ResultSet rs = ps.executeQuery(consulta);

            while (rs.next()) {
                Estudiante e = new Estudiante();
                e.setNombre(rs.getString("nombre_completo"));
                e.setCarnet(rs.getInt("carnet"));
                e.setTelefono(rs.getInt("telefono"));
                e.setCorreo(rs.getString("correo_electronico"));
                e.setDireccion(rs.getString("direccion"));
                listaEstudiantes.add(e);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaEstudiantes;
    }

    public void añadirEstudiante(Estudiante est) {
        String consulta = "INSERT INTO estudiantes "
                + "(carnet, nombre_completo, telefono, correo_electronico, direccion) VALUES (?,?,?,?,?)";
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(consulta);
            ps.setInt(1, est.getCarnet());
            ps.setString(2, est.getNombre());
            ps.setInt(3, est.getTelefono());
            ps.setString(4, est.getCorreo());
            ps.setString(5, est.getDireccion());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al añadir un usuario: " + e.toString());
        }
    }

    public Estudiante listarEstudiante(int carnet) {
        String consulta = "SELECT * FROM estudiantes WHERE carnet = ?";
        Estudiante est = new Estudiante();

        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(consulta);
            ps.setInt(1, carnet);
            ResultSet rs = ps.executeQuery();
            rs.next();
            est.setNombre(rs.getString("nombre_completo"));
            est.setCorreo(rs.getString("correo_electronico"));
            est.setDireccion(rs.getString("direccion"));
            est.setTelefono(Integer.parseInt(rs.getString("telefono")));
            est.setCarnet(Integer.parseInt(rs.getString("carnet")));

            System.out.println(est.toString());
        } catch (SQLException e) {
            System.out.println("Error en listarEstudiante EstudianteDAO" + e.toString());
        }
        return est;
    }

    public String actualizarEstudiante(String nombre, int carnet, int telefono, String correo, String direccion) {
        String consulta = "UPDATE estudiantes SET "
                + "nombre_completo=?, carnet=?, telefono=?, "
                + "correo_electronico=?, direccion=? WHERE carnet=?";
        try{
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(consulta);
            ps.setString(1, nombre);
            ps.setInt(2, carnet);
            ps.setInt(3, telefono);
            ps.setString(4, correo);
            ps.setString(5, direccion);
            ps.setInt(6, carnet);
            ps.executeUpdate();
            return "Estudiante actualizado";
        }catch(SQLException e){
            return "Error en actualizarEstudiante EstudianteDAO" + e.toString();
        }
    }

    public String eliminarEstudiante(int carnet) {
        String consulta = "DELETE FROM estudiantes WHERE carnet = ?";
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(consulta);
            ps.setInt(1, carnet);
            ps.executeUpdate();
            return "Estudiante eliminado exitosamente (EstudianteDAO linea: 98)";
        } catch (SQLException e) {
            return "Error en EstudianteDAO " + e.toString();
        }
    }
}
