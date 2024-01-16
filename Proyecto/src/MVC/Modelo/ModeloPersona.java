package MVC.Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MAX COMPUTERS
 */
public class ModeloPersona extends Persona {

    Conexion cpg = new Conexion();

    public ModeloPersona() {
    }

    public List<Persona> listaPersona() {
        List<Persona> listaPersona = new ArrayList<Persona>();
        try {
            String sql = "select idpersona, nombres, apellidos, fechanacimineto, telefono, sexo, sueldo, cupo, foto FROM Persona ";
            ResultSet rs = cpg.consultaBD(sql);
            while (rs.next()) {
                Persona persona = new Persona();
                persona.setIdPersona(rs.getString("id"));
                persona.setNombrePersona(rs.getString("nombres"));
                persona.setApellidoPersona(rs.getString("apellidos"));
                persona.setTelefono(rs.getString("telefoono"));
                persona.setSexo(rs.getString("sexo"));
                persona.setSueldo(rs.getDouble("sueldo"));
                persona.setCupo(rs.getInt("cupo"));
                persona.setFoto(rs.getBytes("foto"));
                listaPersona.add(persona);
            }
            rs.close();
            return listaPersona;
        } catch (Exception e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public SQLException grabarPersona() {
        Date fechaNacimiento = getFechaNacimiento() ;

       
        java.sql.Date fechaSQL = new java.sql.Date(fechaNacimiento.getTime());
        String sql = "INSERT INTO persona (idpersona, nombres, apellidos, fechanacimiento, telefono, sexo, sueldo, cupo) ";
        sql += "VALUES ('" + getIdPersona() + "', '" + getNombrePersona() + "', '" + getApellidoPersona() + "',";
        sql += "'" +fechaSQL + "', '" + getTelefono() + "', '" + getSexo() + "', '";
        sql +=getSueldo() + "'," +getCupo() + ")";

        return cpg.accionBD2(sql);
    }
//    public boolean grabarPersona(Persona persona) {
//        Date fechaNacimiento = persona.getFechaNacimiento() ;
//
//       
//        java.sql.Date fechaSQL = new java.sql.Date(fechaNacimiento.getTime());
//        String sql = "INSERT INTO persona (idpersona, nombres, apellidos, fechanacimiento, telefono, sexo, sueldo, cupo) ";
//        sql += "VALUES ('" + persona.getIdPersona() + "', '" + persona.getNombrePersona() + "', '" + persona.getApellidoPersona() + "', ";
//        sql += "'" +fechaSQL + "', '" + persona.getTelefono() + "', '" + persona.getSexo() + "', ";
//        sql += persona.getSueldo() + ", " + persona.getCupo() + "')";
//
//        return cpg.accionBD(sql);
//    }

    private String getByteaLiteral(byte[] bytes) {
        if (bytes == null) {
            return "NULL";
        }

        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("\\x%02x", b));
        }
        return "E'" + sb.toString() + "'";
    }

    public ResultSet buscarPersona(String idPersona) {
        String sql = "SELECT * FROM Persona WHERE idpersona = '" + idPersona + "'";
        ResultSet resultado = cpg.consultaBD(sql);
        return resultado;
    }

    public boolean actualizarPersona(String idpersona, String nombre, String apellido, double sueldo, String telefono, Date fechaNacimiento, String genero, int cupo) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fechaNacimientoStr = sdf.format(fechaNacimiento);

        String sql = "UPDATE Persona SET nombres = '" + nombre + "', apellidos = '" + apellido + "', sueldo = " + sueldo + ",";
        sql += " telefono = '" + telefono + "', fechanacimiento = '" + fechaNacimientoStr + "', sexo = '" + genero + "', cupo = " + cupo + " WHERE idpersona = '" + idpersona + "'";

        return cpg.accionBD(sql);
    }

    public boolean eliminarPersona(String idPersona) {
        String sql = "DELETE FROM Persona WHERE idpersona = '" + idPersona + "'";

        return cpg.accionBD(sql);
    }

    public DefaultTableModel mostrarPersonas() {
        String sql = "SELECT * FROM Persona";
        ResultSet resultado = cpg.consultaBD(sql);

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Nombres");
        modelo.addColumn("Apellidos");
        modelo.addColumn("Fecha de Nacimiento");
        modelo.addColumn("Teléfono");
        modelo.addColumn("Sexo");
        modelo.addColumn("Sueldo");
        modelo.addColumn("Cupo");
        modelo.addColumn("Foto");

        try {
            while (resultado.next()) {
                Object[] fila = new Object[10];
                fila[0] = resultado.getString("idpersona");
                fila[1] = resultado.getString("nombres");
                fila[2] = resultado.getString("apellidos");
                fila[3] = resultado.getDate("fechanacimiento");
                fila[4] = resultado.getString("telefono");
                fila[5] = resultado.getString("sexo");
                fila[6] = resultado.getDouble("sueldo");
                fila[7] = resultado.getInt("cupo");
                fila[8] = resultado.getBytes("foto");

                modelo.addRow(fila);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return modelo;
    }

}
