
package MVC.Vista;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 *
 * @author MAX COMPUTERS
 */
public class VistaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form VistaPrincipal
     */
    public VistaPrincipal() {
        initComponents();
    }

    public JDesktopPane getDesktopPrincipal() {
        return DesktopPrincipal;
    }

    public void setDesktopPrincipal(JDesktopPane DesktopPrincipal) {
        this.DesktopPrincipal = DesktopPrincipal;
    }

    public JMenuItem getMnVentas() {
        return mnVentas;
    }

    public void setMnVentas(JMenuItem mnVentas) {
        this.mnVentas = mnVentas;
    }

    public JMenu getMnuCrearPersona() {
        return mnuCrearPersona;
    }

    public void setMnuCrearPersona(JMenu mnuCrearPersona) {
        this.mnuCrearPersona = mnuCrearPersona;
    }

    public JButton getTlbPersona() {
        return tlbPersona;
    }

    public void setTlbPersona(JButton tlbPersona) {
        this.tlbPersona = tlbPersona;
    }

    public JButton getTlbEditar() {
        return tlbEditar;
    }

    public void setTlbEditar(JButton tlbEditar) {
        this.tlbEditar = tlbEditar;
    }

    public JButton getTlbProductos() {
        return tlbProductos;
    }

    public void setTlbProductos(JButton tlbProductos) {
        this.tlbProductos = tlbProductos;
    }
    

    public JButton getTlbEliminar() {
        return tlbEliminar;
    }

    public void setTlbEliminar(JButton tlbEliminar) {
        this.tlbEliminar = tlbEliminar;
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        tlbPersona = new javax.swing.JButton();
        tlbEditar = new javax.swing.JButton();
        tlbEliminar = new javax.swing.JButton();
        tlbProductos = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        DesktopPrincipal = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnuCrearPersona = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        mnVentas = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setBackground(new java.awt.Color(153, 204, 255));
        jToolBar1.setForeground(new java.awt.Color(51, 255, 51));
        jToolBar1.setRollover(true);

        tlbPersona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MVC/Vista/iconos/icons8-añadir-30.png"))); // NOI18N
        tlbPersona.setToolTipText("crear, buscar, editar y eliminar persona");
        tlbPersona.setFocusable(false);
        tlbPersona.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tlbPersona.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(tlbPersona);

        tlbEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MVC/Vista/iconos/icons8-editar-30.png"))); // NOI18N
        tlbEditar.setToolTipText("Crear productos");
        tlbEditar.setFocusable(false);
        tlbEditar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tlbEditar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(tlbEditar);

        tlbEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MVC/Vista/iconos/icons8-eliminar-30.png"))); // NOI18N
        tlbEliminar.setFocusable(false);
        tlbEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tlbEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(tlbEliminar);

        tlbProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MVC/Vista/iconos/icons8-venta-30.png"))); // NOI18N
        tlbProductos.setFocusable(false);
        tlbProductos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tlbProductos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(tlbProductos);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MVC/Vista/iconos/icons8-user-20.png"))); // NOI18N
        jLabel1.setText("Mensajes");
        jLabel1.setToolTipText("Sistema Ventas 1.0");

        jLabel2.setText("10:00:00");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 575, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout DesktopPrincipalLayout = new javax.swing.GroupLayout(DesktopPrincipal);
        DesktopPrincipal.setLayout(DesktopPrincipalLayout);
        DesktopPrincipalLayout.setHorizontalGroup(
            DesktopPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        DesktopPrincipalLayout.setVerticalGroup(
            DesktopPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 486, Short.MAX_VALUE)
        );

        jMenu1.setText("Personas");

        mnuCrearPersona.setText("Crear y Editar");
        jMenu1.add(mnuCrearPersona);

        jMenu6.setText("Modificar");
        jMenu1.add(jMenu6);

        jMenuItem2.setText("jMenuItem2");
        jMenu1.add(jMenuItem2);

        jMenuItem1.setText("jMenuItem1");
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Productos");

        jMenu7.setText("PRoductos");
        jMenu2.add(jMenu7);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Ventas");

        mnVentas.setText("Ventas");
        jMenu3.add(mnVentas);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Ayuda");
        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(DesktopPrincipal)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(DesktopPrincipal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane DesktopPrincipal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenuItem mnVentas;
    private javax.swing.JMenu mnuCrearPersona;
    private javax.swing.JButton tlbEditar;
    private javax.swing.JButton tlbEliminar;
    private javax.swing.JButton tlbPersona;
    private javax.swing.JButton tlbProductos;
    // End of variables declaration//GEN-END:variables
}
