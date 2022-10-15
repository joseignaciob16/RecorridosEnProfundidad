package interfacesfuncionales;

import javax.swing.JOptionPane;
import javax.swing.tree.DefaultTreeModel;


public class TVentana extends javax.swing.JFrame {

    private DefaultTreeModel Mod;
    
    public TVentana() {
        initComponents();
        Mod=(DefaultTreeModel)Arb.getModel();
        Mod.setRoot(null);
        this.setLocationRelativeTo(null);
    }

    private void VerMensaje(String Texto){
    JOptionPane.showMessageDialog(null, Texto);
    }
   
    private TNodo getRaiz() {
        if (Mod.getRoot() != null) {
            return (TNodo)Mod.getRoot();
        } else {
            return null;
        }
    }
    
    private TNodo Seleccionado() {
        if (Arb.getSelectionPath() != null) {
            return (TNodo) Arb.getLastSelectedPathComponent();
        } else {
            return null;
        }
    }
    
    private void Actualizar() {
        Mod.reload();
        tf1.setText("");
        tf1.grabFocus();
    }
   
    private boolean AgregarRaiz() {
        if (getRaiz()==null) {
            Mod.setRoot(new TNodo(tf1.getText()));
            Actualizar();
            return true;
        } else {
            return false;
        }
    }  
 
    private void Mostrar(TNodo Nod) {
        IFiltrar Fil;
        int valor = Integer.parseInt(Nod.getTexto());
        switch (cb1.getSelectedIndex()) {
            case 0: {
                Fil = (int val) -> valor % 2 == 0;
                if (valor % 2 == 0) {
                    txt.append(Nod.getTexto() + " ");
                }
                break;
            }
            case 1: {
                Fil = (int val) -> valor % 2 != 0;
                if (valor % 2 != 0) {
                    txt.append(Nod.getTexto() + " ");
                }
                break;
            }
            case 2: {
                Fil = (int val) -> valor % 2 != 0;
                if (valor % 2 != 0 && valor % 3 == 0) {
                    txt.append(Nod.getTexto() + " ");
                }
                break;
            }
        }
    }
    
    private void PreOrden(TNodo Nod) {
        if (Nod!=null) {
            Mostrar(Nod);
            PreOrden(Nod.HijoIzquierdo());
            PreOrden(Nod.HijoDerecho());
        }
    }
    
    private void InOrden(TNodo Nod) {
        if (Nod!=null) {
            InOrden(Nod.HijoIzquierdo());
            Mostrar(Nod);
            InOrden(Nod.HijoDerecho());
        }
    }
    
    private void PostOrden(TNodo Nod) {
        if (Nod!=null) {
            PostOrden(Nod.HijoIzquierdo());
            PostOrden(Nod.HijoDerecho());
            Mostrar(Nod);            
        }
    }
     
     
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tf1 = new javax.swing.JTextField();
        lblminimizar = new javax.swing.JLabel();
        lblSalir = new javax.swing.JLabel();
        btnayuda = new javax.swing.JLabel();
        B1 = new javax.swing.JButton();
        B2 = new javax.swing.JButton();
        B3 = new javax.swing.JButton();
        B4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Arb = new javax.swing.JTree();
        jLabel2 = new javax.swing.JLabel();
        cb1 = new javax.swing.JComboBox<>();
        B5 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nodo");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, -1, -1));

        tf1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf1KeyTyped(evt);
            }
        });
        jPanel1.add(tf1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 93, -1));

        lblminimizar.setFont(new java.awt.Font("Open Sans", 1, 42)); // NOI18N
        lblminimizar.setForeground(new java.awt.Color(255, 153, 0));
        lblminimizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblminimizar.setText("•");
        lblminimizar.setToolTipText("MINIMIZAR");
        lblminimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblminimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblminimizarMouseClicked(evt);
            }
        });
        jPanel1.add(lblminimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 20));

        lblSalir.setFont(new java.awt.Font("Open Sans", 1, 42)); // NOI18N
        lblSalir.setForeground(new java.awt.Color(255, 51, 51));
        lblSalir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSalir.setText("•");
        lblSalir.setToolTipText("SALIR");
        lblSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSalirMouseClicked(evt);
            }
        });
        jPanel1.add(lblSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 30, 20));

        btnayuda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnayuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/help.png"))); // NOI18N
        btnayuda.setToolTipText("AYUDA");
        btnayuda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnayuda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnayudaMouseClicked(evt);
            }
        });
        jPanel1.add(btnayuda, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 0, 30, 30));

        B1.setText("Izquierda");
        B1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B1ActionPerformed(evt);
            }
        });
        jPanel1.add(B1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 101, -1));

        B2.setText("Derecha");
        B2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B2ActionPerformed(evt);
            }
        });
        jPanel1.add(B2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, 101, -1));

        B3.setText("Eliminar");
        B3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B3ActionPerformed(evt);
            }
        });
        jPanel1.add(B3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 101, -1));

        B4.setText("Limpiar");
        B4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B4ActionPerformed(evt);
            }
        });
        jPanel1.add(B4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 320, 101, -1));

        jScrollPane1.setViewportView(Arb);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 561, 210));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Recorrido");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, -1, -1));

        cb1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PreOrden", "InOrden", "PostOrden" }));
        jPanel1.add(cb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 114, -1));

        B5.setText("Aceptar");
        B5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B5ActionPerformed(evt);
            }
        });
        jPanel1.add(B5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 420, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Resultado:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 320, -1, -1));

        txt.setEditable(false);
        txt.setBackground(new java.awt.Color(255, 255, 255));
        txt.setColumns(20);
        txt.setForeground(new java.awt.Color(0, 0, 0));
        txt.setLineWrap(true);
        txt.setRows(5);
        txt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jScrollPane2.setViewportView(txt);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 340, 290, 130));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void B1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B1ActionPerformed
        if (!tf1.getText().isEmpty()) {
            TNodo Padre;
            if (!AgregarRaiz()) {
                Padre = Seleccionado();
                if (Padre == null) {
                    VerMensaje("SELECCIONE EL NODO PADRE");
                } else {
                    if (Padre.AgregarIzq(new TNodo(tf1.getText()))) {
                        Actualizar();
                    } else {
                        VerMensaje("EL NODO PADRE YA TIENE UN HIJO IZQUIERDO");
                    }
                }
            }
        } else {
            VerMensaje("EL NODO NO PUEDE IR VACIO");
        }
    }//GEN-LAST:event_B1ActionPerformed

    private void B2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B2ActionPerformed
        TNodo Padre;
        if (!tf1.getText().isEmpty()) {
            if (!AgregarRaiz()) {
                Padre = Seleccionado();
                if (Padre == null) {
                    VerMensaje("SELECCIONE EL NODO PADRE");
                } else {
                    if (Padre.AgregarDer(new TNodo(tf1.getText()))) {
                        Actualizar();
                    } else {
                        VerMensaje("EL NODO PADRE YA TIENE UN HIJO DERECHO");
                    }
                }
            }
        } else {
            VerMensaje("EL NODO NO PUEDE IR VACIO");
        }
    }//GEN-LAST:event_B2ActionPerformed

    private void B3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B3ActionPerformed
        TNodo Nod;
        Nod = Seleccionado();
        if (Nod != null) {
            if (Nod != getRaiz()) {
                Mod.removeNodeFromParent(Nod);
            }
        } else {
            VerMensaje("SELECCIONE EL NODO A ELIMINAR");
        }

    }//GEN-LAST:event_B3ActionPerformed

    private void B4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B4ActionPerformed
        Mod.setRoot(null);
        Actualizar();
        txt.setText("");
    }//GEN-LAST:event_B4ActionPerformed

    private void B5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B5ActionPerformed
        TNodo Raiz;
        Raiz = getRaiz();
        if (Raiz == null) {
            VerMensaje("-----------------------------------------EL ÁRBOL ESTA VACÍO-----------------------------------------\n"
                   + "🛑Para poder realizar cualquier recorrido de profundidad debe haber al menos un 'Nodo' en el árbol.\n\n"+ Mensaje());
        } else {
            VerificarSeleccion();
            switch (cb1.getSelectedIndex()) {
                case 0:;
                    PreOrden(Raiz);
                    break;
                case 1:
                    InOrden(Raiz);                 
                    break;
                case 2:
                    PostOrden(Raiz);                   
                    break;
            }
    }//GEN-LAST:event_B5ActionPerformed
    }
    
    public void VerificarSeleccion() {
        switch (cb1.getSelectedIndex()) {
            case 0:
                txt.append("\nPreOrden: ");
                break;
            case 1:
                txt.append("\nInOrden: ");
                break;
            case 2:
                txt.append("\nPostOrden: ");
                break;
        }
    }
    
    private void lblSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSalirMouseClicked
        this.dispose();
    }//GEN-LAST:event_lblSalirMouseClicked

    private void lblminimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblminimizarMouseClicked
        this.setState(TVentana.ICONIFIED);
    }//GEN-LAST:event_lblminimizarMouseClicked

    private void btnayudaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnayudaMouseClicked
        VerMensaje(Mensaje());
    }//GEN-LAST:event_btnayudaMouseClicked

    private String Mensaje(){
       String msj= "-----------------------------------------¿COMO LLENAR EL ÁRBOL?--------------------------------------------\n"
               + "\n  Ingrese los datos en el campo 'Nodo' y seleccione 'Izquierda' o 'Derecha'."
               + "\n        ✅ Debe seleccionar el 'Nodo' padre."
               + "\n        ✅ Solo se permite un 'Hijo' de cada lado (Izquierda/Derecha)."
               + "\n        ✅ Solo se pueden ingresar valores numericos.";   
        return msj;
    }
    
    private void tf1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf1KeyTyped
        int key = evt.getKeyChar();
        boolean numeros = key >= 48 && key <= 57;
        if (!numeros) {
            evt.consume();
        }
        if (tf1.getText().trim().length() == 10) {
            evt.consume();
        }
    }//GEN-LAST:event_tf1KeyTyped

    

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TVentana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTree Arb;
    private javax.swing.JButton B1;
    private javax.swing.JButton B2;
    private javax.swing.JButton B3;
    private javax.swing.JButton B4;
    private javax.swing.JButton B5;
    private javax.swing.JLabel btnayuda;
    private javax.swing.JComboBox<String> cb1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblSalir;
    private javax.swing.JLabel lblminimizar;
    private javax.swing.JTextField tf1;
    private javax.swing.JTextArea txt;
    // End of variables declaration//GEN-END:variables
}
