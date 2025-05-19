package Modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDAO {

    private Connection getConnection() {
        ConexionBDD conexion = new ConexionBDD();
        return conexion.conectar();
    }

    public ArrayList<Usuario> listar() {
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        String consulta = "SELECT * FROM usuarios";

        try (Connection con = getConnection(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(consulta)) {

            while (rs.next()) {
                Usuario u = new Usuario(rs.getString("usuario"), rs.getString("contraseña"));
                listaUsuarios.add(u);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaUsuarios;
    }

    public boolean validarUsuario(String usuario, String password) {
        String consulta = "SELECT * FROM usuarios WHERE usuario = ? AND contraseña = ?";

        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(consulta)) {

            ps.setString(1, usuario);
            ps.setString(2, password);  

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next(); // devuelve true si encuentra el usuario
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public void agregarUsuario(String usuario, String password) {
        String consulta = "INSERT INTO usuarios (usuario, contraseña) VALUES (?, ?)";

        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(consulta)) {

            ps.setString(1, usuario);
            ps.setString(2, password);
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Usuario listarUsuario(String usuario) {
        String consulta = "select * from usuarios where usuario = ?";
        Usuario u = new Usuario();
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(consulta);
            ps.setString(1, usuario);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                u.setUsuario(rs.getString("usuario"));
                u.setPassword(rs.getString("contraseña"));
            }
        } catch (SQLException e) {
            System.out.println("Error en listarUsuario: " + e.toString());
        }
        return u;
    }

    public int actualizar(Usuario u) {
        int r = 0;
        System.out.println(u.getUsuario() + " | " + u.getPassword());
        String consulta = "UPDATE usuarios SET usuario=?, contraseña=? WHERE usuario=?";
        try{
            Connection con = getConnection(); 
            PreparedStatement ps = con.prepareStatement(consulta);
            ps.setString(1, u.getUsuario());   
            ps.setString(2, u.getPassword());  
            ps.setString(3, u.getUsuario());   

            r = ps.executeUpdate();
            System.out.println("Valor de r: " + r);
        } catch (SQLException e) {
            System.out.println("Error al actualizar: " + e.toString());
        }
        return r;
    }
    
    public void eliminar(String usuario){
        String consulta = "DELETE from usuarios where usuario = ?";
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(consulta);
            ps.setString(1, usuario);
            int r =ps.executeUpdate();
            System.out.println(r);
        } catch (SQLException e) {
            System.out.println("Error en eliminar usuarioDAO: " + e.toString());
        }
    }
}
