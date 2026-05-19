package com.example.timetrack; // Asegúrate de tener esta línea arriba

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    // Usamos 10.0.2.2 para que el emulador reconozca el localhost de tu PC
    private static final String URL = "jdbc:mysql://localhost:3306/Empresa?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "root";

    public static Connection conectar() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(URL, USER, PASS);
    }
}