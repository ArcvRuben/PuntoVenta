package MVC.Controlador;

import MVC.Modelo.*;
import MVC.Vista.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author MAX COMPUTERS
 */
public class ControladorPersonas {

    private ModeloPersona modelo;
    private VistaPersona vista;

    public ControladorPersonas(ModeloPersona modelo, VistaPersona vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciaControl() {
        vista.getTablaPersonas().setDefaultEditor(Object.class, null);
        // NAVEGAR ENTRE INTERFACES
        vista.setVisible(true);
        vista.getBtRegresar().addActionListener(l -> vista.setVisible(true));
        vista.getBtRegresar().addActionListener(l -> vista.dispose());

        vista.getBtGuardar().addActionListener(l -> datosPersona());
        vista.getBtnCrear().addActionListener(l -> vista.getjDialog1().setVisible(true));
        vista.getBtBuscar().setEnabled(false);
        vista.getTxtBuscarCedula().setEnabled(false);
        vista.getTbActualizar().addActionListener(l -> vista.getBtBuscar().setEnabled(true));
        vista.getTbActualizar().addActionListener(l -> vista.getTxtBuscarCedula().setEnabled(true));
        vista.getBtnimprimir().addActionListener(l -> imprimirpersona());

        // FUNCIONALIDAD DE BOTONES
        vista.getBtnBuscar1().addActionListener(l -> {
            String idPersona = vista.getTxtBuscar().getText();
            ResultSet persona = modelo.buscarPersona(idPersona);
            try {
                if (persona.next()) {
                    buscarPersona(idPersona);
                } else {
                    JOptionPane.showMessageDialog(null, "Persona no encontrada");
                }
            } catch (SQLException ex) {
                Logger.getLogger(ControladorPersonas.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        vista.getBtnEliminar().addActionListener(l -> {
            int filaSeleccionada = vista.getTablaPersonas().getSelectedRow();

            if (filaSeleccionada == -1) {
                JOptionPane.showMessageDialog(null, "Por favor, selecciona una fila para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String idPersona = vista.getTablaPersonas().getValueAt(filaSeleccionada, 0).toString();

            int confirmacion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas eliminar a esta persona?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
            if (confirmacion == JOptionPane.YES_OPTION) {
                ResultSet persona = modelo.buscarPersona(idPersona);
                try {
                    if (persona.next()) {
                        modelo.eliminarPersona(idPersona);
                        JOptionPane.showMessageDialog(null, "Persona eliminada con éxito");
                    } else {
                        JOptionPane.showMessageDialog(null, "Persona no encontrada (No se ha podido eliminar)");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(ControladorPersonas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        JButton btMostrar = vista.getBtMostrar();
        btMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarPersonas();
            }
        });
        vista.getBtBuscar().addActionListener(l -> vista.getTxtCedula().setEditable(false));
        vista.getjDialog1().setSize(800, 360);
        vista.getjDialog1().setLocationRelativeTo(null);
        llamarActualizar();
    }

    public void imprimirpersona() {
        try {
            URL resourceURL = getClass().getClassLoader().getResource("/Reportes/Reportecliente.jasper");
            System.out.println("URL del recurso: " + resourceURL);
            
            

            JasperReport reporte = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/ReportePersonas.jasper"));
            
            Conexion con = new Conexion();
            Map<String,Object> parametros=new HashMap<String,Object>();
            
            parametros.put("titulo","Listado de Clientes");
            //Hay que sacar parametros seleccionando de un combo o text
            //Hacemos un Casteo
            parametros.put("cupo", 100d);
            JasperPrint jp = JasperFillManager.fillReport(reporte, parametros, con.getCon());

            JasperViewer Jv = new JasperViewer(jp, false);
            Jv.setVisible(true);

        } catch (JRException ex) {
            Logger.getLogger(ControladorPersonas.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public void datosPersona() {
        try {
            String idpersona = vista.getTxtCedula().getText();
            String nombres = vista.getTxtNombre().getText();
            String apellidos = vista.getTxtApellido().getText();
            Date fechanacimiento = vista.getcFecha().getDate();
            String telefono = vista.getTxtTelefono().getText();
            String sexo = generoPersona();
            double sueldo = Double.parseDouble(vista.getTxtSueldo().getText());
            int cupo = Integer.parseInt(vista.getSpCupo().getValue().toString());
            java.sql.Date sqlDate = new java.sql.Date(fechanacimiento.getTime());
            ModeloPersona p1 = new ModeloPersona();

            p1.setIdPersona(idpersona);
            p1.setNombrePersona(nombres);
            p1.setApellidoPersona(apellidos);
            p1.setFechaNacimiento(sqlDate);
            p1.setTelefono(telefono);
            p1.setSexo(sexo);
            p1.setSueldo(sueldo);
            p1.setCupo(cupo);

            if (p1.grabarPersona() == null) {
                JOptionPane.showMessageDialog(null, "Datos Guardados con éxito");
            } else {
                JOptionPane.showMessageDialog(null, "Datos no guardados, revise que todos los campos estén llenos correctamente");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingrese un valor numérico válido para Sueldo");
            e.printStackTrace();
        }
    }

    public long calcularEdad() {
        Date fecha = vista.getcFecha().getDate();
        LocalDate diaseleccionado2 = fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate hoy2 = LocalDate.now();
        long añosT = ChronoUnit.YEARS.between(diaseleccionado2, hoy2);
        return añosT;
    }

    public String generoPersona() {
        String genero = "";
        if (vista.getGeneroM().isSelected()) {
            genero = "Masculino";
        } else if (vista.getGeneroF().isSelected()) {
            genero = "Femenino";
        }
        return genero;
    }

    public void buscarPersona(String idPersona) {
        ResultSet resultado = modelo.buscarPersona(idPersona);

        if (resultado != null) {
            try {
                DefaultTableModel model = (DefaultTableModel) vista.getTablaPersonas().getModel();
                model.setRowCount(0);

                while (resultado.next()) {
                    String id = resultado.getString("idpersona");
                    String nombres = resultado.getString("nombres");
                    String apellidos = resultado.getString("apellidos");
                    String fech = resultado.getString("fechanacimiento");
                    String telefono = resultado.getString("telefono");
                    String sexo = resultado.getString("sexo");
                    String sueldo = resultado.getString("sueldo");
                    String cupo = resultado.getString("cupo");
                    String foto = resultado.getString("foto");

                    // Agregar los datos a la tabla
                    model.addRow(new Object[]{id, nombres, apellidos, fech, telefono, sexo, sueldo, cupo, foto});
                }
            } catch (SQLException ex) {
                Logger.getLogger(ControladorPersonas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void mostrarPersonas() {
        JTable tablaPersonas = vista.getTablaPersonas();
        DefaultTableModel modeloTabla = modelo.mostrarPersonas();
        tablaPersonas.setModel(modeloTabla);
    }

    public void llamarActualizar() {
        vista.getBtBuscar().addActionListener(e -> {
            String cedula = vista.getTxtBuscarCedula().getText();
            ResultSet persona = modelo.buscarPersona(cedula);

            try {
                if (persona.next()) {
                    vista.getTxtCedula().setText(persona.getString("idpersona"));
                    vista.getTxtNombre().setText(persona.getString("nombres"));
                    vista.getTxtApellido().setText(persona.getString("apellidos"));
                    vista.getTxtSueldo().setText(String.valueOf(persona.getDouble("sueldo")));
                    vista.getTxtTelefono().setText(persona.getString("telefono"));
                    vista.getcFecha().setDate(null);
                    vista.getSpCupo().setValue(persona.getInt("cupo"));
                } else {
                    JOptionPane.showMessageDialog(null, "Persona no encontrada");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });

        vista.getBtActualizar().addActionListener(e -> {
            String idpersona = vista.getTxtCedula().getText();
            String nombre = vista.getTxtNombre().getText();
            String apellido = vista.getTxtApellido().getText();
            double sueldo = Double.parseDouble(vista.getTxtSueldo().getText());
            String telefono = vista.getTxtTelefono().getText();
            Date fechaNacimiento = vista.getcFecha().getDate();
            int cupo = (int) vista.getSpCupo().getValue();
            String genero = vista.getGeneroM().isSelected() ? "Masculino" : "Femenino";

            boolean exito = modelo.actualizarPersona(idpersona, nombre, apellido, sueldo, telefono, fechaNacimiento, genero, cupo);

            if (exito) {
                JOptionPane.showMessageDialog(null, "Persona actualizada correctamente");
                vista.getTxtCedula().setText("");
                vista.getTxtNombre().setText("");
                vista.getTxtApellido().setText("");
                vista.getTxtSueldo().setText("");
                vista.getTxtTelefono().setText("");
                vista.getcFecha().setDate(null);
                vista.getSpCupo().setValue(0);
                vista.getGeneroM().setSelected(false);
                vista.getGeneroF().setSelected(false);
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar la persona");
            }
        });
    }

}
