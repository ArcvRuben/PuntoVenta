
package MVC.Modelo;

import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.*;

/**
 *
 * @author MAX COMPUTERS
 */
public class Conexion {
String cadenaConexion = "jdbc:postgresql://localhost:5432/Personas";
    String pgUsuario = "postgres";
    String pgPassword = "12345";
    java.sql.Connection con;
   
    public Conexion() {
        
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        }
        
        try {
            con = DriverManager.getConnection(cadenaConexion, pgUsuario, pgPassword);
            System.out.println("Conexion Correcta");
        } catch (SQLException e) {

            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public ResultSet consultaBD(String sql) {
        try {
            Statement st = con.createStatement();
            return st.executeQuery(sql);
        } catch (Exception e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    
    public boolean accionBD(String sql) {
        try {
            Statement st = con.createStatement();
            st.executeUpdate(sql);
            st.close();
            return true;
        } catch (Exception e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }

    public Connection getCon() {
        return con;
    }
    
    
    public SQLException accionBD2(String sql) {
        try {
            // Crear un Statement y ejecutar la acción
            Statement st = con.createStatement();
            st.execute(sql);  // True si devuelve objeto y False sino se hizo
            st.close();       // Cerrar el Statement
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return ex;
        }
    }
}
