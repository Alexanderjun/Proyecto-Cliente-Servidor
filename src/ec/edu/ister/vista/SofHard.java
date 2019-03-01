/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ister.vista;

import ec.edu.ister.controlador.Validar;
import ec.edu.ister.modelo.*;
import ec.edu.ister.modelo.PartesComputadora;
import ec.edu.ister.modelo.ParteComputadora; 
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alexander Legña - Ivan Correa
 */
public class SofHard extends javax.swing.JFrame {

    /**
     * Creates new form SofHard
     */
    ParteComputadora obParteComputadora = new ParteComputadora();
    PartesComputadora obPartesComputadora = new PartesComputadora();
    Conexion co = new Conexion();
    Connection cnn = co.getConexion();
    Validar validar = new Validar();
    Statement ps;
    ResultSet rs;
    Tiempo tiempo;
    private String sql="";
    public SofHard() {
        initComponents();
        tiempo = new Tiempo(lblFecha);
        Thread time = new Thread(tiempo);
        time.start();
        imprimirTabla(this.sql);        
    }
    private void btnRegistrar() {                                             
        obPartesComputadora.setRegistraParteComputadora(txtCodigo.getText(), txtSerie.getText(), txtNombre.getText(), txtDetalle.getText(), Double.parseDouble(txtPrecio.getText()), txtModelo.getText());
        imprimirTabla("");
        limpiar();
    }  
    private void btnActulizar() {                                             
        obPartesComputadora.setModificaParteComputadora(txtCodigo.getText(), txtSerie.getText(), txtNombre.getText(), txtDetalle.getText(), Double.parseDouble(txtPrecio.getText()), txtModelo.getText());
        imprimirTabla("");
        limpiar();
    }    
    private void btnBorrar() {                                          
        obPartesComputadora.setEliminarParteComputadora(txtCodigo.getText());
        imprimirTabla("");
        limpiar();
    }  
    private void btnBuscar(){
        imprimirTabla(txtBuscar.getText());
    }
    private void imprimirTabla(String codPart) {
        DefaultTableModel obTableModel = new DefaultTableModel();
        obTableModel.addColumn("CÓDIGO");
        obTableModel.addColumn("SERIE");
        obTableModel.addColumn("NOMBRE");
        obTableModel.addColumn("DETALLE");
        obTableModel.addColumn("PRECIO");
        obTableModel.addColumn("MODELO");
        obTableModel.addColumn("FECHA");
        tabla.setModel( obTableModel );
        String tablaBD="partesComputadora";
        if ( "".equals(codPart) ) {    
            this.sql = "SELECT * FROM "+tablaBD+"";
        } else {                       
            this.sql = "SELECT * FROM "+tablaBD+" WHERE codPart='"+codPart+"';";        }
        String[] campoTabla = new String[7];
        try {
            this.ps = cnn.createStatement();
            this.rs = ps.executeQuery(sql);
            while (rs.next()) {
                campoTabla[0] = rs.getString(1);                campoTabla[1] = rs.getString(2);
                campoTabla[2] = rs.getString(3);                campoTabla[3] = rs.getString(4);
                campoTabla[4] = rs.getString(5);                campoTabla[5] = rs.getString(6);
                campoTabla[6] = rs.getString(7);
                obTableModel.addRow(campoTabla);
            }
            tabla.setModel( obTableModel );
        } catch (SQLException ex) {
            ex.toString();
        }
    }
    private void seleccionarFila(){
        if (tabla.getSelectedRow() >= 0){
            txtCodigo.setText (tabla.getValueAt(tabla.getSelectedRow(), 0).toString());
            txtSerie.setText  (tabla.getValueAt(tabla.getSelectedRow(), 1).toString());
            txtNombre.setText (tabla.getValueAt(tabla.getSelectedRow(), 2).toString());
            txtDetalle.setText(tabla.getValueAt(tabla.getSelectedRow(), 3).toString());
            txtPrecio.setText (tabla.getValueAt(tabla.getSelectedRow(), 4).toString());
            txtModelo.setText (tabla.getValueAt(tabla.getSelectedRow(), 5).toString()); 
        }else{
            JOptionPane.showMessageDialog(null,"Debes seleccionar una tupla...!");
        }
    }
    private void limpiar(){
        txtBuscar.setText("");
        txtCodigo.setText("");
        txtDetalle.setText("");
        txtModelo.setText("");
        txtNombre.setText("");
        txtPrecio.setText("");
        txtSerie.setText("");
       
    } 
    private boolean validar(){ 
        return  txtCodigo.getText().equals("") ||
                txtDetalle.getText().equals("")||
                txtModelo.getText().equals("") ||
                txtNombre.getText().equals("") ||
                txtPrecio.getText().equals("") ||
                txtSerie.getText().equals("");
    }
    private void eliminarFila(){
        if (!validar()) {
            btnBorrar();
        }else{
            JOptionPane.showMessageDialog(null,"Debe seleccionar una tupla...!");
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupo1 = new javax.swing.JPopupMenu();
        btnSeleccionar = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        txtModelo = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        txtDetalle = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtSerie = new javax.swing.JTextField();
        txtBuscar = new javax.swing.JTextField();
        lblFecha = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnActulizar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnRefrescar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        btnSeleccionar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSeleccionar.setText("Selecciona Registro");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });
        grupo1.add(btnSeleccionar);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1122, 671));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ));
        tabla.setComponentPopupMenu(grupo1);
        jScrollPane1.setViewportView(tabla);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 220, 590, 280));

        txtModelo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtModelo.setOpaque(false);
        getContentPane().add(txtModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 440, 180, 30));

        txtPrecio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtPrecio.setOpaque(false);
        txtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioKeyTyped(evt);
            }
        });
        getContentPane().add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 400, 180, 30));

        txtDetalle.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtDetalle.setOpaque(false);
        getContentPane().add(txtDetalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 350, 180, 30));

        txtNombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtNombre.setOpaque(false);
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 300, 180, 30));

        txtSerie.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtSerie.setOpaque(false);
        txtSerie.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSerieKeyTyped(evt);
            }
        });
        getContentPane().add(txtSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, 180, 30));

        txtBuscar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtBuscar.setOpaque(false);
        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 170, 180, 30));

        lblFecha.setForeground(new java.awt.Color(255, 255, 255));
        lblFecha.setText("dd/mm/yy/ hh/mm/ss");
        getContentPane().add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 480, 120, 30));

        txtCodigo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtCodigo.setOpaque(false);
        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });
        getContentPane().add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, 180, 30));

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 170, 90, 30));

        btnActulizar.setText("Actualizar");
        btnActulizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActulizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnActulizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 170, 100, 30));

        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 170, 90, 30));

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 170, 100, 30));

        btnRefrescar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ister/imagenes/072f84989bbbc20a8e8112d555c175a3.png"))); // NOI18N
        btnRefrescar.setContentAreaFilled(false);
        btnRefrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefrescarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRefrescar, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 510, 60, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ister/imagenes/cabeza1.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1120, 670));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        btnRegistrar();
    }//GEN-LAST:event_btnRegistrarActionPerformed
    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        seleccionarFila();
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void btnActulizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActulizarActionPerformed
        btnActulizar();
    }//GEN-LAST:event_btnActulizarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        eliminarFila();
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        btnBuscar();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnRefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrescarActionPerformed
        imprimirTabla("");
    }//GEN-LAST:event_btnRefrescarActionPerformed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        validar.soloLetras(evt);
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtSerieKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSerieKeyTyped
        validar.soloNumeros(evt); 
    }//GEN-LAST:event_txtSerieKeyTyped

    private void txtPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyTyped
        validar.soloPrecio(evt);
    }//GEN-LAST:event_txtPrecioKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActulizar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnRefrescar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JMenuItem btnSeleccionar;
    private javax.swing.JPopupMenu grupo1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDetalle;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtSerie;
    // End of variables declaration//GEN-END:variables
}
