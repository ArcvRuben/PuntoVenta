
package MVC;

import MVC.Controlador.*;
import MVC.Modelo.*;
import MVC.Vista.*;

/**
 *
 * @author MAX COMPUTERS
 */
public class Proyecto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        VistaPrincipal vistaprincipal=new VistaPrincipal();
        
        ControladorPrincipal controlPrincipal=new ControladorPrincipal(vistaprincipal);
       
        controlPrincipal.iniciarControl();
        
    }
    
}
