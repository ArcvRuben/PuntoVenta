package MVC.Controlador;


import MVC.Modelo.*;
import MVC.Vista.*;
import java.net.URL;
import javax.swing.table.DefaultTableModel;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.*;
import java.text.SimpleDateFormat;
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
public class ControladorProductos {
    
    private puntoDeVenta vista;  

    public ControladorProductos(puntoDeVenta vista) {
        this.vista = vista;
        iniciarControl2();
    }

    void iniciarControl2() {
        vista.getBtnproductodReporte().addActionListener( l -> imprimirReporte());
    }
  

        public void imprimirReporte() {
        try {
            System.out.println("Botón de reporte presionado");
            URL resourceURL = getClass().getClassLoader().getResource("/Reportes/ReporteProductos.jasper");
            System.out.println("URL del recurso: " + resourceURL);

            JasperReport reporte = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/ReporteProductos.jasper"));

            Conexion con = new Conexion();
            JasperPrint jp = JasperFillManager.fillReport(
                    reporte,
                    null,
                    con.getCon());

            JasperViewer Jv = new JasperViewer(jp, false);
            Jv.setVisible(true);

        } catch (JRException ex) {
            Logger.getLogger(ControladorPersonas.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    

}