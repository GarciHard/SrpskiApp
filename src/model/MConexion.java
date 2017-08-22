package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Hecho con <3 por:
 * @author Alexis (GarciHard)
 */
public class MConexion {
    protected Connection conexion;
    private final String driverJDBC = "oracle.jdbc.driver.OracleDriver";
    private final String urlDB = "jdbc:oracle:thin:@localhost:1521:xe";
    private final String userDB = "srpskifilms";
    private final String pwdDB = "serbian";
    
    public void conectar() throws Exception{
        try {
            conexion = DriverManager.getConnection(urlDB,userDB,pwdDB);
            Class.forName(driverJDBC);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }
    
    public void cerrar() throws Exception {
        try {
            if (conexion != null) {
                if (!conexion.isClosed()) {
                    conexion.close();
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}