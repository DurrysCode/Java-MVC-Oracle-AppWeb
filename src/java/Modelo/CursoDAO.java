/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Gabriel
 */
public class CursoDAO {
    
    public Connection getConexion(){
        ConexionBDD conexion = new ConexionBDD();
        return conexion.conectar();
    }
    
    public void eliminarCurso(int codigo){
        String consulta = "DELETE cursos WHERE codigo_curso=?";
        try{
            Connection con = getConexion();
            PreparedStatement ps = con.prepareStatement(consulta);
            ps.setInt(1, codigo);
            int resultado = ps.executeUpdate();
            System.out.println("eliminarCurso: " + resultado);
        }catch(SQLException e){
            System.out.println("Error en eliminarCurso " + e.toString());
        }
    }
    
    public void actualizarCurso(Curso cur){
        String consulta = "UPDATE cursos SET nombre_curso=?, creditos=? WHERE codigo_curso=?";
        try{
            Connection con = getConexion();
            PreparedStatement ps = con.prepareStatement(consulta);
            ps.setString(1, cur.getCurso());
            ps.setInt(2, cur.getCreditos());
            ps.setInt(3, cur.getCodigo());
            int resultado = ps.executeUpdate();
            System.out.println("ActualizarCurso: " + resultado);
        }catch(SQLException e){
            System.out.println("Error en actualizarCurso() DAO " + e.toString());
        }
    }
    
    public Curso listarCursoPorCodigo(int codigo){
        String consulta = "SELECT * FROM cursos WHERE codigo_curso = ?";
        Curso cur = new Curso();
        try{
            Connection con = getConexion();
            PreparedStatement ps = con.prepareStatement(consulta);
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            rs.next();
            int cod = rs.getInt("codigo_curso");
            String curso = rs.getString("nombre_curso");
            int cre = rs.getInt("creditos");
            cur = new Curso(cod, cre, curso);
        }catch(SQLException e){
            System.out.println("Error en listarCursoPorCodigo() " + e.toString());   
        }
        return cur;
    }
    
    public void añadirCurso(Curso c){
        String consulta = "INSERT INTO cursos(codigo_curso, nombre_curso, creditos)"
                + "VALUES(?,?,?)";
        try{
            Connection con = getConexion();
            PreparedStatement ps = con.prepareStatement(consulta);
            ps.setInt(1, c.getCodigo());
            ps.setString(2, c.getCurso());
            ps.setInt(3, c.getCreditos());
            int resultado =  ps.executeUpdate();
            System.out.println("añadirCurso: " + resultado);
        }catch(SQLException e){
            System.out.println("Error en añadirCurso DAO " + e.toString());
        }
    }
    
    public ArrayList<Curso> listar(){
        ArrayList<Curso> listadoCursos = new ArrayList<>();
        String consulta = "SELECT * FROM cursos";
        try{
            Connection con = getConexion();
            PreparedStatement ps = con.prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int codigo = rs.getInt("codigo_curso");
                String nombre = rs.getString("nombre_curso");
                int creditos = rs.getInt("creditos");
                Curso curso = new Curso(codigo, creditos, nombre);
                listadoCursos.add(curso);
            }
        } catch(SQLException e){
            System.out.println("Error en listar cursos " + e.toString());
        }
        return listadoCursos;
    }
}
