package MVC.Controlador;

import MVC.Modelo.*;
import MVC.Vista.*;
import java.awt.PopupMenu;

/**
 *
 * @author MAX COMPUTERS
 */
public class ControladorPrincipal {

    VistaPrincipal Vista;
    //Modelo SI se necesitta;

    public ControladorPrincipal(VistaPrincipal Vista) {
        this.Vista = Vista;
        iniciarControl();
        Vista.setVisible(true);
    }

    public void iniciarControl() {
        Vista.getTlbPersona().addActionListener(l -> crudPersona());
        Vista.getMnuCrearPersona().addActionListener(l -> crudPersona());
        Vista.getTlbEliminar().addActionListener(l -> crudPersona());
        Vista.getTlbEditar().addActionListener(l-> crudPersona());
        Vista.getTlbProductos().addActionListener(l -> vistaventa());
    }

    private void crudPersona() {
        ModeloPersona modelo = new ModeloPersona();
        VistaPersona vistaPersona = new VistaPersona();
        Vista.getDesktopPrincipal().add(vistaPersona);
        ControladorPersonas controladorPersonas = new ControladorPersonas(modelo, vistaPersona);
        controladorPersonas.iniciaControl();
    }
    private void vistaventa(){
        puntoDeVenta vistap=new puntoDeVenta();
        Vista.getDesktopPrincipal().add(vistap);
        vistap.setVisible(true);
        ControladorProductos control=new ControladorProductos(vistap);
        control.iniciarControl2();
    }
}
