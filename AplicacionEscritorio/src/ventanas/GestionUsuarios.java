/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ventanas;

import com.google.gson.JsonSyntaxException;
import controlador.Consultas;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import modelo.Usuario;
import utilidades.RespuestaJson;
import utilidades.ValidarDatos;

/**
 *
 * @author Josu
 */
public class GestionUsuarios extends javax.swing.JPanel {

    private DefaultTableModel modeloTablaUsuarios = new DefaultTableModel();
    private TableRowSorter<TableModel> tablaOrdenada = new TableRowSorter<TableModel>(modeloTablaUsuarios);
    private TableColumn sportColumn;
        
    
    /**
     * Creates new form GestionUsuarios
     */
    public GestionUsuarios() {
        initComponents();
        llenarModeloTablaUsuarios();
        listarUsuarios();
        llenarComboBox();
        //tablaUsuarios.setRowSorter(tablaOrdenada);
        //sportColumn = tablaUsuarios.getColumnModel().getColumn(5);

        //sportColumn.setCellEditor(new DefaultCellEditor(comboBox));
        //tablaUsuarios.add(jPopupMenu1);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItemEliminar = new javax.swing.JMenuItem();
        jMenuItemModificar = new javax.swing.JMenuItem();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaUsuarios = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        comboBoxTipoUsuario = new javax.swing.JComboBox<>();
        txtNombre = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btnModificarUsuario = new javax.swing.JButton();
        btnEliminarUsuario = new javax.swing.JButton();
        btnInsertarUsuario = new javax.swing.JButton();

        jMenuItemEliminar.setText("jMenuItem1");
        jPopupMenu1.add(jMenuItemEliminar);

        jMenuItemModificar.setText("jMenuItem2");
        jPopupMenu1.add(jMenuItemModificar);

        setPreferredSize(new java.awt.Dimension(1000, 511));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaUsuarios.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        tablaUsuarios.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        tablaUsuarios.setModel(modeloTablaUsuarios);
        tablaUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane2.setViewportView(tablaUsuarios);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 570, 468));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(105, 56, 41)), "Datos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 2, 18))); // NOI18N

        jLabel1.setText("Usuario");

        jLabel3.setText("Password");

        jLabel4.setText("Nombre");

        jLabel5.setText("Apellidos");

        jLabel6.setText("Telefono");

        jLabel7.setText("TipoUsuario");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(62, 62, 62))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addComponent(jLabel4)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                                    .addComponent(txtPassword))
                                .addGap(55, 55, 55)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtApellidos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(56, 56, 56))
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboBoxTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addGap(45, 45, 45))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 20, 330, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(105, 56, 41)), "Operaciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 2, 18))); // NOI18N

        btnModificarUsuario.setText("Modificar Usuario");
        btnModificarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarUsuarioActionPerformed(evt);
            }
        });

        btnEliminarUsuario.setText("Eliminar Usuario");
        btnEliminarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarUsuarioActionPerformed(evt);
            }
        });

        btnInsertarUsuario.setText("Insertar Usuario");
        btnInsertarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEliminarUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnModificarUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                    .addComponent(btnInsertarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(btnInsertarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(btnEliminarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnModificarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 270, 230, 172));
    }// </editor-fold>//GEN-END:initComponents

    private void btnModificarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarUsuarioActionPerformed
        Usuario user = new Usuario(txtTelefono.getText());
        try {
            user = Consultas.existeUsuario("usuarios", user);
            Usuario userModificado = new Usuario(txtUsuario.getText(), txtPassword.getText(), txtNombre.getText(), txtApellidos.getText(), txtTelefono.getText(), String.valueOf(comboBoxTipoUsuario.getSelectedItem()));
            int eleccion = JOptionPane.showConfirmDialog(this,"¿Estas seguro de que quieres modificar el usuario?", "Confirmacion", JOptionPane.YES_NO_OPTION);
            if (eleccion == JOptionPane.YES_OPTION) {
                RespuestaJson respuestaJson = Consultas.actualizar("usuarios", userModificado);
                JOptionPane.showMessageDialog(this, respuestaJson.getValue());
                listarUsuarios();
                limpiarTextos();
            }
        } catch (JsonSyntaxException e) {
            JOptionPane.showMessageDialog(this,"Usuario no registrado.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnModificarUsuarioActionPerformed

    private void btnEliminarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarUsuarioActionPerformed
        // TODO add your handling code here:
        Usuario user = new Usuario(txtTelefono.getText());
        try {
            user = Consultas.existeUsuario("usuarios", user);
            Usuario userEliminado = new Usuario(user.getIdUsuario());
            int eleccion = JOptionPane.showConfirmDialog(this,"¿Estas seguro de que quieres eliminar el usuario?", "Confirmacion", JOptionPane.YES_NO_OPTION);
            if (eleccion == JOptionPane.YES_OPTION) {
                RespuestaJson respuestaJson = Consultas.eliminar("usuarios", userEliminado);
                JOptionPane.showMessageDialog(this, respuestaJson.getValue());
                listarUsuarios();
                limpiarTextos();
            }
        } catch (JsonSyntaxException e) {
            JOptionPane.showMessageDialog(this,"Usuario no registrado.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarUsuarioActionPerformed

    private void btnInsertarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarUsuarioActionPerformed
        // TODO add your handling code here:
        Usuario user = new Usuario(txtTelefono.getText());
        try {
            user = Consultas.existeUsuario("usuarios", user);
            JOptionPane.showMessageDialog(this,"Telefono repetido", "Usuario ya registrado", JOptionPane.INFORMATION_MESSAGE);
        } catch (JsonSyntaxException e) {
            if (ValidarDatos.validarTelefono(txtTelefono.getText())) {
                Usuario userInsertar = new Usuario(txtUsuario.getText(), txtPassword.getText(), txtNombre.getText(), txtApellidos.getText(), txtTelefono.getText(), String.valueOf(comboBoxTipoUsuario.getSelectedItem()));
                RespuestaJson respuestaJson = Consultas.insertar("usuarios",userInsertar);
                JOptionPane.showMessageDialog(this, respuestaJson.getValue());
                listarUsuarios();
                limpiarTextos();
            }else{
                JOptionPane.showMessageDialog(this,"Formato de telefono no valido", "Error", JOptionPane.ERROR_MESSAGE);
            } 
        }
    }//GEN-LAST:event_btnInsertarUsuarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminarUsuario;
    private javax.swing.JButton btnInsertarUsuario;
    private javax.swing.JButton btnModificarUsuario;
    private javax.swing.JComboBox<String> comboBoxTipoUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenuItem jMenuItemEliminar;
    private javax.swing.JMenuItem jMenuItemModificar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaUsuarios;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

    private void llenarModeloTablaUsuarios() {
        modeloTablaUsuarios.addColumn("Nombre");
        modeloTablaUsuarios.addColumn("Apellidos");
        modeloTablaUsuarios.addColumn("Telefono");
        modeloTablaUsuarios.addColumn("Usuario");
        modeloTablaUsuarios.addColumn("Password");
        modeloTablaUsuarios.addColumn("Tipo usuario");
        tablaUsuarios.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                txtNombre.setText(tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(), 0).toString());
                txtApellidos.setText(tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(), 1).toString());
                txtTelefono.setText(tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(), 2).toString());
                txtUsuario.setText(tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(), 3).toString());
                txtPassword.setText(tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(), 4).toString());
                comboBoxTipoUsuario.setSelectedItem(tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(), 5).toString());
            }
        });
    }

    private void listarUsuarios() {
        int numFilas = modeloTablaUsuarios.getRowCount();
        for (int i = 0; i < numFilas; i++) {
            modeloTablaUsuarios.removeRow(0);
        }
        ArrayList<Usuario> users = Consultas.ListarUsuarios();
        for (Usuario u : users) {
            String datos[] = { u.getNombre(), u.getApellidos(), u.getTelefono(), u.getUsuario(), u.getPassword(), u.getTipoUsuario()};
            modeloTablaUsuarios.addRow(datos);
        }
    }

    private void limpiarTextos() {
        txtUsuario.setText("");
        txtPassword.setText("");
        txtNombre.setText("");
        txtApellidos.setText("");
        txtTelefono.setText("");
        comboBoxTipoUsuario.setSelectedItem("");
    }
    
    private void llenarComboBox(){
        comboBoxTipoUsuario.addItem("");
        comboBoxTipoUsuario.addItem("cliente");
        comboBoxTipoUsuario.addItem("trabajador");
    }
}
