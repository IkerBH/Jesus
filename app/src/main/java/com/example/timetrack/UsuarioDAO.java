package com.example.timetrack;

import java.sql.*;

public class UsuarioDAO {
    public boolean login(String dni, String password) {
        try {
            Connection conn = Conexion.conectar();
            String sql = "SELECT * FROM Usuarios WHERE DNI = ? AND Contraseña = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, dni);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            boolean existe = rs.next(); // Si hay resultado, el login es correcto
            conn.close(); // Es buena práctica cerrar la conexión
            return existe;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}